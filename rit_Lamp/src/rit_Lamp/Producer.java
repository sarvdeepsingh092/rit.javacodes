package rit_Lamp;

import java.util.*;

public class Producer {

	public static void main(String args[]) {
		Consumer c1 = new Consumer();
		Consumer c2 = new Consumer();

		Consumer c3 = new Consumer(c1);
		Consumer c4 = new Consumer(c2);

		c3.start();
		c4.start();

		/*
		 * try{ c3.join(); c4.join(); } catch(InterruptedException e){
		 * 
		 * }
		 */

	}

}

class Consumer extends Thread {
	static int counter = 10;
	Consumer o;
	Screw screw;
	LightBulb lb;
	Socket socket;
	Stand stand;
	Base base;

	/*
	 * Screw screw1=new Screw(screw); LightBulb lb1=new LightBulb(lb); Socket
	 * socket1=new Socket(socket); Stand stand1=new Stand(stand); Base base1=new
	 * Base(base);
	 */

	public Consumer() {

	}

	public Consumer(Consumer o) {
		this.o = o;
		screw = new Screw(this.o);
		lb = new LightBulb(this.o);
		socket = new Socket(this.o);
		stand = new Stand(this.o);
		base = new Base(this.o);
	}

	public void run() {
		try {
			while (counter != 0) {
				synchronized (o) {

					if (screw.screwList.size() >= 4 && base.baseList.size() >= 2 && socket.socketList.size() >= 7
							&& lb.lightBulbList.size() >= 4 && stand.standList.size() >= 4) {
						System.out.println("Lamp created");

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

class Screw extends Thread {

	static int counterS=10;
	ArrayList<Integer> screwList = new ArrayList<Integer>();

	Consumer o;

	// Object s;
	public Screw(Consumer o) {
		this.o = o;
	}

	/*
	 * public Screw(Object s){ this.s=s;
	 * 
	 * }
	 */

	public void run() {

		while (counterS!=0) {
			synchronized (o) {
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

class Base extends Thread {

	static int counterB=10;
	ArrayList<Integer> baseList = new ArrayList<Integer>(10);

	Consumer o;

	// Object b;

	public Base(Consumer o) {
		this.o = o;
	}

	/*
	 * public Base(Object b){ this.b=b; }
	 */

	public void run() {

		while (counterB!=0) {
			synchronized (o) {

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

class LightBulb extends Thread {

	static int counterL=10;
	ArrayList<Integer> lightBulbList = new ArrayList<Integer>(20);

	Consumer o;

	// Object l;

	public LightBulb(Consumer o) {
		this.o = o;
	}

	/*
	 * public LightBulb(Object l){ this.l=l; }
	 */

	public void run() {

		while (counterL!=0) {
			synchronized (o) {

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

class Stand extends Thread {

	static int counterST=10;
	ArrayList<Integer> standList = new ArrayList<Integer>(20);

	Consumer o;

	// Object S;

	public Stand(Consumer o) {
		this.o = o;
	}

	/*
	 * public Stand(Object S){ this.S=S; }
	 */

	public void run() {

		while (counterST!=0) {

			synchronized (o) {
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

class Socket extends Thread {

	static int counterSO=10;
	ArrayList<Integer> socketList = new ArrayList<Integer>(35);

	Object so;

	Consumer o;

	public Socket(Consumer o) {
		this.o = o;
	}

	public void run() {

		while (counterSO!=0) {

			synchronized (o) {
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
