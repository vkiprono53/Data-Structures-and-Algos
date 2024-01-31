package dsa.patterns;
import java.util.Scanner;
/**
 *
 *  Problem statement
 *
 * Sam is making a forest visualizer. An N-dimensional forest is represented by the pattern of size NxN filled with ‘*’.
 *
 * For every value of ‘N’, help sam to print the corresponding N-dimensional forest.
 * Example:
 *
 * Input: ‘N’ = 3
 *
 * Output:
 * * * *
 * * * *
 * * * *
 *
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints :
 *
 * 1  <= N <= 25
 * Time Limit: 1 sec
 *
 */
public class Pattern1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n to print: ");
        int n = input.nextInt();
        printPattern1(n);
    }
    public static void printPattern1(int n){
        for (int i = 0 ; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
