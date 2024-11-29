package com.doosane.study01.week02.day03.ex04;

/*
 백준 문제 15829번 : Hashing

 문제 분석:
  문제에서 주어진 해시함수와 입력으로 주어진 문자열을 사용해 계산한 해시 값을 정수로 출력

 제약 조건:
  첫 줄에는 문자열의 길이 L이 들어온다. 둘째 줄에는 영문 소문자로만 이루어진 문자열이 들어온다.
  입력으로 주어지는 문자열은 모두 알파벳 소문자로만 구성되어 있다.

 의사 결정 :
   1. S.charAt(i) - 'a' + 1을 사용하여 각 문자를 알파벳 순서에 맞는 숫자로 변환
   2. 이진 제곱법을 통해 r^i % M을 효율적으로 계산
   3. 각 문자의 값을 계산하고 이를 r^i % M과 곱한 후 더하는 방식으로 해시 값을 구한다.
   4. 최종적으로 계산된 해시 값을 출력한다.

 */
import java.util.Scanner;

public class BOJ15829 {
    public static void main(String[] args) {
        // Scanner 객체를 사용하여 입력을 받는다.
        Scanner sc = new Scanner(System.in);

        // 첫 번째 입력: 문자열의 길이 L을 받는다.
        int L = sc.nextInt();  // 문자열의 길이 L
        // 두 번째 입력: 문자열 S를 받는다.
        String S = sc.next();  // 문자열 S

        // 해시 함수 계산을 위한 변수들
        long r = 31;            // 해시 함수에서 사용하는 상수 r (주어진 값)
        long M = 1234567891;    // 해시 값을 구할 때 나누는 값 M (주어진 값)
        long hashValue = 0;     // 최종 해시 값을 저장할 변수, 초기값은 0

        // 문자열의 각 문자를 하나씩 처리하면서 해시 값을 계산한다.
        // 문자열 S의 각 문자에 대해 그 값을 숫자로 변환하고, 해당 문자에 대한 해시 값을 누적한다.
        for (int i = 0; i < L; i++) {
            // 문자 S.charAt(i)를 숫자 값으로 변환한다. (a -> 1, b -> 2, ..., z -> 26)
            // char 'a'는 97, 'b'는 98, ..., 'z'는 122이므로,
            // S.charAt(i) - 'a' + 1을 통해 'a'는 1, 'b'는 2, ..., 'z'는 26으로 변환된다.
            int charValue = S.charAt(i) - 'a' + 1;

            // 각 문자에 대해 r^i를 계산하여 해당 문자 값에 곱하고,
            // 그 결과를 기존 해시 값에 더한다. 그리고 결과는 M으로 나누어 나머지를 구한다.
            // 해시 값 계산: hashValue = (hashValue + charValue * r^i) % M
            hashValue = (hashValue + charValue * modPow(r, i, M)) % M;
        }

        // 최종적으로 계산된 해시 값을 출력한다.
        System.out.println(hashValue);
    }

    // r^i % M을 효율적으로 계산하는 메소드 (이진 제곱법 사용)
    public static long modPow(long base, int exp, long mod) {
        // result는 초기값 1로 설정. (r^0 = 1 이므로 기본값은 1)
        long result = 1;
        // base가 mod보다 크면, base를 mod로 나눈 나머지 값을 사용한다.
        base = base % mod;

        // exp가 0이 될 때까지 반복문을 돌면서 이진 제곱법을 사용해 거듭제곱을 계산
        while (exp > 0) {
            // exp가 홀수일 때, result에 base 값을 곱하고 mod로 나눈 나머지를 취한다.
            if (exp % 2 == 1) {  // exp가 홀수일 때
                result = (result * base) % mod;  // result에 base를 곱해주고, 그 후 mod로 나눈 나머지
            }
            // exp를 반으로 나누기 (이진 제곱법에서 중요한 부분)
            exp = exp >> 1;  // exp를 반으로 나눈다. (exp를 2로 나눈 것과 동일)

            // base를 제곱하여, 그 값을 mod로 나눈 나머지를 취한다.
            base = (base * base) % mod;  // base를 제곱하여 mod를 취한다.
        }

        // 계산된 r^i % M 값을 반환한다.
        return result;
    }
}

