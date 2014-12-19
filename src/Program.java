import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

import IvanPackages.LinkedListNode;
import IvanPackages.TreeNode;
import IvanPackages.IvanUtils;
import java.awt.*;


public class Program {

    public static void main(String[] args)
    {
        SortingSearching SortingSearching   = new SortingSearching();
        ArraysAndStrings ArraysAndStrings   = new ArraysAndStrings();
        LinkedListProblems linkedListShit = new LinkedListProblems();
        TreesGraphs TreeGraphsAndShit       = new TreesGraphs();
        Recursion RecursionShit             = new Recursion();
        StacksQueues StacksQueuesAndShit    =  new StacksQueues();
        IvanStack minStack                = new IvanStack(5);
        IvanSorts ivan                      = new IvanSorts();
        Moderate modIvan                    = new Moderate();
        IvanHeapSort ivanshit = new IvanHeapSort();

        int[] vals = {1, 2, 3, 4};
        LinkedListNode head1 = new LinkedListNode(vals[0], null, null);
        LinkedListNode list1 = head1;
        for (int i = 1; i < vals.length; i++) {
            list1 = new LinkedListNode(vals[i], null, list1);
        }

        list1 = head1;

        while(list1 != null)
        {
            System.out.print("->" + list1.data);
            list1 = list1.next;
        }

        System.out.println("");
        System.out.println("========================");

        head1 = linkedListShit.reverseLinkedListRecursive(head1, null);


        list1 = head1;

        while(list1 != null)
        {
            System.out.print("->" + list1.data);
            list1 = list1.next;
        }

        head1 = linkedListShit.reverseLinkedList(head1);

        System.out.println("");
        System.out.println("========================");

        list1 = head1;

        while(list1 != null)
        {
            System.out.print("->" + list1.data);
            list1 = list1.next;
        }



        //RecursionShit.getPermutations2("" ,"ABCD");


        //System.out.println("Distance: " + TreeGraphsAndShit.findDistanceInTree(root,4,10));
        //System.out.println("Distance: " + TreeGraphsAndShit.findDistanceInTree(root,4,6));
        //System.out.println("Distance: " + TreeGraphsAndShit.findDistanceInTree(root,3,4));
        //System.out.println("Distance: " + TreeGraphsAndShit.findDistanceInTree(root,2,4));



//        for(int x : shit)
//        {
//            System.out.print(x + " ");
//        }

//int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] data = {-99, 10, 10, -1};
  //      int[] poop = SortingSearching.findLargestSubArraySum(data);

    //    for(int i : poop)
      //  {
        //    System.out.print(" " + i );
       // }


/**********
 *
 *
 *         int[][] matrix1 = { {1,2,3,4},
 {1,2,3,4},
 {1,2,3,4},
 {1,2,3,4}};

 IvanUtils.printMatrix(matrix1);
 System.out.println("=====================================");
 ArraysAndStrings.rotateArray(matrix1 , matrix1.length);
 System.out.println("=====================================");

 IvanUtils.printMatrix(matrix1);
 *        int size = 5;

 ArrayList<Point> path = new ArrayList<Point>();
 boolean success = RecursionShit.getPath(1,1, path);
 if (success) {
 String s = IvanUtils.listOfPointsToString(path);
 System.out.println(s);
 } else {
 System.out.println("No path found.");
 }
 int[] data = { 1 , 2,3,4};



 for(int x : data)
 {
 System.out.print(" " + x);
 }

 ivanshit.heapSort(data);

 System.out.println("===========================================");

 for(int x : data)
 {
 System.out.print(" " + x);
 }
 *
 *
 *         TreeNode root = new TreeNode(8);
 root.left = new TreeNode(3);
 root.right = new TreeNode(14);
 root.left.left = new TreeNode(1);
 root.left.right = new TreeNode(500);
 root.right.left = new TreeNode(11);
 root.right.right =  new TreeNode(17);

 System.out.println(TreeGraphsAndShit.isValid(root));
 *
 *         TreeNode root = new TreeNode(8);
 root.left = new TreeNode(3);
 root.right = new TreeNode(10);
 root.left.left = new TreeNode(1);
 root.left.right = new TreeNode(6);
 root.right.left = new TreeNode(9);
 root.right.right = new TreeNode(14);
 *
 *         //int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
 int[] data = {99, 10, 10, -1};
 SortingSearching.findLargestSubArraySum(data);
 *
 *         int[] shit =  {12, 3, 4, 1, 6, 9,23,0,-2,26,23};
 ArrayList<ArrayList<Integer>> shitList =  modIvan.find3Sum(shit , 24);
 for(ArrayList<Integer> x : shitList)
 {
 for(int y : x)
 {
 System.out.print(" " + x);
 }
 System.out.println(" ");
 }
 *
 *         int[] random = new int[9];
 for(int i = 0 ; i < 9 ; i++)
 {
 random[i] = IvanUtils.randomIntInRange(0 , 100);
 }


 for(int x : random)
 {
 System.out.print(" " + x);
 }

 System.out.println("");

 ivanshit.heapSort(random);

 System.out.println("===========================================");

 for(int x : random)
 {
 System.out.print(" " + x);
 }


 *
 *
 *         System.out.println(modIvan.isPalindrome(21122112));
 *        int[] random = new int[25];

 for(int i = 0 ; i < 25 ; i++)
 {
 random[i] = IvanUtils.randomIntInRange(0 , 100);
 }


 for(int x : random)
 {
 System.out.print(" " + x);
 }

 System.out.println("");

 ivan.quickSort2(random, 0, random.length - 1);

 System.out.println("===========================================");

 for(int x : random)
 {
 System.out.print(" " + x);
 }

 *
 *
 *
 *         ArrayList<String> penis = RecursionShit.getPermutations("abc");

 for(String X : penis)
 {
 System.out.println(X);
 }
 *
 *         TreeNode root = new TreeNode(5);
 root.left = new TreeNode(3);
 root.right = new TreeNode(1);
 root.left.left = new TreeNode(4);
 root.left.right = new TreeNode(8);
 root.right.left = new TreeNode(2);
 root.right.right = new TreeNode(6);
 TreeGraphsAndShit.findSum(root, 8);
 *
 *        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 TreeNode root = TreesGraphs.arrayToBST(array);
 System.out.println(TreeGraphsAndShit.isBST(root));
 *
 *
 *         int[] random = {17,11,1,1,5,9,7,5,388,8,48,6,1,2,3,-1,5,18};

 for(int x : random)
 {
 System.out.print(" " + x);
 }

 System.out.println("");

 ivan.quicksort(random, 0 , random.length-1);

 System.out.println("===========================================");

 for(int x : random)
 {
 System.out.print(" " + x);
 }

 *
 *
 *        IvanQueueOnStacks<Integer> shit = new IvanQueueOnStacks<Integer>();
 shit.enque(1);
 shit.enque(2);
 shit.enque(3);
 shit.deque();
 shit.enque(4);
 shit.enque(5);
 shit.enque(6);
 shit.enque(7);
 shit.deque();


 int size = shit.size();
 for(int i = 0 ; i < size ; i++)
 {
 System.out.println("Deque: " + shit.deque());
 }

 *
 *         Stack<Integer> unsorted = new Stack<Integer>();
 unsorted.push(7);
 unsorted.push(2);
 unsorted.push(14);
 unsorted.push(7);
 unsorted.push(5);
 unsorted.push(1);
 unsorted.push(13);

 Stack<Integer> sortedStack = StacksQueuesAndShit.sortStack(unsorted);

 *     minStack.push(5);
 System.out.println("Min: " + minStack.getMin());
 minStack.push(10);
 System.out.println("Min: " + minStack.getMin());
 minStack.push(1);
 System.out.println("Min: " + minStack.getMin());
 minStack.push(7);
 System.out.println("Min: " + minStack.getMin());

 //int value;


 StacksQueues.StackWithMin stack = new StacksQueues.StackWithMin();

 for(int i = 0; i < 15 ; i++)
 {

 int value = IvanUtils.randomIntInRange(0 , 100);
 stack.push(value);
 System.out.print("Pushed: " + value);
 System.out.print(" Min: " + stack.getMin());
 System.out.println("");
 }

 System.out.println("=======================");

 for(int i = 0 ; i < 15 ; i++)
 {
 System.out.println("Popped: " + stack.pop());
 System.out.println("New Min: " + stack.getMin());
 }

 *
 * int nrows = 10;
 int ncols = 10;
 //int[][] matrix1 = IvanUtils.randomMatrix(nrows, ncols, 0, 100);

 int[][] matrix1 = { {1,2,3,4},
 {1,2,3,4},
 {1,2,3,4},
 {1,2,3,4}};

 IvanUtils.printMatrix(matrix1);
 System.out.println("=====================================");
 ArraysAndStrings.rotateArray(matrix1 , matrix1.length);
 System.out.println("=====================================");

 IvanUtils.printMatrix(matrix1);
 *
 *         System.out.println(ArraysAndStrings.reverseCharArray("penis wrinkle"));
 *             int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 TreeNode root = IvanUtils.createTreeFromArray(nodes_flattened);
 //ArrayList<LinkedList<TreeNode>> list = TreeGraphsAndShit.BFScreateLevelLinkedList(root);
 //TreeGraphsAndShit.printResult(list);
 int sum = TreeGraphsAndShit.sumTree(root);
 System.out.println("Sum is: " + sum);
 *
 *
 *  Scanner in =  new Scanner(System.in);

 int[] data = {1,3,5,6,7,9,11,12,13,14,14,15,16};

 System.out.println("Index at: " + SortingSearching.getIndexInArrayUsingBinarySearch(data, 17));

 *
 int[] data2 = {1,1,2,5,6,7};
 *         int[] data2 = {5,6,7,1,1,3,4};
 System.out.println(ArraysAndStrings.determineIfRotated(data , data2));
 *
 *
 *        TreesGraphs.Graph g = TreeGraphsAndShit.createNewGraph();
 TreesGraphs.Node[] n = g.getNodes();
 TreesGraphs.Node start = n[3];
 TreesGraphs.Node end = n[5];
 System.out.println(TreeGraphsAndShit.determineIfRouteExists(g, start, end));
 *        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 TreeNode root = IvanUtils.createTreeFromArray(nodes_flattened);
 ArrayList<LinkedList<TreeNode>> list = TreeGraphsAndShit.BFScreateLevelLinkedList(root);
 TreeGraphsAndShit.printResult(list);

 * AMAZON
 *
 *
 *         ArrayList<Integer> shit = new ArrayList<Integer>();
 shit.add(5);
 shit.add(15);
 shit.add(1);
 shit.add(1);
 shit.add(19);
 int[] pair = SortingSearching.findSumToValue(shit , 20);
 for(int x : pair)
 {
 System.out.print("[" + x + "]");
 }

 *        int[] vals = {1, 2, 3, 4, 7, 8};
 LinkedListNode head1 = new LinkedListNode(vals[0], null, null);
 LinkedListNode list1 = head1;
 for (int i = 1; i < vals.length; i++) {
 list1 = new LinkedListNode(vals[i], null, list1);
 }

 int[] vals2 = {1, 2, 3, 7, 8, 9 ,10,11,12};
 LinkedListNode head2 = new LinkedListNode(vals[0], null, null);
 LinkedListNode list2 = head2;
 for (int i = 1; i < vals2.length; i++) {
 list2 = new LinkedListNode(vals2[i], null, list2);
 }

 LinkedListNode mergerd = LinkedListShit.mergeSortedList(head1 , head2);

 LinkedListNode itterator = mergerd;
 while(itterator != null)
 {
 System.out.print( " " + itterator.data );
 itterator = itterator.next;
 }

 *         System.out.println(StacksQueuesAndShit.parenValidator("()"));
 System.out.println(StacksQueuesAndShit.parenValidator("(())"));
 System.out.println(StacksQueuesAndShit.parenValidator(")()("));
 System.out.println(StacksQueuesAndShit.parenValidator("())("));
 System.out.println(StacksQueuesAndShit.parenValidator("(()())"));
 System.out.println(StacksQueuesAndShit.parenValidator("((((((()))))))"));
 System.out.println(StacksQueuesAndShit.parenValidator("((((())"));
 System.out.println(StacksQueuesAndShit.parenValidator("()()()()()()"));
 *
 *
 *         int[] a = {4, 5, 6, 7, 0, 1, 2};

 System.out.println(SortingSearching.findElementInRotatedArray(a, 0, a.length - 1, 6));
 *
 *         ArrayList<String> list = RecursionShit.printValidParentheses();
 for(String s : list)
 {
 System.out.println(s);
 }
 System.out.println(list.size());



 int numberOfSteps = 5;

         for(int i = 0 ; i < numberOfSteps ; i++)
         {
         long timer1 = System.currentTimeMillis();
         int[] map = new int[numberOfSteps +1];

         for(int j = 0 ; j < map.length ; j++)
         {
         map[j] = -1;
         }

         int c1 = RecursionShit.countWaysDP(i, map);
         long timer2 = System.currentTimeMillis();
         long timeElapsed = timer2-timer1;

         long timer3 =  System.currentTimeMillis();
         int c2 = RecursionShit.calculateUpStairsPermutations(i);
         long timer4 = System.currentTimeMillis();
         long timeElapsed2 = timer4-timer3;

         System.out.println("Number of steps: " + i + " " + c1 + " " + c2 + " " + timeElapsed + " " + timeElapsed2);


 }


******************
        int[] array = {1,2,3,4,5,6,7,8,9,10,11};

        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root?" + root.data);
        System.out.println("Is balanced? " + TreeGraphsAndShit.determineIfTreeIsBalanced(root));

        // Could be balanced, actually, but it's very unlikely...
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(IvanUtils.randomIntInRange(0, 100));
        }
        System.out.println("Root? " + unbalanced.data);
        System.out.println("Is balanced? " + TreeGraphsAndShit.determineIfTreeIsBalanced(unbalanced));




        int list_length = 99;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = LinkedListShit.returnBeginingOfCircularLinkedList(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
*/
        try
        {
            System.in.read();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
