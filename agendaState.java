import java.*;
import java.util.*;

public class agendaState
{
	// this is the basic state representation: it consists of a string
	// naming the current state after the current station, an integer
	// which is the totat cost so far to get to this point, and a
	// vector of pairs which contains the route taken to get here.

	String currentNode;
	int costSoFar;
	Vector<opPair> pathSoFar;

	agendaState( String newNode )  // create a new node with a starting point
	{
		currentNode = newNode;
		pathSoFar = new Vector<opPair>( 0, 1 );
		pathSoFar.add( new opPair( "start", newNode ));
		costSoFar = 0;
	}

	agendaState( String newNode, int newCost, Vector<opPair> newPath )
	{
					// create a new node with values derived
					// by other code, and passed via arguments
		currentNode = newNode;
		pathSoFar = newPath;
		costSoFar = newCost ;
	}
}
