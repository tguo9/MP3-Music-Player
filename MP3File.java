/**
  A class crate an object of MP3File.
  @author Tao Guo
 **/

public class MP3File {

	//Data members.
	private String title;
	private String artist;
	private String absPath;

	//Constructor for MP3File object.
	public MP3File(String title, String artist, String absPath) {

		this.title = title;
		this.artist = artist;
		this.absPath = absPath;
	}

	//Getters.
	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getAbsPath() {
		return absPath;
	}

	//toString to display the info of the MP3File.
	public String toString() {
		return this.title + "\tArtist: " + this.artist;
	}
}