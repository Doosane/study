package com.doosane.study01.week01.bronze;
import java.util.Scanner;
/* 검증수
컴퓨터를 제조하는 회사인 KOI 전자에서는 제조하는 컴퓨터마다 6자리의 고유번호를 매긴다.
고유번호의 처음 5자리에는 00000부터 99999까지의 수 중 하나가 주어지며 6번째 자리에는 검증수가 들어간다.
검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.

예를 들어 고유번호의 처음 5자리의 숫자들이 04256이면,
각 숫자를 제곱한 수들의 합 0+16+4+25+36 = 81 을 10으로 나눈 나머지인 1이 검증수이다.
*/
public class week01_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();  // 첫 번째 정수를 입력받아 변수 A에 저장
        int B = sc.nextInt();  // 두 번째 정수를 입력받아 변수 A에 저장
        int C = sc.nextInt();  // 세 번째 정수를 입력받아 변수 A에 저장
        int D = sc.nextInt();  // 네 번째 정수를 입력받아 변수 A에 저장
        int E = sc.nextInt();  // 다섯 번째 정수를 입력받아 변수 A에 저장

        // 각 정수의 제곱을 구하고 그 합을 10으로 나눈 나머지를 계산
        int GumjeungRemainder = (A * A + B * B + C * C + D * D + E * E) % 10;

        System.out.println(GumjeungRemainder); // 출력

        sc.close(); // Scanner 닫기
    }
}
