package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentScores = new ArrayList<>();
        ArrayList<String> studentLetterGrades = new ArrayList<>();
        Scanner userIn = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = userIn.nextInt();
        userIn.nextLine(); //Note: to consume /n
        int ATotal=0,BTotal=0, CTotal=0, DTotal=0, FTotal=0;
        double avgCalc;

        for (int i = 0; i <= (numStudents-1) ; i++) {
            System.out.print("Enter name of student "+(i+1)+": ");
            String studentName = userIn.nextLine();
            studentNames.add(studentName);
            System.out.print("Enter score for "+studentName+": ");
            int studentScore = userIn.nextInt();
            userIn.nextLine();
            studentScores.add(studentScore);
            String studentLetterGrade="";
            if(studentScore<=100 && studentScore>=90){
                studentLetterGrade = "A";
                ATotal=ATotal+1;
            } else if (studentScore<=89 && studentScore>=80) {
                studentLetterGrade = "B";
                BTotal=BTotal+1;

            } else if (studentScore<=79 && studentScore>=70) {
                studentLetterGrade = "C";
                CTotal=CTotal+1;
            }
            else if (studentScore<=69 && studentScore>=60) {
                studentLetterGrade = "D";
                DTotal=DTotal+1;

            }else if (studentScore<60) {
                studentLetterGrade = "F";
                FTotal=FTotal+1;
            }

            studentLetterGrades.add(studentLetterGrade);
            System.out.println(studentName+" got grade "+studentLetterGrade+": ");

        }
        System.out.print("\n");
        System.out.println("----- Class Summary -----");
        System.out.println("Average Score: ");
        System.out.println("Grade Counts: ");
        System.out.println("Grades "+studentLetterGrades.toString());
        System.out.println(studentNames.toString());
        System.out.println(studentScores.toString());

        // Note, write function to get top students
    }
}
