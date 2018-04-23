/**
  A class driver for the MP3player.
  @author Tao Guo
 **/

import java.util.*;

public class MusicPlayerDriver {

	public static void main(String[] args) {

		//Checking the commend line args.
		if(args.length != 1) {					
				System.out.println("usage: java MusicPlayerDriver <absolute_path>");
				System.exit(1);				
		}

		String path = args[0];

        MP3FileList list = (new MP3Finder(path)).returnList();

		MusicPlayer player = new MusicPlayer(list);
		player.loopMenu();
	}
}