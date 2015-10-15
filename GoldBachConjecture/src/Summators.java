import java.math.BigInteger;

import edu.rit.pj2.Vbl;

/**
 * Description: This class holds the max value and the result which is reduced to get the final values.
 * @author Sarvdeep Singh Bindra.
 *
 */
class Summators implements Vbl{

	//variable that stores max p value
	BigInteger max = BigInteger.ZERO;
	
	//variable that stores the number for which max p value is found
	BigInteger result = BigInteger.ZERO;
	@Override
	public void reduce(Vbl arg0) {
		Summators st = (Summators)arg0;
		//compare the max values of the threads and update the result if necessary
		if(st.max.compareTo(this.max)==1){
			this.max= st.max;
			this.result = st.result;
		}
		
		//if value of max is same for threads compare the number and update result is necessary
		if(st.max.compareTo(this.max)==0){
			if(st.result.compareTo(this.result)==1){
				this.result = st.result;
			}
		}
	}

	@Override
	//setting values of max and result
	public void set(Vbl arg0) {
		// TODO Auto-generated method stub
		Summators st = (Summators)arg0;
		
		this.max = st.max;
		this.result = st.result;
	}
	
	//returning the clone of the calling object
	public Object clone() {
		Summators s=null;
		try{
			s= (Summators) super.clone();
			s.max = this.max;
			s.result = this.result;
			return s;
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return s;
	}
	
}