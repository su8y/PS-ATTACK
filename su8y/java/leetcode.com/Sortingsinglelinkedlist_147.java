package leetcode.com;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Sortingsinglelinkedlist_147 {

//    public static void main(String[] args) {
//        ListNode a1 = new ListNode(5, null);
//        ListNode a2 = new ListNode(25, a1);
//        ListNode a3 = new ListNode(15, a2);
//        ListNode head = new ListNode(8, a3);
//
//        ListNode start = head;
//        ListNode start2 = new ListNode(0);
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
//
//        do {
//            queue.add(start);
//        } while ((start = start.next) != null);
//
//        start = queue.poll(); /// 1 next 2
//        ListNode head2 = start;
//        out.println(queue.size());
//
//        int len = queue.size();
//        for (int i = 0; i < len; i++) {
//            if (i == len - 1) {
//                queue.peek().next = null;
//            }
//            start.next = queue.poll();
//            start = start.next;
//
//        }
//
//
//    }
}
