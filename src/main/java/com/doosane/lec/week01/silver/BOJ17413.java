package com.doosane.lec.week01.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 백준 17413번
 * 단어 뒤집기
 */
public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String S = br.readLine();
           reverse(S);
    }

    public static void reverse(String S) {
        StringBuilder result = new StringBuilder();
        Stack<Character> wordStack = new Stack<>();
        boolean insideTag = false;

        // 문자열을 하나씩 처리
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // 태그 내부 처리
            if(c =='<') {
                // 태그 내부에 있으면 지금까지 쌓인 단어를 뒤집어서 출력
                while (!wordStack.isEmpty()) {
                    result.append(wordStack.pop());
                }
                // <를 결과에 추가
                result.append(c);
                insideTag = true;

            } else if (c == '>') {
                // 태그 내부의 끝
                result.append(c);
                insideTag = false;

            } else {
                if(insideTag) {
                    // 태그 내부의 문자들은 그대로 추가
                    result.append(c);

                } else {
                    if (c == ' ') {
                        // 단어가 끝났으면, 쌓인 단어를 뒤집어서 출력
                        while(!wordStack.isEmpty()) {
                            result.append(wordStack.pop());
                        }
                        result.append(c); // 공백은 그대로 출력

                    } else {
                        // 단어의 문자들은 스택에 쌓아두기
                        wordStack.push(c);
                    }
                }
            }
        }

        // 마지막에 남은 단어를 뒤집어서 출력
        while (!wordStack.isEmpty()) {
            result.append(wordStack.pop());
        }

        // 결과 출력
        System.out.println(result);
    }
}
