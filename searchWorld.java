import java.lang.String;
import java.util.Vector;

public interface searchWorld<Label,Operator>
{

	// this interface acts as a type declaration for the search world
	// (in this case, tubemap) so that the Java compiler knows how to
	// compile before the run time objects are created.

        public String test = "searchWorld";

        public Vector<Operator> operators( Label start );

	public int cost( Label start, Label end );

	public Vector<Label> tubeZones( Label station ); //remove
	
	public int costSoFar( Vector<Operator> pairs ); // remove
	
	public boolean pairExist( Label station, Label line ); //remove

}

