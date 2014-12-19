import java.lang.Object;
import java.util.HashSet;
import java.util.Hashtable;
import IvanPackages.LinkedListNode;
import jdk.nashorn.internal.ir.WhileNode;
import java.util.Stack;

/**
 * Created by Ivan on 10/29/2014.
 *
 * 2.1 Write code to remove duplicates from an unsorted linked list.
     FOLLOW UP
     How would you solve this problem if a temporary buffer is not allowed?
     pg 184
     2.2 Implement an algorithm to find the kth to last element of a singly linked list. „ pe 1 85
     2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
     EXAMPLE
     Input: the node c from the linked list a->b->c->d->e
     Result: nothing is returned, but the new linked list looks like a- >b- >d->e pg 187
     2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. pg 188
     2.5 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the Ts digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
     EXAMPLE
     Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
     Output: 2 -> 1 -> 9.That is, 912.
     FOLLOW UP
     Suppose the digits are stored in forward order. Repeat the above problem.
     EXAMPLE
     Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
     Output: 9 -> 1 -> 2.That is, 912.
     pi
     CrackingTheCodinglnterview.com 77
     Chapter 2 | Linked Lists
     2.6 Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
     DEFINITION Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
     EXAMPLE
     Input: A ->B->C->D->E-> C [the same C as earlier]
     Output: C
     pg 1 93
     2.7 Implement a function to check if a linked list is a palindrome.
 *
 */
public class LinkedList {



    //2.1 Write code to remove duplicates from an unsorted linked list.

    public void deleteDups( LinkedListNode Node )
    {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;

        while(Node != null)
        {
            if(set.contains(Node.data))
            {
                previous.next = Node.next;
            }
            else
            {
                set.add(Node.data);
                previous = Node;
            }
            Node = Node.next;
        }
    }

    //2.2 Implement an algorithm to find the kth to last element of a singly linked list.

    public int findKthToTheLastElementInList(LinkedListNode head , int kth)
    {
        LinkedListNode node = head;
        if(node == null) return -1;

        int length = 0;
        //Find Length of List
        while(node != null)
        {
             length++;
             node = node.next;
        }

        node = head;
        for(int i = 0 ; i < length - kth ; i++)
        {
            node = node.next;
        }

        return node.data;
    }

    //2.3Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.

    public boolean deleteNode(LinkedListNode node)
    {
        if((node == null) || (node.next == null))
        {
            return false;
        }
        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    //2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
    //Create two linked list that contain
    // x = 7
    // Original List 1<->5<->4<->3<->7<->8<->9<-><->12
    // List1
    public LinkedListNode partitionLinkedListByValue(LinkedListNode head , int value)
    {
        LinkedListNode lessThan = null;
        LinkedListNode greaterThan = null;
        LinkedListNode node = head;

        if(node == null) return null;

        //Itterate through linked list until null and create two lists.
        while(node != null)
        {
            LinkedListNode next = node.next;
            if(node.data < value) //Checks to see if data is less than value
            {
                //Insert Node into start of before list.
                node.next = lessThan;
                lessThan = node;
            }
            else
            {
                //Insert Node into front of after list
                node.next = greaterThan;
                greaterThan = node;
            }
            node = next;
        }

        //Merge lessThan and greaterThan
        if(lessThan == null)
        {
            return greaterThan;
        }

        head = lessThan;
        while(lessThan.next != null)
        {
            lessThan = lessThan.next;
        }
        lessThan.next = greaterThan;
        return head;

    }


    //2.6 Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
    //DEFINITION Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
    //EXAMPLE
    //This will only work for UNIQUE ELEMENTS IN THE LIST.
    //Input: A ->B->C->D->E-> C [the same C as earlier]
    //Output: C

    public LinkedListNode returnBeginingOfCircularLinkedList(LinkedListNode head)
    {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        //find where these two bitches meet.

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast)
            {
                //They've been found
                break;
            }
        }

