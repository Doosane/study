package com.doosane.study01.week02.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
  백준 문제 1769 3의 배수
  20164	224
 */
public class pairProgramming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 입력 - 그냥 스트링으로 받는다.
        String X = br.readLine(); // 문자열 입력 받았음 1234567
        sumPrint(X);
    }
}