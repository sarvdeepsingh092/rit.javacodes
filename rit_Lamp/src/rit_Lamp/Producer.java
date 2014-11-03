package rit_Lamp;


import java.util.*;

public class Producer {

}

class Consumer{
	
}


class Screw extends Thread{
	
	ArrayList<Integer> screwList=new ArrayList<Integer>(20);
	
	Object s;
	
	public Screw(Object s){
		this.s=s;
	}
	
	public void run(){
		synchronized(s){
		if(screwList.size()<20&& screwList.size()%4==0){
			s.notify();
			while(screwList.size()!=20){
				screwList.add(1);
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
	
	ArrayList<Integer> baseList=new ArrayList<Integer>(10);
	
	Object b;
	
	public Base(Object b){
		this.b=b;
	}
	
	public void run(){
		synchronized(b){
			if(baseList.size()<10 && baseList.size()%2==0){
				b.notify();
				while(baseList.size()!=10){
					baseList.add(1);
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
	
	ArrayList<Integer> lightBulbList=new ArrayList<Integer>(20);
	
	Object l;
	
	public LightBulb(Object l){
		this.l=l;
	}
	
	public void run(){
		synchronized(l){
			if(lightBulbList.size()<20 && lightBulbList.size()%4==0){
				l.notify();
				while(lightBulbList.size()!=20){
					lightBulbList.add(1);
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
	
	ArrayList<Integer> standList=new ArrayList<Integer>(20);
	
	Object S;
	
	public Stand(Object S){
		this.S=S;
	}
	
	public void run(){
		synchronized(S){
			if(standList.size()<20 && standList.size()%4==0){
				S.notify();
				while(standList .size()!=20){
					standList.add(1);
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
	
	ArrayList<Integer> socketList=new ArrayList<Integer>(35);
	
}

