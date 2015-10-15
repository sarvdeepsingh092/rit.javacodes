/**
 * TetraVbl.java
 * 
 * Version 1.0
 */
import java.io.IOException;

import edu.rit.io.InStream;
import edu.rit.io.OutStream;
import edu.rit.pj2.Tuple;
import edu.rit.pj2.Vbl;

/**
 * Description: This class helps in reducing the results, cloning an object, sending data on the outstream and reading data from the instream
 * @author Sarvdeep Singh Bindra
 *
 */
public class TetraVbl extends Tuple implements Vbl{
	
	//variable to store the volume
	double volume;
	
	//variable to store the index of the first point
	int ind1;
	//variable to store the index of the second point
	int ind2;
	//variable to store the index of the third point
	int ind3;
	//variable to store the index of the fourth point
	int ind4;
	
	/**
	 * default constructor
	 */
	public TetraVbl(){
		
		//set the volume to max value
		volume = Double.MAX_VALUE;
	}
	
	/**
	 * method to clone an object
	 */
	public Object clone() {
		TetraVbl s=null;
		s= (TetraVbl) super.clone();
		return s;
	}

	@Override
	/**
	 * Method to reduce the results
	 * @param vbl		object with whom the values are the to be compared
	 */
	public void reduce(Vbl vbl) {
		TetraVbl tVbl = (TetraVbl) vbl;
		
		//compare the volume and update the values if necessary
		if(this.volume > tVbl.volume){
			this.volume = tVbl.volume;
			this.ind1 = tVbl.ind1;
			this.ind2 = tVbl.ind2;
			this.ind3 = tVbl.ind3;
			this.ind4 = tVbl.ind4;
		}
		
	}
	
	/**
	 * Method to compare the volume computed by two tasks
	 * @param vol			Volume
	 * @param index		index of the first point
	 * @param ind1			index of the second point
	 * @param ind2			index of the third point
	 * @param ind3			index of the fourth point
	 */
	public void compare(double vol , int index, int ind1, int ind2, int ind3){
		
		//compare the volume and update the values of necessary
		if(this.volume > vol){
			this.volume = vol;
			this.ind1 = index;
			this.ind2 = ind1;
			this.ind3 = ind2;
			this.ind4 = ind3;
		}
	}
	
	@Override
	/**
	 * Method to set the values
	 * @param vbl		Object from whom the values should be copied
	 */
	public void set(Vbl vbl) {
		TetraVbl tVbl = (TetraVbl) vbl;
		this.volume = tVbl.volume;
		this.ind1 = tVbl.ind1;
		this.ind2 = tVbl.ind2;
		this.ind3 = tVbl.ind3;
		this.ind4 = tVbl.ind4;
		
	}

	@Override
	/**
	 * Method to read the stream of bytes from the tuple space 
	 * @param in				InStream
	 */
	public void readIn(InStream in) throws IOException {
		this.volume = in.readDouble();
		this.ind1 = in.readInt();
		this.ind2 = in.readInt();
		this.ind3 = in.readInt();
		this.ind4 = in.readInt();
		
	}

	@Override
	/**
	 * Method to write the byte stream to the tuple space
	 * @param out		OutStream
	 */
	public void writeOut(OutStream out) throws IOException {
		out.writeDouble(volume);
		out.writeInt(ind1);
		out.writeInt(ind2);
		out.writeInt(ind3);
		out.writeInt(ind4);
	}

}
