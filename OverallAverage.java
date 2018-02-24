
/****************************************************************************
*
* Created by: Heejo Suh
* Created on: Feb 2018
* Created for: learning
* 
* Marks for a class are saved in a 2D array:
* One dimension for the student, the other for the assignment.
* This is a program that populates a 4x6 array (4 students, 6 assignments) with 
* random numbers from 0 to 100.
* A function will accept the array and pass back the classes overall average.
*     
*
****************************************************************************/


//have to import the following:
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//****************************************************************************
public class OverallAverage {

	//----------------------------------------- 
	private static void getAverage(double[][] inputArray) {
		//This method calculates the average and returns it.
		
		double classTotal = 0, studentAverage = 0;
		
		for(int student = 0; student<inputArray.length; student++) {
		//for number of students, do	
			studentAverage = Arrays.stream(inputArray[student]).average().getAsDouble();
			classTotal += studentAverage;
			System.out.print("Student " + (student+1) + " average : " + String.format("%.4g%n", studentAverage)); //rounds it up to 2 decimal places
		}
		String classAverage = String.format("%.4g%n", (classTotal/inputArray.length));
		System.out.println("\nClass average : " + classAverage);
	}
	
	//-----------------------------------------    
	public static void main(String[] args) {
	//Generate array of students and marks then return average

		Random rand = new Random();
		
		
		// Generates 4 x 6 array
		double[][] wholeClass = new double[4][6];
		
		//for variable x : name
		//let student = first arrays inside class array
		for(double[] student: wholeClass) {
			//for each student (first array) do 
			for(int assignment=0; assignment<student.length; assignment++) {
				student[assignment] = rand.nextInt(100) + 1;
			}
		}

		//print whole class marks
		System.out.println("Class marks : ");
		System.out.print(Arrays.deepToString(wholeClass).replace(".0" , "").replace("]," , "]").replace("]" , "\n").replace("[[" , "[").replace("[", "Student mark: "));
		
		//get average
		getAverage(wholeClass);
	}
}
			
