/**
  A class will take the MP3File list, and play the music.
  @author Tao Guo
 **/

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer {
	
	//Data members.
	private MP3FileList playList;
	private Scanner input;
	private boolean isPlaying;
	private Player player;
	private int index;
	private int choice;

	//Constructor.
	public MusicPlayer(MP3FileList playList) {

		this.playList = playList;
	}

	//The whole menu.
	public void loopMenu() {

		if(playList.size() == 0) {
			System.out.println("NO Mp3 File FOUND!!!");
			System.exit(1);

		}

		displayMenu();
		
		boolean loop = true;

		while(loop == true) {

			Scanner input = new Scanner(System.in);
	        System.out.println("Please enter a number for operation: ");

			try{
				choice = Integer.parseInt(input.next());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}

			if(choice == 1) {
				playList.displayByTitle();
				displayMenu();
			} else if (choice == 2) {
				playList.displayByArtist();
				displayMenu();
			} else if (choice == 3) {
				playMusic();
				displayMenu();
			} else if (choice == 4) {
				if(isPlaying == true) {
					player.close();
					isPlaying = false;
					displayMenu();
				} else {
					System.out.println("No song is playing right now.\n");
				}
			} else if (choice == 5) {
				loop = false;
				System.out.println("Thanks for using!!!\n");
				System.exit(1);
			} else {
				System.out.println("Please enter a vaild menu number.\n");
			}
		}

	}
	
	//A method to play the music.
	public void play(String name) {

		try {
			player = new Player(new FileInputStream(name));
		} catch (JavaLayerException jle) {
			jle.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

		Thread t = new Thread() {
		    public void run() {
		        try {
		            player.play();
		        } catch(Exception e) {
		            e.printStackTrace();
		        }
		    }
		}; 
		isPlaying = true;
		t.start();
	}

	//The methods to chack the songs.
	public void playMusic() {

		playList.displayByTitle();
		
		System.out.println("Please enter the number of the song: ");
		Scanner input = new Scanner(System.in);

		try{
			index = Integer.parseInt(input.next());
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
			return;
		}
		
		if(index <= 0 || index > playList.size()) {
			 
			 System.out.println("Please enter a vaild index.\n");
			 return;

		}

		if(isPlaying == true) {
			player.close();
			isPlaying = false;
		}

		play(playList.getPath(index - 1));
	}

	//A methods to display the menu.
	public void displayMenu() {
		
		System.out.println("1. MP3s sorted by song title \n" +
				"2. MP3s sorted by artist \n" +
				"3. Play MP3 \n" +
				"4. Stop playback \n" +
				"5. Exit");
	}
}