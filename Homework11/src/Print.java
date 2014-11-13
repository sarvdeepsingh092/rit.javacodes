
/**
 * Print.java
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
 * This class creates the three Sequence which would print a b and c respectively
 * @author Sarvdeep Singh Bindra
 * @author Sumedha Singh
 *
 */
public class Print {
	
	public static void main(String args[])throws InterruptedException{
		
		//create an object on which every thread will put a lock
		Object t4=new Object();
		
		//create the three threads
		//for the first thread id is "a" and pass the object to put lock on
		Sequence t1=new Sequence("a",t4);
		
		//for the second thread id is "b" and pass the object to put lock on
		Sequence t2=new Sequence("b",t4);
		
		//for the third thread id is "c" and pass the object to put lock on
		Sequence t3=new Sequence("c",t4);
		
		//start the Sequence
		t1.start();
		
		t2.start();
		
		t3.start();
	
		
		
		
		
	}

}
