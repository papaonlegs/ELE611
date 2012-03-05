public class opPair
{
	// a pair of strings used to represent an operator (moving down a
	// particular line to a particular station)

	String tubeLine;
	String destination;

	opPair( String theLine, String theDestination )
	{
		tubeLine = theLine;
		destination = theDestination;
	}

	public boolean equals( opPair comparee )  // equality method for a pair
	{
		return tubeLine.equals( comparee.tubeLine ) &&
			       destination.equals( comparee.destination );
	}
}
