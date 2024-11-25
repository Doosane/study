package com.doosane.lec.week01.gold;

import java.io.*;
import java.util.*;

public class BOJ2800_2 {
    static char[] arr;
    static int[] pair;
    static TreeSet<String> set;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        arr = s.toCharArray();

        pair = new int[arr.length]; // 괄호의 서로의 짝을 저장할 배열
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                // 여는 괄호가 나오면 스택에 넣는다
                stack.push(i);
            } else if (arr[i] == ')') {
                // 닫는 괄호가 나오면 스택의 제일 위 번호를 짝으로 저장하고
                // 거꾸로도 짝으로 저장한다
                pair[i] = stack.peek();
                pair[stack.peek()] = i;
                stack.pop();
            }
        }

        set = new TreeSet<>();
        visit = new boolean[arr.length];
        dfs(0, arr.length);
        // 처음 주어진 식은 제외한다
        set.remove(s);

        StringBuilder sb = new StringBuilder();
        set.stream().forEach(ans -> sb.append(ans).append("\n"));

        System.out.println(sb);
    }

    private static void dfs(int idx, int len) {
        if (idx == len) {
            print();
            return;
        }

        if (arr[idx] == '(') {
            // 여는 괄호를 만나면 해당 괄호와 짝 괄호를 vist배열에 true처리한다
            visit[idx] = true;
            visit[pair[idx]] = true;
            dfs(idx + 1, len);

            // 해당 괄호 쌍의 visit배열을 다시 false처리한다
            visit[idx] = false;
            visit[pair[idx]] = false;
        }

        dfs(idx + 1, len);
    }

    private static void print() {
        String tmp = "";
        for (int i = 0; i < arr.length; i++) {
            // visit가 true인 괄호는 출력하지 않는다
            if (!visit[i]) {
                tmp += arr[i];
            }
        }
        set.add(tmp);
    }

}

