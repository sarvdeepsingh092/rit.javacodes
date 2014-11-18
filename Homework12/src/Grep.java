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
import java.util.*;

/**
 * This class reads the word to be found, reads the file and checks if the word
 * is present It also prints all the lines in which the word is present
 * 
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class Grep {

	public static int counter = 0;

	static List<File> list = new ArrayList<File>();
	
	
	
	/**
	 * main program
	 * 
	 * @param args
	 *            command line arguments(ignored)
	 * @throws IOException
	 *             The exception which is thrown on reading the strings
	 */
	public static void main(String args[]) throws IOException {

		try {
			// declare and initialize the string in which the word to be
			// searched will be read
			String searchWord = "";

			// declare the buffered reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("enter the word you are looking for");

			// read the word to be searched for
			searchWord = reader.readLine();

			//set the path to search for directories and files
			String path = "/Users/sunnyb/Desktop";

			//create the file object
			File f = new File(path);

			//call the method to check if directories are present
			checkDirectory(f);

			

			//for every file in the list read the the file and search for the word
			for (File file4 : list) {
				// read the file
				FileReader reader2 = new FileReader(file4.getAbsolutePath());
				
				// call the method which would check for the words presence
				grep(file4, reader2, searchWord);
			}
			

			

			//print the number of times the word is found
			System.out.println("The word " + searchWord + " appears " + counter + " times.");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}
	}

	/**
	 * Method to check if the file is a directory and add it to the list
	 * @param f		the file object
	 */
	public static void checkDirectory(File f) {
		
		//create a file array and store all the files in the directory to the array
		File[] array = f.listFiles();
		
		//if the file is a directory then add it to the list
		if (f.isDirectory()) {
			for (int i = 0; i < array.length; i++) {
				list.add(array[i]);
			}
		}
		
		//call the recursive method to go into the directories and check the files
		list = checkRecursive(list);

	}

	/**
	 * recursive method to go into the directories and return the node files
	 * @param list		The list of files which are found in directories
	 * @return			The list of files found in a directory
	 */
	private static List<File> checkRecursive(List<File> list) {
		
		
		//create the arraylist in which the files would be added
		List<File> onlyFilelist = new ArrayList<File>();
		
		//for every list in the file
		for (File file : list) {
			
			//check if the file is a directory
			if (file.isDirectory()) {
				
				//call the recursive method to go deeper into the directory and add the node files returned to the list
				onlyFilelist.addAll(checkRecursive((List<File>) Arrays.asList(file.listFiles())));
			} else {
				//otherwise add the files into the list
				onlyFilelist.add(file);
			}
		}
		
		//return the list in which the node files are stored
		return onlyFilelist;
	}

	/**
	 * Method to check if the word is present in the file and the lines in which
	 * it is present
	 * 
	 * @param file
	 *            The file reader object
	 * @param word
	 *            The word to be searched for
	 * @throws IOException
	 *             The exception thrown on reading the string
	 */
	public static void grep(File filename,FileReader file, String word) throws IOException {
		try {

			// declare and initialize the string which would be read
			String input = "";

			// declare the buffered reader and pass the file reader object to it
			// so that it can read lines from the file
			BufferedReader reader1 = new BufferedReader(file);

			// use a flag to indicate that the word has been found
			int flag = 0;

			// read the first line of the file
			input = reader1.readLine();

			// until you encounter a null string
			while (input != null) {

				// check if the read line contains the word
				if (input.contains(word)) {

					// if yes change the value of the flag
					flag = 1;

					// increment the counter
					counter++;

					// print the line in which the word is present
					System.out.println("The string in which the word is present is as follows :");
					System.out.println(input);
				}

				// read the next line in the file
				input = reader1.readLine();
			}
			// if the word is not found print a message
			if (flag != 1) {
				System.out.println("The word you are searching for in file "+filename.getName()+" is not present in the file");
			}
		} catch (Exception e) {

		}

	}
}
