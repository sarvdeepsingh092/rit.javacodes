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

public class Producer1 {

	public static void main(String args[]) {
		//create two consumer objects
		Consumer1 c1 = new Consumer1();
		Consumer1 c2 = new Consumer1();

		//create two more consumer objects and pass the previously created objects as arguments
		Consumer1 c3 = new Consumer1(c1);
		Consumer1 c4 = new Consumer1(c2);

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

class Consumer1 extends Thread {
	
	//declare a counter variable to run the run function that many times
	static int counter = 10;
	
	static int count=0;
	//create reference of the Consumer
	Consumer1 o;
	
	//create references of the producers
	Screw1 screw;
	LightBulb1 lb;
	Socket1 socket;
	Stand1 stand;
	Base1 base;

	

	/**
	 * default Constructor
	 */
	public Consumer1() {

	}

	/**
	 * parameterized constructor
	 * @param o		The Consumer object passed
	 */

	public Consumer1(Consumer1 o) {
		
		//assign the passed object to the locally created reference
		this.o = o;
		
		//create the objects of the producers and pass the consumer object to them
		screw = new Screw1(this.o);
		lb = new LightBulb1(this.o);
		socket = new Socket1(this.o);
		stand = new Stand1(this.o);
		base = new Base1(this.o);
	}

	

	/**
	 * This function creates the lamp and invokes the producers if the items needed are insufficient
	 */
	public void run() {
		try {
			while (counter != 0) {
				synchronized (o) {

					//check if the items are available
					if (Screw1.countScrew >= 4 && Base1.countBase >= 2 && Socket1.countSocket >= 7
							&& LightBulb1.countLB >= 4 && Stand1.countStand >= 4) {
						
						//if yes then lamp is created
						
						count++;
						System.out.println("Lamp "+count+" created");
						//remove those many items from the producers count
						for (int i = 0; i < 4; i++) {
							Screw1.countScrew--;
						}

						for (int i = 0; i < 2; i++) {
							Base1.countBase--;
						}
						for (int i = 0; i < 4; i++) {
							LightBulb1.countLB--;
						}
						for (int i = 0; i < 4; i++) {
							Stand1.countStand--;
						}
						for (int i = 0; i < 7; i++) {
							Socket1.countSocket--;
						}
						
						//notify the consumer to wake up
						o.notify();

					} else {
						try {

							
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
class Screw1 extends Thread {

	//initialize counter to run the run method that many times
	static int counterS = 10;

	//declare and initialize counter
	static int countScrew = 20;
	

	//declare reference of the consumer
	Consumer1 o;

	/**
	 * parameterized constructor assigns passed object to the consumer reference
	 * @param o		passed object
	 */
	public Screw1(Consumer1 o) {
		this.o = o;
	}

	

	/**
	 * This method creates 4 screws at a time and waits if the count is full
	 */
	public void run() {

		while (counterS != 0) {
			synchronized (o) {
				
				//check conditions and generate screws
				if (countScrew <= 20 || countScrew % 4 == 0) {
					for(int i=0;i<4;i++){
						countScrew++;
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
class Base1 extends Thread {

	//declare the counter to run the run method
	static int counterB = 10;

	//declare and initialize the counter
	static int countBase = 10;
	//declare the consumer reference
	Consumer1 o;

	

	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public Base1(Consumer1 o) {
		this.o = o;
	}

	

	/**
	 * This method creates 2 bases at a time
	 */
	public void run() {

		while (counterB != 0) {
			synchronized (o) {

				//check condition and create base
				if (countBase < 10 || countBase % 2 == 0) {
					for(int i=0;i<2;i++){
						countBase++;

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
class LightBulb1 extends Thread {

	//declare the counter to run the run method
	static int counterL = 10;

	//declare and initialize the counter
	static int countLB = 20;
	

	//declare the consumer reference
	Consumer1 o;

	

	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public LightBulb1(Consumer1 o) {
		this.o = o;
	}

	

	/**
	 * This method creates the lightbulbs needed for the lamp
	 */
	public void run() {

		while (counterL != 0) {
			synchronized (o) {
				//check condition and create the lightbulbs  
				if (countLB < 20 || countLB % 4 == 0) {
					for(int i=0;i<4;i++){
					countLB++;
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
class Stand1 extends Thread {

	//declare the counter to run the run method
	static int counterST = 10;

	//declare and initialize the counter
	static int countStand = 20;
	
	//declare the consumer reference
	Consumer1 o;

	

	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public Stand1(Consumer1 o) {
		this.o = o;
	}

	

	/**
	 * this method creates 4 stands at a time for the lamp
	 */
	public void run() {

		while (counterST != 0) {

			synchronized (o) {
		
				//check condition and make stands
				if (countStand < 20 || countStand % 4 == 0) {
					for(int i=0;i<4;i++){
					countStand++;
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
class Socket1 extends Thread {

	//declare the counter to run the run method
	static int counterSO = 10;

	//declare and initialize the counter
	static int countSocket = 35;
	
	Object so;

	//declare the consumer reference
	Consumer1 o;

	/**
	 * parameterized constructor assigns value of passed object to object reference created
	 * @param o		passed objects
	 */
	public Socket1(Consumer1 o) {
		this.o = o;
	}

	/**
	 * This method creates 7 sockets for the lamp at a time
	 */
	public void run() {

		while (counterSO != 0) {

			synchronized (o) {
		
				//check the conditions and make the sockets
				if (countSocket < 35 || countSocket % 7 == 0) {
					for(int i=0;i<7;i++){
					countSocket++;
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
