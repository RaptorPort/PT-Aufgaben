package PT_1;
import java.util.Scanner;

public class Gauss {
	
	/**
	 * The Programm takes user input for a NxN Matrix and a 1xN Matrix.
	 * Sorting and applying of Gauﬂ 
	 * The resulting X-Matrix is printed into the console. 
	 * <p>
	 * @author Nico Meiﬂen
	 * 
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Array Size N (NxN Array): ");
		int ArraySize = Integer.parseInt(scan.nextLine());
		double [][]A_Array = new double [ArraySize+1] [ArraySize];
		for (int k=0;k<(ArraySize+1);k++){
			for (int j=0;j<ArraySize;j++){
				if(k<ArraySize)
				{System.out.print("A_Array["+k+"]"+"["+j+"]=");}
				else
				{System.out.print("B_Array["+(k-ArraySize)+"]=");}
				A_Array[k][j]=(double) Integer.parseInt(scan.nextLine());
			}
		}
		//Actual Algorythm:
		int column=0;
		for(int x=0;x<ArraySize-1;x++,column++){
			A_Array = twoDimensionalArraySort(A_Array,ArraySize,column);
			A_Array = gaus_step(A_Array, column);
		}
		
		print_me_the_thing(A_Array);
		if(Validate(A_Array)){
		double[][]X_Array= Solve_for_x_Array(A_Array,0);
		for(int y=0;y<X_Array.length-1;y++){
			System.out.print(" "+X_Array[0][y]+"| ");
			System.out.print("\n");
		}
		}
		else
		System.out.print("Nope");
		scan.close();
	}
	
	/**
	 * Swaps two rows in an Array
	 * 
	 * @param Array 	Input Array
	 * @param biggestcolumn row that will be placed in the first column
	 * @param column Place ??
	 * @return a copy of the original array with the two rows swapped
	 */
	public static double[][] twoDimensionalArraySwap(double[][]Array, int biggestcolumn, int column){
		double [][]ray= new double [Array.length][Array.length-1];
		for(int x=0;x<Array.length;x++){
			for(int y=0;y<Array.length-1;y++){
				ray[x][y]=Array[x][y];
			}
		}
		for(int x =column; x<Array.length;x++){
			ray[x][column]=Array[x][biggestcolumn];
		
		}
		for(int x =column; x<Array.length;x++){
			ray[x][biggestcolumn]=Array[x][column];
		}
		return ray;
	}
	/**
	 * Returns an array where the row starting with the highest value is swapped into the first position.
	 * <p>
	 * Also works for other column by use of column
	 * 
	 * @param Array Input array
	 * @param ArraySize Size of the input array
	 * @param column Criteria for where to sort
	 * @return A sorted Array of equal size
	 */
	public static double[][] twoDimensionalArraySort(double[][]Array,int ArraySize, int column){
		double Max = Array[0][0];
		int BiggestColoumn=0;
		for(int k=0; k<ArraySize; k++){
			if(Array[column][k]>Max){
				BiggestColoumn=k;
			}
		}
		if(BiggestColoumn==0){
			return Array;}
		else{
			return twoDimensionalArraySwap(Array, BiggestColoumn, column);
			}
		
	}
	
	/**
	 * Takes an Array and a starting point and reduces one column to zeros starting in row = [column+1]
	 * 
	 * @param Array Input array
	 * @param column Start point
	 * @return The input array with a reduced column specified by column
	 */
	
	public static double[][] gaus_step(double [][]Array, int column){	
		column++;
		for(int coloumn=column;coloumn<Array.length-1;coloumn++){
			double conversion_number=Array[column-1][column-1]/Array[column-1][coloumn];
			for(int row=0; row<Array.length;row++){
				Array[row][coloumn] = Array[row][coloumn]*conversion_number;
				Array[row][coloumn] = Array[row][coloumn]-Array[row][column-1]; 		
			}
			
		}	
		return Array;
		
	}
	/**
	 * Prints the NxN+1 Array used
	 * @param Array Array to be output
	 */
	public static void print_me_the_thing(double [][]Array){
		for(int x=0;x<Array.length-1;x++){
			for(int y=0;y<Array.length;y++){
			System.out.print(" "+Array[y][x]+"| ");
			}
			System.out.print("\n");
		}
	}
	/**
	 * Checks if the input array has reduced form
	 *
	 * @param Array Input Array to be checked
	 * @return True or False
	 */
	public static boolean Validate(double [][]Array){
		for(int coloumn=0;coloumn<Array.length;coloumn++){
			for(int row=0; row<Array.length-1;row++){
				if((row>coloumn)&&(Array[coloumn][row]!=0)||((row<=coloumn)&&(Array[coloumn][row]==0)))		
					return false;
			}
			
		}	
		return true;
	}
	
	/**
	 * Takes a NxN Array that is in reduced form 
	 * and writes the X matrix on the first column of the input matrix 
	 * 
	 * 
	 * @param Array Input array in reduced form
	 * @return A NxN Array containing the Solution 
	 */
	public static double[][] Solve_for_x_Array(double [][]Array, int recursion_level){
		if((Array.length-2)>recursion_level){
			Array = Solve_for_x_Array(Array, recursion_level+1);
			}
		
		double temp = Array[Array.length-1][recursion_level]/Array[recursion_level][recursion_level];
		for(int x=recursion_level;x>=0;x--){
		Array[Array.length-1][x]=Array[Array.length-1][x]-(Array[recursion_level][x]*temp);
		Array[recursion_level][x] = 0.0;
		}
		Array[0][recursion_level]=temp;
		return Array;
	}
}
