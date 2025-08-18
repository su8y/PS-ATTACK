package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    Node(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public void insertNode(int nxtData) {
        if (data > nxtData) {
            if (leftNode == null)
                leftNode = new Node(nxtData);
            else
                leftNode.insertNode(nxtData);
        } else if (data < nxtData) {
            if (rightNode == null)
                rightNode = new Node(nxtData);
            else
                rightNode.insertNode(nxtData);
        }
    }
}

public class 이진검색트리 {
    static List<Integer> ret = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while ((input = br.readLine()) != null) {
            root.insertNode(Integer.parseInt(input));
        }
        postOrder(root);
        ret.stream().forEach(System.out::println);

    }

    private static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.leftNode);
            postOrder(root.rightNode);
            ret.add(root.data);
        }
    }
}