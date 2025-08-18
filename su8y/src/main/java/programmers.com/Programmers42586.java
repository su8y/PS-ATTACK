package programmers.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
public class Programmers42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        boolean empty = q.isEmpty();
        List<Integer> list = new ArrayList<>();
        int rear = 0, count = 0;
        // 리어가 array.length 보다 작을때까지 반복
        // 93 이면 부족한 숫자만큼(7) speed * 7 더해줌
        // 리어의 값과 차이를 곱해준다.
        while (rear < progresses.length) {
            int times = (int) Math.ceil(((100 - progresses[rear]) / (double) speeds[rear]));
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += (times * speeds[i]);
            }
            while (rear < progresses.length && progresses[rear] >= 100) {
                ++rear;
                ++count;
            }
            list.add(count);
            count = 0;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] progress = {90, 1, 3, 1, 1, 8};
        int[] speeds = {2, 99, 3, 2, 3, 5};
        // 33 21 31 58 // 100 33 67/ 3
        int[] solution = solution(progress, speeds);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }

}
