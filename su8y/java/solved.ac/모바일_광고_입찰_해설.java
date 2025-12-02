package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모바일_광고_입찰_해설 {
    static int[] a;
    static int[] b;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N];
        b = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        // 입찰가를 1씩 올린다고 가정을 하면 총 10억번의 연산이 필요하다.
        // 그리고 1씩 올리고 나서 다른 입찰가와 비교하는데 걸리는 시간은 총 10만번 이므로
        // 10^4 * 10 ^ 9 총 10 ^ 14
        // 보통 1초에 1억번 연산을 한다고 가정할시에는 불가능한 숫자 입니다.
        // 그래서 최적화 할수 있는 방법을 찾아야 합니다.
        // 솔루션 1 : 이렇게 하면 어떨까요 ?
        // 총 10억 이라는 숫자에서 중간에서 찾아 들어가는 이분탐색을 시작하는 겁니다.
        // 처음에는 5억 근사치에서 시작을 하게 되면 log(10 ^ 9)가 걸리게 됩니다.
        // 그리고 각각 비교를 하는데 걸리는 시간 10^4 이 걸리게 되면 총 시간 복잡도는 10^4 * log(10 ^9)이 되어 약 30만정도가 됩니다.
        // 비교하는 시간을 최적화 할 수 있는 방법이 있을까요 ?
        // 비교하는 시간을 최적화 한다면 문제는 조금 더 어려워 질것입니다.
        // 이는 다음번에 알아 보도록 하겠습니다.

        // 솔루션 설명
        // 이분탐색을 위해 중간값을 구합니다. 우선 생각해 볼수 있는 것으로 B[i]가 최대 10억이므로
        // 돈이 많다면 K개 만큼 입찰을 하게 될수 있습니다.
        // 그러면 총 10억 이므로 0원에서부터 10억원 까지 추가 입찰가를 생각해 보아야 합니다.
        // 그리고 문제에서 "최소 정수 X" 를 출력해야 하기 때문에 최대한 최적화된 값을 가져야 겠죠 .
        // 그렇다면 (lo + 1 < hi) 이분탐색을 시작하고
        // isAvailableK(mid)를 하였을 때 만족 한다면 충분히 입찰 할수 있다는 뜻 이므로 입찰가를 낮춰야합니다. (hi = mid)
        // 반대 상황이라면 돈이 살짝 부족하므로 (lo = mid)가 되겠죠 .
        // 그렇게 되면 결과값은 FFFFFFFFFFFTTTTTTTTTTTTTTT가 될것입니다. 저희는 T의 가장 최소값을 가져야 하므로 lo와 hi중 hi를 고르면 되는 것이죠
        // 참 그리고 lo + 1 = hi인 상태가 됩니다.

        // 이렇게 반복하다보면 값이 나오게 됩니다.
        long lo = -1, hi = 10_000_000_000L;
        // 0을 포함하려면 -1 을 해야한다.
        long mid;
        while (lo + 1 < hi) {
            mid = (lo + hi) / 2;
            if (isAvailableK(mid)) hi = mid;
            else lo = mid;
        }


        System.out.println(hi);

    }

    private static boolean isAvailableK(long mid) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] + mid >= b[i]) count++;
        }
        return count >= K; // K개 만큼 입찰 가능
    }

}
