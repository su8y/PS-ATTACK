package solved.ac;

import java.io.*;

public class AC {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while (n-- != 0) {
            String macro = br.readLine();
            int m = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] split = input.split(",|\\[|\\]");
            extracted(macro, split);
        }


    }

    private static void extracted(String macro, String[] strings) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int start = 1;
        int end = strings.length;
        boolean dir = true;
        for (int i = 0; i < macro.length(); i++) {
            if (macro.charAt(i) == 'R') dir = !dir;
            else {
                if (dir) start++;
                else end--;
                if (start > end) {
                    bw.write("error\n");
                    bw.flush();
                    return;
                }
            }
            if (macro.indexOf('D', i) == -1) {
                if ((macro.length() - i) % 2 == 0) dir = !dir;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!dir) {
            sb.append("[");
            for (int i = end - 1; i >= start; i--) {
                sb.append(strings[i]);
                if (i == start) continue;
                sb.append(",");
            }
            sb.append("]\n");
            bw.write(sb.toString());
        } else {
            sb.append("[");
            for (int i = start; i < end; i++) {
                sb.append(strings[i]);
                if (i == end - 1) continue;
                sb.append(",");
            }
            sb.append("]\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }
}