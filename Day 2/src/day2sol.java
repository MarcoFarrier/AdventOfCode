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
		System.out.println(getPaper(2,3,4));
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
}