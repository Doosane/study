package com.doosane.study01.week01.bronze;

/*
문제 분석 :
 - 재귀 호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인
 - 아래의 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력

제약 조건 :
 - 첫째 줄에 n(5 ≤ n ≤ 40)이 주어진다.
 - 코드1 코드2 실행 횟수를 한 줄에 출력한다.

의사 결정 :
 - BufferedReader 사용, readLine() 으로 N을 입력 받아 읽는다.
 - 재귀 방식으로 피보나치 수 계산
 - 동적 프로그래밍 방식으로 피보나치 수 계산
 - 재귀 / 동적 계산 호출 수 출력
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week02_01_BOJ_24416 {
    private static int jaguiProgramCount = 0;     // 재귀 호출 실행 횟수 카운트
    private static int dongjeokProgramCount = 0;  // 동적 프로그래밍 실행 횟수 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine().trim());

        // 재귀 호출 방식으로 피보나치 수 구하고 실행 횟수 카운트
        fibonacciJaguiProgram(N);

        // 동적 프로그래밍 방식으로 피보나치 수 구하고 실행 횟수 카운트
        fibonacciDongjeockProgram(N);

        // 결과 출력 (문제에서 요구한 대로, 코드1, 코드2 실행 횟수 출력)
        System.out.println(jaguiProgramCount + " " + dongjeokProgramCount);
    }

    // 재귀 방식의 피보나치 수 계산
    private static int fibonacciJaguiProgram(int n) {
        if (n == 1 || n == 2) {
            jaguiProgramCount++;  // 코드1 실행 횟수 증가
            return 1;
        } else {
            return fibonacciJaguiProgram(n - 1) + fibonacciJaguiProgram(n - 2);
        }
    }

    // 동적 프로그래밍 방식의 피보나치 수 계산
    private static int fibonacciDongjeockProgram(int n) {
        int[] dongjeockProgram = new int[n + 1];
        dongjeockProgram[1] = dongjeockProgram[2] = 1;
        for (int i = 3; i <= n; i++) {
            dongjeockProgram[i] = dongjeockProgram[i - 1] + dongjeockProgram[i - 2];
            dongjeokProgramCount++;  // 코드2 실행 횟수 증가
        }
        return dongjeockProgram[n];
    }
}