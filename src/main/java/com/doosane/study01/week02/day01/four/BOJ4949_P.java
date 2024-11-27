package com.doosane.study01.week02.day01.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949_P {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String line = br.readLine().trim();
            if(line.equals(".")) {
                break;
            }
            if(isBalanced(line)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>();
        for(char ch : line.toCharArray()) {
            if(ch == '(' || ch == '[') {
                stack.push(ch);

            } else if (ch == ')' ||ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if((ch == ')' && open != '(') || (ch == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
