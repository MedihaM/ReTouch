import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 
 * Accepts a string (a file name) and parses it, returning the contents of the
 * file as a string to be used in the GUI.
 * 
 * @author Mediha
 *
 */
public class Parser {
	
	static String graphicsString;
	static String realString;

	
	private static void makeString(String fileName) throws IOException {

		graphicsString = "<html>";
		String line = null;

		FileReader fr;
		try {
			fr = new FileReader("data/" + fileName + ".txt");

			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();
			while (line != null) {
				graphicsString += line + "<br>";
				realString += line + "/n";
				line = br.readLine();
			}

			graphicsString += "</html>";
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String getString(String filename) throws IOException{
		if (realString == null){
			makeString(filename);
		}
		return realString;
	}
	
	public static String getGString(String filename) throws IOException{
		if (graphicsString == null){
			makeString(filename);
		}
		return graphicsString;
	}	

}
