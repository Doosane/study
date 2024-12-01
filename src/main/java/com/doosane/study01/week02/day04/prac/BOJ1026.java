package com.doosane.study01.week02.day04.prac;
import java.util.*;
import java.io.*;

/*
백준 문제 : 1026번 보물
문제 분석 :
    S = A[0] × B[0] + ... + A[N-1] × B[N-1]
    S의 값을 가장 작게 만들기 위해 A의 수를 재배열
    S의 최솟값을 출력하는 프로그램 작성

제약 조건 :
    첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고,
    셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고,
    A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수

의사결정 :
     1. BufferedReader를 사용하여 입력받고
     2. A 배열은 int[]로, B 배열은 Integer[]로 선언
     3. StringTokenizer를 사용하여 A와 B 배열의 원소들을 입력
     4. A 배열은 오름차순으로 정렬하고, B 배열은 내림차순으로 정렬
     5. B 배열의 내림차순 정렬을 위해 Collections.reverseOrder()를 사용
     6. 정렬된 A와 B 배열의 같은 인덱스 원소들을 곱하여 더하고, 최종 결과인 S를 출력
 */
public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 입력 받아서
        int N = Integer.parseInt(br.readLine()); // BufferedReader의 readLine 메서드로 문자열을 읽어온 값을 parseInt로 직접 형변환 해서 불필요한 객체 생성을 막고 N 할당

        // A 배열은 int[]로, B 배열은 Integer[]로 선언
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        // StringTokenizer를 사용하여 A와 B 배열의 원소들을 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); // A 배열은 오름차순으로 정렬
        Arrays.sort(B, Collections.reverseOrder()); // B 배열의 내림차순 정렬

        long S = 0;
        // 정렬된 A와 B 배열의 같은 인덱스 원소들을 곱하여 더하고
        for (int i = 0; i < N; i++) {
            S += (long) A[i] * B[i];
        }

        //최종 결과인 S를 출력
        System.out.println(S);
    }
}

