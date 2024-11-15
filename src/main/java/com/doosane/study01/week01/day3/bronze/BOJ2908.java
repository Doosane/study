package com.doosane.study01.week01.day3.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

문제 분석:
- 첫째 줄에 상근이가 적은 A와 B가 주어지면, 각각의 숫자를 거꾸로 하여 크기 비교한 후 큰 숫자를 출력한다.

제약 조건:
- 두 수는 같지 않은 세자리 수이며, 0이 포함되어 있지 않다.

의사 결정:
- 상근이가 적은 A와 B를 BufferedReader로 입력받아서
- A와 B를 각각 거꾸로 뒤집고
- 크기 비교하여 큰 수를 출력한다.

 */

public class BOJ2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader, InputStreamReader 로 입력 받으면 메모리 사용 효율이 좋다.

        String[] input = br.readLine().split(" "); // 입력 값을 공백으로 구분하여 두 개의 문자열로 분리한다.

        br.close(); // 입력 작업 완료후  BufferedReader 닫음

        // reverseNumber 메소드를 이용해서 문자열을 뒤집는다.
        int A = reverseNumber(input[0]); //  인덱스 0 -> 첫번째 숫자 문자열
        int B = reverseNumber(input[1]); //  인덱스 1 -> 두번째 숫자 문자열

        printLargerNumber(A, B); // printLargerNumber 메소드 실행
    }

    // 문자열 숫자를 뒤집어 저장
    static int reverseNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        // StringBuilder 를 사용하여 문자열을 뒤집고
        return Integer.parseInt(sb.reverse().toString());
        // 뒤집어진 문자열을 정수로 변환해서 반환한다.
    }

    static void printLargerNumber(int A, int B) {
        // Math.max 사용해서 A, B 중에서 큰 숫자를 출력
        System.out.println(Math.max(A, B));
    }

}

/*
메모리 14156 KB
시간 104 ms
 */