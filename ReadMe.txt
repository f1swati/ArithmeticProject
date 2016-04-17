Brief Description of MathExprBuild.java module

1) src/(default package)
	-MathExprBuild.java	(Main Java file to compute the airthmentic expression)

2) Steps to run code
	i. compile the code from command line by using following command
	> javac MathExprBuild.java

	ii. To run the code
	>Java MathExprBuild <Target Integer> <Input Integer Array>
 	Example 
 	Java MathExprBuild 8 1 2 2 3 
 	8 = Target Integer
 	1 2 2 3 = Input Integer Array
 	((1+2)+2)+3 = 8 -> Output
 
	
3) Test Cases:
 To ensure that program performs in case of higher loads I have tested my case on multiple test cases:
 Test Case 1: [1, 2, 3, 4],    target = 3,    output: 4-((1+2)/3) = 3
 Test Case 2: [3, 3, 2, 8],    target = 2,    output: 8/((3+3)-2) = 2
 Test Case 3: [2, 1, 7],       target = 12,   output: (7-1)*2 = 12
 Test Case 4: [3, 5, 5, 3],    target = 1,    output: ((3+5)-5)/3 = 1
 Test Case 5: [5, 5, 5, 1],    target = 24,   output: none
 Test Case 6: [0, 0, 0, 0],    target = 0,    output: ((0+0)+0)+0 = 0
 Test Case 7: [],			     target = 1,    output: none
 Test Case 8: [],			     target =  ,    output: none
 Test Case 9: [0]              target = 0,    output: 0
 Test Case 10:[0]              target = 1,    output: none
 Test Case 11:[5, 4, 2, 3, 0], target = 0,    output: (((5+4)+2)+3)*0 = 0
 Test Case 12:[5, 5, 5, 4],    target = -121, output: 4-((5*5)*5) = -121
 Test Case 13:[-1, -1, -1, -1],target = 2,    output: -1-((-1+-1)+-1) = 2
 Test Case 14:[Hello, 1, 3],   target = 2     output: none
 Test Case 15:[1000, 10, 10085, -81, 1, 4],   target = 1000     output: ((10085+-81)-4)/(10*1) = 1000
	

ReadMe.txt
-Description of submitted files
