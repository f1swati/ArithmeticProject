/* This Program was developed by Swati Mittal. 
 * Date - 16-April-2016
 * 
 * Objective:  
 * Objective of the program is to build the arithmetical expression by using four arithmetic operands
 * "+", "-", "*" and "/" for a given input array of integers and the desired target integer. 
 * Program should able to generate the arithmetical expression by using different permutations
 * of operands and integers in the input array to produce target integer. In case that any operation
 * given the input integers and operands cannot produce target then "none" should be returned to
 * signify that expression not possible.
 * 
 * Input Format on command line:
 * Java MathExprBuild <Target Integer> <Input Integer Array>
 * Example 
 * Java MathExprBuild 8 1 2 2 3 
 * 8 = Target Integer
 * 1 2 2 3 = Input Integer Array
 * ((1+2)+2)+3 = 8 -> Output
 * 
 * Constraints:
 * One integer from input array can be used only once
 * Operands can be used multiple times and 9it is not necessary to use all operands
 * Maximum input integer array length is 5 (However, program is designed to handle 
 * higher lengths as well)
 * 
 * Solution:
 * I have used recursive calling to achieve the objective. I have broken down the problem to 
 * performing different arithmetic operation between two numbers and calling the function repeatedly. 
 * I use string to store the arithmetic operation to understand what operations have been performed 
 * till now. The program ends when the target integer is calculated using all the input integers 
 * or if the target integer is not achievable using all permutations of operations.
 * 
 * Test Cases:
 * To ensure that program performs in case of higher loads I have tested my case on multiple test cases:
 * Test Case 1: [1, 2, 3, 4],    target = 3,    output: 4-((1+2)/3) = 3
 * Test Case 2: [3, 3, 2, 8],    target = 2,    output: 8/((3+3)-2) = 2
 * Test Case 3: [2, 1, 7],       target = 12,   output: (7-1)*2 = 12
 * Test Case 4: [3, 5, 5, 3],    target = 1,    output: ((3+5)-5)/3 = 1
 * Test Case 5: [5, 5, 5, 1],    target = 24,   output: none
 * Test Case 6: [0, 0, 0, 0],    target = 0,    output: ((0+0)+0)+0 = 0
 * Test Case 7: [],			     target = 1,    output: none
 * Test Case 8: [],			     target =  ,    output: none
 * Test Case 9: [0]              target = 0,    output: 0
 * Test Case 10:[0]              target = 1,    output: none
 * Test Case 11:[5, 4, 2, 3, 0], target = 0,    output: (((5+4)+2)+3)*0 = 0
 * Test Case 12:[5, 5, 5, 4],    target = -121, output: 4-((5*5)*5) = -121
 * Test Case 13:[-1, -1, -1, -1],target = 2,    output: -1-((-1+-1)+-1) = 2
 * Test Case 14:[Hello, 1, 3],   target = 2     output: none
 * Test Case 15:[1000, 10, 10085, -81, 1, 4],   target = 1000     output: ((10085+-81)-4)/(10*1) = 1000
 */

import java.util.LinkedList;

public class MathExprBuild {

	public static void main(String[] args) {

		String result;
		//Check for no-input
		if(args.length == 0){
		result = "none";
		}else {
		//Function to build arithmetic expression
		result = expressionBuild(args);
		if (result == null) {
			result = "none";
		}
		}
		System.out.println(result);
	}

	/*
	 * The input received from the command line is in the array of string. Therefore this method 
	 * is used to take the input as an array of string and convert the string into an integer array 
	 * for calculation purposes. I have used linked list for faster performance as adding and 
	 * deletion operations at the end is of order O[1]. I have used two linked list one to store
	 * integers for calculation and one to store the expression as a string. 
	 * 
	 */
	public static String expressionBuild(String[] input) {

		LinkedList<Integer> listOfInteger = new LinkedList<Integer>();
		LinkedList<String> expression = new LinkedList<String>();
		int target = 0;
		try{
		target = Integer.parseInt(input[0]);
				
		
		for (int i = 1; i < input.length; i++) {
			expression.add(input[i]);
			int x = Integer.parseInt(input[i]);
			listOfInteger.add(x);
		}
		
		//Check for wrong input type like characters
		}catch(NumberFormatException e){
			//System.out.println("Bad Input");
		}
		
		return expressionBuild(listOfInteger, expression, target);
		
	}

