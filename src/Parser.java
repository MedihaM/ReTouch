
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 
 * The Parser class accepts a string (a file name) and parses it, returning the contents of the
 * file as a string to be used in the GUI.
 * @author Mediha Munimm
 * @version 1.0
 * @since 2017-11-06
 *
 */
public class Parser {
	
	static String realString;
	static String[] stringArr = new String[8];	
	// Causes an error if 7 on Linux for some reason
	
	/**
	 * This method reads the file and returns its contents as a string.
	 * @param fileName The file that is parsed through.
	 * @throws IOException On input error.
	 */
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

	
	/**
	 * This method checks if the initial line in the file was inputed in the string array as a string. If it has not been initialized, the string array will be initialized.
	 * @param filename The file to be read and parsed through.
	 * @return String The contents of the file.
	 * @throws IOException On input error.
	 */
	public static String[] getStringArr(String filename) throws IOException{
		
		if (stringArr[0] == null){
			makeString(filename);
		}
		return stringArr;
	}	

	/**
	 * This method returns the string array regardless of what it is composed of.
	 * @return String The contents of the file.
	 * @throws IOException On input error.
	 */
	public static String[] getStringArr() throws IOException{
		return stringArr;
	}

}
