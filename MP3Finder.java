/**
  A class will recursively traverse the given directory and add to a list.
  @author Tao Guo
 **/

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class MP3Finder {

	//Data member.
	private MP3FileList mp3List;

	//Constructor for MP3Finder.
	public MP3Finder(String path) {

		mp3List = new MP3FileList();

		findFiles(path);
	}

	//File finder for the all mp3 files.
	public void findFiles(String directory) {

		File input = new File(directory);

		if(input.isFile()) {
			if(input.getName().lastIndexOf(".mp3") != -1 || input.getName().lastIndexOf(".MP3") != -1) {
				
				try {
					AudioFile f = AudioFileIO.read(new File(input.getAbsolutePath()));
					Tag tag = f.getTag();
					String title = tag.getFirst(FieldKey.TITLE);
					String artist = tag.getFirst(FieldKey.ARTIST);
					MP3File mp3 = new MP3File(title, artist, input.getAbsolutePath());
					mp3List.addMP3(mp3);

				} catch (CannotReadException cre) {
					cre.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (TagException te) {
					te.printStackTrace();
				} catch (InvalidAudioFrameException iafe) {
					iafe.printStackTrace();
				} catch (ReadOnlyFileException rofe) {
					rofe.printStackTrace();
				}
			} 
		} else if(input.isDirectory()) {	
			File[] children = input.listFiles();
			for(File f: children) {
				findFiles(f.getAbsolutePath());
			}
		}
	}

	//Return the list.
	public MP3FileList returnList() {
		return mp3List;
	}
}