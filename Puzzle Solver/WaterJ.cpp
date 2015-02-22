/**
* WaterJ.cpp
* 
* Version
*			$id$
*
* Revision
*			$log$
*
* This program takes the capacity of the two buckets and the amount of water needed in the bucket and gives out the sequence 
* followed to reach the goal configuration
*
* input: capacity of the buckets and the amount of water needed in the bucker
*
* output: sequence of moves to reach the goal configuration
*/
#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include "solver.h" //include the framework

using namespace std;
/**
* This class holds the jug objects for the problem class and handles the current value and capacity of the jugs
*
* @author Sarvdeep Singh Bindra
* @author Tuheen R Sukhrani
*
*/
class Jug{
	
	public:
			//variables to hold the capacity and current value for jugs
			int capacity;
			int current;
			
};


/**
*
* This class finds the configurations, keeps track of the configurations and prints the configurations created to fill the jug
* @author Sarvdeep Singh Bindra
* @author Tuheen R Sukhrani
*/
class Problem: public solver<Problem>{
	
	public:
		
		//declare the variable to store the amount needed in the bucket
		int goal;
		//set of jugs for the problem
		Jug jug[2];
		
	
		
		/**
		* Default constructor
		*
		*/
		Problem(){
			//initialize the capacity of the jugs for the problem
			jug[0].capacity=jug[0].capacity;
			jug[1].capacity=jug[1].capacity;	
			goal=goal;
		}
		
		Problem(int capacity1, int capacity2, int goal1){
			jug[0].capacity=capacity1;
			jug[1].capacity=capacity2;
			goal=goal1;
		}
		
		vector<Problem> newConfig(Problem conf){
			
			//create a temporary object so as to create the configurations
			Problem temp;
			
			//create a vector to store the configurations generated
			vector<Problem> result;
				
				
				//empty the jugs
				for(int i=0;i<2;i++){
					//if the jug is not empty make it empty and print the configuration
					if(conf.jug[i].current!=0){
						temp=conf;
						temp.jug[i].current=0;

						//push the configuration generated in the queue
						result.push_back(temp);
					}
				}

				//fill the jugs
				for(int i=0;i<2;i++){
					
					//if the current value of the jug is not equal to its capacity
					//fill the jug to its capacity and print the configuration
					if(conf.jug[i].current!=conf.jug[i].capacity){
						temp=conf;
						temp.jug[i].current=temp.jug[i].capacity;

						//push the configuration in the queue
						result.push_back(temp);
					}
				}

				
				//transfer water from one jug to another
				for(int i=0;i<2;i++){
					for(int j=0;j<2;j++){
						//if its not the same jug then proceed
						if(i!=j){
						//decide the amount to be transferred from one jug to another	
						int amount=min(conf.jug[i].current, conf.jug[j].capacity-conf.jug[j].current);	
						//if the amount is not 0 then proceed
						if(amount!=0){
							temp=conf;
							//if the current value of the jug after transferring goes below 0 then make it 0
							//otherwise keep the original value after tranferring as it is
							if((temp.jug[i].current-amount)<0){
								temp.jug[i].current=0;
							}
							else{
								temp.jug[i].current=temp.jug[i].current-amount;
							}
							//if the current value of the jug after transferring is more than its capacity 
							//then make it its capacity otherwise keep the original value after transferring
							if((temp.jug[j].current+amount)>temp.jug[j].capacity){
								temp.jug[j].current=temp.jug[j].capacity;
							}
							else{
								temp.jug[j].current=temp.jug[j].current+amount;
							}
							
							//push the configuration into the queue
							result.push_back(temp);
						}	
						}
					}
				}
				
			//return the vector holding the new configurations	
			return result;
			}
			

			
			
			/**
			* Method to compare two configurations
			* @param p1		Object of type Problem
			* @param p2		Object of type Problem
			*
			*
			*/
			bool compare(Problem p1, Problem p2){
				Problem pointer1, pointer2;
				pointer1=p1;
				pointer2=p2;
				
				//compare the current value of the two jugs held by the two objects passed
				if((pointer1.jug[0].current==pointer2.jug[0].current)&&(pointer1.jug[1].current==pointer2.jug[1].current)){
					return true;
				}
				else{
				return false;
				}
			}
			