	/* Recursive function to perform the arithmetic operation on the array of integer to get the 
	 * target number. If target number found it will return the expression else it will return null.
	 * The function performs arithmetic operation of either "+", "-", "*" or "/" on two input 
	 * integers at a time and keeps on recursively for different permutations till all the input
	 * integer variables are completed and target integer is achieved or all arithmetic operations 
	 * are exhausted with all the input variables and target integer can not be achieved.   
	 */
	private static String expressionBuild(LinkedList<Integer> listOfInteger, LinkedList<String> expression,
			int target) {
		//Exit the recursive loop only when all the inputs are exhausted
		if (listOfInteger.size() == 1) {                  
			// Base case condition to exit from the recursive call when target is achieved
			if (listOfInteger.get(0) == target)			
				return (expression.get(0) + " = " + target);
			// Base case condition to exit when all options are exhausted and target is not achieved
			else
				return null;
		}

		// Iterate on every number from set of input integers using the linked list  
			for (int i = 0; i < listOfInteger.size(); i++) {
			
				for (int j = i + 1; j < listOfInteger.size(); j++) {
								
				int x = listOfInteger.get(i);
				int y = listOfInteger.get(j);
				String xe = expression.get(i);
				String ye = expression.get(j);
				
				/* Selects the first 2 inputs from the input linked list and calls the function to 
				 * perform 6 arithmetic operations of : 
				 * "x + y", "x - y", "y - x", "x * y", "x / y" and "y / x"
				 */ 
				for (int k = 0; k < 6; k++) {
					// Copy of the integer list
					LinkedList<Integer> listOfIntegerNew = new LinkedList<Integer>();
					LinkedList<String> expressionNew = new LinkedList<String>();

					// Copy the Integer List in to new List of Integer
					for (Integer a : listOfInteger) {
						listOfIntegerNew.addLast(a);
					}

					// Remove the numbers on which operation are currently in process
					listOfIntegerNew.remove(j);
					listOfIntegerNew.remove(i);
					
					
					//Copy the list of expression in to new List of operation
					for (String s : expression) {
						expressionNew.addLast(s);
					}
					
					//Remove the expression which are currently in use
					expressionNew.remove(j);
					expressionNew.remove(i);

					// Boundary condition to check the divide by zero
					if (k == 4 && (y == 0 || x % y != 0))
						continue;
					if (k == 5 && (x == 0 || y % x != 0))
						continue;

					// Perform the arithmetic operation on the bases of value of k
					int res = calculate(x, y, k);
					listOfIntegerNew.addFirst(res);

					// Build the expression 
					String e = resultExpression(xe, ye, k);
					expressionNew.addFirst(e);
					
					String ans = expressionBuild(listOfIntegerNew, expressionNew, target);
					if (ans != null)
						return ans;
				}
			}
		}
		return null;
	}

	/*  This method performs the arithmetic expression on the number
	 */
	private static int calculate(int x, int y, int k) {
		switch (k) {
		case 0:
			return x + y;
		case 1:
			return x - y;
		case 2:
			return y - x;
		case 3:
			return x * y;
		case 4:
			return x / y;
		}
		return y / x;
	}

	/*  This method build the expression on the basis of the arithmetic operation performed 
	 * in the previous function
	 */
	private static String resultExpression(String xe, String ye, int k) {
		if (xe.matches(".+[-+*/].+"))
			xe = "(" + xe + ")";
		if (ye.matches(".+[-+*/].+"))
			ye = "(" + ye + ")";

		switch (k) {
		case 0:
			return xe + "+" + ye;
		case 1:
			return xe + "-" + ye;
		case 2:
			return ye + "-" + xe;
		case 3:
			return xe + "*" + ye;
		case 4:
			return xe + "/" + ye;
		}
		return ye + "/" + xe;

	}
}
