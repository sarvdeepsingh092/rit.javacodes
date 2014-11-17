/**
 * Grep.java
 * 
 * Version
 * 			$id$
 * 
 * Revision
 * 			$log$
 */
import java.io.*;

/**
 * This class reads the word to be found, reads the file and checks if the word is present
 * It also prints all the lines in which the word is present
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class Grep {

	public static int counter=0;
	/**
	 * main program
	 * @param args		command line arguments(ignored)
	 * @throws IOException		The exception which is thrown on reading the strings
	 */
	public static void main(String args[]) throws IOException {

		try {
			//declare and initialize the string in which the word to be searched will be read
			String searchWord = "";
			
			//declare the buffered reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter the word you are looking for");
			
			//read the word to be searched for
			searchWord = reader.readLine();
			
			//read the file
			FileReader file = new FileReader("src/grep.txt");

			//call the method which would check for the words presence
			grep(file, searchWord);
			
			System.out.println("The word "+searchWord+" appears "+counter+" times in the file.");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}
	}

	/**
	 * Method to check if the word is present in the file and the lines in which it is present
	 * @param file		The file reader object
	 * @param word		The word to be searched for
	 * @throws IOException		The exception thrown on reading the string
	 */
	public static void grep(FileReader file, String word) throws IOException {
		try {
			
			//declare and initialize the string which would be read
			String input = "";
			
			//declare the buffered reader and pass the file reader object to it 
			//so that it can read lines from the file
			BufferedReader reader1 = new BufferedReader(file);
			
			//use a flag to indicate that the word has been found
			int flag = 0;
			
			
			//read the first line of the file
			input = reader1.readLine();
			
			//until you encounter a null string
			while (input != null) {

				//check if the read line contains the word
				if (input.contains(word)) {
					
					//if yes change the value of the flag
					flag = 1;
					
					//increment the counter
					counter++;
					
					//print the line in which the word is present
					System.out.println("The string in which the word is present is as follows :");
					System.out.println(input);
				}
				
				
				//read the next line in the file
				input = reader1.readLine();
			}
			//if the word is not found print a message
			if (flag != 1) {
				System.out.println("The word you are searching for is not present in the file");
			}
		} catch (Exception e) {

		}

	}
}
