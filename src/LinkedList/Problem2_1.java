package LinkedList;

import myLibrary.LinkedListNode;
import java.lang.Math;

//This solution does not pass all test cases for the problem.
// Since Integer can only be added until a certain point without overflowing
public class Problem2_1 {
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


        LinkedListNode sol = addNumbers(n1,n4);

        System.out.println(sol.printForward());

    }

    public static LinkedListNode addNumbers(LinkedListNode n1, LinkedListNode n2) {

        int num1 = returnNumberFromReverseLinkedList(n1);
        int num2 = returnNumberFromReverseLinkedList(n2);

        int return_num = num1 + num2;
        LinkedListNode sol = returnLinkedListToNumber(return_num);

        return sol;
    }

    public static LinkedListNode returnLinkedListToNumber (int num) {
        LinkedListNode first = new LinkedListNode(num % 10, null, null);
        num = num / 10;
        LinkedListNode head = first;
        LinkedListNode second = first;
        while (num > 0) {
            second = new LinkedListNode(num % 10, null, null);
            num = num /10;
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        return  head;
    }

    public static int returnNumberFromReverseLinkedList(LinkedListNode n) {
        int num = 0;
        int counter = 0;
        LinkedListNode runner = n;
        while (runner != null) {
            num += runner.data * Math.pow(10, counter);
            counter++;
            runner = runner.next;
        }
        return num;
    }
}
