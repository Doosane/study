package com.doosane.study01.week02.day02.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
백준 17608번 : 막대기
문제 분석 :
  이가 다른 막대를 오른쪽에서 보았을때 몇개가 보이는지 알아내는 프로그램 작성
  -> stack 의 개념을 사용하여,반복문을 통해
     스택에 쌓인 내용중 맨 위 요소를 가져와서 이전에 보였던 막대의 높이보다 큰 값으로
     갱신되는 횟수를 구해 출력한다.

제약 조건 : 첫 번째 줄에는 막대기의 개수를 나타내는 정수 N (2 ≤ N ≤ 100,000)이 주어지고 이어지는 N줄 각각에는 막대기의 높이를 나타내는 정수 h(1 ≤ h ≤ 100,000)가 주어진다.

의사 결정 :
 1. BufferedReader로 막대 수를 읽어 오고
 2. maxBar를 선언하고 , 스택에 반복문을 사용해서 , 스택의 가장 위에 쌓인 내용을 stack.peek()로 가져온다.
 3. showingBeforeMaxBar에 이전에 보였던 막대 중에서 가장 높은 막대를 저장하고
 4. countBar에 결과값을 저장한다.
 5. 반복문으로 현재 스택에서 꺼낸 막대의 높이(currentStackBar)가 스택의 맨 위의 요소를 제거하고 반환 했을 때,
    showingBeforeMaxBar 보다 크면 보이는 막대이므로  currentStackBar 를 갱신한다.
 6. showingBeforMaxBar 가 maxBar를 만나면 최고 높이 막대기 에서 break;
 7. countBar를 결과 출력한다.
 */
public class BOJ17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 막대기 수
        int N = Integer.parseInt(br.readLine());

        // 스택을 사용해서
        Stack<Integer> stack = new Stack<>();

        // 가장 높은 막대기 높이
        int maxBar = 0;

        // 반복문으로
        for (int i = 0; i < N; i++) {

            //스택에 읽어온 값을 push
            stack.push(Integer.parseInt(br.readLine()));

            // maxBar 는 스택의 가장 위에 쌓인 내용을 가져온다.
            if (maxBar < stack.peek()) {
                maxBar = stack.peek();
            }
        }

        // 이전에 보였던 막대 중에서 가장 높은 막대를 저장
        int showingBeforMaxBar = 0;

        // 결과값 선언
        int countBar = 0;

        // 반복문으로
        for (int i = 0; i < N; i++) {

            // 현재 스택에서 꺼낸 막대의 높이 : 스택의 맨 위의 요소를 제거하고 반환
            // 이 높이가 showingBeforMaxBar보다 크면, 즉 이전에 보였던 막대들보다 더 크면, 이 막대는 보이는 막대
            int currentStackBar = stack.pop();

            // 보이는 막대 보다 다음 막대기가 높이가 크면,
            // 만약 현재 막대(currentStackBar)의 높이가 이전에 보였던 막대들 중
            // 가장 높은 막대(showingBeforMaxBar)보다 크다면, 이 막대는 "새롭게 보이는" 막대.

            // 만약 이전 막대중 제일 큰 값 보다 새로 보인 막대가 더 큰 조건이라면
            if (showingBeforMaxBar < currentStackBar) {
                // 이 막대가 보였으므로, showingBeforMaxBar를 현재 막대의 높이로 갱신
                // 앞으로 볼 막대들과 비교하기 위한 기준
                showingBeforMaxBar = currentStackBar;

                // 보이는 막대 하나를 찾았으므로, countBar를 1 증가
                countBar++;
            }

            // 최대 높이 막대기 만나면 break;
            if(showingBeforMaxBar == maxBar) {
                break;
            }
        }

        // 결과 출력
        System.out.println(countBar);
    }
}