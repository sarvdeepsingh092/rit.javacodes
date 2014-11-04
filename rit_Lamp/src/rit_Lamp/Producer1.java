package rit_Lamp;

import java.util.*;

public class Producer1 {

	public static void main(String args[]) {
		Consumer1 c1 = new Consumer1();
		Consumer1 c2 = new Consumer1();

		Consumer1 c3 = new Consumer1(c1);
		Consumer1 c4 = new Consumer1(c2);

		c3.start();
		c4.start();

		/*
		 * try{ c3.join(); c4.join(); } catch(InterruptedException e){
		 * 
		 * }
		 */

	}

}

class Consumer1 extends Thread {
	static int counter = 10;
	Consumer1 o;
	Screw1 screw;
	LightBulb1 lb;
	Socket1 socket;
	Stand1 stand;
	Base1 base;

	/*
	 * Screw screw1=new Screw(screw); LightBulb lb1=new LightBulb(lb); Socket
	 * socket1=new Socket(socket); Stand stand1=new Stand(stand); Base base1=new
	 * Base(base);
	 */

	public Consumer1() {

	}

	public Consumer1(Consumer1 o) {
		this.o = o;
		screw = new Screw1(this.o);
		lb = new LightBulb1(this.o);
		socket = new Socket1(this.o);
		stand = new Stand1(this.o);
		base = new Base1(this.o);
	}

	public void run() {
		try {
			while (counter != 0) {
				synchronized (o) {

					if (Screw1.countScrew >= 4 && Base1.countBase >= 2 && Socket1.countSocket >= 7
							&& LightBulb1.countLB >= 4 && Stand1.countStand >= 4) {
						System.out.println("Lamp created");

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
						o.notify();

					} else {
						try {

							System.out.println("starting production");

							screw.start();
							base.start();
							socket.start();
							stand.start();
							lb.start();
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

class Screw1 extends Thread {

	static int counterS = 10;

	static int countScrew = 20;
	// ArrayList<Integer> screwList = new ArrayList<Integer>();

	Consumer1 o;

	// Object s;
	public Screw1(Consumer1 o) {
		this.o = o;
	}

	/*
	 * public Screw(Object s){ this.s=s;
	 * 
	 * }
	 */

	public void run() {

		while (counterS != 0) {
			synchronized (o) {
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

class Base1 extends Thread {

	static int counterB = 10;

	static int countBase = 10;
	// ArrayList<Integer> baseList = new ArrayList<Integer>(10);

	Consumer1 o;

	// Object b;

	public Base1(Consumer1 o) {
		this.o = o;
	}

	/*
	 * public Base(Object b){ this.b=b; }
	 */

	public void run() {

		while (counterB != 0) {
			synchronized (o) {

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

class LightBulb1 extends Thread {

	static int counterL = 10;

	static int countLB = 20;
	// ArrayList<Integer> lightBulbList = new ArrayList<Integer>(20);

	Consumer1 o;

	// Object l;

	public LightBulb1(Consumer1 o) {
		this.o = o;
	}

	/*
	 * public LightBulb(Object l){ this.l=l; }
	 */

	public void run() {

		while (counterL != 0) {
			synchronized (o) {

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

class Stand1 extends Thread {

	static int counterST = 10;

	static int countStand = 20;
	// ArrayList<Integer> standList = new ArrayList<Integer>(20);

	Consumer1 o;

	// Object S;

	public Stand1(Consumer1 o) {
		this.o = o;
	}

	/*
	 * public Stand(Object S){ this.S=S; }
	 */

	public void run() {

		while (counterST != 0) {

			synchronized (o) {
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

class Socket1 extends Thread {

	static int counterSO = 10;

	static int countSocket = 35;
	// ArrayList<Integer> socketList = new ArrayList<Integer>(35);

	Object so;

	Consumer1 o;

	public Socket1(Consumer1 o) {
		this.o = o;
	}

	public void run() {

		while (counterSO != 0) {

			synchronized (o) {
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
