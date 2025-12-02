package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

public class 트리순회_1991 {
    static int K, N, M, T;

    /**
     * @return
     */
    private static void preorder(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.value);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    private static void inorder(Node root, StringBuilder sb) {
        if (root == null) return;
        inorder(root.left, sb);
        sb.append(root.value);
        inorder(root.right, sb);

    }

    private static void postorder(Node root, StringBuilder sb) {
        if (root == null) return;
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node((char) ('A' + i));
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // A 라면 0
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            if (left > 0) nodes[parent].left = nodes[left];

            if (right > 0) nodes[parent].right = nodes[right];
        }
        Node root = nodes[0];
        StringBuilder sb;


        sb = new StringBuilder();
        preorder(root, sb);
        System.out.println(sb);

        sb = new StringBuilder();
        inorder(root, sb);
        System.out.println(sb);

        sb = new StringBuilder();
        postorder(root, sb);
        System.out.println(sb);

        bw.close();
        br.close();
    }

    static class Node {
        Node left;
        Node right;
        char value;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
}