import java.sql.Time;
import java.text.*;
/**
 * @author thabu
 *
 */
public class Song implements Comparable<Song>
{
	private String title, artist, album;
	private double cost;
	private Time songLength;

	public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getAlbum()
    {
        return album;
    }

    public void setAlbum(String album)
    {
        this.album = album;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    /**
	 * @param name- name of song
	 * @param singer- artist of the song
	 * @param al- album name
	 * @param price- price of song
	 * @param t- duration of song
	 */
	public Song(String name, String singer, String al,double price, Time t)
	{
		title = name;
		artist = singer;
		cost = price;
		album=al;
		songLength=t;
	}

	/**
	 * @return String representation of a Song
	 */
	public String toString()
	{
		DecimalFormat df=new DecimalFormat ("$#,##0.00");

		String description;
		String fmt="%-10s %-11s %-20s %-15s %-20s";
		description = String.format(fmt, df.format(cost),songLength,title ,artist,album);

		return description;
	}
	
	/**
	 * @return duration of Song
	 */
	public Time getTime()
	{
		return songLength;
	}
	
	/**
	 * Compare songs alphabetically by artist name
	 * @param other
	 * @return
	 */
	public int compareTo(Song other)
	{
		return artist.compareTo(other.getArtist());
	}
}