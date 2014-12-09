/**
 * NFLServer.java
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
 * This class is the client class
 * It will get a Team name from the client and find that in the html file and return the line which contains the team name
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 * 
 */
public class NFLServer {

	/**
	 * This method will create the server socket and accept connection from the client
	 * It will find the team name passed by the client in the html file and return the line which contains the team name
	 * @throws IOException
	 */
	public static void processServer()throws IOException{
		
		//print that the server is running
		System.out.println("Server running");
		
		//create a file object
		File f=null;
		
		try{
		//give the path to the file object
		f=new File("/Users/sunnyb/Documents/workspace/Homework14/src/NFL1.html");
		}
		catch(Exception e){
			System.out.println("file not found");
		}
		
		//create a file reader
		FileReader reader=new FileReader(f);
		
		//create the server socket
		ServerSocket serverSocket=new ServerSocket(1234);
		
		//accept connection from the client
		Socket client=serverSocket.accept();
		
		//declare the print writer for the socket
		PrintWriter out=new PrintWriter(client.getOutputStream(), true);
		
		//declare the buffered reader for the socket
		BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		//read the team name from the client
		String input=in.readLine();
		
		//declare a string to read the file into
		String line=null;
		
		//create an indicator
		boolean flag=false;
		
		//declare a buffered reader to read the file
		BufferedReader read=new BufferedReader(reader);
		
		//declare an indicator
		boolean found=false;
		
		//read the first line of the html file
		line=read.readLine();
		
		//convert the read line to lowercase
		line=line.toLowerCase();
		
		//create a string which would store the result without any tags
		String text=null;
		
		//if nothing is read from the client print nothing
		if(input==null){
		System.out.println("nothing");
		}
		
		//while the file does not end
		while (line != null) {
			
			//find "by division" in the html file
			if(line.contains("by division")){
				//make the indicator true
				flag=true;
			}
			
			//if the line read has endfile in it then stop
			else if(line.contains("endfile")){
				break;
			}
			
			
			 if(flag){
				
				 	//if the indicator is true then check if the team name is present in the line
					if(line.contains(input)){
						
					//if it is then remove all the tags from that line	
					text = line.replaceAll("\\<.*?>", "");
					
					//make the indicator true and stop
					found=true;
					
					break;
					}
					
					
				}
			 
			 	//read the next line in the html file 
			 	line = read.readLine();
			 	
			 	//convert the line read to lowercase
			 	line=line.toLowerCase();
			}
		
		//if the indicator is true then return the result to the client
		if(found){
			out.println(text);
		}

		
	}
	
	/**
	 * main program
	 * @param args				command line arguments(ignored)
	 * @throws IOException
	 */
	public static void main(String args[])throws IOException{
		
		//create the object of the class
		NFLServer nflServer= new NFLServer();
		
		//call the method to process
		NFLServer.processServer();
	}
	
}
