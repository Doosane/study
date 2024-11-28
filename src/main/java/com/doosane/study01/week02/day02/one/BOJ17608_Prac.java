package com.doosane.study01.week02.day02.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17608_Prac {
    public static void main(String[] args) throws IOException {
        // BufferedReader , InputStreamReader 같이 사용 , N개의 막대기 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 읽어온 내용을 N에 할당
        int N = Integer.parseInt(br.readLine());

        // 스택을 사용해서
        Stack<Integer> stack = new Stack<>();

        // 가장 높은 막대기 높이
        int maxBar = 0;

        // 반복문으로
        for (int i = 0; i < N; i++) {

            //스택에 읽어온 값을 push
            stack.push(Integer.parseInt(br.readLine()));

            // 가장 높은 막대기의 높이가 스택의 제일 위에 것을 가져오는 값보다 작은 조건에서
            if (maxBar < stack.peek()) {

                // 가장 높은 막대기의 높이는 스택의 제일 위에 있는 요소를 제거하고 가져온다.
                maxBar = stack.peek();
            }
        }

        // 이전에 보였던 막대 중에서 가장 높은 막대를 저장하는 변수 선언
        int showingBeforMaxBar = 0;

        // 결과값 선언
        int countBar = 0;

        // 반복문으로
        for (int i = 0; i < N; i++) {

            // 현재 스택에서 꺼낸 막대의 높이 : 스택의 맨 위의 요소를 제거하고 반환
            int currentStackBar = stack.pop();

            // 조건문 사용, (만약 보이는 막대) 보다 다음 막대기가 높이가 크면 결과값 ++
            if (showingBeforMaxBar < currentStackBar) {
                // 현재 스택에서 꺼낸 막대가 보이면 이전 막대중 가장 높은 막대 갱신
                showingBeforMaxBar = currentStackBar;

                // 보이는 막대를 찾았으므로 ,countBar를 1 증가
                countBar++;
            }

            // 최대 높이 막대기 만나면 break;
            if (currentStackBar == maxBar) {
                break;
            }
        }

        // 결과 출력
        System.out.print(countBar);
    }
}