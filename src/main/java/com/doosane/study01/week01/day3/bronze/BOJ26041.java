package com.doosane.study01.week01.day3.bronze;
/*
문제: 비슷한 전화번호 표시

문제 분석 :
- 주어진 문자열 A는 여러개의 전화번호를 공백으로 구분한 문자열임
- 추가적으로 하나의 전화번호 B가 주어짐
- A에 포함된 전화번호 중 B와 같지 않으면서 B를 접두사로 갖는 전화번호의 개수를 출력해야한다.

제약 조건 :
- 전화번호 개수 n ( 1<= n <= 100000 )
- 문자열 A의 길이 ( 2<= 문자열 A 길이 <= 1000000) , 공백을 포함한 모든 전화번호의 총 길이
- 전화번호 B의 길이 2<= 전화번호 길이 <= 10
- 전화번호는 문자 '1' ~ 문자 '9' 로만 이루어짐

의사 결정 :
- BufferedReader를 사용하여 입력을 받는다 ( 메모리 효율, Scanner 보다 덩어리째로 빠르게 읽음)
- 전화번호 목록은 공백으로 구분된 문자열을 split(" ") 메서드를 사용하여 배열로 변환하여 저장한다.
- 두번째 줄에서 전화번호 B를 입력받아 저장한다.
- 전화번호 배열 A를 순회하면서 각 전화번호가 B와 같지 않은지 확인한다.
- startsWith(B) 메서드를 사용하여 B를 접두사로 갖는지 확인한다.
- 두조건 만족시, 카운트 증가시킨다.
- 죄종 조건 만족하는 전화번호 개수를 출력한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ26041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 A 입력 (전화번호 목록)
        String[] A = br.readLine().split(" ");

        // 비교할 전화번호 B 입력
        String B = br.readLine();

        int count = 0;

        // 전화번호 목록 A에서 B를 접두사로 가지면서 B와 다른 전화번호 수를 셈
        for (String number : A) {
            if(!number.equals(B) && number.startsWith(B)) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}

/*
메모리 27288 KB
시간 276 ms
 */