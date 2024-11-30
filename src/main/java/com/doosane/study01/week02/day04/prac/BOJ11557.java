package com.doosane.study01.week02.day04.prac;

import java.io.*;
/*
문제 분석 :
    여러 테스트 케이스에 대해 각 학교의 술 소비량을 비교
    각 테스트 케이스마다 가장 많은 술을 소비한 학교의 이름을 출력해야 함

제약 조건 :
    1 ≤ 테스트 케이스 수 (T) ≤ 100
    1 ≤ 학교 수 (N) ≤ 100
    학교 이름 길이: 1 ≤ |S| ≤ 20 (공백 없는 알파벳 문자열)
    술 소비량: 0 ≤ L ≤ 10,000,000
    같은 테스트 케이스 내에서 소비량이 같은 학교는 없음

의사 결정 :
    BufferedReader 사용: 빠른 입력 처리를 위해 선택
    long 타입 사용: 최대 소비량이 10,000,000까지 가능하므로 long 타입 사용
    단순 비교 방식: 별도의 정렬 없이 순차적으로 비교하여 최대값 갱신
    문자열 분리: split() 메소드를 사용하여 학교 이름과 소비량 분리
 */
public class BOJ11557 {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 효율적인 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 T 입력 받기
        int T = Integer.parseInt(br.readLine());

        // 각 테스트 케이스에 대해 반복
        for (int t = 0; t < T; t++) {
            // 학교의 수 N 입력 받기
            int N = Integer.parseInt(br.readLine());

            // 최대 소비량을 가진 학교 이름과 소비량을 저장할 변수 초기화
            String maxSchool = "";
            long maxConsumption = 0;

            // N개의 학교에 대한 정보 처리
            for (int i = 0; i < N; i++) {
                // 학교 이름과 소비량을 공백으로 구분하여 입력 받기
                String[] input = br.readLine().split(" ");
                String school = input[0];
                long consumption = Long.parseLong(input[1]);

                // 현재 학교의 소비량이 최대값보다 크면 갱신
                if (consumption > maxConsumption) {
                    maxConsumption = consumption;
                    maxSchool = school;
                }
            }

            // 가장 많은 술을 소비한 학교 이름 출력
            System.out.println(maxSchool);
        }
    }
}