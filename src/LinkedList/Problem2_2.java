package LinkedList;

import myLibrary.LinkedListNode;

public class Problem2_2 {
    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(2);
        LinkedListNode n2 = new LinkedListNode(4);
        LinkedListNode n3 = new LinkedListNode(3);
        n1.setNext(n2);
        n2.setPrevious(n1);
        n2.setNext(n3);
        n3.setPrevious(n2);
        System.out.println(n1.printForward());

        LinkedListNode n4 = new LinkedListNode(5);
        LinkedListNode n5 = new LinkedListNode(6);
        LinkedListNode n6 = new LinkedListNode(4);

        n4.setNext(n5);
        n5.setPrevious(n4);
        n5.setNext(n6);
        n6.setPrevious(n5);
        System.out.println(n4.printForward());


        LinkedListNode sol = addLists(n1,n4, 0);

        System.out.println(sol.printForward());

    }

    public static LinkedListNode addLists(LinkedListNode n1, LinkedListNode n2, int carry) {
        if(n1 == null && n2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        LinkedListNode result = new LinkedListNode();
        if(n1 != null) {
            value += n1.data;
        }

        if(n2 != null) {
            value += n2.data;
        }
        result.data = value % 10;

        if(n1 != null || n2 != null) {
            LinkedListNode more = addLists(n1 == null ? null : n1.next,
                                           n2 == null ? null : n2.next,
                                           value >= 10 ? 1 : 0);
            result.setNext(more);
        }

        return result;
    }

}
