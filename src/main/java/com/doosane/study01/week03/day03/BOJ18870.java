package com.doosane.study01.week03.day03;

import java.io.*;
import java.util.*;
/*
 백준 문제 18870번 좌표압축
 문제 분석 :
    수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용
    Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
    X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력

 제한 조건 :
    첫째 줄에 N이 주어진다.
    둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
    첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

 의사 결정 :
    1. 첫째 줄에 N , 둘째 줄에 공백 한칸으로 구분 , XN을 BufferedReader로 입력 받고
    2. 원본 좌표와 정렬된 좌표를 저장할 배열 생성
    3. 두 번째 줄에서 좌표 값을 입력받아 배열에 저장
    4. 정렬된 배열을 오름차순으로 정렬
    5. 좌표 압축 값을 저장할 HashMap 생성, 맵에 값과 현재 랭크를 저장하고 랭크 증가
    6. 원본 배열의 각 값을 압축된 좌표 값으로 변환하여 출력
 */
public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        // BufferedReader로 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 좌표의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 원본 좌표와 정렬된 좌표를 저장할 배열 생성
        int[] original = new int[N];
        int[] sorted = new int[N];

        // 두 번째 줄에서 좌표 값을 입력받아 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(st.nextToken()); // 원본 배열에 저장
            sorted[i] = original[i]; // 정렬을 위한 배열에 동일하게 저장
        }

        // 정렬된 배열을 오름차순으로 정렬
        Arrays.sort(sorted);

        // 좌표 압축 값을 저장할 HashMap 생성
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0; // 압축된 좌표 값을 나타낼 랭크 변수 초기화
        for (int value : sorted) {
            // 현재 값이 맵에 없으면 중복을 제거
            if (!map.containsKey(value)) {
                map.put(value, rank++); // 맵에 값과 현재 랭크를 저장하고 랭크 증가
            }
        }

        // 원본 배열의 각 값을 압축된 좌표 값으로 변환하여 출력
        StringBuilder sb = new StringBuilder();
        for (int value : original) {
            sb.append(map.get(value)).append(' '); // 압축된 좌표 값을 StringBuilder에 추가
        }
        System.out.println(sb.toString().trim()); // 결과 문자열을 출력
    }
}

