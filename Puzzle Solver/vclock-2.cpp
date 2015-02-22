	/**
	*
	* Clock.cpp
	*
	* Version
	*			$id$
	* Revision
	*			$log$
	* This program will take the number of hours on the dial the initial hour pointed by the hand and the final hour,
	* the hand should point at.
	*
	* input: hours on the dial, initial hour pointed by hand, final hour pointed by hand.
	* output: The configurations obtained and the sequence followed to reach the final hour 
	*/
	
	#include<iostream>
	#include<queue>
	#include<vector>
	#include<algorithm>
	#include<map>
	#include<list>
	#include "solver.h" //include the framework
	
	using namespace std;
	
	/**
	*
	* This class will take in the initial config and final configuration
	* It will track the sequence of moves needed to reach the final configuration
	* 
	* @author Sarvdeep Singh Bindra
	* 
	*
	*/
	class Clock: public solver<int>{
		
		public:
			//variables to store the number of hours on dial, the initial hour, the final hour and the hours to advance
			int totalNumber, starting, ending, move;
			
			
			
			/**
			* parameterized constructor
			* @param t		total number of hours on the dial
			* @param s		The starting hour
			* @param e		The final hour
			* @param m		The number of hours by which the hour shouls move
			*/
			Clock(int t, int s, int e, int m){
				totalNumber=t;
				starting=s;
				ending=e;
				move=m;
				if(move==0){
					cout<<"enter a value greater than 0"<<endl;
					exit(0);
				}
				
			}
			
			/**
			*
			* Method to get new configurations
			* @param config		This is the previous configuration from which new configuration are to be found
			*
			*
			*/
			vector<int> newConfig(int config){
				
				//create a vector to store the configurations generated
				vector<int> final;
				
				//decide the next move
				int next=config+move;
				
				//if it is less than 0 then adjust according to the dial
				if(next<=0){
					next+=totalNumber;
				}
				
				
				
			\
				
				//if it it greater than total number of hours on the dial adjust it
				if(next>totalNumber){
					next=next%totalNumber;
				}
				
				
				//add the next move to the vector
				
				final.push_back(next);
				
				//return the vector
				return final;
			}
			
			
				void solveClock(solver &sol){
				list<int> orblm = solve(sol);
				//print the sequence of moves taken to get the final configuration
				cout<<"the clock will tick as follows:"<<endl;
				
				for(list<int>::iterator it=orblm.begin();it!=orblm.end();it++){
					cout<<*it<<endl;
				}
				}
			
				/**
				* This method will loop till the queue is not empty and till the goal is not reached
				*
				*/
			    list<int> solve(solver &sol){
			    	
			    //allot the calling object as the initial configuration
				Clock initial=(*this);
				
				//create the map to keep track of repeated configurations
				map<int, int> visited;
				
				//add the initial configuration to the queue
				sol.configuration_queue.push(initial.starting);
				
				//make the initial configuration seen
				visited[initial.starting]=initial.starting;
				
				//varialbe to store the front of the queue
				int desired;
				
				//flag to indicate repeated configurations
				bool seen;
	
				
				
				
				//list to store the final set of moves to reach the final configuration
				list<int> result;
				//variable to retrieve configuration from the queue
				int con;
				
				//loop till the queue is not empty and the goal is not reached
				while(!sol.configuration_queue.empty() && !solved(desired=sol.configuration_queue.front())){
					
					//retrieve the configuration from the queue
					 con=sol.configuration_queue.front();
				
				
					//remove the configuration from the queue
					sol.configuration_queue.pop();
					
					//retrieve new configurations for the configuration stored in the queue
					vector<int>prob=newConfig(con);
					
					
					for(int j=0;j<prob.size();j++){
						//check whether the configuration is seen or not
						seen=visited.find(prob[j])!=visited.end();
						
						//if it is not seen add it to the queue and make the configuration from which new configurations are received 
						//as seen
						if(!seen){
						
						sol.configuration_queue.push(prob[j]);
						
						//make the configuration seen
						visited[prob[j]]=con;
					}
					
					
				}
				
				}
	
				
	
				//if the goal is reached
				if(solved(desired)){
					//get the last element added in the queue;
					int conf=desired;
					//till we dont find the initial configuration keep looping
					while(conf!=initial.starting){
						//add the configuration to the vector
						result.push_back(conf);
						//retrieve the configuration from the seen map
						conf=visited[conf];
						
					}
					//add the initial configuration to the vector
					result.push_back(initial.starting); 
				}
				else{
					cout<<"The goal cannot be reached with the value of move provided"<<endl;
					exit(0);
				}
				
				
				reverse(result.begin(),result.end());
				return result;
			}
			
			/**
			* method to check if the goal is reached
			* @param value 		it is the configuration
			*
			*/
			bool solved(int value){
				
				//if the passed configuration matches the final configuration then the goal has been reached.
				if(value==ending){
					return true;
				}
				else{
					return false;
				}
			}
	};
	
	int main(int argc, char const *argv[]){
		
		if(argc==5){
			int numberOfHours=atoi(argv[1]);
		int start=atoi(argv[2]);
		int end=atoi(argv[3]);
		int moveBy=atoi(argv[4]);
		Clock c(numberOfHours, start, end, moveBy);
		//create object of the solver class
		solver<int> sol;
		c.solveClock(sol);
		}
		else{
			cout<<"unexpected arguments"<<endl;
		}
		
		
	}
