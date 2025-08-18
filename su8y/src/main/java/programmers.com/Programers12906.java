package programmers.com;

import java.util.Arrays;

public class Programers12906 {
    public static void main(String[] args) {
        int[] request = {1, 1, 3, 3, 0, 1, 1, 2, 3, 4, 5};
        Arrays.stream(new Programers12906().solution(request)).forEach(System.out::println);
    }

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        Arrays.fill(answer, 0, arr.length, -1);
        int rear = 0;

        // 첫번째 값은 무조건 들어감
        answer[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //arr 를 순차적으로 탐색 rear의 값이 현재 포인터랑 같다면 패스
            if (answer[rear] != arr[i]) {
                answer[++rear] = arr[i];
            }

        }

        return Arrays.copyOfRange(answer, 0, rear + 1);
    }
}
