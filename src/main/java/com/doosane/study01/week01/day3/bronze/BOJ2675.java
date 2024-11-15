package com.doosane.study01.week01.day3.bronze;

/*

문제 : 문자열 반복

문제 분석 :
 - 문자열 S를 입력받아 각 문자를 R 번 반복하여 새 문자열 P를 만든후 출력
 - S의 첫번째 문자는 R 번 반목하고 , 두번째 문자는 R 번 반복하고

제약 조건 :
 - 사용할수 있는 문자 숫자 0-9 , 대문자 알파벳 A-Z, 특수문자 $%*+-./:
 - 첫째 줄: 테스트 케이스의 개수 T (1 ≤ T ≤ 1,000)
 - 각 테스트 케이스는 정수 R(1 ≤ R ≤ 8)과 문자열 S가 공백으로 구분되어 주어짐.
 - S의 길이는 최소 1자 이상이고 최대 20자 이하.

의사 결정 :
 - 첫 번째 줄에서 테스트 케이스 수 T를 입력받음
 - 각 테스트 케이스마다 입력된 R과 S를 분리하여 처리
 - 문자열 S의 각 문자를 R번 반복하여 새로운 문자열 P를 생성
 - 각 테스트 케이스마다 생성된 문자열 P를 출력

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 몇 개의 테스트 케이스가 입력되는지 받음
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스마다 반복
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" "); // 공백을 기준으로 문자 나눔
            int R = Integer.parseInt(input[0]); // 반복 횟수
            String S = input[1]; // 문자열

            printPtext(R, S); // prinPtext 메소드 실행
        }
    }

    static void printPtext(int R, String S) {
        StringBuilder sb = new StringBuilder();      // 효율적인 메모리 사용 위해 StringBuilder 사용


        // 문자열 S의 각 문자를 R번 반복하여 sb에 추가
        for (char c : S.toCharArray()) {
            for (int j = 0; j < R; j++) {
                sb.append(c);
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}

/*
메모리 13972 KB
시간 108 ms
 */