			/**
			* method to get the final sequence of configurations and to print that sequence
			* @param &sol 		Object of type solver
			*
			*/
			void solveJug(solver<Problem> &sol){
				vector<Problem> orblm = solve(sol);
				//print the vector in reverse order as the configurations were added from end to initial				
				cout<<"the sequence of reaching the goal is as follows: "<<endl;				
				for(int i=orblm.size()-1;i>=0;i--){
					Problem temp1=orblm[i];
					cout<<"("<<temp1.jug[0].current<<","<<temp1.jug[1].current<<")"<<endl;
				}

			}
			
			/**
			*
			* This method will solve the problem by checking if the one of the jugs has the required value
			* and by looping till the queue is not empty
			* @param Object of type solver
			*/
			vector<Problem> solve(solver<Problem> &sol){
				Problem initial=(*this);
				
				//push the initial configuration into the queue
				sol.configuration_queue.push(initial);
				Problem desired;
				
				//declare the map to check for the seen configurations
				map<Problem, Problem> visited;
				
				//declare a boolean indicator
				bool seen=false;
				
				//make the initial configuration seen
				visited[initial]=initial;
				
				//create a vector which holds the final sequence of steps
				vector<Problem> finalResult;
				
				//loop till the queue is not empty and the result is not obtained
				while(!sol.configuration_queue.empty()&& !solved(desired=sol.configuration_queue.front())){
					
					//get the configuration in the front of the queue
					Problem C=sol.configuration_queue.front();
					
					//pop that configuration out of the queue
					sol.configuration_queue.pop();					
					//retrieve set of new configurations for the configuration obtained from the queue
					vector<Problem> prob=newConfig(C);
					
					//add the new configurations obtained to the queue
					for(int i=0;i<prob.size();i++){
						
							 //check whether the new configuration retrieved has been seen
							 seen=visited.find(prob[i])!=visited.end();
						
						//if it is not seen then add it to the configuration queue
						if(!seen){
						
						sol.configuration_queue.push(prob[i]);
						
						//make the configuration seen
						visited[prob[i]]=C;
						
					}
				} 
					
				}
				
				//if the goal has been reached
				if(solved(desired)){			
					Problem con=desired;
				
					//compare the configuration to the initial configuration
					while(compare(con, initial)!=true){
						
						//put the configuration into the vector
						finalResult.push_back(con);
						
						//retrieve configuration from the visited map
						con=visited[con];
						
					}
					//eventually add the initial configuration to the vector
					finalResult.push_back(initial);
					
				}
				//if the goal is not reached print the message
				else{
					cout<<"solution does not exist"<<endl;
					exit(1);
				}
				
				
				return finalResult;

							
			}
			
			/**
			* method to check if the soltution is obtained
			* @param		object of the class Problem
			*/
			bool solved(Problem c){
					//check if any of the jug has the required amount of water in it
					if(c.jug[0].current==c.goal||c.jug[1].current==c.goal){
						return true;
					
				}
				//if not return false
				else{
				
				return false;
				}
			}
};

			/**
			* This method overloads the less than operator which is used while adding configurations to the map
			* Since the configurations are compared to each other while adding them to the map
			* @param p1		Object of type Problem
			* @param p2		Object of type Problem
			*
			*
			*/
			bool operator<(const Problem& p1, const Problem& p2){
				
				//if the current value of the first object's jug is less than second object's jug return true
				if(p1.jug[0].current<p2.jug[0].current){
					return true;
				}
				//else return false
				else if(p1.jug[0].current>p2.jug[0].current){
					return false;
				}
				//if the current value of the first object's jug is less than second object's jug return true
				else if(p1.jug[1].current<p2.jug[1].current){
					return true;
				}
				//else return false
				else if(p1.jug[1].current>p2.jug[1].current){
					return false;
				}
				//if no conditions pass then return false
				else{
					return false;
				}
			}

/**
* main program
*
*/
int main(int argc, char* argv[]){
	//create the object of the problem class
	
	int capacity1, capacity2, goal;
	if(argc==4)
{
	capacity1=atoi(argv[1]);
	capacity2=atoi(argv[2]);
	goal=atoi(argv[3]);
	Problem p(capacity1, capacity2, goal);
	for(int i=0;i<2;i++){
		p.jug[i].current=0;
	}
	
		//object of the solver
		solver<Problem> sol;
	//call the method to solve the problem
	p.solveJug(sol);
}
}
