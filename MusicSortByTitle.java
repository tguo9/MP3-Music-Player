/**
  A class to compare MP3File by title.
  @author Tao Guo
 **/

import java.util.Comparator;

public class MusicSortByTitle implements Comparator<MP3File> {

	public int compare(MP3File a1, MP3File a2) {		
		
		return a1.getTitle().compareTo(a2.getTitle());
	}
}