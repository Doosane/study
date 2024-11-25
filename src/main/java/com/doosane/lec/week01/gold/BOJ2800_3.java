package com.doosane.lec.week01.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 백준 BOJ2800
괄호제거

 1.문제 정의
     입력된 수식에서 가능한 모든 경우의 조합을 탐색하여 각 조합의 계산 결과가 0이 되는 수식을 출력.
     주어진 숫자들을 연결하거나, 더하거나(+), 빼는(-) 연산자를 삽입하면서 모든 경우를 탐색.

 2.제약 조건
     숫자의 범위: 최대 9까지의 정수 입력.
     수식 길이: 숫자와 연산자의 조합으로 이루어진 수식.
     연산자: 공백(숫자 연결), +, -만 사용 가능.

3.의사 결정
     DFS 기반 조합 탐색:
     숫자와 연산자의 모든 조합을 탐색하며 결과를 계산.
     공백, +, - 처리:
     공백(숫자 결합), + 및 - 연산자로 분기.
     계산 결과 검증:
     합계가 0인 경우만 결과에 포함.
     StringBuilder를 사용해 결과를 누적, 메모리 및 출력 효율성 최적화.
     각 DFS 호출은 상태 변화(숫자, 연산자 추가)를 명확히 나타냄.
 */
public class BOJ2800_3 {

    static char[] ch;
    static List<Pair> list = new ArrayList<>();
    static Set<String> resu = new TreeSet<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수식 입력 받기
        ch = br.readLine().toCharArray();

        // 1. 괄호 쌍 구하기
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(i);
            } else if (ch[i] == ')') {
                list.add(new Pair(stack.pop(), i));
            }
        }

        // 2. 괄호 존재하는 모든 조합 구하기
        check = new boolean[ch.length];
        comb(0);

        // 3. 출력하기
        Iterator<String> iter = resu.iterator(); // Set을 Iterator로 변환
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    // 조합 생성 메서드
    private static void comb(int depth) {
        if (depth == list.size()) {
            boolean b = false; // 괄호가 1개 이상 제거되었는지 나타내는 변수

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                if (!check[i]) {
                    sb.append(ch[i]);
                } else {
                    b = true;
                }
            }

            if (b) {
                resu.add(sb.toString()); // 결과에 추가
            }
            return;
        }

        // 현재 괄호 제거 안 함
        comb(depth + 1);

        // 현재 괄호 제거
        Pair now = list.get(depth);
        check[now.start] = true;
        check[now.end] = true;
        comb(depth + 1);
        check[now.start] = false;
        check[now.end] = false;
    }
}

// Pair 클래스 정의
class Pair {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
