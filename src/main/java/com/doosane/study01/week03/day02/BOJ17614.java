package com.doosane.study01.week03.day02;

import java.util.Scanner;
/*
    백준 문제 17614번 : 369

    문제 분석:
        3, 6, 9 게임의 규칙에 따라 주어진 숫자 N 이하의 모든 숫자에서 3, 6, 9의 개수를 세는 문제

    제약 조건:
        1 ≤ N ≤ 10,000

    의사 결정:
        1. 각 숫자의 자릿수를 확인하여 3, 6, 9의 개수를 센다.
        2. 더 효율적인 방법으로 모든 자릿수를 한번에 탐색하여 계산한다.
*/
public class BOJ17614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력받은 숫자
        int count = 0; // 3, 6, 9의 개수를 세기 위한 변수

        // 0부터 N-1까지의 숫자에 대해 3, 6, 9의 개수를 셈
        for(int i = 0; i < N; i++) {
            count += count369(i); // 각 숫자의 3, 6, 9 개수를 누적합
        }

        System.out.println(count); // 최종 개수 출력
    }

    // 주어진 숫자의 각 자리에서 3, 6, 9의 개수를 세는 함수
    public static int count369(int number) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10; // 각 자릿수 확인
            if (digit == 3 || digit == 6 || digit == 9) { // 3, 6, 9인 경우 카운트 증가
                count++;
            }
            number /= 10; // 다음 자릿수로 이동
        }
        return count; // 3, 6, 9의 총 개수 반환
    }
}
