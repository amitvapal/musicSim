import java.sql.Time;
import java.text.*;
import java.util.*;
/**
 * @author Val Klosky
 * Library of Songs
 * add functionality for:
 *   -deleting a Song from the collection
 *   -create an outputToFile method
 *   -demo adding and deleting a few songs
 *   -print to screen after each
 *   -write results to file
 */

public class MusicLibrary 
{
	private ArrayList<Song> collection;			//list of songs objects
	
	/**
	 * Instantiates a new MusicLibrary 
	 */
	public MusicLibrary()
	{
		collection = new ArrayList<Song>();		
	}
	
	/**
	 * Adds a Song to the collection
	 * @param title- Song title
	 * @param artist- name of artist
	 * @param album-album title
	 * @param cost-cost of the song
	 * @param songLength-duration of the song
	 */
	public void addSong(String title, String artist, String album,double cost, Time songLength)
	{
		collection.add(new Song(title, artist, album, cost,songLength));
	}
	
	public double getCollectionValue()
	{
	    double total=0;
	    for(Song s:collection)
	        total+=s.getCost();
	    return total;
	}
	
	/**
	 * @return String representation of MusicLibrary Object
	 */
	public String toString()
	{
		Collections.sort(collection);	//sorts by artist name
		DecimalFormat df = new DecimalFormat("$##,###.00");
		String report = "***************************************************\n";
		report += "Number of Songs: " + collection.size() + "\n";
		report += "Total value of collection: "+df.format(getCollectionValue())+"\n";
		report += "\nAverage song cost: " + df.format(getCollectionValue()/collection.size())+"\n";
		report += "Total listening time: " + getTotalTime();
		
		report += "\n\nSong List: \n\n";
		String fmt="%-10s %-11s %-20s %-15s %-20s%n";
		report += String.format(fmt, "Price","Duration","Song Title","Artist","Album");
		report += String.format(fmt, "-----","--------","----------","------","-----");
		
		for(int cdnum = 0; cdnum<collection.size(); cdnum++)
		{
			report += collection.get(cdnum)+ "\n";
		}
		return report;
	}
	
	/**
	 * @return duration of all songs in the collection
	 */
	private Time getTotalTime()
	{
		int minutes=0;
		int seconds=0;
		int hours=0;
		String t="";
		
		for (int i=0;i<collection.size();i++)
		{
			minutes += Integer.parseInt(collection.get(i).getTime().toString().substring(3,5));
			seconds += Integer.parseInt(collection.get(i).getTime().toString().substring(6));
		}	
		hours = minutes/60;
		minutes= minutes % 60;
		minutes+=seconds/60;
		seconds%=60;
			
		if (hours<10)
			t+="0";
		t+=hours +":";
		if (minutes<10)
			t+="0";
		t+=minutes +":";
		if(seconds<10)
			t+=0;
		t+=seconds;
			
		return (Time.valueOf(t));
	}
}