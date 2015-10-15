/**
 * TetraClu.java
 * 
 * Version 1.0
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import edu.rit.pj2.Job;
import edu.rit.pj2.Loop;
import edu.rit.pj2.Task;
import edu.rit.pj2.tuple.ObjectTuple;

/**
 * Description: This class stores the three co-ordinates of a particular file
 * @author Sarvdeep Singh Bindra
 *
 */
class p {
	
	//store the x co-ordinate
	double p1;
	//store the y co-ordinate
	double p2;
	//store the z co-ordinate
	double p3;
	
	/**
	 * Parameterized constructor
	 * @param p1			x co-ordinate
	 * @param p2			y co-ordinate
	 * @param p3			z co-ordinate
	 */
	public p(double p1, double p2, double p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
}

/**
 * Description: This class acts as the master class and reads the points from the file 
 * It also distributs the files amongst the worker tasks.
 * @author Sarvdeep Singh Bindra
 *
 */
public class TetraClu extends Job {

	@Override
	/**
	 * Main Program
	 * @param arg0				Command Line Arguments
	 */
	public void main(String[] arg0) throws Exception {
		
		//List which stores all the points present in the file
		ArrayList<p> pointString = new ArrayList<>();

		//check for proper arguments
		if(arg0.length<1||arg0.length>1){
			System.out.println("Please provide one file name when you run this program next time");
			System.exit(0);
		}
		
		//file object
		File input = null;
		try{
			
		//initialize the file object
		input = new File(arg0[0]);
		}
		catch(Exception e){
			System.out.println("No such file found");
			System.exit(0);
		}
		//counter that records number of points
		int count = 0;
		
		//string to read the points
		String read = "";
		
		//string array which stores the co-ordinates of a point temporarily
		String read1[];
		
		//file reader
		FileReader fileRead = new FileReader(input);
		BufferedReader readInput = new BufferedReader(fileRead);
		
		//read the first line of the file
		read = readInput.readLine();

		
		while (read != null) {
			//split the string read and get the individual co-ordinates
			String split[] = read.split(" ");
			
			//create the object which stores the three co-ordinates
			p p1 = new p(Double.parseDouble(split[0]), Double.parseDouble(split[1]),Double.parseDouble(split[2]));
			
			//add it to the list
			pointString.add(p1);
			//increment the count
			count++;
			
			//read the next line
			read = readInput.readLine();
		}
		
		//put the list containing the points in the tuple space
		putTuple(new ObjectTuple<List<p>>(pointString));
		
		//set the schedule scheme to leapfrog
		masterSchedule(leapfrog);
		
		//the master for loop
		//start the worker tasks
		masterFor(0, count - 1, Worker.class).args(String.valueOf(count));
		
		//when all the tasks finish run the reducer task
		rule().atFinish().task(ReducerWorker.class).runInJobProcess();

	}

}

/**
 * Description: This class acts as the reducer class.
 * This class reduces the result from various worker tasks and prints the result
 * @author Sarvdeep Singh Bindra
 *
 */
class ReducerWorker extends Task {

	//set the format to print the result appropriately
	DecimalFormat seven = new DecimalFormat("#0.0000000");

