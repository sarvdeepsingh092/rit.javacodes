#include<iostream>
#include<vector>
#include<queue>
#include<map>

using namespace std;

template <class T>
class solver{
	public:
		
		
		//the queue to hold the configurations
		queue<T> configuration_queue;
		
		//the map to check for repeated configurations
		map<T,T> visited;
		
		//the vector to store the seen configurations.
		vector<T> seen_queue;
		
		
};
