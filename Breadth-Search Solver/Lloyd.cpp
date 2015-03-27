/**
*
* Lloyd.cpp
*
* Version
*			$id$
* Revision
*			$log$
* This program will a take two two dimensional arrays as the initial configuration and the goal configuration
* It will find the configurations needed to reach the goal configuration from the initial configuration
* input: initial configuration
* output: The configurations added in the configuration queue and the the goal configuration once it is reached
*/
#include<iostream>
#include<fstream>
#include<stdio.h>
#include<stdlib.h>


#include"solver.h" //include the framework

using namespace std;

/**
* This class takes the initial configuration and tries to reach the goal configuration
*
* @author Sarvdeep Singh Bindra
* @author Tuheen R Sukhrani
*
*
*/
class Lloyd{
	public:
		
		//pointer to two dimensional array to store the initial configuration
		char **initial;
		
		//pointer to two dimensional array to store the goal configuration
		char **goal;
		
		//The solver class object 
		solver<char**> sol;
		
		//variables to store the number of rows and columns for the configuration
		int height, width;
		
		
	/**
	* method to read the number of rows and columns from the user
	* It will also read the initial and the goal configuration
	*
	*/
	void read(){
		
		//ask for the number of rows
		cout<<"enter the number of rows"<<endl;
		cin>>height;
		
		//ask for the number of coloumns
		cout<<"enter the number of columns"<<endl;
		cin>>width;
		
		//initialize the initial and goal configuration array
		initial=new char*[height];
		goal=new char*[height];
		
		for(int i=0;i<height;i++){
			initial[i]=new char[width];
			goal[i]=new char[width];
		}
		
		//string to read the configuration
		string input;
		
		cout<<"enter the initial configuration"<<endl;
		
		//read the initial configuration
		for(int i=0;i<height;i++){
			cin>>input;
			//if the length of the string is more than number of coloumns then print error
			if(input.length()!=width){
				cout<<"enter the correct amount of characters"<<endl;
				exit(1);
			}
			else{
				//otherwise read the configuration and store it in the array
				for(int j=0;j<input.length();j++){
					initial[i][j]=input[j];
				}
			}
		}
		
		cout<<"enter the goal configuration"<<endl;
		
		//read the goal configuration
		for(int i=0;i<height;i++){
			cin>>input;
			//if the length of the string is more than number of coloumns then print error
			if(input.length()!=width){
				cout<<"enter the correct amount of characters"<<endl;
				exit(1);
			}
			else{
				//otherwise read the configuration and store it in the array
				for(int j=0;j<input.length();j++){
					goal[i][j]=input[j];
				}
			}
		}	
		
		//push the initial configuration to the queue
		sol.configuration_queue.push(initial);
		
		//push the initial configuration to the seen queue
		sol.seen_queue.push_back(initial);
		
		//call the method to reach the goal configuration
		solve();
			
		}
	
