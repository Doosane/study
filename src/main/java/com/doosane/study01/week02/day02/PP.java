package com.doosane.study01.week02.day02;

import java.io.*;

/*
  백준 문제 1769 3의 배수
  20164	224
 */
public class PP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 입력 - 그냥 스트링으로 받는다.
        String X = br.readLine(); // 문자열 입력 받았음 1234567
        sumPrint(X);
    }

    private static void sumPrint(String X) {
        int count = 0;
        while(X.length() > 1) {
            // sum 을 0으로 초기화
            int sum = 0;
            //  반복문
            for(int i = 0; i < X.length(); i++ ) {
                // 이거 아스키 코드에서
                // 문자를 정수형으로 만들 수 있는 , 다 더해야 하니까
                sum += X.charAt(i) - '0'; // sum에 담았음  '1' '0' - '0' = 1 + 0 = sum = > 1
            }
            // sum에 담음 정수형 데이터를 X에 String으로 변환해서 담는다
            X = Integer.toString(sum);
            count++; // 1 ->  2  -> 3
        }
        printResult(X,count);
    }

    private static void printResult(String X, int count) {
        // 출력
        // 3의 배수 ->
        int result = Integer.parseInt(X);
        // X%3 == 0
        if( result  % 3 == 0)
            System.out.println(count + "\n" + "YES");
        else
            System.out.println(count + "\n" + "NO");
    }
}