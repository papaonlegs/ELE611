import java.*;
import java.util.*;

public class tubeSearch
{
	public static void main( String[] args )	// main method for call to tubeSearch
	{						// expected call: java tubeSearch Stn1 Stn2
							// where Stn1 and Stn2 are strings naming stations
		tubeMap tubeMap = new tubeMap();	// create the map object

		if ( ! tubeMap.exists( args[0] ))					// check inputs
			System.out.println( args[0] + " is not a known station." );

		else if ( ! tubeMap.exists( args[1] ))
			System.out.println( args[1] + " is not a known station." );

		else 
		{
			agenda<tubeMap> agenda = new agenda<tubeMap>( tubeMap ); // create an agenda of type
										 // tubemap and pass the object
			agendaState result = agenda.bfs( args[0], args[1] );	 // call the bfs method

			System.out.println( "BFS Result:\n" + tubeMap.routeString( result.pathSoFar ) + "at cost " + result.costSoFar + "\nExpanded " + agenda.expansionSteps + " nodes.\n========\n" ); // output results

			//result = agenda.ucs( args[0], args[1] );		// call the bfs method

			//System.out.println( "UCS Result:\n" + tubeMap.routeString( result.pathSoFar ) + "at cost " + result.costSoFar+ "\nExpanded " + agenda.expansionSteps + " nodes.\n========\n"  ); // output results

			result = agenda.dfs( args[0], args[1] );		// call the ucs method

			System.out.println( "DFS Result:\n" + tubeMap.routeString( result.pathSoFar ) + "at cost " + result.costSoFar+ "\nExpanded " + agenda.expansionSteps + " nodes."  ); // output results
		}

	}
}

