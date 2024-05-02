import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Student student = new Student("Math", 123, 34, 65);
        System.out.println(student.getCourseName());
        System.out.println(student.getCredit());
        System.out.println(student.getExamScore());
        System.out.println(student.getAssignmentScore());
        System.out.println(student.equals(new Student()));
        Student st2 = new Student(student);
        System.out.println(student.equals(st2));
        System.out.println(student.calcFinalScore());
        System.out.println(student.isPassed());
        System.out.println(student.toString());
        */
        Lamborghini lam = new Lamborghini(99, 100, 100);
        printCar(lam);

    }

    public static boolean isPalindrome(String str) {
        if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
        if (str.length() > 2)
            return isPalindrome(str.substring(1, str.length() - 1));
        return true;
    }

    public static char toLetterScore(float score) {
        score = Math.min(score, 100);
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }

    public static float calcAverageScore(int scoreCount) {
        float total = 0;
        int averageCount = scoreCount;
        Random rand = new Random();
        for (int i = 0; i < scoreCount; i++) {
            int localScore = rand.nextInt(100);

            if (localScore < 40) {
                averageCount --;
                continue;
            }

            total += localScore;
            System.out.println(localScore);
        }
        if (averageCount == 0) return 0;
        return ((float) Math.round(total / averageCount * 100)) / 100;
    }

    //The parameter is defined as Car which is inherited by the class Lamborghini
    //Therefore it excepts any class that extends car. Since Lamborghini overloads the toString method of the car
    //The jvm doesn't call the toString method from the car's class but the Lamborghini's class since the object that
    //is passed is a Lamborghini. If the Lamborgini class did not overload the toString method, the jvm would
    //instead call the toString method belonging to the car class
    public static void printCar(Car car) {
        System.out.println(car.toString());
    }
}