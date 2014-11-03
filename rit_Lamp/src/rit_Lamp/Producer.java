package rit_Lamp;


import java.util.*;

public class Producer {
	
	public static void main(String args[]){
		Consumer c1=new Consumer();
		Consumer c2=new Consumer();
		
		Consumer c3=new Consumer(c1);
		Consumer c4=new Consumer(c2);
		
		c3.start();
		c4.start();
		
		/*try{
		c3.join();
		c4.join();
		}
		catch(InterruptedException e){
			
		}*/
		
	}

}

class Consumer extends Thread{
	
	Screw screw=new Screw();;
	LightBulb lb=new LightBulb();
	Socket socket=new Socket();
	Stand stand=new Stand();
	Base base=new Base();
	
	/*Screw screw1=new Screw(screw);
	LightBulb lb1=new LightBulb(lb);
	Socket socket1=new Socket(socket);
	Stand stand1=new Stand(stand);
	Base base1=new Base(base);*/
	
	Consumer o;
	
	public Consumer(){
		
	}
	
	public Consumer(Consumer o){
		this.o=o;
	}
	
	public void run(){
	synchronized(o){
		
		
			
		
		if(screw.screwList.size()>=4 && base.baseList.size()>=2 && socket.socketList.size()>=7 && lb.lightBulbList.size()>=4 && stand.standList.size()>=4){
	        o.notify();
			System.out.println("Lamp created");	
		
	}
		else{
			try{
				
				System.out.println("starting production");
				screw.start();
				base.start();
				socket.start();
				stand.start();
				lb.start();
				o.wait();
			}
			catch(Exception e){
				
			}
		}
		
	}
	}
	
	
	
	
}


class Screw extends Thread{
	
	ArrayList<Integer> screwList=new ArrayList<Integer>(20);
	
	
	
	//Object s;
	public Screw(){
		
	}
	
	/*public Screw(Object s){
		this.s=s;
		
	}*/
	
	public void run(){
		synchronized(Screw.class){
		if(screwList.size()<20 ||screwList.size()%4==0){
			Screw.class.notify();
			while(screwList.size()!=20){
				screwList.add(1);
			}
		}
			else{
				try{
				Screw.class.wait();
			}
				catch(Exception e){
					
				}
			}
		}
		}
	}


class Base extends Thread{
	
	ArrayList<Integer> baseList=new ArrayList<Integer>(10);
	
	//Object b;
	
	public Base(){
		
	}
	
	/*public Base(Object b){
		this.b=b;
	}*/
	
	public void run(){
		synchronized(Base.class){
			if(baseList.size()<10 || baseList.size()%2==0){
				Base.class.notify();
				while(baseList.size()!=10){
					baseList.add(1);
				}
			}
			else{
				try{
				Base.class.wait();
			}
				catch(Exception e){
					
				}
				}
		}
	}
}

class LightBulb extends Thread{
	
	ArrayList<Integer> lightBulbList=new ArrayList<Integer>(20);
	
	//Object l;
	
	public LightBulb(){
		
	}
	
	/*public LightBulb(Object l){
		this.l=l;
	}*/
	
	public void run(){
		synchronized(LightBulb.class){
			if(lightBulbList.size()<20 || lightBulbList.size()%4==0){
				LightBulb.class.notify();
				while(lightBulbList.size()!=20){
					lightBulbList.add(1);
				}
			}
			else{
				try{
					LightBulb.class.wait();
				}
				catch(Exception e){
					
				}
			}
		}
	}
}

class Stand extends Thread{
	
	ArrayList<Integer> standList=new ArrayList<Integer>(20);
	
	//Object S;
	
	public Stand(){
		
	}
	
	/*public Stand(Object S){
		this.S=S;
	}*/
	
	public void run(){
		synchronized(Stand.class){
			if(standList.size()<20 || standList.size()%4==0){
				Stand.class.notify();
				while(standList .size()!=20){
					standList.add(1);
				}
			}
			else{
				try{
					Stand.class.wait();
				}
				catch(Exception e){
					
				}
			}
		}
	}
}

class Socket extends Thread{
	
	ArrayList<Integer> socketList=new ArrayList<Integer>(35);
	
	Object so;
	
	public Socket(){
		
	}
	
	public Socket(Object so){
		this.so=so;
	}
	
	public void run(){
		synchronized(so){
			if(socketList.size()<35 || socketList.size()%7==0){
				so.notify();
				while(socketList.size()!=35){
					socketList.add(1);
				}
			}
			else{
				try{
				so.wait();
			}
				catch(Exception e){
					
				}
		}
		}
	}
}

