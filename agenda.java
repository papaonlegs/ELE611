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
		tubeMap tubemap = new tubeMap();
		Vector<agendaState> expandedStates = new Vector<agendaState>( 0, 0);
		Vector<opPair> operators = tubemap.operators(currentState.currentNode);
		for(opPair operator : operators)
			expandedStates.add(new agendaState(operator.destination, tubemap.cost(currentState.currentNode, operator.destination), tubemap.operators(operator.destination)));
		expansionSteps++;
		return expandedStates;
	}

	// public agendaState dfs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place.
										// Use the specification in the lecture notes.
										
	public agendaState dfs( String start, String goal ){
		tubeMap tubeMap = new tubeMap();
		agenda<tubeMap> agend = new agenda<tubeMap>(tubeMap);
		Vector<String> visited = new Vector<String>(0,0);
		Stack stack = new Stack();
		agendaState position = new agendaState(start);
		agenda.add(position);
		stack.push(position);
		visited.add(position.currentNode);
		if(agenda.contains(position)) System.out.println("contains works");
		//System.out.println(position.currentNode);
		while(!stack.isEmpty()){
			position = (agendaState) stack.peek();
			if (position.currentNode.equals(goal)){ return position; }
			Vector<agendaState> possibilities = agend.expand(position);
			for(agendaState possibility : possibilities){
				//agendaState pos = new agendaState(possibility.currentNode, possibility.costSoFar, possibility.pathSoFar);
				if(visited.contains( possibility.currentNode)){ 
				//System.out.println("null!");
				position = null; 
				continue;
				}else {
				//System.out.println("not in list!" + possibility.currentNode);
				//stack.push(position);
				position = possibility; 
				break;
				}
			}
			//System.out.println(position.currentNode);
			//System.out.println("Vecky :" +agenda.lastElement().currentNode);
			if (position == null){
				stack.pop();
				//System.out.println("pop!" + position.currentNode);
			}else{
				//System.out.println(position.currentNode);
				stack.push(position);
				agenda.add(position);
				visited.add(position.currentNode);
			}
		}

		//Vector<agendaState> next = agenda.expand(beginning);
		return null;
	}

	// public agendaState bfs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place
										
	public agendaState bfs(String start, String goal){
		tubeMap tubeMap = new tubeMap();
		agenda<tubeMap> agend = new agenda<tubeMap>(tubeMap);
		Vector<String> visited = new Vector<String>(0,0);
		Vector<agendaState> possibilities = new Vector<agendaState>(0,0);
		agendaState position = new agendaState(start);
		agenda.add(position);
		possibilities.add(position);
		visited.add(position.currentNode);
		while(possibilities != null){
			Vector<agendaState> temps = possibilities;
			possibilities = new Vector<agendaState>(0,0);
			for(agendaState temp : temps){
			//System.out.println("First loop:"+temp.currentNode);
				for (agendaState possibility : agend.expand(temp)){
					//System.out.println("Second loop:"+ possibility.currentNode);
					if (possibility.currentNode.equals(goal)){ return possibility; }
					if (visited.contains( possibility.currentNode)){
					continue;
					}else{
						visited.add(possibility.currentNode);
						agenda.add(position);
						possibilities.add(possibility);
					}
				}
			}
			//System.out.println("Vecky :" +agenda.lastElement().currentNode);
		}
		
		return null;
		
	}

	// public agendaState ucs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place

	// put any other private methods you write here

}
