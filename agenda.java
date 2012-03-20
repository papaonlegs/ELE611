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
			
			for(opPair paths : currentState.pathSoFar)
				path.add(paths);
				
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
		
			position = (agendaState) agenda.lastElement();
			
			if(position.currentNode.equals(goal))return position;
			
			Vector<agendaState> possibilities = expand(position);
			
			for(agendaState possibility : possibilities){
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
		agendaState position = new agendaState(start);
		
		agenda.add(position);
		visited.add(position.currentNode);
		
		while(agenda != null){
		
			Vector<agendaState> temps = agenda;
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
		boolean makesure = true;
		
		agenda.add(smallest);
		visited.add(smallest.currentNode);
		
		while(agenda != null){
			
			if(smallest.currentNode.equals(goal)) return smallest;
			
			//System.out.println(smallest.currentNode);
			agenda.addAll(expand(smallest));
			smallest = null;
			for(agendaState state:agenda){
				if(visited.contains(state.currentNode))continue;
				if(smallest == null) smallest = state;
				if(state.costSoFar < smallest.costSoFar){
					smallest = state;
				}
			}
			//System.out.println(smallest.currentNode);
			visited.add(smallest.currentNode);
		}
		return null;
		
	}
	
	public agendaState ucsx(String start, String goal){
	
		agenda = new Vector<agendaState>( 0, 0);
		Vector<String> visited = new Vector<String>(0,0);
		agendaState smallest = new agendaState(start);
		Vector<agendaState> possibilities = new Vector<agendaState>( 0, 0);
		boolean makesure = true;
		
		agenda.add(smallest);
		visited.add(smallest.currentNode);
		
		while(agenda != null){
			
			if(smallest.currentNode.equals(goal)) return smallest;
			
			smallest.costSoFar += costSoFar(smallest);
			//System.out.println(smallest.currentNode);
			agenda.addAll(expand(smallest));
			agendaState previous = smallest;
			smallest = null;
			for(agendaState state:agenda){
				if(visited.contains(state.currentNode))continue;
				if(smallest == null) smallest = state;
				if(state.costSoFar < smallest.costSoFar){
					smallest = state;
				}
				
			}
			//System.out.println(smallest.costSoFar);
			visited.add(smallest.currentNode);
		}
		return null;
		
	}

	public agendaState heuristicUcs(String start, String goal){
	
		agenda = new Vector<agendaState>( 0, 0);
		Vector<String> visited = new Vector<String>(0,0);
		agendaState smallest = new agendaState(start);
		Vector<agendaState> possibilities = new Vector<agendaState>( 0, 0);
		boolean makesure = true;
		
		agenda.add(smallest);
		visited.add(smallest.currentNode);
		
		while(agenda != null){
			
			if(smallest.currentNode.equals(goal)) return smallest;
			smallest.costSoFar += heuristicCostSoFar(smallest, goal);	
			//System.out.println(smallest.currentNode);
			agenda.addAll(expand(smallest));
			agendaState previous = smallest;
			smallest = null;
			for(agendaState state:agenda){
				if(visited.contains(state.currentNode))continue;
				if(smallest == null) smallest = state;
				if(state.costSoFar < smallest.costSoFar){
					smallest = state;
				}
				
			}
			//System.out.println(smallest.costSoFar);
			visited.add(smallest.currentNode);
		}
		return null;
		
	}
	
	public int costSoFar(agendaState ag){

		String prev = null;
		int someRet = 0;
		int weighting = 1;
		boolean addWeight = true;

		for(opPair op : ag.pathSoFar){
			//System.out.println(op.destination);
			if(prev == null){
				prev = op.tubeLine; continue;
			}
			//System.out.println(prev+"and"+op.tubeLine);
			if(op.tubeLine.equals(prev)) addWeight = false;
			if(addWeight) someRet += weighting;
			prev = op.tubeLine;
			addWeight = true;
		}
		//System.out.println(someRet);
		return someRet;
	}

	public int heuristicCostSoFar(agendaState ag, String goal){
		
		int prevMath;
		int nowMath;
		int destMath;
		int from;
		int to;
			
		//if(worldDescription.tubeZones(goal).firstElement() instanceof Character) destMath = Character.getNumericValue(worldDescription.tubeZones(goal).firstElement());
		 destMath = Integer.valueOf(worldDescription.tubeZones(goal).firstElement().charAt(0));
		
		int someRet = 0;
		int weighting = 1;
		boolean addWeight = true;
		Vector<String> goals = worldDescription.tubeZones(goal);
		Vector<String> prev = null;
		opPair now = null;
		for (opPair op : ag.pathSoFar){
			//System.out.println(op.destination);
			if(worldDescription.tubeZones(op.destination) == null) continue;
			if(worldDescription.tubeZones(op.destination).firstElement().equals(worldDescription.tubeZones(goal).firstElement())) continue;
			if (prev == null){ prev = worldDescription.tubeZones(op.destination); continue;
			}else if(now != null){ prev = worldDescription.tubeZones(now.destination);}
			//Vector<String> that = worldDescription.tubeZones(op.destination);
			
			for(String zone : worldDescription.tubeZones(op.destination)){
				if(prev.contains(zone)) addWeight = false;

			}
			//if(worldDescription.tubeZones(prev.destination).firstElement() instanceof Character) prevMath = Character.getNumericValue(worldDescription.tubeZones(prev.destination));
			 prevMath = Integer.valueOf(prev.firstElement().charAt(0));
			 //catch(Exception e){prevMath = }

			//if(worldDescription.tubeZones(op.destination).firstElement() instanceof Character) nowMath = Character.getNumericValue(worldDescription.tubeZones(op.destination));
			 nowMath = Integer.valueOf(worldDescription.tubeZones(op.destination).firstElement().charAt(0));
			//System.out.println(nowMath);

			if(Math.abs(prevMath - destMath) < Math.abs(nowMath - destMath)) addWeight = true;
			now = op;
			if(addWeight) someRet+=weighting;
			addWeight = true;
		}
		//System.out.println(someRet);
		return someRet;
	}

	// put any other private methods you write here

}
