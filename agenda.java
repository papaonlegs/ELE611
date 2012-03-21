import java.util.*;
import java.lang.*;
import java.io.*;

public class agenda<World extends searchWorld<String,opPair>>
{
		// agenda is a generic class whose argument must be an implementation of the searchWorld interface 
		// (see searchWorld.java). It is specified as an implementation of the agendaSpecification interface
		// (see agendaSpecification.java). It implements agenda-based search strategies Depth-first,
		// Breadth-first, and Uniform-cost, which are the minimal requirements of agendaSpecification, but
		// it can be extended by the addition of public code for other kinds of search.
 
	protected World worldDescription;					// this stores the world description

	protected Vector<agendaState> agenda = new Vector<agendaState>( 0, 0 ); // this is the actual agenda

	protected int expansionSteps = 0;					// can be used to count the number
										// of expansion steps used by expand

	protected agenda( World worldGiven )					// this is the constructor
	{
		worldDescription =  worldGiven;					// put the supplied world desc. in place
	}

	private void initialise( String start )					// this initalises the agenda object
	{									// for a new search. Note that the same
		agenda.clear();							// object/world can be used for multiple
		agenda.add( 0, new agendaState( start ));			// searches, in this design.
		expansionSteps = 0;
	}

	// private Vector<agendaState> expand( agendaState currentState )		// given the current state, ask tubeMap
										// for the operators that could apply
										// and then apply them. In the current
										// design, the operator type is opPair.
										// don't forget to update expansionSteps.
	
	private Vector<agendaState> expand( agendaState currentState){
	
		Vector<agendaState> expandedStates = new Vector<agendaState>( 0, 0);
		
		for(opPair operator : worldDescription.operators(currentState.currentNode)){
			Vector<opPair> path = new Vector<opPair>( 0, 0);
			
			path.addAll(currentState.pathSoFar);
			path.add(operator);
			
			expandedStates.add(new agendaState(
							operator.destination, 
							currentState.costSoFar + worldDescription.cost(currentState.currentNode, operator.destination), 
							path
							));
		}
			
		expansionSteps++;
		return expandedStates;
	}

	// public agendaState dfs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place.
										// Use the specification in the lecture notes.
										
	public agendaState dfs( String start, String goal ){
	
		Vector<String> visited = new Vector<String>(0,0);
		agendaState position = new agendaState(start);
		
		agenda.add(position);
		visited.add(position.currentNode);
		
		while(!agenda.isEmpty()){
		
			position = agenda.lastElement();
			
			if(position.currentNode.equals(goal))return position;
			
			for(agendaState possibility : expand(position)){
				if(visited.contains( possibility.currentNode)){ 
					position = null; 
					continue;
				}else {
					position = possibility; 
					break;
				}
			}
			
			if (position == null){
				agenda.remove(agenda.lastElement());
			}else{
				agenda.add(position);
				visited.add(position.currentNode);
			}
			
		}

		return null;
	}

	// public agendaState bfs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place
										
	public agendaState bfs(String start, String goal){
		
		agenda = new Vector<agendaState>( 0, 0);
		Vector<String> visited = new Vector<String>(0,0);
		Vector<agendaState> temps = new Vector<agendaState>(0,0);
		agendaState position = new agendaState(start);
		
		agenda.add(position);
		visited.add(position.currentNode);
		
		while(agenda != null){
		
			temps = agenda;
			agenda = new Vector<agendaState>(0,0);
			
			for(agendaState temp : temps){
				for (agendaState possibility : expand(temp)){
				
					if(possibility.currentNode.equals(goal)) return possibility;
					
					if(visited.contains( possibility.currentNode)){
						continue;
					}else{
						visited.add(possibility.currentNode);
						agenda.add(possibility);
					}
					
				}
			}
		}
		
		return null;
		
	}

	// public agendaState ucs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place
	
	public agendaState ucs(String start, String goal){
	
		agenda = new Vector<agendaState>( 0, 0);
		Vector<String> visited = new Vector<String>(0,0);
		agendaState smallest = new agendaState(start);
		Vector<agendaState> possibilities = new Vector<agendaState>( 0, 0);
		
		agenda.add(smallest);
		visited.add(smallest.currentNode);
		
		while(agenda != null){
			
			if(smallest.currentNode.equals(goal)) return smallest;
			
			agenda.addAll(expand(smallest));
			smallest = null;
			for(agendaState state:agenda){
				if(visited.contains(state.currentNode))continue;
				if(smallest == null) smallest = state;
				if(state.costSoFar < smallest.costSoFar){
					smallest = state;
				}
			}
			visited.add(smallest.currentNode);
		}
		return null;
		
	}
	
