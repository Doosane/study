package com.doosane.study01.week02.day01.lec;

import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<Document> queue = new LinkedList<>();
            int[] priorities = new int[9];

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                queue.add(new Document(i, priority));
                priorities[priority - 1]++;
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();
                boolean hasHigherPriority = false;

                for (int i = current.priority; i < 9; i++) {
                    if (priorities[i] > 0) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.add(current);
                } else {
                    printOrder++;
                    priorities[current.priority - 1]--;
                    if (current.index == m) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }

        sc.close();
    }

    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
