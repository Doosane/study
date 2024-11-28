package com.doosane.study01.week02.day02.two;
/*
 백준 문제 12605번
 단어순서 뒤집기

 문제 분석 :
     각 케이스에 대해서, 케이스 번호가 x일때  "Case #x: " 를 출력한 후 그 후에 이어서 단어들을 반대 순서로 출력한다.
     후입선출의 스택의 개념을 사용 , stack.pop()으로 스택의 맨 위 요소를 제거하고 반환 후 , append로 붙여준다.

     성능과 효율적인 메모리 사용을 위해 BufferedReader 와 InputStreamReaser를 함께 사용
     효육적인 메모리 사용을 위해, StringBuilder 로 값을 한번에 모았다가 출력

 제약 조건 :
     첫 행은 N이며, 전체 케이스의 개수이다.
     N개의 케이스들이 이어지는데, 각 케이스는 스페이스로 띄어진 단어들이다.
     스페이스는 라인의 처음과 끝에는 나타나지 않는다. N과 L은 다음 범위를 가진다.
        N = 5
        1 ≤ L ≤ 25

 의사 결정 :
     1. BufferedReader , InputStreamReader 사용 , 문자을 읽어 오고
     2. StringTokenizer 로 공백 기준 단어를 읽어온다.
     2. while 조건문으로 StringTokenizer에서 가져온 토큰을 스택에 푸시한다.
     3. append로 Case #x : 모양으로 출력되도록 붙여준다.
     4. 스택이 비어있는지 isEmpty() 확인하고 , 비어있지 않다면
     5. stack.pop() 으로 스택의 맨 위 요소를 제거하고 반환 후 append로 붙여준다.
     5. Case # 별로 한줄에 하나 Case 노출되도록 하고 출력한다.
     6. StringBuilder로 모았다가 한번에 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12605 {
    public static void main(String[] args) throws IOException {
        // 성능과 효율적인 메모리 사용을 위해 BufferedReader 와 InputStreamReaser를 함께 사용.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 효육적인 메모리 사용을 위해, StringBuilder 로 값을 한번에 모았다가 출력.
        StringBuilder sb = new StringBuilder();
        // 공백 기준 단어를 읽어 오기 위해 StringTokenizer 사용.
        StringTokenizer st;

        // 스택 사용
        Stack<String> stack = new Stack<>();

        // 케이스의 개수 N
        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++) {

            // StringTokenizer 로 공백 기준 단어를 읽어온다.
            st = new StringTokenizer(br.readLine(), " ");

            // while 조건문으로 StringTokenizer에서 가져온 토큰을 스택에 푸시한다.
            while(st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            // "Case #i: " 모양으로 추가
            sb.append("Case #").append(i + 1).append(": ");

            // 스택이 비어있는지 isEmpty() 확인하고 , 비어있지 않다면
            while( !stack.isEmpty()) {

                // stack.pop() 으로 스택의 맨 위 요소를 제거하고 반환 후 , append로 붙여준다.
                sb.append(stack.pop() + " ");
            }

            // Case # 별로 한줄에 하나 Case 노출되도록
            sb.append("\n");
        }

        // 출력
        System.out.print(sb);
    }
}
