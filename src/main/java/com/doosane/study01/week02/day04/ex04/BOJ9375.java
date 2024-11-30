package com.doosane.study01.week02.day04.ex04;
/*
 백준 문제 9375번 : 패션왕 신해빈

 문제분석:
    의상 조합 수를 계산하되, 아무것도 착용하지 않는 경우는 제외.

    제약조건:
    의상의 종류는 중복될 수 있으며, 최대 30개의 의상까지 입력 가능.
    한 종류의 의상은 한 번에 하나만 착용 가능.

    의사결정:
    1. BufferedReader와 BufferedWriter를 사용해 대량 데이터 처리에 대응.
    2. HashMap을 사용해 의상 종류별 개수를 저장.
    3. 각 의상 종류별 (개수 + 1)을 곱한 뒤 -1로 아무것도 착용하지 않는 경우 제외.
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위해 BufferedReader를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력도 빠르게 처리하기 위해 BufferedWriter를 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수를 입력받음
        int t = Integer.parseInt(br.readLine());

        // 각 테스트 케이스에 대해 반복
        while (t-- > 0) {
            // 의상의 개수를 입력받음
            int n = Integer.parseInt(br.readLine());

            // 의상의 종류와 개수를 저장하기 위한 HashMap
            Map<String, Integer> cloth = new HashMap<>();

            // n개의 의상 정보를 입력받음
            for (int i = 0; i < n; i++) {
                // 의상의 이름과 종류를 공백으로 구분하여 입력받음
                String[] input = br.readLine().split(" ");
                String clothType = input[1]; // 의상의 종류

                // 해당 종류의 의상 개수를 증가시킴 (없으면 기본값 0으로 초기화 후 1 추가)
                cloth.put(clothType, cloth.getOrDefault(clothType, 0) + 1);
            }

            // 조합 계산을 위한 변수 초기화
            int combinations = 1;

            // 각 종류의 의상 개수에 대해 계산
            // (해당 종류를 착용하지 않는 경우를 포함하여 +1)
            for (int count : cloth.values()) {
                combinations *= (count + 1);
            }

            // 조합에서 아무것도 착용하지 않는 경우를 제외 (-1)
            bw.write((combinations - 1) + "\n");
        }

        // 남아있는 데이터를 출력
        bw.flush();
        // BufferedWriter를 닫아 리소스 해제
        bw.close();
    }
}
