package rit_Lamp;


import java.util.*;

public class Producer {

}

class Consumer{
	
}


class Screw extends Thread{
	
	ArrayList<Integer> screw=new ArrayList<Integer>(20);
	
	Object s;
	
	public Screw(Object s){
		this.s=s;
	}
	
	public void run(){
		synchronized(s){
		if(screw.size()<20&& screw.size()%4==0){
			s.notify();
			while(screw.size()!=20){
				screw.add(1);
			}
		}
			else{
				try{
				s.wait();
			}
				catch(Exception e){
					
				}
			}
		}
		}
	}


class Base extends Thread{
	
	ArrayList<Integer> base=new ArrayList<Integer>(10);
	
	Object b;
	
	public Base(Object b){
		this.b=b;
	}
	
	public void run(){
		synchronized(b){
			if(base.size()<10 && base.size()%2==0){
				b.notify();
				while(base.size()!=10){
					base.add(1);
				}
			}
			else{
				try{
				b.wait();
			}
				catch(Exception e){
					
				}
				}
		}
	}
}

class LightBulb extends Thread{
	
	ArrayList<Integer> lightBulb=new ArrayList<Integer>(20);
	
	Object l;
	
	public LightBulb(Object l){
		this.l=l;
	}
	
	public void run(){
		synchronized(l){
			if(lightBulb.size()<20 && lightBulb.size()%4==0){
				l.notify();
				while(lightBulb.size()!=20){
					lightBulb.add(1);
				}
			}
			else{
				try{
					l.wait();
				}
				catch(Exception e){
					
				}
			}
		}
	}
}

class Stand extends Thread{
	
	ArrayList<Integer> stand=new ArrayList<Integer>(20);
	
	Object S;
	
	public Stand(Object S){
		this.S=S;
	}
	
	public void run(){
		synchronized(S){
			if(stand.size()<20 && stand.size()%4==0){
				S.notify();
				while(stand.size()!=20){
					stand.add(1);
				}
			}
			else{
				try{
					S.wait();
				}
				catch(Exception e){
					
				}
			}
		}
	}
}

class Socket extends Thread{
	
	ArrayList<Integer> socket=new ArrayList<Integer>(35);
	
}

