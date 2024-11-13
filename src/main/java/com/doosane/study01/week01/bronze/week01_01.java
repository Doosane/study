package com.doosane.study01.week01.bronze;
import java.util.Scanner;

/* 두 수 비교  */
public class week01_01 {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     int A = sc.nextInt(); // 사용자가 입력하는  정수 A에 저장
     int B = sc.nextInt(); // 사용자가 입력하는  정수 B에 저장

     if(A > B) { // 조건 비교
         System.out.println(">");

     } else if (A < B) {
         System.out.println("<");

     } else {
         System.out.println("==");
     }

      sc.close(); // Scanner 닫기
    }

}
