//Name : Patel Raj Mahendrakumar
//ID   : N03555681
//Subject: Programming and Data Structure
//Assignment 1
//precondition : Enter integer value between 0 to 100 and insert negative integer value as end of input.
	
import java.util.Scanner;

public class ScoreConvertor{
	
	public static void main(String[] args){
		int gradeA=0,gradeB=0,gradeC=0,gradeD=0,gradeF=0,gradeTotal=0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your exam scores in range of 0 to 100:");
	  
		while(true){
		
		int score = input.nextInt();
		if(score>=0 && score<=100){
			if(score>=90){
				gradeA++;
			}
			else if(score>=80 && score<=89){
				gradeB++;
			}
			else if(score>=70 && score<=79){
				gradeC++;
			}
			else if(score>=60 && score<=69){
				gradeD++;
			}
			else if(score<=59){
				gradeF++;
			}
			
		}

		else if (score > 100){
			System.out.println("Invalid Value");
			break;
		}

		else{
		
			gradeTotal=gradeA+gradeB+gradeC+gradeD+gradeF;
		
			System.out.println("Total number of grades = "+gradeTotal);
			System.out.println("Number of A's = "+gradeA);
			System.out.println("Number of B's = "+gradeB);
			System.out.println("Number of C's = "+gradeC);
			System.out.println("Number of D's = "+gradeD);
			System.out.println("Number of F's = "+gradeF);
			break;
		}
		}
	}
}