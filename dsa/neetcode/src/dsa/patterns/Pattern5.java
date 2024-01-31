package dsa.patterns;

import java.util.Scanner;

/**
 * Pattern-5: Inverted Right Pyramid
 *
 * Problem Statement: Given an integer N, print the following pattern :
 *
 * Input Format: N = 3
 * Result:
 * * * *
 * * *
 * *
 */
public class Pattern5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = input.nextInt();
        pattern5(n);

    }

    public static void pattern5(int n){
        for (int i = 0; i < n; i++){
            for (int j = i; j<n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
