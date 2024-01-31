package dsa.patterns;

import java.util.Scanner;

/**
 * Pattern – 6: Inverted Numbered Right Pyramid
 *
 * Problem Statement: Given an integer N, print the following pattern :
 * Input Format: N = 3
 * Result:
 * 1 2 3
 * 1 2
 * 1
 */
public class Pattern6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = input.nextInt();
        pattern6(n);

    }
    public static void pattern6(int n){
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
