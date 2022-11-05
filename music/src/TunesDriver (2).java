import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Scanner;

 /********************************************************
 * Tunes.java
 * Client code to demo the use of an array of CD's
 *
 *********************************************************/
 
 public class TunesDriver
 {
 	//creates a MusicLibary object and adds some songs to it. Prints report
 	
 	public static void main(String[] args) throws FileNotFoundException
 	{
 		MusicLibrary myMusic = new MusicLibrary();  //instantiates new object, calling it's constructor
 		
 		Scanner inFile=new Scanner(new File("songs.txt"));
 		String song, artist, album;
 		String time;
 		double price;
 		while(inFile.hasNext())
 		{
 			song=inFile.nextLine();
 			artist=inFile.nextLine();
 			album=inFile.nextLine();
 			price=inFile.nextDouble();
 			inFile.nextLine();//flush input stream-switching from numeric to String input
 			time=inFile.nextLine();
 			Time t= Time.valueOf(time);
 			myMusic.addSong(song, artist, album, price, t);
 			
 		}
 		inFile.close();
 		System.out.println(myMusic);
 		

 	}
 }