import java.math.BigInteger;

import edu.rit.pj2.*;

/**
 * Description: Class GoldbachSmp follows the Goldbach Conjecture and finds the prime summators
 * of even numbers within a given range
 * The program runs in parallel on multiple cores.
 * @author Sarvdeep Singh Bindra
 *
 */
public class GoldbachSmp extends Task {

	//lower bound
	BigInteger lower;
	
	//upper bound
	BigInteger upper;
	
	//parent object of Summators 
	Summators sum = new Summators();
	
	/**
	 * Main Program
	 * Takes in the command line inputs, checks for errors and follows Goldbach Conjecture
	 * to find prime summators
	 * @param args 			Command Line Arguments
	 */
	public void main(String[] args) throws Exception {
		
		//check if arguments are given
				if(args.length<2){
					System.out.println("enter both lower bound and upper bound");
				}
				//check if proper number of arguments are given
				if(args.length<1){
					System.out.println("Please enter the lower and upper bound arguments");
				}
				
				//check if the format of the argument is appropriate
				for(int i=0;i<args.length;i++){
					String input = args[i];
					for(int j=0;j<input.length();j++){
						if(Character.isLetter(input.charAt(j))){
							System.out.println("please enter numbers");
						}
					}
				}
				
				
				lower = new BigInteger(args[0]);
				upper = new BigInteger(args[1]);
				
				//check if the lower and upper bounds are even
				if((lower.mod(new BigInteger("2")).equals(BigInteger.ZERO))&& (upper.mod(new BigInteger("2")).equals(BigInteger.ZERO))){
				
				if(lower.compareTo(new BigInteger("2"))==1&&lower.compareTo(upper)==-1){
				//call the method to compute the summators
				String output = computeResult();
				//print the output
				System.out.println(output);
				}
				else{
					System.out.println("Lower Bound should be greater than 2 and Lower Bound should be less than upper Bound");
				}
			}
				//if lower or upper bound are not even then print message
				else{
					System.out.println("Lower bound and upper bound should be even");
				}
		
	}
	
	/**
	 * Method to compute the prime summators of even numbers within a given range
	 * @return				The resulting number with p and q values
	 */
	public String computeResult(){	
		
		//calculate the range of the values given which is integer
		int difference = (upper.subtract(lower)).intValue();
		
		//run the loop from lower bound to upper bound inclusive
		parallelFor(0,difference/2).schedule(proportional).exec(new Loop(){

			//clone object for the individual threads
			Summators s;
			
			
			public void start(){
			//getting the clone of the parent object
			s = threadLocal(sum);
			}
			public void run(int number) throws Exception {
				
				Summators sum1 = new Summators();
				//get the appropriate even number to compute its summators
				BigInteger input = lower.add(BigInteger.valueOf(number).multiply(new BigInteger("2")));
				
				//if even continue
				if(input.mod(new BigInteger("2")).equals(BigInteger.ZERO)){

					//this is the p value of an even number
				    BigInteger pValue;
					
					//q value of an even number
					BigInteger qValue;
					
					//initialize p value to one
					pValue = BigInteger.ONE;
					//find corresponding q value
					qValue = input.subtract(pValue);
					
					//till q is not prime run the loop
					while(!qValue.isProbablePrime(100)){
						//find the next prime p value
						pValue=pValue.nextProbablePrime();
						
						//find the corresponding q value
						qValue = input.subtract(pValue);
					}
					
					sum1.max=pValue;
					sum1.result = input;
					
					//reduce the max and the result value
					s.reduce((Vbl)sum1);
				}		
		}
		});
		//return the complete result with number, p value and q value.
		return(sum.result+" = "+sum.max+" + "+(sum.result.subtract(sum.max)));
	}
}

