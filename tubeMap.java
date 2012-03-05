import java.util.*;
import java.io.*;

public class tubeMap implements searchWorld<String,opPair>
{
	private static Vector<tubeStep> map;	// the map is stored as a vector of tubeSteps (see class defn)

	public tubeMap()	// constructor
	{
		map = new Vector<tubeStep>( 0, 1 );

		map.add( new tubeStep( "Harrow & Wealdstone", "Kenton", "Bakerloo", 3, "5", "0" ));	// add one step
		map.add( new tubeStep( "Kenton", "South Kenton", "Bakerloo", 2, "4", "0" ));		// etc.
		map.add( new tubeStep( "South Kenton", "North Wembley", "Bakerloo", 2, "4", "0" ));
		map.add( new tubeStep( "North Wembley", "Wembley Central", "Bakerloo", 2, "4", "0" ));
		map.add( new tubeStep( "Wembley Central", "Stonebridge Park", "Bakerloo", 3, "4", "0" ));
		map.add( new tubeStep( "Stonebridge Park", "Harlesden", "Bakerloo", 2, "3", "0" ));
		map.add( new tubeStep( "Harlesden", "Willesden Junction", "Bakerloo", 2, "3", "0" ));
		map.add( new tubeStep( "Willesden Junction", "Kensal Green", "Bakerloo", 3, "3", "0" ));
		map.add( new tubeStep( "Kensal Green", "Queen's Park", "Bakerloo", 3, "2", "0" ));
		map.add( new tubeStep( "Queen's Park", "Kilburn Park", "Bakerloo", 2, "2", "0" ));
		map.add( new tubeStep( "Kilburn Park", "Maida Vale", "Bakerloo", 2, "2", "0" ));
		map.add( new tubeStep( "Maida Vale", "Warwick Avenue", "Bakerloo", 1, "2", "0" ));
		map.add( new tubeStep( "Warwick Avenue", "Paddington", "Bakerloo", 2, "2", "0" ));
		map.add( new tubeStep( "Paddington", "Edgware Road", "Bakerloo", 3, "1", "0" ));
		map.add( new tubeStep( "Edgware Road", "Marylebone", "Bakerloo", 2, "1", "0" ));
		map.add( new tubeStep( "Marylebone", "Baker Street", "Bakerloo", 1, "1", "0" ));
		map.add( new tubeStep( "Baker Street", "Regent's Park", "Bakerloo", 2, "1", "0" ));
		map.add( new tubeStep( "Regent's Park", "Oxford Circus", "Bakerloo", 2, "1", "0" ));
		map.add( new tubeStep( "Oxford Circus", "Piccadilly Circus", "Bakerloo", 2, "1", "0" ));
		map.add( new tubeStep( "Piccadilly Circus", "Charing Cross", "Bakerloo", 2, "1", "0" ));
		map.add( new tubeStep( "Charing Cross", "Embankment", "Bakerloo", 1, "1", "0" ));
		map.add( new tubeStep( "Embankment", "Waterloo", "Bakerloo", 2, "1", "0" ));
		map.add( new tubeStep( "Waterloo", "Lambeth North", "Bakerloo", 1, "1", "0" ));
		map.add( new tubeStep( "Lambeth North", "Elephant & Castle", "Bakerloo", 3, "1", "0" ));
		map.add( new tubeStep( "West Ruislip", "Ruislip Gardens", "Central", 3, "6", "0" ));
		map.add( new tubeStep( "Ruislip Gardens", "South Ruislip", "Central", 1, "5", "0" ));
		map.add( new tubeStep( "South Ruislip", "Northolt", "Central", 3, "5", "0" ));
		map.add( new tubeStep( "Northolt", "Greenford", "Central", 2, "5", "0" ));
		map.add( new tubeStep( "Greenford", "Perivale", "Central", 2, "4", "0" ));
		map.add( new tubeStep( "Perivale", "Hanger Lane", "Central", 2, "4", "0" ));
		map.add( new tubeStep( "Hanger Lane", "North Acton", "Central", 2, "3", "0" ));
		map.add( new tubeStep( "Ealing Broadway", "West Acton", "Central", 3, "3", "0" ));
		map.add( new tubeStep( "West Acton", "North Acton", "Central", 2, "3", "0" ));
		map.add( new tubeStep( "North Acton", "East Acton", "Central", 2, "2", "3" ));
		map.add( new tubeStep( "East Acton", "White City", "Central", 3, "2", "0" ));
		map.add( new tubeStep( "White City", "Shepherd's Bush", "Central", 3, "2", "0" ));
		map.add( new tubeStep( "Shepherd's Bush", "Holland Park", "Central", 2, "2", "0" ));
		map.add( new tubeStep( "Holland Park", "Notting Hill Gate", "Central", 2, "2", "0" ));
		map.add( new tubeStep( "Notting Hill Gate", "Queensway", "Central", 2, "1", "2" ));
		map.add( new tubeStep( "Queensway", "Lancaster Gate", "Central", 1, "1", "0" ));
		map.add( new tubeStep( "Lancaster Gate", "Marble Arch", "Central", 3, "1", "0" ));
		map.add( new tubeStep( "Marble Arch", "Bond Street", "Central", 1, "1", "0" ));
		map.add( new tubeStep( "Bond Street", "Oxford Circus", "Central", 1, "1", "0" ));
		map.add( new tubeStep( "Oxford Circus", "Tottenham Court Road", "Central", 2, "1", "0" ));
		map.add( new tubeStep( "Tottenham Court Road", "Holborn", "Central", 2, "1", "0" ));
		map.add( new tubeStep( "Holborn", "Chancery Lane", "Central", 1, "1", "0" ));
		map.add( new tubeStep( "Chancery Lane", "St. Paul's", "Central", 2, "1", "0" ));
		map.add( new tubeStep( "St. Paul's", "Bank/Monument", "Central", 2, "1", "0" ));
		map.add( new tubeStep( "Bank/Monument", "Liverpool Street", "Central", 2, "1", "0" ));
		map.add( new tubeStep( "Liverpool Street", "Bethnal Green", "Central", 3, "1", "0" ));
		map.add( new tubeStep( "Bethnal Green", "Mile End", "Central", 2, "2", "0" ));
		map.add( new tubeStep( "Mile End", "Stratford", "Central", 4, "2", "0" ));
		map.add( new tubeStep( "Stratford", "Leyton", "Central", 2, "3", "0" ));
		map.add( new tubeStep( "Leyton", "Leytonstone", "Central", 3, "3", "0" ));
		map.add( new tubeStep( "Leytonstone", "Wanstead", "Central", 2, "3", "4" ));
		map.add( new tubeStep( "Wanstead", "Redbridge", "Central", 2, "4", "0" ));
		map.add( new tubeStep( "Redbridge", "Gants Hill", "Central", 2, "4", "0" ));
		map.add( new tubeStep( "Gants Hill", "Newbury Park", "Central", 3, "5", "6" ));
		map.add( new tubeStep( "Newbury Park", "Barkingside", "Central", 2, "4", "0" ));
		map.add( new tubeStep( "Barkingside", "Fairlop", "Central", 2, "5", "0" ));
		map.add( new tubeStep( "Fairlop", "Hainault", "Central", 2, "5", "0" ));
		map.add( new tubeStep( "Hainault", "Grange Hill", "Central", 2, "5", "0" ));
		map.add( new tubeStep( "Grange Hill", "Chigwell", "Central", 2, "5", "0" ));
		map.add( new tubeStep( "Chigwell", "Roding Valley", "Central", 2, "5", "0" ));
		map.add( new tubeStep( "Roding Valley", "Woodford", "Central", 3, "5", "0" ));
		map.add( new tubeStep( "Leytonstone", "Snaresbrook", "Central", 2, "3", "4" ));
		map.add( new tubeStep( "Snaresbrook", "South Woodford", "Central", 2, "4", "0" ));
		map.add( new tubeStep( "South Woodford", "Woodford", "Central", 2, "4", "0" ));
		map.add( new tubeStep( "Woodford", "Buckhurst Hill", "Central", 3, "4", "0" ));
		map.add( new tubeStep( "Buckhurst Hill", "Loughton", "Central", 2, "5", "0" ));
		map.add( new tubeStep( "Loughton", "Debden", "Central", 2, "6", "0" ));
		map.add( new tubeStep( "Debden", "Theydon Bois", "Central", 3, "6", "0" ));
		map.add( new tubeStep( "Theydon Bois", "Epping", "Central", 2, "6", "0" ));
		map.add( new tubeStep( "Paddington", "Edgware Road", "Circle", 3, "1", "0" ));
		map.add( new tubeStep( "Edgware Road", "Baker Street", "Circle", 3, "1", "0" ));
		map.add( new tubeStep( "Baker Street", "Great Portland Street", "Circle", 3, "1", "0" ));
		map.add( new tubeStep( "Great Portland Street", "Euston Square", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Euston Square", "King's Cross St. Pancras", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "King's Cross St. Pancras", "Farringdon", "Circle", 4, "1", "0" ));
		map.add( new tubeStep( "Farringdon", "Barbican", "Circle", 1, "1", "0" ));
		map.add( new tubeStep( "Barbican", "Moorgate", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Moorgate", "Liverpool Street", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Liverpool Street", "Aldgate", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Aldgate", "Tower Hill", "Circle", 4, "1", "0" ));
		map.add( new tubeStep( "Tower Hill", "Bank/Monument", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Bank/Monument", "Cannon Street", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Cannon Street", "Mansion House", "Circle", 1, "1", "0" ));
		map.add( new tubeStep( "Mansion House", "Blackfriars", "Circle", 1, "1", "0" ));
		map.add( new tubeStep( "Blackfriars", "Temple", "Circle", 1, "1", "0" ));
		map.add( new tubeStep( "Temple", "Embankment", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Embankment", "Westminster", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Westminster", "St. James' Park", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "St. James' Park", "Victoria", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Victoria", "Sloane Square", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Sloane Square", "South Kensington", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "South Kensington", "Gloucester Road", "Circle", 1, "1", "0" ));
		map.add( new tubeStep( "Gloucester Road", "High Street Kensington", "Circle", 4, "1", "0" ));
		map.add( new tubeStep( "High Street Kensington", "Notting Hill Gate", "Circle", 3, "1", "0" ));
		map.add( new tubeStep( "Notting Hill Gate", "Bayswater", "Circle", 2, "1", "2" ));
		map.add( new tubeStep( "Bayswater", "Paddington", "Circle", 2, "1", "0" ));
		map.add( new tubeStep( "Ealing Broadway", "Ealing Common", "District", 4, "3", "0" ));
		map.add( new tubeStep( "Ealing Common", "Acton Town", "District", 2, "3", "0" ));
		map.add( new tubeStep( "Acton Town", "Chiswick Park", "District", 2, "3", "0" ));
		map.add( new tubeStep( "Chiswick Park", "Turnham Green", "District", 2, "3", "0" ));
		map.add( new tubeStep( "Wimbledon", "Wimbledon Park", "District", 3, "3", "0" ));
		map.add( new tubeStep( "Wimbledon Park", "Southfields", "District", 3, "3", "0" ));
		map.add( new tubeStep( "Southfields", "East Putney", "District", 2, "3", "0" ));
		map.add( new tubeStep( "East Putney", "Putney Bridge", "District", 2, "2", "3" ));
		map.add( new tubeStep( "Putney Bridge", "Parsons Green", "District", 3, "2", "0" ));
		map.add( new tubeStep( "Parsons Green", "Fulham Broadway", "District", 2, "2", "0" ));
		map.add( new tubeStep( "Fulham Broadway", "West Brompton", "District", 1, "2", "0" ));
		map.add( new tubeStep( "West Brompton", "Earls' Court", "District", 2, "2", "0" ));
		map.add( new tubeStep( "Olympia", "Earls' Court", "District", 3, "2", "0" ));
		map.add( new tubeStep( "Edgware Road", "Paddington", "District", 3, "1", "0" ));
		map.add( new tubeStep( "Paddington", "Bayswater", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Bayswater", "Notting Hill Gate", "District", 3, "1", "0" ));
		map.add( new tubeStep( "Notting Hill Gate", "High Street Kensington", "District", 3, "1", "2" ));
		map.add( new tubeStep( "High Street Kensington", "Earls' Court", "District", 3, "1", "0" ));
		map.add( new tubeStep( "Richmond", "Kew Gardens", "District", 3, "4", "0" ));
		map.add( new tubeStep( "Kew Gardens", "Gunnersbury", "District", 3, "3", "4" ));
		map.add( new tubeStep( "Gunnersbury", "Turnham Green", "District", 3, "3", "0" ));
		map.add( new tubeStep( "Turnham Green", "Stamford Brook", "District", 1, "2", "3" ));
		map.add( new tubeStep( "Stamford Brook", "Ravenscourt Park", "District", 2, "2", "0" ));
		map.add( new tubeStep( "Ravenscourt Park", "Hammersmith", "District", 2, "2", "0" ));
		map.add( new tubeStep( "Hammersmith", "Barons Court", "District", 1, "2", "0" ));
		map.add( new tubeStep( "Hammersmith", "Barons Court", "District", 1, "2", "0" ));
		map.add( new tubeStep( "Barons Court", "West Kensington", "District", 2, "2", "0" ));
		map.add( new tubeStep( "West Kensington", "Earls' Court", "District", 2, "2", "0" ));
		map.add( new tubeStep( "Earls' Court", "Gloucester Road", "District", 3, "1", "2" ));
		map.add( new tubeStep( "Gloucester Road", "South Kensington", "District", 1, "1", "0" ));
		map.add( new tubeStep( "South Kensington", "Sloane Square", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Sloane Square", "Victoria", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Victoria", "St. James' Park", "District", 2, "1", "0" ));
		map.add( new tubeStep( "St. James' Park", "Westminster", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Westminster", "Embankment", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Embankment", "Temple", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Temple", "Blackfriars", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Blackfriars", "Mansion House", "District", 1, "1", "0" ));
		map.add( new tubeStep( "Mansion House", "Cannon Street", "District", 1, "1", "0" ));
		map.add( new tubeStep( "Cannon Street", "Bank/Monument", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Bank/Monument", "Tower Hill", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Tower Hill", "Aldgate East", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Aldgate East", "Whitechapel", "District", 2, "1", "0" ));
		map.add( new tubeStep( "Whitechapel", "Stepney Green", "District", 3, "2", "0" ));
		map.add( new tubeStep( "Stepney Green", "Mile End", "District", 2, "2", "0" ));
		map.add( new tubeStep( "Mile End", "Bow Road", "District", 1, "2", "0" ));
		map.add( new tubeStep( "Bow Road", "Bromley-by-Bow", "District", 2, "2", "0" ));
		map.add( new tubeStep( "Bromley-by-Bow", "West Ham", "District", 2, "2", "3" ));
		map.add( new tubeStep( "West Ham", "Plaistow", "District", 2, "3", "0" ));
		map.add( new tubeStep( "Plaistow", "Upton Park", "District", 2, "3", "0" ));
		map.add( new tubeStep( "Upton Park", "East Ham", "District", 2, "3", "0" ));
		map.add( new tubeStep( "East Ham", "Barking", "District", 4, "3", "4" ));
		map.add( new tubeStep( "Barking", "Upney", "District", 2, "4", "0" ));
		map.add( new tubeStep( "Upney", "Becontree", "District", 2, "4", "0" ));
		map.add( new tubeStep( "Becontree", "Dagenham Heathway", "District", 3, "5", "0" ));
		map.add( new tubeStep( "Dagenham Heathway", "Dagenham East", "District", 4, "5", "0" ));
		map.add( new tubeStep( "Dagenham East", "Elm Park", "District", 3, "5", "0" ));
		map.add( new tubeStep( "Elm Park", "Hornchurch", "District", 2, "6", "0" ));
		map.add( new tubeStep( "Hornchurch", "Upminster Bridge", "District", 2, "6", "0" ));
		map.add( new tubeStep( "Upminster Bridge", "Upminster", "District", 3, "6", "0" ));
		map.add( new tubeStep( "Shoreditch", "Whitechapel", "East London", 2, "2", "0" ));
		map.add( new tubeStep( "Whitechapel", "Shadwell", "East London", 2, "2", "0" ));
		map.add( new tubeStep( "Shadwell", "Wapping", "East London", 1, "2", "0" ));
		map.add( new tubeStep( "Wapping", "Rotherhithe", "East London", 1, "2", "0" ));
		map.add( new tubeStep( "Rotherhithe", "Canada Water", "East London", 1, "2", "0" ));
		map.add( new tubeStep( "Canada Water", "Surrey Quays", "East London", 2, "2", "0" ));
		map.add( new tubeStep( "Surrey Quays", "New Cross Gate", "East London", 4, "2", "0" ));
		map.add( new tubeStep( "Surrey Quays", "New Cross", "East London", 4, "2", "0" ));
		map.add( new tubeStep( "Hammersmith", "Goldhawk Road", "Hammersmith & City", 2, "2", "0" ));
		map.add( new tubeStep( "Hammersmith", "Goldhawk Road", "Hammersmith & City", 2, "2", "0" ));
		map.add( new tubeStep( "Goldhawk Road", "Shepherd's Bush", "Hammersmith & City", 1, "2", "0" ));
		map.add( new tubeStep( "Shepherd's Bush", "Latimer Road", "Hammersmith & City", 2, "2", "0" ));
		map.add( new tubeStep( "Latimer Road", "Ladbroke Grove", "Hammersmith & City", 1, "2", "0" ));
		map.add( new tubeStep( "Ladbroke Grove", "Westbourne Park", "Hammersmith & City", 2, "2", "0" ));
		map.add( new tubeStep( "Westbourne Park", "Royal Oak", "Hammersmith & City", 2, "2", "0" ));
		map.add( new tubeStep( "Royal Oak", "Paddington", "Hammersmith & City", 1, "2", "0" ));
		map.add( new tubeStep( "Paddington", "Edgware Road", "Hammersmith & City", 4, "1", "0" ));
		map.add( new tubeStep( "Edgware Road", "Baker Street", "Hammersmith & City", 3, "1", "0" ));
		map.add( new tubeStep( "Baker Street", "Great Portland Street", "Hammersmith & City", 3, "1", "0" ));
		map.add( new tubeStep( "Great Portland Street", "Euston Square", "Hammersmith & City", 2, "1", "0" ));
		map.add( new tubeStep( "Euston Square", "King's Cross St. Pancras", "Hammersmith & City", 2, "1", "0" ));
		map.add( new tubeStep( "King's Cross St. Pancras", "Farringdon", "Hammersmith & City", 4, "1", "0" ));
		map.add( new tubeStep( "Farringdon", "Barbican", "Hammersmith & City", 1, "1", "0" ));
		map.add( new tubeStep( "Barbican", "Moorgate", "Hammersmith & City", 2, "1", "0" ));
		map.add( new tubeStep( "Moorgate", "Liverpool Street", "Hammersmith & City", 2, "1", "0" ));
		map.add( new tubeStep( "Liverpool Street", "Aldgate East", "Hammersmith & City", 4, "1", "0" ));
		map.add( new tubeStep( "Aldgate East", "Whitechapel", "Hammersmith & City", 2, "1", "0" ));
		map.add( new tubeStep( "Whitechapel", "Stepney Green", "Hammersmith & City", 3, "2", "0" ));
		map.add( new tubeStep( "Stepney Green", "Mile End", "Hammersmith & City", 2, "2", "0" ));
		map.add( new tubeStep( "Mile End", "Bow Road", "Hammersmith & City", 1, "2", "0" ));
		map.add( new tubeStep( "Bow Road", "Bromley-by-Bow", "Hammersmith & City", 2, "2", "0" ));
		map.add( new tubeStep( "Bromley-by-Bow", "West Ham", "Hammersmith & City", 2, "2", "3" ));
		map.add( new tubeStep( "West Ham", "Plaistow", "Hammersmith & City", 2, "3", "0" ));
		map.add( new tubeStep( "Plaistow", "Upton Park", "Hammersmith & City", 2, "3", "0" ));
		map.add( new tubeStep( "Upton Park", "East Ham", "Hammersmith & City", 2, "3", "0" ));
		map.add( new tubeStep( "East Ham", "Barking", "Hammersmith & City", 4, "3", "4" ));
		map.add( new tubeStep( "Stanmore", "Canons Park", "Jubilee", 2, "5", "0" ));
		map.add( new tubeStep( "Canons Park", "Queensbury", "Jubilee", 2, "5", "0" ));
		map.add( new tubeStep( "Queensbury", "Kingsbury", "Jubilee", 2, "4", "0" ));
		map.add( new tubeStep( "Kingsbury", "Wembley Park", "Jubilee", 4, "4", "0" ));
		map.add( new tubeStep( "Wembley Park", "Neasden", "Jubilee", 4, "4", "0" ));
		map.add( new tubeStep( "Neasden", "Dollis Hill", "Jubilee", 2, "3", "0" ));
		map.add( new tubeStep( "Dollis Hill", "Willesden Green", "Jubilee", 2, "3", "0" ));
		map.add( new tubeStep( "Willesden Green", "Kilburn", "Jubilee", 2, "2", "3" ));
		map.add( new tubeStep( "Kilburn", "West Hampstead", "Jubilee", 2, "2", "0" ));
		map.add( new tubeStep( "West Hampstead", "Finchley Road", "Jubilee", 1, "2", "0" ));
		map.add( new tubeStep( "Finchley Road", "Swiss Cottage", "Jubilee", 2, "2", "0" ));
		map.add( new tubeStep( "Swiss Cottage", "St. John's Wood", "Jubilee", 1, "2", "0" ));
		map.add( new tubeStep( "St. John's Wood", "Baker Street", "Jubilee", 4, "2", "0" ));
		map.add( new tubeStep( "Baker Street", "Bond Street", "Jubilee", 2, "1", "0" ));
		map.add( new tubeStep( "Bond Street", "Green Park", "Jubilee", 2, "1", "0" ));
		map.add( new tubeStep( "Green Park", "Westminster", "Jubilee", 3, "1", "0" ));
		map.add( new tubeStep( "Westminster", "Waterloo", "Jubilee", 2, "1", "0" ));
		map.add( new tubeStep( "Waterloo", "Southwark", "Jubilee", 1, "1", "0" ));
		map.add( new tubeStep( "Southwark", "London Bridge", "Jubilee", 2, "1", "0" ));
		map.add( new tubeStep( "London Bridge", "Bermondsey", "Jubilee", 3, "1", "0" ));
		map.add( new tubeStep( "Bermondsey", "Canada Water", "Jubilee", 2, "2", "0" ));
		map.add( new tubeStep( "Canada Water", "Canary Wharf", "Jubilee", 3, "2", "0" ));
		map.add( new tubeStep( "Canary Wharf", "North Greenwich", "Jubilee", 3, "2", "0" ));
		map.add( new tubeStep( "North Greenwich", "Canning Town", "Jubilee", 3, "2", "3" ));
		map.add( new tubeStep( "Canning Town", "West Ham", "Jubilee", 3, "3", "0" ));
		map.add( new tubeStep( "West Ham", "Stratford", "Jubilee", 3, "3", "0" ));
		map.add( new tubeStep( "Aldgate", "Liverpool Street", "Metropolitan", 2, "1", "0" ));
		map.add( new tubeStep( "Liverpool Street", "Moorgate", "Metropolitan", 2, "1", "0" ));
		map.add( new tubeStep( "Moorgate", "Barbican", "Metropolitan", 2, "1", "0" ));
		map.add( new tubeStep( "Barbican", "Farringdon", "Metropolitan", 1, "1", "0" ));
		map.add( new tubeStep( "Farringdon", "King's Cross St. Pancras", "Metropolitan", 4, "1", "0" ));
		map.add( new tubeStep( "King's Cross St. Pancras", "Euston Square", "Metropolitan", 2, "1", "0" ));
		map.add( new tubeStep( "Euston Square", "Great Portland Street", "Metropolitan", 2, "1", "0" ));
		map.add( new tubeStep( "Great Portland Street", "Baker Street", "Metropolitan", 3, "1", "0" ));
		map.add( new tubeStep( "Baker Street", "Finchley Road", "Metropolitan", 6, "1", "0" ));
		map.add( new tubeStep( "Finchley Road", "Wembley Park", "Metropolitan", 7, "2", "0" ));
		map.add( new tubeStep( "Wembley Park", "Preston Road", "Metropolitan", 3, "4", "0" ));
		map.add( new tubeStep( "Preston Road", "Northwick Park", "Metropolitan", 2, "4", "0" ));
		map.add( new tubeStep( "Northwick Park", "Harrow-on-the-Hill", "Metropolitan", 2, "4", "0" ));
		map.add( new tubeStep( "Harrow-on-the-Hill", "North Harrow", "Metropolitan", 3, "5", "0" ));
		map.add( new tubeStep( "North Harrow", "Pinner", "Metropolitan", 3, "5", "0" ));
		map.add( new tubeStep( "Pinner", "Northwood Hills", "Metropolitan", 2, "5", "0" ));
		map.add( new tubeStep( "Northwood Hills", "Northwood", "Metropolitan", 2, "6", "0" ));
		map.add( new tubeStep( "Northwood", "Moor Park", "Metropolitan", 3, "6", "0" ));
		map.add( new tubeStep( "Harrow-on-the-Hill", "West Harrow", "Metropolitan", 2, "5", "0" ));
		map.add( new tubeStep( "West Harrow", "Rayners Lane", "Metropolitan", 3, "5", "0" ));
		map.add( new tubeStep( "Rayners Lane", "Eastcote", "Metropolitan", 2, "5", "0" ));
		map.add( new tubeStep( "Eastcote", "Ruislip Manor", "Metropolitan", 2, "5", "0" ));
		map.add( new tubeStep( "Ruislip Manor", "Ruislip", "Metropolitan", 2, "6", "0" ));
		map.add( new tubeStep( "Ruislip", "Ickenham", "Metropolitan", 3, "6", "0" ));
		map.add( new tubeStep( "Ickenham", "Hillingdon", "Metropolitan", 2, "6", "0" ));
		map.add( new tubeStep( "Hillingdon", "Uxbridge", "Metropolitan", 3, "6", "0" ));
		map.add( new tubeStep( "Moor Park", "Croxley", "Metropolitan", 4, "6", "a" ));
		map.add( new tubeStep( "Croxley", "Watford", "Metropolitan", 3, "a", "0" ));
		map.add( new tubeStep( "Moor Park", "Rickmansworth", "Metropolitan", 4, "6", "a" ));
		map.add( new tubeStep( "Rickmansworth", "Chorleywood", "Metropolitan", 4, "a", "0" ));
		map.add( new tubeStep( "Chorleywood", "Chalfont & Latimer", "Metropolitan", 4, "b", "0" ));
		map.add( new tubeStep( "Chalfont & Latimer", "Chesham", "Metropolitan", 8, "c", "0" ));
		map.add( new tubeStep( "Chesham", "Amersham", "Metropolitan", 4, "d", "0" ));
		map.add( new tubeStep( "Mill Hill East", "Finchley Central", "Northern", 3, "4", "0" ));
		map.add( new tubeStep( "High Barnet", "Totteridge & Whetstone", "Northern", 3, "5", "0" ));
		map.add( new tubeStep( "Totteridge & Whetstone", "Woodside Park", "Northern", 3, "4", "0" ));
		map.add( new tubeStep( "Woodside Park", "West Finchley", "Northern", 1, "4", "0" ));
		map.add( new tubeStep( "West Finchley", "Finchley Central", "Northern", 2, "4", "0" ));
		map.add( new tubeStep( "Finchley Central", "East Finchley", "Northern", 4, "4", "0" ));
		map.add( new tubeStep( "East Finchley", "Highgate", "Northern", 2, "3", "0" ));
		map.add( new tubeStep( "Highgate", "Archway", "Northern", 3, "3", "0" ));
		map.add( new tubeStep( "Archway", "Tufnell Park", "Northern", 2, "2", "3" ));
		map.add( new tubeStep( "Tufnell Park", "Kentish Town", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Kentish Town", "Camden Town", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Edgware", "Burnt Oak", "Northern", 3, "5", "0" ));
		map.add( new tubeStep( "Burnt Oak", "Colindale", "Northern", 2, "4", "0" ));
		map.add( new tubeStep( "Colindale", "Hendon Central", "Northern", 3, "4", "0" ));
		map.add( new tubeStep( "Hendon Central", "Brent Cross", "Northern", 2, "3", "4" ));
		map.add( new tubeStep( "Brent Cross", "Golders Green", "Northern", 3, "3", "0" ));
		map.add( new tubeStep( "Golders Green", "Hampstead", "Northern", 4, "3", "0" ));
		map.add( new tubeStep( "Hampstead", "Belsize Park", "Northern", 2, "2", "3" ));
		map.add( new tubeStep( "Belsize Park", "Chalk Farm", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Chalk Farm", "Camden Town", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Camden Town", "Mornington Crescent", "Northern", 1, "2", "0" ));
		map.add( new tubeStep( "Mornington Crescent", "Euston", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Euston", "Warren Street", "Northern", 1, "1", "0" ));
		map.add( new tubeStep( "Warren Street", "Goodge Street", "Northern", 2, "1", "0" ));
		map.add( new tubeStep( "Goodge Street", "Tottenham Court Road", "Northern", 1, "1", "0" ));
		map.add( new tubeStep( "Tottenham Court Road", "Leicester Square", "Northern", 1, "1", "0" ));
		map.add( new tubeStep( "Leicester Square", "Charing Cross", "Northern", 2, "1", "0" ));
		map.add( new tubeStep( "Charing Cross", "Embankment", "Northern", 1, "1", "0" ));
		map.add( new tubeStep( "Embankment", "Waterloo", "Northern", 2, "1", "0" ));
		map.add( new tubeStep( "Waterloo", "Kennington", "Northern", 3, "1", "0" ));
		map.add( new tubeStep( "Euston", "King's Cross St. Pancras", "Northern", 2, "1", "0" ));
		map.add( new tubeStep( "King's Cross St. Pancras", "Angel", "Northern", 2, "1", "0" ));
		map.add( new tubeStep( "Angel", "Old Street", "Northern", 3, "1", "0" ));
		map.add( new tubeStep( "Old Street", "Moorgate", "Northern", 1, "1", "0" ));
		map.add( new tubeStep( "Moorgate", "Bank/Monument", "Northern", 3, "1", "0" ));
		map.add( new tubeStep( "Bank/Monument", "London Bridge", "Northern", 2, "1", "0" ));
		map.add( new tubeStep( "London Bridge", "Borough", "Northern", 2, "1", "0" ));
		map.add( new tubeStep( "Borough", "Elephant & Castle", "Northern", 1, "1", "0" ));
		map.add( new tubeStep( "Elephant & Castle", "Kennington", "Northern", 2, "1", "2" ));
		map.add( new tubeStep( "Kennington", "Oval", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Oval", "Stockwell", "Northern", 3, "2", "0" ));
		map.add( new tubeStep( "Stockwell", "Clapham North", "Northern", 1, "2", "0" ));
		map.add( new tubeStep( "Clapham North", "Clapham Common", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Clapham Common", "Clapham South", "Northern", 2, "2", "0" ));
		map.add( new tubeStep( "Clapham South", "Balham", "Northern", 2, "2", "3" ));
		map.add( new tubeStep( "Balham", "Tooting Bec", "Northern", 1, "3", "0" ));
		map.add( new tubeStep( "Tooting Bec", "Tooting Broadway", "Northern", 2, "3", "0" ));
		map.add( new tubeStep( "Tooting Broadway", "Colliers Wood", "Northern", 2, "3", "0" ));
		map.add( new tubeStep( "Colliers Wood", "South Wimbledon", "Northern", 2, "3", "0" ));
		map.add( new tubeStep( "South Wimbledon", "Morden", "Northern", 4, "3", "4" ));
		map.add( new tubeStep( "Cockfosters", "Oakwood", "Piccadilly", 4, "5", "0" ));
		map.add( new tubeStep( "Oakwood", "Southgate", "Piccadilly", 3, "5", "0" ));
		map.add( new tubeStep( "Southgate", "Arnos Grove", "Piccadilly", 3, "4", "0" ));
		map.add( new tubeStep( "Arnos Grove", "Bounds Green", "Piccadilly", 3, "4", "0" ));
		map.add( new tubeStep( "Bounds Green", "Wood Green", "Piccadilly", 2, "3", "4" ));
		map.add( new tubeStep( "Wood Green", "Turnpike Lane", "Piccadilly", 2, "3", "0" ));
		map.add( new tubeStep( "Turnpike Lane", "Manor House", "Piccadilly", 3, "3", "0" ));
		map.add( new tubeStep( "Manor House", "Finsbury Park", "Piccadilly", 2, "2", "3" ));
		map.add( new tubeStep( "Finsbury Park", "Arsenal", "Piccadilly", 2, "2", "0" ));
		map.add( new tubeStep( "Arsenal", "Holloway Road", "Piccadilly", 1, "2", "0" ));
		map.add( new tubeStep( "Holloway Road", "Caledonian Road", "Piccadilly", 2, "2", "0" ));
		map.add( new tubeStep( "Caledonian Road", "King's Cross St. Pancras", "Piccadilly", 5, "2", "0" ));
		map.add( new tubeStep( "King's Cross St. Pancras", "Russell Square", "Piccadilly", 2, "1", "0" ));
		map.add( new tubeStep( "Russell Square", "Holborn", "Piccadilly", 2, "1", "0" ));
		map.add( new tubeStep( "Holborn", "Covent Garden", "Piccadilly", 1, "1", "0" ));
		map.add( new tubeStep( "Covent Garden", "Leicester Square", "Piccadilly", 1, "1", "0" ));
		map.add( new tubeStep( "Leicester Square", "Piccadilly Circus", "Piccadilly", 2, "1", "0" ));
		map.add( new tubeStep( "Piccadilly Circus", "Green Park", "Piccadilly", 1, "1", "0" ));
		map.add( new tubeStep( "Green Park", "Hyde Park Corner", "Piccadilly", 2, "1", "0" ));
		map.add( new tubeStep( "Hyde Park Corner", "Knightsbridge", "Piccadilly", 2, "1", "0" ));
		map.add( new tubeStep( "Knightsbridge", "South Kensington", "Piccadilly", 3, "1", "0" ));
		map.add( new tubeStep( "South Kensington", "Gloucester Road", "Piccadilly", 1, "1", "0" ));
		map.add( new tubeStep( "Gloucester Road", "Earls' Court", "Piccadilly", 2, "1", "0" ));
		map.add( new tubeStep( "Earls' Court", "Barons Court", "Piccadilly", 3, "1", "2" ));
		map.add( new tubeStep( "Barons Court", "Hammersmith", "Piccadilly", 2, "2", "0" ));
		map.add( new tubeStep( "Hammersmith", "Turnham Green", "Piccadilly", 3, "2", "0" ));
		map.add( new tubeStep( "Hammersmith", "Turnham Green", "Piccadilly", 3, "2", "0" ));
		map.add( new tubeStep( "Turnham Green", "Acton Town", "Piccadilly", 3, "2", "3" ));
		map.add( new tubeStep( "Acton Town", "South Ealing", "Piccadilly", 4, "3", "0" ));
		map.add( new tubeStep( "South Ealing", "Northfields", "Piccadilly", 1, "3", "0" ));
		map.add( new tubeStep( "Northfields", "Boston Manor", "Piccadilly", 2, "3", "0" ));
		map.add( new tubeStep( "Boston Manor", "Osterley", "Piccadilly", 3, "4", "0" ));
		map.add( new tubeStep( "Osterley", "Hounslow East", "Piccadilly", 2, "4", "0" ));
		map.add( new tubeStep( "Hounslow East", "Hounslow Central", "Piccadilly", 2, "4", "0" ));
		map.add( new tubeStep( "Hounslow Central", "Hounslow West", "Piccadilly", 2, "4", "0" ));
		map.add( new tubeStep( "Hounslow West", "Hatton Cross", "Piccadilly", 4, "5", "0" ));
		map.add( new tubeStep( "Hatton Cross", "Heathrow Terminal 3", "Piccadilly", 3, "5", "6" ));
		map.add( new tubeStep( "Heathrow Terminal 4", "Heathrow Terminals 1,2,3", "Piccadilly", 5, "6", "0" ));
		map.add( new tubeStep( "Heathrow Terminals 1,2,3", "Hatton Cross", "Piccadilly", 3, "6", "0" ));
		map.add( new tubeStep( "Acton Town", "Ealing Common", "Piccadilly", 2, "3", "0" ));
		map.add( new tubeStep( "Ealing Common", "North Ealing", "Piccadilly", 3, "3", "0" ));
		map.add( new tubeStep( "North Ealing", "Park Royal", "Piccadilly", 2, "3", "0" ));
		map.add( new tubeStep( "Park Royal", "Alperton", "Piccadilly", 3, "3", "0" ));
		map.add( new tubeStep( "Alperton", "Sudbury Town", "Piccadilly", 2, "4", "0" ));
		map.add( new tubeStep( "Sudbury Town", "Sudbury Hill", "Piccadilly", 3, "4", "0" ));
		map.add( new tubeStep( "Sudbury Hill", "South Harrow", "Piccadilly", 2, "4", "0" ));
		map.add( new tubeStep( "South Harrow", "Rayners Lane", "Piccadilly", 3, "5", "0" ));
		map.add( new tubeStep( "Rayners Lane", "Eastcote", "Piccadilly", 2, "5", "0" ));
		map.add( new tubeStep( "Eastcote", "Ruislip Manor", "Piccadilly", 2, "5", "0" ));
		map.add( new tubeStep( "Ruislip Manor", "Ruislip", "Piccadilly", 2, "6", "0" ));
		map.add( new tubeStep( "Ruislip", "Ickenham", "Piccadilly", 3, "6", "0" ));
		map.add( new tubeStep( "Ickenham", "Hillingdon", "Piccadilly", 2, "6", "0" ));
		map.add( new tubeStep( "Hillingdon", "Uxbridge", "Piccadilly", 3, "6", "0" ));
		map.add( new tubeStep( "Walthamstow Central", "Blackhorse Road", "Victoria", 2, "3", "0" ));
		map.add( new tubeStep( "Blackhorse Road", "Tottenham Hale", "Victoria", 2, "3", "0" ));
		map.add( new tubeStep( "Tottenham Hale", "Seven Sisters", "Victoria", 3, "3", "0" ));
		map.add( new tubeStep( "Seven Sisters", "Finsbury Park", "Victoria", 4, "3", "0" ));
		map.add( new tubeStep( "Finsbury Park", "Highbury & Islington", "Victoria", 2, "2", "0" ));
		map.add( new tubeStep( "Highbury & Islington", "King's Cross St. Pancras", "Victoria", 4, "2", "0" ));
		map.add( new tubeStep( "King's Cross St. Pancras", "Euston", "Victoria", 2, "1", "0" ));
		map.add( new tubeStep( "Euston", "Warren Street", "Victoria", 1, "1", "0" ));
		map.add( new tubeStep( "Warren Street", "Oxford Circus", "Victoria", 2, "1", "0" ));
		map.add( new tubeStep( "Oxford Circus", "Green Park", "Victoria", 2, "1", "0" ));
		map.add( new tubeStep( "Green Park", "Victoria", "Victoria", 2, "1", "0" ));
		map.add( new tubeStep( "Victoria", "Pimlico", "Victoria", 3, "1", "0" ));
		map.add( new tubeStep( "Pimlico", "Vauxhall", "Victoria", 1, "1", "0" ));
		map.add( new tubeStep( "Vauxhall", "Stockwell", "Victoria", 3, "1", "2" ));
		map.add( new tubeStep( "Stockwell", "Brixton", "Victoria", 2, "2", "0" ));
		map.add( new tubeStep( "Bank/Monument", "Waterloo", "Waterloo & City", 4, "1", "0" ));
	}

	public Vector<opPair> operators( String start )	// given a starting station, return a vector of operators expressed
							// as opPairs (see class). This function will return all possible
							// operators, useful or otherwise.
	{
		Vector<opPair> operators = new Vector<opPair>( 0, 1 );

                for ( tubeStep possibleStep : map )
                        if ( start.equals( possibleStep.start ))					// each segment of line is
				operators.add( new opPair( possibleStep.line, possibleStep.end ));	// expressed only once in
			else if ( start.equals( possibleStep.end ))					// the tubeStep relation, so
				operators.add( new opPair( possibleStep.line, possibleStep.start ));	// we have to look both ways

		return operators;
	}

	public int cost( String start, String end ) // given a start and an end station, return the average time between them
	{
                for ( tubeStep possibleNode : map )
                        if ( start.equals( possibleNode.start ) && end.equals( possibleNode.end ) ||	// like operators, above,
                             start.equals( possibleNode.end ) && end.equals( possibleNode.start ))	// match the step both ways
				return possibleNode.time; 						// round

		return -1;
	}

	public Vector<String> tubeZones( String station )	// return the zones this station is in as a vector of strings
	{
		Vector<String> tubeZones = new Vector<String>( 0, 1 );

		for ( tubeStep possibleNode : map )
                        if ( station.equals( possibleNode.start ))
			{
				tubeZones.add( possibleNode.zone );
				if ( ! possibleNode.otherZone.equals( "0" ))
					tubeZones.add( possibleNode.otherZone );
				return tubeZones;
			}
		return null;	
	}

        public String routeString( Vector<opPair> pathNodes )	// convert a path of opPairs into a string for printing
        {
                String answer = "";
                for ( opPair pathNode: pathNodes )
			if ( pathNode.tubeLine.equals( "start" ))
				answer = "From " + pathNode.destination + "\n";
			else
				answer = answer + "via the " + pathNode.tubeLine + " line to " + pathNode.destination + "\n" ;
                return answer;
        }

	public boolean exists( String station )	// check that a station exists on the map (for error checking)
	{
		for ( tubeStep link : map )
			if ( link.start.equals( station ) || link.end.equals( station ))
				return true;
		return false;
	}
}

