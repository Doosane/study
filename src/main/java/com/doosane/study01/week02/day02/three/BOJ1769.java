package com.doosane.study01.week02.day02.three;

import java.io.*;

/*
  백준 문제 1769 3의 배수
  20164	224
 */
public class BOJ1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader로 ,InputStreamReader와 같이 사용해서, 문자열 입력받는다.
        String X = br.readLine(); // readLine()으로 읽어온다.
        sumPrint(X);
    }

    private static void sumPrint(String X) {
        int count = 0; // 반환 횟수 카운트
        while(X.length() > 1) {
            int sum = 0;    // sum 을 0으로 초기화
            for(int i = 0; i < X.length(); i++ ) { //  반복문
                // 이거 아스키 코드에서
                // 문자를 정수형으로 만들 수 있는 , 다 더해야 하니까
                sum += X.charAt(i) - '0'; // sum에 담고  '1' '0' - '0' = 1 + 0 = sum = > 1
            }
            X = Integer.toString(sum);  // sum에 담음 정수형 데이터를 X에 String으로 변환해서 담는다
            count++; // 변환 횟수 증가
        }
        printResult(X,count); // 출력 메소드 실행
    }

    private static void printResult(String X, int count) { // 출력 메소드
        int result = Integer.parseInt(X); // X값 Integer.parseInt로 타입 변환 해서  result에 담는다.
        if( result  % 3 == 0) // X%3 == 0 3으로 나눈 나머지 0 이면, 3의 배수
            System.out.println(count + "\n" + "YES");     // 3의 배수면 YES 출력
        else
            System.out.println(count + "\n" + "NO");   // 3의 배수가 아니면 NO 출력
    }
}