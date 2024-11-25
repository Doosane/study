package com.doosane.lec.week01.gold;

/**
 * 백준 BOJ2800
 * 괄호제거
 * 문제 분석 : 어떤 수식이 주어졌을 때, 괄호를 제거해서 나올 수 있는 서로 다른 식의 개수를 계산하는 프로그램 작성

 * 제약 조건 :
 첫째 줄에 음이 아닌 정수로 이루어진 수식 입력
 수식 길이 최대 200, 괄호 쌍은 적어도 1개, 많아야 10개
 숫자, '+', '*', '-', '/', '(', ')'로만 이루어져 있다.

 * 의사 결정 :
 * 1.수식을 입력 받을 수 있도록 BufferedReader 로 읽고 , InputSreamReader 사용 , readLine() 사용
 * 2.조건에 맞는 괄호 제거 메서드 작성
 * 3.출력
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 백준 BOJ2800
 * 괄호제거


 */
public class BOJ2800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mathematicalExpression = br.readLine();
        br.close();

        // 1. 모든 괄호 쌍 찾기
        List<int[]> parenthesesPairs = findParenthesesPairs(mathematicalExpression);

        // 2. 괄호를 제거한 모든 가능한 수식을 생성
        Set<String> resultSet = new HashSet<>();
        generateExpressions(mathematicalExpression, parenthesesPairs, 0, new boolean[parenthesesPairs.size()], resultSet);

        // 3. 원래 수식을 결과에서 제거
        resultSet.remove(mathematicalExpression);

        // 4. 결과를 정렬하여 출력
        resultSet.stream().sorted().forEach(System.out::println);
    }

    // (1) 모든 괄호 쌍의 인덱스 찾기
    private static List<int[]> findParenthesesPairs(String expression) {
        List<Integer> stack = new ArrayList<>();
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.add(i); // '('의 인덱스를 스택에 추가
            } else if (expression.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    int openIndex = stack.remove(stack.size() - 1); // 짝이 맞는 '('의 인덱스 꺼내기
                    pairs.add(new int[]{openIndex, i});
                }
            }
        }
        return pairs;
    }

    // (2) 괄호를 제거한 모든 가능한 수식을 생성
    private static void generateExpressions(String expression, List<int[]> pairs, int index, boolean[] toRemove, Set<String> resultSet) {
        if (index == pairs.size()) {
            // 괄호 제거에 따라 새로운 수식 생성
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                boolean skip = false;
                for (int j = 0; j < pairs.size(); j++) {
                    if (toRemove[j] && (i == pairs.get(j)[0] || i == pairs.get(j)[1])) {
                        skip = true; // 제거 대상 괄호일 경우 건너뜀
                        break;
                    }
                }
                if (!skip) {
                    sb.append(expression.charAt(i));
                }
            }
            String newExpression = sb.toString();
            if (!newExpression.equals(expression)) { // 원래 수식과 동일한 경우는 추가하지 않음
                resultSet.add(newExpression);
            }
            return;
        }

        // 재귀 호출: 현재 괄호 쌍을 포함/제외한 경우를 모두 고려
        toRemove[index] = false;
        generateExpressions(expression, pairs, index + 1, toRemove, resultSet);

        toRemove[index] = true;
        generateExpressions(expression, pairs, index + 1, toRemove, resultSet);
    }
}


