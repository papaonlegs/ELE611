public class tubeStep
{
	public String start;	// the starting station of this step
	public String end;	// the ending stationg of thie step
	public String line;	// the tube line of this step
	public int time;	// the average time taken on this step
	public String zone;	// the main zone of the station
	public String otherZone;// the secondary zone of the station; "0" if there isn't one
	
	public tubeStep( String startInit, String endInit, String lineInit, 
			 int timeInit, String zoneInit, String otherZoneInit )
	{
		// all the parameters of this object are simply set by the code that creates it

		start = startInit;
		end = endInit;
		line = lineInit;
		time = timeInit;
		zone = zoneInit;
		otherZone = otherZoneInit;
	} 
}

