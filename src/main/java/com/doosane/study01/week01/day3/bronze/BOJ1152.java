package com.doosane.study01.week01.day3.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * StringBuilder를 사용햇을때 오히려 메모리 효율이 떨어지는 이유는 ?
 * -> sb.append(words.length);
 * System.out.println(sb.toString()); -> StringBuilder에 값을 추가한 후에 이를 문자열로 변환할때 변환 작업이 추가로 되면서
 * 간단한 문자열 조작에는 오히려 적합하지 않다.
 *
 */
/*
문제 분석
- 단어의 개수를 세어 출력
제약 조건
-
의사 결정
- 메모리와 시간 효율성을 고려 할 때, 불필요한 객체 생성을 피하는 것이 좋다.
- StringBuilder 사용을 피하고, 단순히 System.out.println()을 사용하여 값을 바로 출력하는 방식으로 한다.
- BufferdReader로 입력 문자열을 readLine()을 이용해 읽어온다.
- 문자열 word에서 양 끝의 공백을 제거한 후, 문자열이 비어 있는지 확인한다.
- 비어있다면, 단어의 개수가 0 이므로, 0을 출력한다.
- 비어있지 않다면, 공백을 기준으로 문자열을 분리하여 단어 배열을 만들고, 그 배열의 길이(단어 개수)를 출력한다.

 */
public class BOJ1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferdReader로 입력 문자열을
        String word = br.readLine();
        // readLine()을 이용해 읽어온다. 덩어리째 읽어서 Scanner 보다 빠르다
        br.close(); // readLine() 이후에 br.close()를 호출해서 더이상 BufferedReader를 사용하지 않음을 명확하게 한다.

        printWord(word); //printWord 메소드에 입력받은 word를 인자로 보내고 호출
    }

    static void printWord(String word) {
        //  입력받은 문자열 word에서 양 끝의 공백을 제거한 후, 문자열이 비어 있는지 확인한다.
        if (word.trim().isEmpty()) {
            // 비어있다면, 단어의 개수가 0 이므로, 0을 출력한다.
            System.out.println(0);
        } else {
           // 비어있지 않다면,
            String[] words = word.trim().split("\\s+");
            // 공백을 기준으로 문자열을 분리하여 단어 배열을 만들고
            System.out.println(words.length);
            // 그 배열의 길이(단어 개수)를 출력한다.
        }
    }
}

/*
메모리 54808 KB
시간 376 ms
 */


/*
오버 헤드

public class BOJ1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        br.close();

        printWord(word);
    }

    static void printWord(String word) {
        StringBuilder sb = new StringBuilder();

        if (word.trim().isEmpty()) {
            sb.append(0);

        } else {
            String[] words = word.trim().split("\\s+");
            sb.append(words.length);
        }

        System.out.println(sb.toString());
    }
}

 */

/*
메모리 55656 KB
시간 400 ms
 */