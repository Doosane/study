package com.doosane.study01.week03.day01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 백준 문제 1026번 : 보물

 문제 분석:
    길이가 N인 정수 배열 A와 B에서, 함수 S를 정의
    S = A[0] × B[0] + ... + A[N-1] × B[N-1]
    S의 값을 가장 작게 만들기 위해 A의 수를 재배열
    S의 최솟값을 출력하는 프로그램 작성

 제약 조건:
    N은 50보다 작거나 같은 자연수
    A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수

 의사 결정:
     1. BufferedReader를 사용하여 입력받고
     2. A 배열은 int[]로, B 배열은 Integer[]로 선언
     3.StringTokenizer를 사용하여 A와 B 배열의 원소들을 입력
     4.A 배열은 오름차순으로 정렬하고, B 배열은 내림차순으로 정렬
     5.B 배열의 내림차순 정렬을 위해 Collections.reverseOrder()를 사용
     6.정렬된 A와 B 배열의 같은 인덱스 원소들을 곱하여 더하고, 최종 결과인 S를 출력
 */
public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader 사용해서 입력받고
        int N = Integer.parseInt(br.readLine());                                  // 읽어온 값을 파싱해서 N 할당
        int[] A = new int[N];                                                     // 타입 int 로 A 배열 선언
        Integer[] B = new Integer[N];                                             // 타입 Integer로 B 배열 선언
        StringTokenizer st = new StringTokenizer(br.readLine());                  // StringTokenizer로 BufferedReader의 readLine() 메서드로 읽어온 값을 토큰화
        for(int i=0; i<N; i++) {                                                  // 반복문을 통해 , 토큰화한 내용을 A에 넣어주고
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());                                  // StringTokenizer로 BufferedReader의 readLine() 메서드로 읽어온 값을 토큰화
        for(int i=0; i<N; i++) {                                                  // 반복문을 통해, 토큰화한 내용을 B에 넣어주고
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);                                                           // A를 sort를 사용하여 정렬 (디폴트 오름차순)
        Arrays.sort(B, Collections.reverseOrder());                               // B를 sort를 사용하여 Collections.reverseOrder() 사용, 내림차순 정렬
        long S =0;                                                                // 출력할 S를 long 타입으로 선언
        for(int i=0; i<N; i++) {                                                  // 반복문을 통해
            S += (long) A[i] * B[i];                                              // 정렬된 A와 B 배열의 같은 인덱스 원소들을 콥하여 더한 후, S에 넣어준다.
        }
        System.out.println(S);                                                    // 출력
    }
}