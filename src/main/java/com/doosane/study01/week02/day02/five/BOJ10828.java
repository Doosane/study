package com.doosane.study01.week02.day02.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 백준 문제 10828번
 스택
 문제 분석:
 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성

 제한 조건:
  N (1 ≤ N ≤ 10,000)
  주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.

 의사 결정:
 1.BufferedReader, InputStreamReader 사용하여 메모리를 효율적으로 사용하고 빠르게 입력값을 가져올수 있도록 한다.
     2.StringBuilder 를 사용하여 모아서 한번에 출력한다.
     3.StringTokenizer를 이용해서 읽어온 값을 토큰화 한다
       st는 StringTokenizer 객체 입력받은 문자열을 공백 단위로 분리한 후 각 토큰을 하나씩 처리하는 데 사용
     4.토큰화한 값을 S에 할당 하고, 스위치문을 이용해서 케이스 별로 연산을 진행

 */
public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        // BufferedReader, InputStreamReader 사용하여 메모리를 효율적으로 사용하고 빠르게 입력값을 가져올수 있도록 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //모아서 한번에 출력하도록 스트링 빌더 사용
        StringBuilder sb = new StringBuilder();

        // stack 사용
        Stack<Integer> stack = new Stack<>();
        int b = 0;
        int n = Integer.parseInt(br.readLine());

        //반복문을 통해 읽어 온 값을 넣는다.
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            switch(S) {
                case "push": //정수 X를 스택에 넣는 연산
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    b = num;
                    break;
                case "pop": //스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력
                    if(stack.isEmpty()) {// 스택이 비어있는지 확인
                        sb.append("-1\n"); // 스택이 비어 있으면 "-1"을 출력
                    } else {
                        sb.append(stack.pop() + "\n"); // stack의 stack.pop을 이용 , 가장 맨 위의 내용을 가져온다.
                    }
                    break;
                case "size": // size: 스택에 들어있는 정수의 개수를 출력
                    sb.append(stack.size() + "\n");
                    break;
                case "empty": //empty: 스택이 비어있으면 1, 아니면 0을 출력
                    if(stack.isEmpty()) { // 스택이 비어있는지 확인
                        sb.append("1\n"); // 스택이 비어있으면 "1"을 출력
                    } else {
                        sb.append("0\n"); // 스택이 비어 있지 않으면 "0"을 출력
                    }
                    break;
                case "top":
                    if(stack.isEmpty()) { // 스택이 비어있는지 확인
                        sb.append("-1\n"); // 스택이 비어있으면 "-1"을 출력
                    } else {
                        sb.append(stack.peek() + "\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
