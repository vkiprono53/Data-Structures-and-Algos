package dsa.patterns;

import java.util.Scanner;

/**
 * Pattern – 3: Right-Angled Number Pyramid
 *
 * Problem Statement: Given an integer N, print the following pattern :
 * Input Format: N = 3
 * Result:
 * 1
 * 1 2
 * 1 2 3
 */
public class Pattern3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n : " );
        int n = input.nextInt();
        pattern3(n);
    }
    public static void pattern3(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
