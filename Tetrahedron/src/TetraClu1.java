import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class TetraClu1 {
	
	static int count;
	static double minResult = 100000000;
	static double volume = 0;
	static double firstResult[] = new double[3];
	static double secondResult[] = new double[3];
	static double thirdResult[] = new double[3];
	static double fourthResult[] = new double[3];

	public static void main(String args[]) throws IOException {

		int index1 =-1, index2=-1, index3=-1,index4=-1;
		DecimalFormat seven = new DecimalFormat("#0.0000000");
		int counter;
		ArrayList<String> pointString = new ArrayList<String>();

		File input = new File("Points.txt");

		String read = "";
		FileReader fileRead = new FileReader(input);

		BufferedReader readInput = new BufferedReader(fileRead);

		read = readInput.readLine();

		while (read != null) {
			count++;
			pointString.add(read);
			read = readInput.readLine();

		}
		System.out.println("Total points are: " + count);

		double points[] = new double[3];
		/*
		 * for(int i=0;i<pointString.size();i++){
		 * System.out.println(pointString.get(i)); }
		 */

		/*
		 * String firstPoint[] = pointString.get(0).split(" "); double first[] =
		 * new double[3]; for(int i = 0; i<firstPoint.length;i++){
		 * 
		 * first[i] = Double.parseDouble(firstPoint[i]);
		 * System.out.println("at index)"+i+" (double value) "+first[i]); }
		 */
		for (int i = 0; i < pointString.size(); i++) {
			String f =pointString.get(i);
			String firstPoint[] = f.split(" ");
			double first[] = new double[3];
			for (counter = 0; counter < firstPoint.length; counter++) {
				first[counter] = Double.parseDouble(firstPoint[counter]);
			}
			counter = 0;
			for (int j = i + 1; j < pointString.size(); j++) {
				String s = pointString.get(j);
				String secondPoint[] = s.split(" ");
				double second[] = new double[3];
				for (counter = 0; counter < secondPoint.length; counter++) {
					second[counter] = Double.parseDouble(secondPoint[counter]);
				}
				counter = 0;
				for (int k = j + 1; k < pointString.size(); k++) {
					String t = pointString.get(k);
					String thirdPoint[] = t.split(" ");
					double third[] = new double[3];
					for (counter = 0; counter < thirdPoint.length; counter++) {
						third[counter] = Double
								.parseDouble(thirdPoint[counter]);
					}
					counter = 0;
					for (int m = k + 1; m < pointString.size(); m++) {
						String f4 = pointString.get(m);
						String fourthPoint[] = f4.split(" ");
						double fourth[] = new double[3];
						for (counter = 0; counter < fourthPoint.length; counter++) {
							fourth[counter] = Double
									.parseDouble(fourthPoint[counter]);
						}
						counter = 0;
						volume = computeVolume(first, second, third, fourth);
						if (volume < minResult) {
							minResult = volume;
							//firstResult = first;
							index1 = pointString.indexOf(f);
							//secondResult = second;
							index2 = pointString.indexOf(s);
							//thirdResult = third;
							index3 = pointString.indexOf(t);
							//fourthResult = fourth;
							index4 = pointString.indexOf(f4);
						}
					}
				}
			}
		}
		
		System.out.println("minimum volume is: "+seven.format(minResult));
		System.out.println(index1+" "+pointString.get(index1));
		System.out.println(index2+" "+pointString.get(index2));
		System.out.println(index3+" "+pointString.get(index3));
		System.out.println(index4+" "+pointString.get(index4));
	}

	public static double computeVolume(double first[], double[] second,
			double[] third, double fourth[]) {
		double result = 0;

		/*result = Math
				.abs(((first[0] * second[1] * third[2])
						- (first[0] * second[1] * fourth[2])
						- (first[0] * third[1] * second[2])
						+ (first[0] * third[1] * fourth[2])
						+ (first[0] * fourth[1] * second[2])
						- (first[0] * fourth[1] * third[2])
						- (second[0] * first[1] * third[2])
						+ (second[0] * first[1] * fourth[2])
						+ (second[0] * third[1] * first[2])
						- (second[0] * third[1] * fourth[2])
						- (second[0] * fourth[1] * first[2])
						+ (second[0] * fourth[1] * third[2])
						+ (third[0] * first[1] * second[2])
						- (third[0] * first[1] * fourth[2])
						- (third[0] * second[1] * first[2])
						+ (third[0] * second[1] * fourth[2])
						+ (third[0] * fourth[1] * first[2])
						- (third[0] * fourth[1] * second[2])
						- (fourth[0] * first[1] * second[2])
						+ (fourth[0] * first[1] * third[2])
						+ (fourth[0] * second[1] * first[2]) - (fourth[0]
						* second[1] * third[2])-(fourth[0]*third[1]*first[2])+(fourth[0]*third[1]*second[2])) / 6);*/
		result = Math
				.abs(((first[2] - second[2])
						* (third[0] * fourth[1] - fourth[0] * third[1])
						+ (third[2] - fourth[2])
						* (first[0] * second[1] - second[0] * first[1])
						+ (second[2] - fourth[2])
						* (third[0] * first[1] - first[0] * third[1])
						+ (second[2] - third[2])
						* (first[0] * fourth[1] - fourth[0] * first[1])
						+ (first[2] - fourth[2])
						* (second[0] * third[1] - third[0] * second[1]) 
						+ (first[2] - third[2])* (fourth[0] * second[1] - second[0]
								* fourth[1]))*0.1666666666);
		return result;
	}
}
