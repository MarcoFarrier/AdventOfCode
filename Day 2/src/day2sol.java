/* package whatever; // don't place package name! */

import java.util.*;
import java.util.Arrays;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class day2sol
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		String line = br.readLine();
		double totalPaper = 0;
		double totalRibbon = 0;
		
		while(line != null)
		{
			String[] data = line.split("x");
			Double[] dataDouble = new Double[3];
			for(int i = 0; i < 3; i++)
			{
				dataDouble[i] = Double.parseDouble(data[i]);
			}
			
			totalPaper += getPaper(dataDouble[0], dataDouble[1], dataDouble[2]);
			totalRibbon += getRibbon(dataDouble[0], dataDouble[1], dataDouble[2]);
			line = br.readLine();
		}
		
		br.close();
		System.out.println(totalPaper);
		System.out.println(totalRibbon);
	}
	
	static double getPaper(double l, double w, double h)
	{
		double side1 = l*w;
		double side2 = w*h;
		double side3 = l*h;
		
		double[] sides = {side1, side2, side3};		
		Arrays.sort(sides);
		
		double slack = sides[0];
		
		double presentSize = 2 * (side1 + side2 + side3);
		
		return presentSize + slack;
	}
	
	static double getRibbon(double l, double w, double h)
	{
		double[] lengths = {l, w, h};
		Arrays.sort(lengths); //sorted lowest to highest
		
		//"The ribbon required to wrap a present is the 
		//shortest distance around its sides, or 
		//the smallest perimeter of any one face."
		double perimeter = 2 * (lengths[0] + lengths[1]);
		
		//"Each present also requires a bow made out of ribbon as well
		//the feet of ribbon required for the perfect bow is equal 
		//to the cubic feet of volume of the present."
		double volume = l * w * h;
		
		return volume + perimeter;
	}
}