        //Error check - there is no meeting point , and therefore no loop.
        if(fast == null || fast.next == null)
        {
            return null;
        }

        slow = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
    //2.7 Implement a function to check if a linked list is a palindrome.
    public boolean checkifLLisPalindrome(LinkedListNode head)
    {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack();


        //Itterate through half of the loop and add half of the list into a stack.
        while(fast != null && fast.next != null)
        {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //Check to see if it has a odd number of elements , if so  skip the midde
        if(fast != null)
        {
            slow = slow.next;
        }

        while(slow != null)
        {
            int top = stack.pop().intValue();
            if(top != slow.data)
            {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    //Given two linked list of different lengths write a function to merge the two linked list
    /**
     * 1. Merge two sorted singly linked list into single one sorted list.

         List1: Tail->1->2->3->4->7->8->TAIL
         List2: Head->1->2->3->7->8->9->10->11->12->TAIL

         LinkedListNode

         output finalstList = {1,1,2,2,3,3,4,7,7,8,9,10,11,12}
     *
     *
     */

    public LinkedListNode mergeSortedList(LinkedListNode head1 , LinkedListNode head2)
    {
        LinkedListNode list1 = head1;
        LinkedListNode list2 = head2;

        LinkedListNode fakeHead = new LinkedListNode(0 , null , null);
        LinkedListNode p = fakeHead;

        while(list1 !=null && list2 != null)
        {
            if(list1.data <= list2.data)
            {
                p.next = list1;
                list1 = list1.next;
            }
            else
            {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if(list1 != null)
        {
            p.next = list1;
        }
        if(list2 != null)
        {
            p.next = list2;
        }

        return fakeHead;

    }

    /** LEET CODE
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.

         For example:
         Given 1->2->3->4->5->NULL, m = 2 and n = 4,

         return 1->4->3->2->5->NULL.

         Note:
         Given m, n satisfy the following condition:
         1 ≤ m ≤ n ≤ length of list.
     *
     */

    public static LinkedListNode reverseLinkedList2(LinkedListNode head , int a , int b)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        LinkedListNode prev = new LinkedListNode();
        prev.next = head;
        head = prev;

        LinkedListNode n1 = head;

        int c = a -1;

        while(c > 0)
        {
            n1 = n1.next;
            c--;
        }

        prev = n1;
        n1 = n1.next;
        c = b - a;

        while(n1.next != null && c > 0) {

            LinkedListNode temp = n1.next;
            n1.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            c--;
        }
        return head.next;
    }

/**
 * You are given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
     i.e. if the given linked list is: 1->2->3->4->5 and k is 3,
     the list should be modified to: 4->5->1->2->3.
 *
 *
 */

    public static LinkedListNode rotateListByKNodes(LinkedListNode head , int k)
    {
        if(k==0) return head;

        LinkedListNode current = head;
        int counter = 1;
        while(counter < k && current != null)
        {
            current = current.next;
            counter++;
        }

        if(current == null) return head;

        LinkedListNode KthNode = current;

        while(current.next != null)
        {
            current = current.next;
            current.next = head;
            head = KthNode.next;
            KthNode.next = null;
        }

        return head;
    }

/**
 *  Given a linked list and a number k. Reverse every k nodes in the list.

     Example :

     Input 1->2->3->4->5->6 and k = 2
     Output 2->1->4->3->6->5
 *
 */

    public  LinkedListNode reverseKNodes(LinkedListNode head , int k)
    {
        LinkedListNode a = head;
        LinkedListNode b = null;
        LinkedListNode c;

        int count = 0;

        while(a != null && count < k)
        {
            c = b;
            b = a;
            a = a.next;
            b.next = c;
            count++;
        }
        if(a != null)
        {
            head.next = reverseKNodes(a , k);
        }

        return b;
    }

    public LinkedListNode reverseLinkedList(LinkedListNode head)
    {
        LinkedListNode current , prev , next;
        current = head;
        prev = null;
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }



}