	public agendaState ucsx(String start, String goal){
	
		agenda = new Vector<agendaState>( 0, 0);
		Vector<String> visited = new Vector<String>(0,0);
		agendaState smallest = new agendaState(start);
		Vector<agendaState> possibilities = new Vector<agendaState>( 0, 0);
		
		agenda.add(smallest);
		visited.add(smallest.currentNode);
		
		while(agenda != null){
			
			if(smallest.currentNode.equals(goal)) return smallest;
			
			//smallest.costSoFar += costSoFar(smallest);
			agenda.addAll(costSoFar(expand(smallest)));
			agendaState previous = smallest;
			smallest = null;
			for(agendaState state:agenda){
				if(visited.contains(state.currentNode))continue;
				if(smallest == null) smallest = state;
				if(state.costSoFar < smallest.costSoFar){
					smallest = state;
				}
				
			}
			visited.add(smallest.currentNode);
		}
		return null;
		
	}

	public agendaState heuristicUcs(String start, String goal){
	
		agenda = new Vector<agendaState>( 0, 0);
		Vector<String> visited = new Vector<String>(0,0);
		agendaState smallest = new agendaState(start);
		Vector<agendaState> possibilities = new Vector<agendaState>( 0, 0);
		
		agenda.add(smallest);
		visited.add(smallest.currentNode);
		
		while(agenda != null){
			
			if(smallest.currentNode.equals(goal)) return smallest;
			//smallest.costSoFar += heuristicCostSoFar(smallest, goal);
			agenda.addAll(heuristicCostSoFar(expand(smallest), goal));
			agendaState previous = smallest;
			smallest = null;
			for(agendaState state:agenda){
				if(visited.contains(state.currentNode))continue;
				if(smallest == null) smallest = state;
				if(state.costSoFar < smallest.costSoFar){
					smallest = state;
				}
				
			}
			visited.add(smallest.currentNode);
		}
		return null;
		
	}
	
	/** costSoFar function that adds a weighting
	*	whenever there is a change in tubeLine.
	*	This is only fair as there is delay whenever
	*	one changes lines. The weighting can be 
	*	finetuned to get better results depending
	*	on overall system.
	*/

	public Vector<agendaState> costSoFar(Vector<agendaState> ags){

		String prev = null;
		int someRet = 0;
		int weighting = 1; //Weighting that can be finetuned
		boolean addWeight = true;
		for(agendaState ag : ags){
			prev = null;
			someRet = 0;
			for(opPair op : ag.pathSoFar){
				if(prev == null){
					prev = op.tubeLine; continue;
				}
				if(op.tubeLine.equals(prev)) addWeight = false;
				if(addWeight) someRet += weighting;
				prev = op.tubeLine;
				addWeight = true;
			}
			ag.costSoFar += someRet;
		}
		return ags;
	}
	/** heuristicCostSoFar function that adds a weighting
	*	whenever the search moves further from the goal zone.
	*	If the difference between the previous zone to the goal zone
	*	is less than the current zone to the goal zone it is penalised.
	*	This also serves to try to keep the search in the goal zone 
	*	once it reaches there. Good example : Stratford to Bermondsey
	*/
	public Vector<agendaState> heuristicCostSoFar(Vector<agendaState> ags, String goal){
		
		//Cast worldDescription as its same type in order to access tubeZones function
		tubeMap worldDescriptio = (tubeMap) worldDescription;
		int prevMath;
		int nowMath;
		int destMath;
			
		destMath = Integer.valueOf(worldDescriptio.tubeZones(goal).firstElement().charAt(0));
		
		int someRet = 0;
		int weighting = 2; //Weighting that can be finetuned
		boolean addWeight = true;
		Vector<String> prev = null;
		opPair now = null;
		for(agendaState ag : ags){
			someRet = 0;
			prev = null;
			now = null;
			for (opPair op : ag.pathSoFar){
				//Check to see if pair is valid and not equal to destination zone
				if(worldDescriptio.tubeZones(op.destination) == null)continue;
				if(worldDescriptio.tubeZones(op.destination).firstElement().equals(worldDescriptio.tubeZones(goal).firstElement())) continue;
				
				if (prev == null){ 
					prev = worldDescriptio.tubeZones(op.destination);
					continue;
				}else if(now != null)prev = worldDescriptio.tubeZones(now.destination);
				
				for(String zone : worldDescriptio.tubeZones(op.destination)){
					if(prev.contains(zone)) addWeight = false;

				}
				prevMath = Integer.valueOf(prev.firstElement().charAt(0));
				nowMath = Integer.valueOf(worldDescriptio.tubeZones(op.destination).firstElement().charAt(0));

				if(Math.abs(prevMath - destMath) < Math.abs(nowMath - destMath)) addWeight = true; //Penalise it for going further away from target zone
				now = op;
				if(addWeight) someRet+=weighting;
				addWeight = true;
			}
			ag.costSoFar += someRet;
		}
		return ags;
	}

	// put any other private methods you write here

}
