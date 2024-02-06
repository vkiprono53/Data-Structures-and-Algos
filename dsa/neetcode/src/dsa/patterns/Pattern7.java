package dsa.patterns;

import java.util.Scanner;

/**
 * Given an integer N, print the following pattern :
 *
 *
 * Input Format: N = 3
 * Result:
 *   *
 *  ***
 * *****
 */
public class Pattern7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = input.nextInt();
        pattern7(n);
    }

    public static void pattern7(int n){
        //Outer Loop
        for (int i = 0 ; i < n; i++){

            for (int j = 0; j < n - i - 1; j++ ){
                System.out.print("-");
            }

            for (int k = 0 ; k < (i * 2) + 1 ; k++){
                System.out.print("*");
            }

            for (int l = 0; l < n - i - 1; l++ ){
                System.out.print("-");
            }

            System.out.println();
        }
    }
}
