package com.doosane.study01.week02.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
  백준 문제 1769 3의 배수
 */
public class pairProgramming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 입력 - 그냥 스트링으로 받는다.

        String X = br.readLine(); // 문자열 입력 받았음 1234567
        int count = 0;

        while(X.length() > 1) {
            // sum 을 0으로 초기화
            int sum = 0;
            //  반복문 무조건
            for(int i = 0; i < X.length(); i++ ) {
                // 이거 아스키 코드에서
                // 문자를 정수형으로 만들 수 있는 , 다 더해야 하니까
                sum += X.charAt(i) - '0'; // sum에 담았음  '1' '0' - '0' = 1 + 0 = sum = > 1
            }
            X = String.valueOf(sum);
            count++; // 1 ->  2  -> 3
        }

        // 출력
        // 3의 배수 ->
        if(X.equals("3") || X.equals("6") || X.equals("9")) {
            System.out.println(count);
            // 3의 배수 -> "YES" 출력
            System.out.println("YES");

        } else {
            System.out.println(count);
            // 3의 배수 -> "NO" 출력
            System.out.println("NO");
        }
    }
}