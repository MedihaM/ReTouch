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
	
	static String realString;
	static String[] stringArr = new String[8];	
	// Causes an error if 7 on Linux for some reason
	
	private static void makeString(String fileName) throws IOException {

		String line = null;

		FileReader fr;
		try {
			fr = new FileReader("data/" + fileName + ".txt");

			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();
			
			int stringArrRow = 0;
			while (line != null) {
				realString += line + "/n";
				stringArr[stringArrRow] = line;
				line = br.readLine();
				stringArrRow++;
			}

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
	
	
	public static String[] getStringArr(String filename) throws IOException{
		if (stringArr[0] == null){
			makeString(filename);
		}
		return stringArr;
	}	

}
