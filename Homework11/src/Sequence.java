
/**
 * Sequence.java
 * 
 * Version
 * 			$id$
 * 
 * Revision
 * 			$log$
 * 
 *
 */


/**
 * This class will print the three alphabets in order
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class Sequence extends Thread {

	//declare the object to put lock on
	Object t;

	//declare the id
	String id = "";

	//declare the indicators to control the flow of the output
	static boolean flagA = true;
	static boolean flagB = true;
	static boolean flagC = true;

	/**
	 * parameterized constructor
	 * @param id 		The thread id passed
	 * @param t			The object to put lock on
	 */
	Sequence(String id, Object t) {
		//assign the object passed to t
		this.t = t;

		//assign the value of id to id
		this.id = id;
	}

	/**
	 * This method will print the three alphabets in order
	 */
	public void run() {
		while (true) {
			//put the lock on the object
			synchronized (t) {

				//check if thread id is "a"
				if (id.equals("a")) {
					
					//check whether indicator permits to print
					if (flagA) {
						
						//notify the thread with id "a"
						t.notify();
						
						//print the id
						System.out.print(id+" ");
						
						//put the thread to sleep so that the output is clear
						try {
							sleep(1000);
						} 
						catch (InterruptedException e1) {
							
						}
						
						//make indicator for "b" true and indicators for "a" and "c" false
						flagB = true;
						flagA = false;
						flagC = false;
						
						//make the thread with id "a" wait
						try {
							t.wait();
						} catch (Exception e) {

						}
					}
				} 
				
				//check if thread id is "b"
				else if (id.equals("b")) {
					
					//check whether indicator permits to print
					if (flagB) {
						
						//notify the thread with id "b"
						t.notify();
						
						//print the id
						System.out.print(id+" ");
						
						//put the thread to sleep so that the output is clear
						try {
							sleep(1000);
						} 
						catch (InterruptedException e1) {
							
						}
						
						//make indicator for "c" true and indicators for "a" and "b" false
						flagC = true;
						flagA = false;
						flagB = false;
						
						//make the thread with id "b" wait
						try {
							t.wait();
						} catch (Exception e) {

						}
					}
				} 
				
				//check if thread id is "c"
				else if (id.equals("c")) {
					
					//check whether indicator permits to print
					if (flagC) {
						
						//notify the thread with id "c"
						t.notify();
						
						//print the id
						System.out.print(id+" ");
						
						//put the thread to sleep so that the output is clear
						try {
							sleep(1000);
						}
						catch (InterruptedException e1) {
													
						}
					
						//make indicator for "a" true and indicators for "b" and "c" false
						flagA = true;
						flagB = false;
						flagC = false;
						
						//make the thread with id "c" wait
						try {
							t.wait();
						} catch (Exception e) {

						}
					}
				}

			}
		}
	}
}
