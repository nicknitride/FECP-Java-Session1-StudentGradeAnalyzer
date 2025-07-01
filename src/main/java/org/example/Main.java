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
        double avgNumerator = 0,finalAverage = 0;

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
            avgNumerator = avgNumerator + studentScore;
            studentLetterGrades.add(studentLetterGrade);
            System.out.println(studentName+" got grade : "+studentLetterGrade);
            if(i==(numStudents-1)){
                finalAverage = (int)(avgNumerator/(numStudents));
            }
        }

        /*
        * Get max grade and see if there are multiple students
         */
        double maxScore = 0;
        for (int i = 0; i <= (studentScores.size() - 1) ; i++) {
            if (studentScores.get(i)>=maxScore){
                maxScore = studentScores.get(i);
            }
        }

        // Get students with matching scores
        ArrayList<Integer> matchingIndices = new ArrayList<>();
        for (int i = 0; i <= (studentScores.size() - 1); i++) {
            if (studentScores.get(i)==maxScore){
                matchingIndices.add(i);
            }
        }

        System.out.print("\n");
        System.out.println("----- Class Summary -----");
        System.out.println("Average Score: "+finalAverage);
        System.out.printf("Grade Counts: A:%d B:%d C:%d D:%d F:%d \n",ATotal, BTotal, CTotal, DTotal, FTotal);

        // Build string of top students
        String topStudentString = "";
        for (int i = 0; i <= (matchingIndices.size() - 1); i++) {
            String topStudentName = studentNames.get(matchingIndices.get(i));
            String topStudentScore = studentScores.get(matchingIndices.get(i)).toString();
            topStudentString = String.format("%s %s (%s)",topStudentString,topStudentName,topStudentScore);
        }

        System.out.println("Top Student(s): "+topStudentString);
        System.out.println("\n\nGrades "+studentLetterGrades.toString());
        System.out.println(studentNames.toString());
        System.out.println(studentScores.toString());
        System.out.printf("Max score :%.2f%n\n",maxScore);
        System.out.println(matchingIndices.toString());
    }
}
