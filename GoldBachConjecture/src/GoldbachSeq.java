import java.math.BigInteger;
import edu.rit.pj2.*;

/**
 * Description: Class GoldBachSeq finds the prime summators of even numbers between a given range
 * @author Sarvdeep Singh Bindra
 * 
 *
 */
public class GoldbachSeq extends Task {

	/**
	 * Main Program
	 */
	public void main(String args[]){
		
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
		
		
		BigInteger lowerBound = new BigInteger(args[0]);
		BigInteger upperBound = new BigInteger(args[1]);
		
		//check if the lower and upper bounds are even
		if((lowerBound.mod(new BigInteger("2")).equals(BigInteger.ZERO))&& (upperBound.mod(new BigInteger("2")).equals(BigInteger.ZERO))){
		
		if(lowerBound.compareTo(new BigInteger("2"))==1&&lowerBound.compareTo(upperBound)==-1){
		//call the method to compute the summators
		String output = computeResult(lowerBound, upperBound);
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
	 * @param lb			The lower bound
	 * @param ub			The upper bound
	 * @return				The result with p and q values
	 */
	public String computeResult(BigInteger lb, BigInteger ub){
		
		//this is the p value of an even number
		BigInteger pValue;
		
		//q value of an even number
		BigInteger qValue = BigInteger.valueOf(Integer.MIN_VALUE);
		
		//variable to store the max p value
		BigInteger max = BigInteger.ZERO;
		
		//variable to store the result number
		BigInteger result = BigInteger.ZERO;
		
		
		//run the loop from lower bound to upper bound inclusive
		for(BigInteger i =lb;i.compareTo(ub)==-1||i.compareTo(ub)==0;i=i.add(BigInteger.ONE)){
			
			//if the number is even
			if(i.mod(new BigInteger("2")).equals(BigInteger.ZERO)){
				//initialize p value to one for each even integer
				pValue = BigInteger.ONE;
				
				//find the q value with p=1
				qValue = i.subtract(pValue);
				
				//till q is not prime run the loop
				while(!qValue.isProbablePrime(100)){
					//find the next prime p value
					pValue=pValue.nextProbablePrime();
					
					//find the corresponding q value
					qValue = i.subtract(pValue);
				}
				
				//if p is greater than max and q is not less than 0 then update max and result
				if(pValue.compareTo(max)==1&& !(i.subtract(pValue).compareTo(BigInteger.ZERO)==-1)){
					max = pValue;
					result = i;
				}
				
				//if p value is same as max then compare the two integers and update the result if necessary
				if(pValue.compareTo(max)==0){
					if(i.compareTo(result)==1){
						result = i;
					}
				}
				//find the final q value
				qValue = result.subtract(max);
			}
		}
		//return the complete result with number, p value and q value.
		return(result+" = "+max+" + "+qValue);
	}
}

