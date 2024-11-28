package com.doosane.study01.week02.day02.six;
/*
 백준 문제 1406번 : 에디터
 스트링빌더를 활용한 커서 관리 방식
 StringBuilder는 기본적으로 문자 배열처럼 내부에서 데이터를 처리하며,
 문자열 삽입/삭제에서 효율적인 성능이 있다.
 다만, 이 방식은 문자열의 길이가 매우 길어지는 경우 성능 이슈가 발생할 수 있다.

 즉 , 덱이나 리스트 같은 자료 구조를 사용하지 않고, 단순히 인덱스 기반 접근을 활용해서
 커서를 관리하는 방식

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1406_StringBuilder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열 입력 받기
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());  // 명령어의 개수

        // StringBuilder로 문자열 관리
        StringBuilder sb = new StringBuilder(str);
        int cursor = sb.length();  // 커서의 위치를 문자열의 끝으로 설정

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);  // 명령어의 첫 글자

            switch (cmd) {
                case 'L':  // 커서를 왼쪽으로 한 칸 이동
                    if (cursor > 0) {
                        cursor--;
                    }
                    break;
                case 'D':  // 커서를 오른쪽으로 한 칸 이동
                    if (cursor < sb.length()) {
                        cursor++;
                    }
                    break;
                case 'B':  // 커서 왼쪽에 있는 문자 삭제
                    if (cursor > 0) {
                        sb.deleteCharAt(cursor - 1);  // 커서 바로 왼쪽의 문자 삭제
                        cursor--;  // 삭제 후 커서 위치를 왼쪽으로 이동
                    }
                    break;
                case 'P':  // 문자를 삽입
                    char ch = command.charAt(2);  // 삽입할 문자
                    sb.insert(cursor, ch);  // 커서 위치에 문자 삽입
                    cursor++;  // 삽입 후 커서 위치를 한 칸 오른쪽으로 이동
                    break;
                default:
                    break;
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}