	/**
	* method to find the new configurations from previous configurations and to check whether goal has been reached
	*
	*
	*/
	void solve(){
		
		//pointer to represent current configuration
		//initialize it
		char** current=new char*[height];
		
		for(int i=0;i<height;i++){
			current[i]=new char[width];
		}
		
		//check if the goal is reached
		while(!solved(sol.configuration_queue.front())){
			
			//copy the configuration stored in the queue into the current configuration
			for(int i=0;i<height;i++){
				for(int j=0;j<width;j++){
					current[i][j]=sol.configuration_queue.front()[i][j];
				}
			}
			
			
			
			//pop it out of the queue
			sol.configuration_queue.pop();
			
			for(int i=0;i<height;i++){
				for(int j=0;j<width;j++){
					
					//'.' represents a blank
					//if a blank is found then decide where to move it 
					if(current[i][j]=='.'){
						
						//check for the four corners
						
						//top left corner
						if(i==0&&j==0){
							//move right
							char **newconfig=moveright(current,i,j);
							//if new config is not seen add it to the queue
							if(seen(newconfig)==false){
								sol.configuration_queue.push(newconfig);
							
							}
							
							//move down
							newconfig=movedown(current,i,j);
							//if new config is not seen add it to the queue
							if(seen(newconfig)==false){
								sol.configuration_queue.push(newconfig);
								
							}
						}
						
						//top right corner
						else if(i==0&&j==width-1){
							
							//move left
							char **newconfig=moveleft(current,i,j);
							//if new config is not seen add it to the queue
							if(seen(newconfig)==false){
								sol.configuration_queue.push(newconfig);
								
							}
							
							//move down
							newconfig=movedown(current,i,j);
							//if new config is not seen add it to the queue
							if(seen(newconfig)==false){
								sol.configuration_queue.push(newconfig);
								
							}
						}
						
						//bottom left corner
						else if(i==height-1&&j==0){
							
							//move up
							char **newconfig=moveup(current,i,j);
							//if new config is not seen add it to the queue
							if(seen(newconfig)==false){
								sol.configuration_queue.push(newconfig);
								
							}
							
							//move right
							newconfig=moveright(current,i,j);
							//if new config is not seen add it to the queue
							if(seen(newconfig)==false){
								sol.configuration_queue.push(newconfig);
								
							}
							}
							
							//bottom right corner 
							else if(i==height-1&&j==width-1){
								
								//move up
								char **newconfig=moveup(current,i,j);
								//if new config is not seen add it to the queue
								if(seen(newconfig)==false){
									sol.configuration_queue.push(newconfig);
									
								}
								
								//move left
								newconfig=moveleft(current,i,j);
								//if new config is not seen add it to the queue
								if(seen(newconfig)==false){
									sol.configuration_queue.push(newconfig);
							
								}
							}
							
							//check for the four boundaries
							
							//left boundary
							else if((i>0&&i<height-1)&&j==0){
								
								//move up
								char **newconfig=moveup(current,i,j);
								//if new config is not seen add it to the queue
								if(seen(newconfig)==false){
									sol.configuration_queue.push(newconfig);
									
								}
								
								//move right
								newconfig=moveright(current,i,j);
								//if new config is not seen add it to the queue
								if(seen(newconfig)==false){
									sol.configuration_queue.push(newconfig);
								
								}
								
								//move down
								newconfig=movedown(current,i,j);
								//if new config is not seen add it to the queue
								if(seen(newconfig)==false){
									sol.configuration_queue.push(newconfig);
									
								}
								}
								
								//right boundary
								else if((i>0&&i<height-1)&&(j==width-1)){
									
									//move up
									char **newconfig=moveup(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
									
									}
									
									//move left
									newconfig=moveleft(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move down
									newconfig=movedown(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
								}
								
								//top boundary
								else if(i==0&&(j>0&&j<width-1)){
									
									//move down
									char **newconfig=movedown(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move left
									newconfig=moveleft(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move right
									newconfig=moveright(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
								}
								
								//bottom boundary
								else if(i==height-1&&(j>0&&j<width-1)){
									
									//move up
									char **newconfig=moveup(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move left
									newconfig=moveleft(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move right
									newconfig=moveright(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
								}
								
								//the middle of the array
								else if((i>0&&i<height-1)&&(j>0&&j<width-1)){
									
									//move up
									char **newconfig=moveup(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move down
									newconfig=movedown(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move left
									newconfig=moveleft(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
										
									}
									
									//move right
									newconfig=moveright(current,i,j);
									//if new config is not seen add it to the queue
									if(seen(newconfig)==false){
										sol.configuration_queue.push(newconfig);
									
									}
								}
							}
						}
					}
					//add the current configuration to the seen queue
					sol.seen_queue.push_back(current);
					
				//print the current configuration	
				cout<<"the current configuration is: "<<endl;
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						cout<<current[i][j]<<" ";
					}
					cout<<endl;
				}
			}
				//print the goal configuration
				//since the goal has been reached this statement will execute as it is outside the while loop
				cout<<"goal configuration is:"<<endl;
					for(int i=0;i<height;i++){
						for(int j=0;j<width;j++){
							cout<<goal[i][j]<<" ";
						}
						cout<<endl;
					}
	}

			
		
			
			/**
			* method to move the blank up
			* @param **currentconfig		it the configuration from which new configuration is to be obtained
			* @param a						the row position of the blank
			* @param b						the column position of the blank
			*/
			char** moveup(char **currentconfig,int a, int b){
				//create a new array pointer to store the new configuration
				char **newconfig=new char*[height];
				
				for(int i=0;i<height;i++){
					newconfig[i]=new char[width];
				}
				
				//copy the current config to new config
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						newconfig[i][j]=currentconfig[i][j];
					}
				}
				
				//swap the characters
				newconfig[a][b]=newconfig[a-1][b];
				newconfig[a-1][b]='.';
				return newconfig;
			}
			
			/**
			* method to move the blank down
			* @param **currentconfig		it the configuration from which new configuration is to be obtained
			* @param a						the row position of the blank
			* @param b						the column position of the blank
			*/
			char** movedown(char **currentconfig, int a, int b){
				//create a new array pointer to store the new configuration	
				char **newconfig=new char*[height];
				
				for(int i=0;i<height;i++){
					newconfig[i]=new char[width];
				}
				
				//copy the current config to new config
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						newconfig[i][j]=currentconfig[i][j];
					}
				}
				//swap the characters
				newconfig[a][b]=newconfig[a+1][b];
				newconfig[a+1][b]='.';
				return newconfig;
			}
			
			/**
			* method to move the blank to the left
			* @param **currentconfig		it the configuration from which new configuration is to be obtained
			* @param a						the row position of the blank
			* @param b						the column position of the blank
			*/
			char** moveleft(char **currentconfig,int a, int b){
				//create a new array pointer to store the new configuration
				char **newconfig=new char*[height];
				
				for(int i=0;i<height;i++){
					newconfig[i]=new char[width];
				}
				//copy the current config to new config
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						newconfig[i][j]=currentconfig[i][j];
					}
				}
				//swap the characters
				newconfig[a][b]=newconfig[a][b-1];
				newconfig[a][b-1]='.';
				return newconfig;
			}
			
			/**
			* method to move the blank to the right
			* @param **currentconfig		it the configuration from which new configuration is to be obtained
			* @param a						the row position of the blank
			* @param b						the column position of the blank
			*/
			char** moveright(char **currentconfig, int a, int b){
				//create a new array pointer to store the new configuration
				char **newconfig=new char*[height];
				
				for(int i=0;i<height;i++){
					newconfig[i]=new char[width];
				}
				//copy the current config to new config
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						newconfig[i][j]=currentconfig[i][j];
					}
				}
				//swap the characters
				newconfig[a][b]=newconfig[a][b+1];
				newconfig[a][b+1]='.';
				return newconfig;
			}
			
			/**
			* method to check whether a configuration has been seen
			* @param **newconfig 		the configuration to be checked
			*
			*/
			bool seen(char** newconfig){
			
			//check if the configuration is present in the seen queue	
			for(int i=0;i<sol.seen_queue.size();i++){
					if(compare(newconfig, sol.seen_queue[i])){
						return true;
					}
				}
				return false;
				
			}
			
			/**
			* method to check if the goal has been reached
			* @param **config 		the configuration to be compared with the goal
			*
			*/
			bool solved(char **config){
				
				//compare the configuration with the goal configuration
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(config[i][j]!=goal[i][j]){
							return false;
						}
					}
				}
				return true;
			}
			
			/**
			* method to compare two arrays
			* @param **firstconfig		the first configuration to be compared
			* @param **secondconfig		the second configuration to be compared
			*/
			bool compare(char** firstconfig, char** secondconfig){
				//compare te first and the second configuration
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(firstconfig[i][j]!=secondconfig[i][j]){
							return false;
						}
					}
				}
				return true;
			}
		};
	
	

/**
* main program
* @param argc		number of arguments
* @param *argv[]	the arguments passed if any
*/
int main(int argc, char *argv[]){
	
	Lloyd ll;
	
	ll.read();
	
	
}
