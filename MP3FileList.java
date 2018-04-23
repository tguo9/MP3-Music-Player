/**
  A class with MP3File list.
  @author Tao Guo
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class MP3FileList {

	//Data member.
	private ArrayList<MP3File> mp3Files;

	//Constructor.
	public MP3FileList () {
		this.mp3Files = new ArrayList<MP3File>();
	}

	//Add MP3File object to the list.
	public void addMP3(MP3File mp3File) {
		this.mp3Files.add(mp3File);
	}

	//Return the list.
	public ArrayList<MP3File> returnList() {
		return mp3Files;
	}

	//Getter for path.
	public String getPath(int index) {
		return mp3Files.get(index).getAbsPath();
	}

	//Get the list size.
	public int size() {
		return mp3Files.size();
	}

	//Using Comparator to sort the list.
	public void displayByTitle() {
		
		String printVal = "";
		Collections.sort(mp3Files, new MusicSortByTitle());
		
		for(int i = 0; i < mp3Files.size(); i++) {

			printVal += (i+1) + "." + mp3Files.get(i).toString() + "\n";
		}

		System.out.println("Play List By Title:\n" + printVal);

	}
	
	public void displayByArtist() {

		String printVal = "";
		Collections.sort(mp3Files, new MusicSortByArtist());
		
		for(int i = 0; i < mp3Files.size(); i++) {

			printVal += (i+1) + "." + mp3Files.get(i).toString() + "\n";
		}

		System.out.println("Play List By Artist:\n" + printVal);

	}

}