package rit_Lamp;


/**
 * Producer.java
 * 
 * Version
 * 			$id$
 * 
 * Revision
 * 			$log$
 */
import java.util.*;


/**
 * This class is responsible for making the consumer Threads
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class Producer {

	public static void main(String args[]) {
		//create two consumer objects
		Consumer c1 = new Consumer();
		Consumer c2 = new Consumer();

		//create two more consumer objects and pass the previously created objects as arguments
		Consumer c3 = new Consumer(c1);
		Consumer c4 = new Consumer(c2);

		//start the two threads
		c3.start();
		c4.start();

		
		 

	}

}

/**
 * 
 * This class is responsible for creating threads for the various producers and creating the lamp
 *
 */
class Consumer extends Thread {
	
	//declare a counter variable to run the run function that many times
	static int counter = 10;
	
	//create reference of the Consumer
	Consumer o;
	
	//create references of the producers
	Screw screw;
	LightBulb lb;
	Socket socket;
	Stand stand;
	Base base;

	

	/**
	 * default Constructor
	 */
	public Consumer() {

	}

	/**
	 * parameterized constructor
	 * @param o		The Consumer object passed
	 */
	public Consumer(Consumer o) {
		//assign the passed object to the locally created reference
		this.o = o;
		
		//create the objects of the producers and pass the consumer object to them
		screw = new Screw(this.o);
		lb = new LightBulb(this.o);
		socket = new Socket(this.o);
		stand = new Stand(this.o);
		base = new Base(this.o);
	}

	/**
	 * This function creates the lamp and invokes the producers if the items needed are insufficient
	 */
	public void run() {
		try {
			while (counter != 0) {
				synchronized (o) {

					//check if the items are available
					if (screw.screwList.size() >= 4 && base.baseList.size() >= 2 && socket.socketList.size() >= 7
							&& lb.lightBulbList.size() >= 4 && stand.standList.size() >= 4) {
						//if yes then lamp is created
						System.out.println("Lamp created");

						//remove those many items from the producers count
						for (int i = 0; i < 4; i++) {
							screw.screwList.remove(i);
						}

						for (int i = 0; i < 2; i++) {
							base.baseList.remove(i);
						}
						for (int i = 0; i < 4; i++) {
							lb.lightBulbList.remove(i);
						}
						for (int i = 0; i < 4; i++) {
							stand.standList.remove(i);
						}
						for (int i = 0; i < 7; i++) {
							socket.socketList.remove(i);
						}
						
						//notify the consumer to wake up
						o.notify();

					} else {
						try {

							//System.out.println("starting production");

							//invoke the producers
							screw.start();
							base.start();
							socket.start();
							stand.start();
							lb.start();
							
							//make the consumer wait
							o.wait();
						} catch (Exception e) {

						}
					}
					counter--;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

}

/**
 * 
 * This class is responsible for creating the screws needed
 *
 */
class Screw extends Thread {

	//initialize counter to run the run method that many times
	static int counterS=10;
	
	//declare and initialize an arraylist
	ArrayList<Integer> screwList = new ArrayList<Integer>();

	//declare reference of the consumer
	Consumer o;

	/**
	 * parameterized constructor assigns passed object to the consumer reference
	 * @param o		passed object
	 */
	public Screw(Consumer o) {
		this.o = o;
	}

	

	/**
	 * This method creates 4 screws at a time and waits if the count is full
	 */
	public void run() {

		while (counterS!=0) {
			synchronized (o) {
				
				//check conditions and generate screws
				if (screwList.size() <= 20 || screwList.size() % 4 == 0) {
					for (int i = 0; i < 4; i++) {
						screwList.add(1);
					}
					o.notify();

				} else {
					try {
						
						o.wait();
					} catch (Exception e) {

					}
				}
				counterS--;
			}
		}

	}
}

/**
 * 
 * This class makes the base needed for the lamp
 * it makes 2 bases at a time and waits if the count is full
 *
 */
class Base extends Thread {

	//declare the counter to run the run method
	static int counterB=10;
	
	//declare the arraylist
	ArrayList<Integer> baseList = new ArrayList<Integer>(10);

	//declare the consumer reference
	Consumer o;

	

	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public Base(Consumer o) {
		this.o = o;
	}

	

	/**
	 * This method creates 2 bases at a time
	 */
	public void run() {

		while (counterB!=0) {
			synchronized (o) {

				//check condition and create base
				if (baseList.size() < 10 || baseList.size() % 2 == 0) {

					for (int i = 0; i < 2; i++) {
						baseList.add(1);
					}
					o.notify();
				} else {
					try {
						o.wait();
					} catch (Exception e) {

					}
				}
				counterB--;
			}
			
		}
	}
}

/**
 * 
 * This class makes the lightbulbs needed for the lamp
 *
 */
class LightBulb extends Thread {

	//declare the counter to run the run method
	static int counterL=10;
	
	//declare the arraylist
	ArrayList<Integer> lightBulbList = new ArrayList<Integer>(20);

	//declare the consumer reference
	Consumer o;

	

	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public LightBulb(Consumer o) {
		this.o = o;
	}

	

	/**
	 * This method creates the lightbulbs needed for the lamp
	 */
	public void run() {

		while (counterL!=0) {
			synchronized (o) {

				//check condition and create the lightbulbs  
				if (lightBulbList.size() < 20 || lightBulbList.size() % 4 == 0) {

					for (int i = 0; i < 4; i++) {
						lightBulbList.add(1);
					}
					o.notify();
				} else {
					try {
						o.wait();
					} catch (Exception e) {

					}

				}
				counterL--;
			}
			
		}
	}
}

/**
 * 
 * This class creates the stand for the lamp
 *
 */
class Stand extends Thread {

	//declare the counter to run the run method
	static int counterST=10;
	
	//declare the arraylist
	ArrayList<Integer> standList = new ArrayList<Integer>(20);

	//declare the consumer reference
	Consumer o;

	
	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public Stand(Consumer o) {
		this.o = o;
	}

	/**
	 * this method creates 4 stands at a time for the lamp
	 */
	public void run() {

		while (counterST!=0) {

			synchronized (o) {
				
				//check condition and make stands
				if (standList.size() < 20 || standList.size() % 4 == 0) {

					for (int i = 0; i < 4; i++) {
						standList.add(1);
					}
					o.notify();
				} else {
					try {
						o.wait();
					} catch (Exception e) {

					}
				}
				counterST--;
			}
		}
	}
}

/**
 * 
 * This class makes the sockets for the lamps
 *
 */
class Socket extends Thread {

	//declare the counter to run the run method
	static int counterSO=10;
	
	//declare the arraylist
	ArrayList<Integer> socketList = new ArrayList<Integer>(35);

	Object so;

	//declare the consumer reference
	Consumer o;

	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public Socket(Consumer o) {
		
		this.o = o;
	}

	/**
	 * This method creates 7 sockets for the lamp at a time
	 */
	public void run() {

		while (counterSO!=0) {

			synchronized (o) {
				
				//check the conditions and make the sockets
				if (socketList.size() < 35 || socketList.size() % 7 == 0) {

					for (int i = 0; i < 7; i++) {
						socketList.add(1);
					}
					o.notify();
				} else {
					try {
						o.wait();
					} catch (Exception e) {

					}
				}
counterSO--;
			}
		}
	}
}
