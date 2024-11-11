package com.doosane.lec.backjun.silver;
import java.util.Scanner;

public class numberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String numbers = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += numbers.charAt(i) - '0';
        }

        System.out.println(sum);

        scanner.close();
    }
}
