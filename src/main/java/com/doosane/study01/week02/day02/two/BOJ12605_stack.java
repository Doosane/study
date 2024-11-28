package com.doosane.study01.week02.day02.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12605_stack {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i ++) {
            st =new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }
            sb.append("Case #" + i + ": ");
            while( ! stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
