package leetcode.com;

import java.util.List;

public class GenerateParentheses {
    public static void solve(List<String> res, String str, int openDeps, int closeDeps) {
        if (openDeps == 0 && closeDeps == 0)
            res.add(str);
        if (openDeps > 0)
            solve(res, str + "(", openDeps - 1, closeDeps);
        if (openDeps < closeDeps)
            solve(res, str + ")", openDeps, closeDeps - 1);
    }
}
