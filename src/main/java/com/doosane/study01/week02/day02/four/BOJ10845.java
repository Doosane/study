package com.doosane.study01.week02.day02.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
     백준 문제 10845번
     큐
 
     문제 분석 :
        입력으로 주어지는 명령을 처리하는 프로그램을 작성

     제약 조건 :
        명령의 수 N (1 ≤ N ≤ 10,000)
        주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.

     의사 결정 :
     1.BufferedReader, InputStreamReader 사용하여 메모리를 효율적으로 사용하고 빠르게 입력값을 가져올수 있도록 한다.
     2.StringBuilder 를 사용하여 모아서 한번에 출력한다.
     3.StringTokenizer를 이용해서 읽어온 값을 토큰화 한다
       st는 StringTokenizer 객체 입력받은 문자열을 공백 단위로 분리한 후 각 토큰을 하나씩 처리하는 데 사용
     4.토큰화한 값을 S에 할당 하고, 스위치문을 이용해서 케이스 별로 연산을 진행

 */
public class BOJ10845 {
    public static void main(String[] args) throws IOException {

        // BufferedReader, InputStreamReader 사용하여 메모리를 효율적으로 사용하고 빠르게 입력값을 가져올수 있도록 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //모아서 한번에 출력하도록 스트링 빌더 사용
        StringBuilder sb = new StringBuilder();

        // 큐 사용
        Queue<Integer> q = new LinkedList<Integer>();
        int b = 0;
        int n = Integer.parseInt(br.readLine());

        // 반목문을 통해 읽어온 값을 넣는다
        for(int i=0; i<n; i++) {
            // StringTokenizer를 이용해서 읽어온 값을 토큰화 한다
            // st는 StringTokenizer 객체 입력받은 문자열을 공백 단위로 분리한 후 각 토큰을 하나씩 처리하는 데 사용
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 토큰화한 값을 S에 할당
            String S = st.nextToken();
            // 스위치문을 이용해서 케이스 별로 연산을 진행한다.
            switch(S) {
                case "push": // 정수 X를 큐에 넣는 연산
                    // st.nextToken()은 StringTokenizer에서 분리된 문자열 중 다음 토큰을 반환
                    // Integer.parseInt(st.nextToken())는 이 반환된 문자열을 정수(int)로 변환
                    int num = Integer.parseInt(st.nextToken());
                    // queue의 q.add() 를 이용, stack의 push 와 유사
                    q.add(num);
                    b = num;
                    break;

                case "pop":
                    if(q.isEmpty()) { // 큐가 비어 있는지 확인
                        sb.append("-1\n"); // 큐가 비어 있으면 "-1"을 출력
                    } else {
                        // queue의 q.remove() 를 이용 , stack의 pop과 유사
                        sb.append(q.remove() + "\n");
                    }
                    break;

                case "size":
                    // queue의 q.size() 를 이용 , stack의 size와 유사
                    sb.append(q.size() + "\n");
                    break;

                case "empty":
                    // q.isEmpty()로 큐가 비었는지 확인 , stack의 isEmpty 와 유사
                    if(q.isEmpty()) { // 큐가 비어 있는지 확인
                        sb.append("1\n"); // 큐가 비어 있으면 "1"을 출력
                    } else {
                        sb.append("0\n"); // 큐가 비어 있지 않으면 "0"을 출력
                    }
                    break;

                case "front":
                    if (q.isEmpty()) { // 큐가 비어 있는지 확인
                        sb.append("-1\n"); // 큐가 비어 있으면 "-1"을 출력
                    } else {
                        // stack의 peek()에서는 맨 위 값을 가져오지만
                        // queue에서는 가장 앞에 있는 값을 조회한다.
                        sb.append(q.peek() + "\n");
                    }
                    break;

                case "back":
                    if(q.isEmpty()) { // 큐가 비어 있는지 확인
                        sb.append("-1\n"); // 큐가 비어 있으면 "-1"을 출력
                    } else {
                        sb.append(b + "\n"); // 큐가 비어 있지 않으면 변수 b의 값을 출력
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}