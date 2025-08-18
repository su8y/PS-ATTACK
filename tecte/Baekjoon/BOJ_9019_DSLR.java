/*
 * 문제 : 백준 9019번 - DSLR (https://www.acmicpc.net/problem/9019)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9019_DSLR {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            Queue<Register> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];

            queue.offer(new Register(a, ""));
            visited[a] = true;

            while (true) {
                Register register = queue.poll();

                if (register.num == b) {
                    bw.write(register.cmd);
                    bw.newLine();
                    break;
                }

                for (char c : new char[]{'D', 'S', 'L', 'R'}) {
                    Register newRegister = null;

                    switch (c) {
                        case 'D':
                            newRegister = new Register((register.num << 1) % 10000, register.cmd + "D");
                            break;
                        case 'S':
                            newRegister = new Register((register.num + 9999) % 10000, register.cmd + "S");
                            break;
                        case 'L':
                            newRegister = new Register(register.num % 1000 * 10 + register.num / 1000, register.cmd + "L");
                            break;
                        case 'R':
                            newRegister = new Register(register.num % 10 * 1000 + register.num / 10, register.cmd + "R");
                            break;
                    }

                    if (!visited[newRegister.num]) {
                        queue.offer(newRegister);
                        visited[newRegister.num] = true;
                    }
                }
            }
        }

        br.close();
        bw.close();
    }

    public static class Register {
        int num;
        String cmd;

        public Register(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
}
