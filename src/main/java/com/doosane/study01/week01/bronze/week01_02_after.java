package com.doosane.study01.week01.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 검증수 */
public class week01_02_after {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // br.readLine().split(" ")을 통해 한 줄로 입력된 숫자들을 공백기준으로 분리
        String[] inputs = br.readLine().split(" ");

        int sum = 0;
        for (String input : inputs) {
            int num = Integer.parseInt(input);
            // math.pow()대신 * 사용
            // 간단한 정수제곱이고 불필요한 double 타입 변환을 줄이기 위해 사용
            sum += num * num;  // 제곱을 더하기
        }

        System.out.println(sum % 10);
    }
}
