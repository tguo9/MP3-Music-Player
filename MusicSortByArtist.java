/**
  A class to compare MP3File by artist.
  @author Tao Guo
 **/

import java.util.Comparator;

public class MusicSortByArtist implements Comparator<MP3File> {

	public int compare(MP3File a1, MP3File a2) {		
		
		return a1.getArtist().compareTo(a2.getArtist());
	}
}