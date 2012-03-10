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
										
	/**public agendaState ucs(String start, String goal){
	
		Vector<String> visited = new Vector<String>(0,0);
		agendaState position = new agendaState(start);
		agendaState smallest = new agendaState(start);
		
		agenda.add(position);
		visited.add(position.currentNode);
		
		position = agenda.lastElement();
		while(agenda != null){
			
			
			if(position.currentNode.equals(goal))return position;
			
			agendaState smallest = new agendaState(start);
			for(agendaState state : expand(position)){
				if(smallest.costSoFar == 0) smallest = state;
				if(visited.contains(smallest.currentNode)){ continue;}
				else{ visited.add(smallest.currentNode);
						agenda.add(smallest); }
				if(smallest.costSoFar >= state.costSoFar) smallest = state;
			}
			position = smallest;
			/**for(agendaState state : expand(position)){
				
				if(position.costSoFar == 0) position = state;
				
				if(visited.contains(position.currentNode)){
					//position = null;
					continue;
				}else
				if(position.costSoFar >= state.costSoFar){ 
					position = state; 
					visited.add(position.currentNode);
					continue;
				}
				System.out.println(position.currentNode);
				
			}
			
			System.out.println(position.currentNode);
			if(visited.contains(position.currentNode)){
				agenda.remove(agenda.lastElement());
			}
		}
		return null;
	}*/
	
	public agendaState bucs(String start, String goal){
	
		agenda = new Vector<agendaState>( 0, 0);
		Vector<String> visited = new Vector<String>(0,0);
		agendaState smallest = new agendaState(start);
		
		agenda.add(smallest);
		visited.add(smallest.currentNode);
		
		while(agenda != null){
			Vector<agendaState> temp = agenda;
			if(smallest.currentNode.equals(goal)) return smallest;
			
			for(agendaState item:expand(smallest)){
				agenda.add(item);
			}
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
	
	public Vector<agendaState> arrange(Vector<agendaState> unsorted){
	
		Vector<agendaState> returnVector = new Vector<agendaState>(0,0);
		int i=0;
		int[] numbers = new int[unsorted.size()];
		for (agendaState unsort: unsorted){
			numbers[i] = unsort.costSoFar;
			i++;
		}
		
		Arrays.sort(numbers);
		for(int j=0; j<=numbers.length;j++){
			for (agendaState item : unsorted){
				if (item.costSoFar == numbers[j]){
					returnVector.add(item);
					unsorted.remove(item);
					break;
				}
			}
		}
		
		return returnVector;
	}

	// put any other private methods you write here

}
