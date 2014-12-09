/**
 * NFLCLient.java
 * 
 * Version
 * 			$id$
 * 
 * Revision
 * 			$log$
 */



import java.io.*;
import java.net.*;
import java.util.regex.*;

/**
 * This class is the client
 * It will read a team name from the user, pass it to the server, receive a result from the server
 * Process that result to extract the desired values and print the result to the console
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class NFLClient {

	//decalre a variable to store the team name
	static String teamName;
	
	/**
	 * parameterized constructor
	 * @param teamName		The name of the team passed
	 */
	NFLClient(String teamName){
		//assign the name of the team passed to the teamName variable
		this.teamName=teamName;
	}
	
	/**
	 * Method will create the client socket, pass the team name to the server, receive the result from the server
	 * Process that result to get the desired values
	 * @return		returns a string which contains the desired values
	 * @throws IOException
	 */
	public static String process() throws IOException{
		//print that the client is running
		System.out.println("client running");
		
		//string to store the result coming in from the server
		String result=" ";
		
		//the string which would have the desired values
		String returnResult=" ";
		
		//create the client socket
		Socket clientSocket=new Socket("localhost",1234);
		
		//create the print writer for the client socket
		PrintWriter out=new PrintWriter(clientSocket.getOutputStream(), true);
		
		//create the buffered reader for the client socket
		BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		//convert the team name to lower case
		teamName=teamName.toLowerCase();
		
		//pass the team name to the server
		out.println(teamName);
		
		//read the result from the server
		result=in.readLine();
		
		
		
		//if nothing is read print error message
		if(result==null){
			System.out.println("result was not read from server");
			System.exit(0);
		}
		
		if(result.equals("not found")){
			return ("t");
		}
		else{
			
			//split the result obtained from the server
			String[] array=result.split("=");
			
			
			//create part 1
			String part1=array[1].substring(0, 7);
			
			
			int p2=array[1].indexOf("|");
			
			String temp=array[1].substring(p2+1, array[1].length());
			
		
			int p3=temp.indexOf("|");
			
			String temp1=temp.substring(p3+1, temp.length());
			
			
			int p4=temp1.indexOf("|");
			
			
			//create part 2
			String part2=temp1.substring(0,p4);
			
			
			String temp2=temp1.substring(p4+1, temp1.length());
			
			
			int p5=temp2.indexOf("|");
			
			//create part 3
			String part3=temp2.substring(0, p5);
			
			//create part 4
			String part4=temp2.substring(p5+1,temp2.length());
			
			
			//concatenate the four parts with appropriate symbols between them
			returnResult=part1+" "+part2+"|"+part3+"|"+part4;
			
			//return the concatenated desired result
			return returnResult;
		}
		
	}
	
	/**
	 * main program
	 * @param args				command line arguments(ignored)
	 * @throws IOException
	 */
	public static void main(String args[])throws IOException{
		
		//create the buffered reader to read the input from the user
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		
		//variable to store the team name
		String team;
		
		//give the path of the file to which the result is to be written 
		File f=new File("/Users/sunnyb/Documents/workspace/Homework14/src/file.txt");
		
		//create the file writer 
		FileWriter writer=new FileWriter(f);
		
		//create the string which would hold the desired result
		String output=" ";
		
		//ask for the team name from the user
		System.out.println("Select the team whose standing you wish to see");
		
		team=stdin.readLine();
		
		//create the NFLCLient object and pass the team name as argument
		NFLClient nflClient =new NFLClient(team);
		
		//call the method to process
		output=nflClient.process();
		
		if(output.equals("t")){
			System.out.println("could not fetch the standing of the team");
		}
		
		else{
			//print the standing of the team as it is in the html file
			System.out.println("The standing of the team is as follows :");
			System.out.println(team+" = "+output);
			//write the result to the file
			writer.write(team+" = "+output);
			
			
		}
	}
	
}
