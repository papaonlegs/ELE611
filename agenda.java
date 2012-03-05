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
		Vector<opPair> operators = tubeMap.operators(currentState.currentNode);
		for(opPair operator : operators)
			expandedStates.add(new agendaState(operator.destination, tubeMap.cost(currenState.currentNode, operator.destination), tubeMap.operators(operator.destination)));
		expansionSteps++;
		return expandedStates;
	}

	// public agendaState dfs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place.
										// Use the specification in the lecture notes.
										
	public agendaState dfs( String start, String goal ){
		
		Stack stack = new Stack();
		agendaState beginning = new agendaState(start);
		agenda.add(beginning);
		stack.push(beginning);
		Vector<agendaState> next = agenda.expand(beginning);
		
	}

	// public agendaState bfs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place

	// public agendaState ucs( String start, String goal )			// use the expand method to compute the
										// next possible states and insert them
										// into the agenda at the appropriate place

	// put any other private methods you write here

}
