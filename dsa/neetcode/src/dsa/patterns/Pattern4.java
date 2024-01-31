package dsa.patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = input.nextInt();
        pattern4(n);
    }

    public static void pattern4(int n){
        for (int i = 1; i <=n ; i++){
            for (int j = 1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
