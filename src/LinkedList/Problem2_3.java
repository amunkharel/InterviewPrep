package LinkedList;

import myLibrary.LinkedListNode;

//Adding two lists without the recursion and just by using loop
public class Problem2_3 {
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


        LinkedListNode sol = addLists(n1,n4);

        System.out.println(sol.printForward());

    }


    public static LinkedListNode addLists(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode a = n1, b = n2, curr = head;
        int value = 0, carry = 0;
        while (a != null || b != null) {
            int x = a != null ? a.data : 0;
            int y = b != null ? b.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new LinkedListNode(sum % 10);
            curr = curr.next;
            if( a != null) a = a.next;
            if (b != null) b = b.next;
        }

        if (carry > 0) {
            curr.next = new LinkedListNode(carry);
        }
        return head.next;
    }
}
