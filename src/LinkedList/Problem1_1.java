//Remove Duplicate from a LinkedList
package LinkedList;

import myLibrary.LinkedListNode;

import java.util.HashSet;

public class Problem1_1 {
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = first;

        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i%2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        removeDup(head);
        System.out.println(head.printForward());
    }

    //Remove duplicates without Buffer
    public static void removeDuplicates(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();

        LinkedListNode previous = null;

        while (n != null) {
            if(set.contains(n.data)) {
                previous.next = n.next;
            }
            else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
    //Remove duplicates without Buffer
    public static void removeDup(LinkedListNode n) {
        LinkedListNode current = n;

        while (current != null) {
            LinkedListNode runner = current;

            while (runner.next != null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

    }
}
