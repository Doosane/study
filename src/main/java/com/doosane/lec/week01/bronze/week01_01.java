package com.doosane.lec.week01.bronze;
import java.util.Scanner;

public class week01_01 {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int A = sc.nextInt();
     int B = sc.nextInt();

     if(A > B) {
         System.out.println(">");
     } else if (A < B) {
         System.out.println("<");
     } else {
         System.out.println("==");
     }

      sc.close();
    }

}
