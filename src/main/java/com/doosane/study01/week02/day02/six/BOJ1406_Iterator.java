package com.doosane.study01.week02.day02.six;
/*
 백준 1406번 : 에디터
 Iterator를 이용한 풀이

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ1406_Iterator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열 입력 받기
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());  // 명령어의 개수

        // 문자열을 LinkedList로 변환 (효율적인 삽입/삭제를 위해)
        LinkedList<Character> text = new LinkedList<>();
        for (char c : str.toCharArray()) {
            text.add(c);
        }

        // ListIterator 사용, 초기 커서는 문자열 끝에 위치
        ListIterator<Character> iterator = text.listIterator(text.size());

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);  // 명령어의 첫 글자

            switch (cmd) {
                case 'L':  // 커서를 왼쪽으로 한 칸 이동
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case 'D':  // 커서를 오른쪽으로 한 칸 이동
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case 'B':  // 커서 왼쪽에 있는 문자 삭제
                    if (iterator.hasPrevious()) {
                        iterator.previous();  // 커서 왼쪽으로 이동
                        iterator.remove();  // 해당 문자 삭제
                    }
                    break;
                case 'P':  // 문자를 삽입
                    char ch = command.charAt(2);  // 삽입할 문자
                    iterator.add(ch);  // 현재 커서 위치에 문자 삽입
                    break;
                default:
                    break;
            }
        }

        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (char c : text) {
            result.append(c);
        }

        System.out.println(result.toString());
    }
}