	/**
	 * main program
	 * @param arg0 			arguments passed to the worker task
	 */
	public void main(String[] arg0) throws Exception {

		//store the list read from the tuple space
		List<p> pointString = readTuple(new ObjectTuple<List<p>>()).item;

		//create a template object of the TetraVbl
		TetraVbl template = new TetraVbl();
		
		//create an object to reduce the results
		TetraVbl reduction = new TetraVbl();
		
		//temporary object
		TetraVbl temp;
		
		//while there are tuples available in the tuple space perform the reduction
		while ((temp = tryToTakeTuple(template)) != null) {
			reduction.reduce(temp);
		}

		// Display the contents
		System.out.println(reduction.ind1 + " ("
				+ pointString.get(reduction.ind1).p1 + ","+ pointString.get(reduction.ind1).p2+","+pointString.get(reduction.ind1).p3+")");
		System.out.println(reduction.ind2 + " ("
				+ pointString.get(reduction.ind2).p1+","+pointString.get(reduction.ind2).p2+","+pointString.get(reduction.ind2).p3+")");
		System.out.println(reduction.ind3 + " ("
				+ pointString.get(reduction.ind3).p1+","+pointString.get(reduction.ind3).p2+","+pointString.get(reduction.ind3).p3+")");
		System.out.println(reduction.ind4 + " ("
				+ pointString.get(reduction.ind4).p1+","+pointString.get(reduction.ind4).p2+","+pointString.get(reduction.ind4).p3+")");
		System.out.println(seven.format(reduction.volume));
	}

}

/**
 * Description: This class acts as the worker task
 * This class computes the volume for the points allotted to the worker task
 * @author Sarvdeep Singh Bindra
 *
 */
class Worker extends Task {

	//variables to store the indexes of the four points
	int index1 = -1, index2 = -1, index3 = -1, index4 = -1;
	
	//variable to store the minimum volume
	double minResult = 100000000;
	
	//global object of TetraVbl
	TetraVbl globalVbl;
	
	//variable to iterate the loops
	int count;

	@Override
	/**
	 * Main Program
	 * @param arg0			arguments passed to the worker task
	 */
	public void main(String[] arg0) throws Exception {
		
		//initialize the global object
		globalVbl = new TetraVbl();
		
		
		//count = Integer.parseInt(arg0[0]);
		
		//read the list of points passed by the master from the tuple space
		List<p> pointString = readTuple(new ObjectTuple<List<p>>()).item;
		
		//workfor loop
		workerFor().schedule(leapfrog).exec(new Loop() {

			/**
			 * Method to compute the volume given a set of points
			 * @param p11			The first point
			 * @param p12			The second point
			 * @param p13			The third point
			 * @param p14			The fourth point
			 * @return					The volume
			 */
			public double computeVolume(p p11, p p12,
					p p13 , p p14) {
				//initialize result to 0
				double result = 0;

				//compute the volume
				result = Math
						.abs(((p11.p3 - p12.p3)
								* (p13.p1 * p14.p2 - p14.p1 * p13.p2)
								+ (p13.p3 - p14.p3)
								* (p11.p1 * p12.p2 - p12.p1 * p11.p2)
								+ (p12.p3 - p14.p3)
								* (p13.p1 * p11.p2 - p11.p1 * p13.p2)
								+ (p12.p3 - p13.p3)
								* (p11.p1 * p14.p2 - p14.p1 * p11.p2)
								+ (p11.p3 - p14.p3)
								* (p12.p1 * p13.p2 - p13.p1 * p12.p2) 
								+ (p11.p3 - p13.p3)* (p14.p1 * p12.p2 - p12.p1
										* p14.p2))*0.1666666666);
				
				//return the result
				return result;
			}

			//local object of TetraVbl
			TetraVbl vblLocal;

			/**
			 * method to initialize variables and get the clone of the global object
			 */
			public void start() {
				//get the clone of the global object
				vblLocal = threadLocal(globalVbl);
			}

			@Override
			public void run(int i) throws Exception {
				
				//get the first point
				p p11 = pointString.get(i);
				
				//get all possible options for the second point
				for (int j = i + 1; j < pointString.size(); j++) {
					p p12 = pointString.get(j);
					
					//get all possible options for the third point
					for (int k = j + 1; k < pointString.size(); k++) {
						p p13 = pointString.get(k);
						
						//get all possible options for the fourth point
						for (int m = k + 1; m < pointString.size(); m++) {
							p p14 = pointString.get(m);
							
							//compute the volume
							double volume = computeVolume(p11, p12, p13, p14);
							
							//compare the volume set by another task
							vblLocal.compare(volume, i, j, k, m);
					}
					}
				}
			}
		});
		
		//put the global object into the tuple space
		putTuple(globalVbl);
	}

}


