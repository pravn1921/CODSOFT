import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Student Grade Calculator");
		System.out.println("Enter the number of subjects: ");
		// input for number of subjects
		int n = sc.nextInt();
		int totalMarksObtained = 0;
		
		// getting marks for n number of subjects
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Marks for Subject " + (i + 1) + ":");
			int marks = sc.nextInt();
			// calculating total marks by adding the inputs
			totalMarksObtained += marks; 
		}

		// calculating marks percentage
		double percentage = (double) totalMarksObtained / (n * 100) * 100;
		System.out.println();
		// Displaying the total marks obtained and percentage
		System.out.println("Total Marks :"+totalMarksObtained);
		System.out.println("Average Percentage : "+String.format("%.2f", percentage)+"%");
		 
		// condition to determine the grade, result and display it
		if(percentage<100 && percentage>90) {
			System.out.println("Result: Pass");
			System.out.println("Grade: A");
		}else if(percentage<89.99 && percentage>80) {
			System.out.println("Result: Pass");
			System.out.println("Grade: B");
		}else if(percentage<79.99 && percentage>70) {
			System.out.println("Result: Pass");
			System.out.println("Grade: C");
		}else if(percentage<69.99 && percentage>60) {
			System.out.println("Result: Pass");
			System.out.println("Grade: D");
		}else if(percentage<59.99 && percentage>50) {
			System.out.println("Result: Pass");
			System.out.println("Grade: E");
		}else {
			System.out.println("Result: Fail");
			System.out.println("Work Hard...");
		}	
	}
}
