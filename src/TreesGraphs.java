import IvanPackages.TreeNode;

import java.util.*;
import java.util.LinkedList;


/**
 * Created by Ivan on 10/29/2014.
 *
 *   4.1 Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one. pg 220
     4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes. pg 221
     4.3 Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
     4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
     4.5 Implement a function to check if a binary tree is a binary search tree.
     P 9 2 2 5
     4.6 Write an algorithm to find the'next'node (i.e., in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent. pg 229
     4.7 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree. pg 230
     4.8 You have two very large binary trees: Tl, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide ifT2 is a subtree of Tl.
     A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
     : :
     4.9 You are given a binary tree in which each node contains a value. Design an algo- rithm to print all paths which sum to a given value. The path does not need to start or end at the root or a leaf.

     Implement a BST with insert and delete functions

     Print a tree using BFS and DFS

     Write a function that determines if a tree is a BST

     Find the smallest element in a BST

     Find the 2nd largest number in a BST

     Given a binary tree which is a sum tree (child nodes add to parent), write an algorithm to determine whether the tree is a valid sum tree

     Find the distance between 2 nodes in a BST and a normal binary tree

     Print the coordinates of every node in a binary tree, where root is 0,0

     Print a tree by levels

     Given a binary tree which is a sum tree, write an algorithm to determine whether the tree is a valid sum tree

     Given a tree, verify that it contains a subtree.

     HARD: Find the max distance between 2 nodes in a BST.

     HARD: Construct a BST given the pre-order and in-order traversal Strings





     *
 *
 */
public class TreesGraphs {

    //4.1 Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
    // defined to be a tree such that the heights of the two subtrees of any node never differ by more than one. pg 220

    /**
    We've been fortunate enough to be told exactly what balanced means: that for each node, the two subtrees differ in ehigh by no more than one. We can implement
     a solution based on this definition.



     */
   public boolean determineIfTreeIsBalanced(TreeNode root)
   {
       //Checks if root is null.
       if(root == null)
       {
           return true;
       }


       int heightDiff = getHeight(root.left) - getHeight(root.right);

       if(Math.abs(heightDiff) > 1)
       {
           return false;
       }
       else
       {
           return determineIfTreeIsBalanced(root.left) && determineIfTreeIsBalanced(root.right);
       }
   }

    public  int getHeight(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        return Math.max(getHeight(root.left) , getHeight(root.right)) + 1;
    }

    public boolean determineIfTreeIsBalancedSmart(TreeNode root)
    {
        if(checkHeightOfTree(root) == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public int checkHeightOfTree(TreeNode root)
    {
        if(root == null) return 0; // Height of 0

        // Check if left is balanced.
        int leftHeight = checkHeightOfTree(root.left);
        if(leftHeight == -1 ) return -1; //Not balanced

        // Checj if rgiht is balanced.
        int rightHeight = checkHeightOfTree(root.right);
        if(rightHeight == -1) return -1; //Not balanced

        // Check if current node is balanced.
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1)
        {
            return -1; //NOT BALANCED
        }
        else
        {
            //Return Height
            return Math.max(leftHeight , rightHeight + 1);
        }
    }



    //4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes. pg 221

    /**
     * This problem can be solved by just simple and graph traversal , such as depth first search or BFS. We start with one of the two nodes and , during traversal , check if the other
     * node is found. We should mark any node found in the course of the algorithm as "already visted" to avoid cycles and repetition of the nodes.
     */
    public enum State
    {
        Unvisted , Visted , Visting;
    }



    public boolean determineIfRouteExists(Graph g , Node start , Node end)
    {
        if(start ==  end)
        {
            //You win at life.
            return true;
        }

        //Operates as a Queue
        LinkedList<Node> queue = new LinkedList<Node>();

        for(Node x : g.getNodes())
        {
            x.state = State.Unvisted; //Marks every node as Unvisted...need to do this before we DFS this bitch.
        }

        //Perform DFS BITCH
        start.state = State.Visted;
        queue.add(start); //Add start to queue

        Node y;

        while(!queue.isEmpty()) //Run untill queue is empty.
        {
            y = queue.removeFirst(); //get node from queue

            if(y != null)
            {
                for(Node z : y.getAdjacent())
                {
                    if(z.state == State.Visted)
                    {
                        return true;
                    }
                    else
                    {
                        z.state = State.Visting;
                        queue.add(z);
                    }
                }
            }
            y.state = State.Visted;
        }

        return false;
    }

    //Graph Classes
    public class Graph
    {
        private Node vertices[];
        public int count;

        public Graph()
        {
            vertices = new Node[6];
            count = 0;
        }

        public void addNode(Node x)
        {
            if (count < 30)
            {
                vertices[count] = x;
                count++;
            }
            else
            {
                System.out.print("Graph full");
            }
        }
        public Node[] getNodes() {
            return vertices;
        }
    }

    class Node
    {
        private Node adjacent[];
        public int adjacentCount;
        private String vertex;
        public TreesGraphs.State state;

        public Node(String vertex, int adjacentLength)
        {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new Node[adjacentLength];
        }

        public void addAdjacent(Node x)
        {
            if (adjacentCount < 30)
            {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            }
            else
            {
                System.out.print("No more adjacent can be added");
            }
        }

        public Node[] getAdjacent() {
            return adjacent;
        }
        public String getVertex() {
            return vertex;
        }
    }

    public  Graph createNewGraph()
    {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    //4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

    public ArrayList<LinkedList<TreeNode>> BFScreateLevelLinkedList(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();

        if( root != null)
        {
            current.add(root);
        }

        while(current.size() > 0 )
        {
            result.add(current); //Add Previous level
            LinkedList<TreeNode> parents = current; //Go to next level
            current = new LinkedList<TreeNode>();

            for(TreeNode parent : parents)
            {
                if(parent.left != null)
                {
                    current.add(parent.left);
                }
                if(parent.right != null)
                {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    public ArrayList<LinkedList<TreeNode>> DFScreateLevelLinkedList(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        DFScreateLevelLinkedList(root , lists , 0);
        return lists;
    }

    public void DFScreateLevelLinkedList(TreeNode root , ArrayList<LinkedList<TreeNode>> lists , int level )
    {
        if(root ==  null) return;
        LinkedList<TreeNode> list = null;

        if(lists.size() == level)//Level not contained in list
        {
            list = new LinkedList<TreeNode>();
            /* Levels are always traversed in order. So, if this is the first time we've visited level i,
			 * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */
            lists.add(list);
        }
        else
        {
            list = lists.get(level);
        }
        list.add(root);
        DFScreateLevelLinkedList(root.left , lists , level + 1);
        DFScreateLevelLinkedList(root.right , lists , level + 1);
    }

    public void printResult(ArrayList<LinkedList<TreeNode>> result)
    {
        int depth = 0;
        for(LinkedList<TreeNode> entry : result)
        {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Linked List at depth " + depth + ":");
            while(i.hasNext())
            {
                System.out.print(" " + ((TreeNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }

    //4.3 Given a sorted increasing order array with unique elements , write an algorithm to create a binary search tree with minimal height.
    public static TreeNode arrayToBST(int[] data)
    {
        return arrayToBST(data , 0 , data.length);
    }
    public static TreeNode arrayToBST(int[]data , int first , int last)
    {
        if(last < first) return null;
        int mid = (first + last)/2;
        TreeNode root = new TreeNode(data[mid]);
        root.setLeftChild(arrayToBST(data , first , mid - 1));
        root.setRightChild(arrayToBST(data , mid + 1 , last));
        return root;
    }



    /**
         * Difference between sums of odd level and even level nodes of a Binary Tree
         Given a a Binary Tree, find the difference between the sum of nodes at odd level and the sum of nodes at even level.
         Consider root as level 1, left and right children of root as level 2 and so on.

         For example, in the following tree, sum of nodes at odd level is (5 + 1 + 4 + 8) which is 18.
         And sum of nodes at even level is (2 + 6 + 3 + 7 + 9) which is 27. The output for following tree should be 18 – 27 which is -9.

           5  Level 1 odd
         /   \
        2     6  Level 2 even
       /  \     \
      1    4     8   LEvel 3 odd
          /     / \
         3     7   9  Level 4 even
     *
     *
     */

    public int sumTree(TreeNode root)
    {
        if(root == null) return 0;

        int result = root.data - sumTree(root.left) - sumTree(root.right);

        return result;
    }

    //validate if this is a BST.

    public Boolean isBST(TreeNode root)
    {
        return validate( root , Integer.MIN_VALUE , Integer.MAX_VALUE );
    }

    public boolean validate(TreeNode root , int min ,int max)
    {
        if(root == null)
        {
            return true;
        }
        // not in range
        if(root.data <= min || root.data >= max)
        {
            return false;
        }

        //Left subtree must be < root.data && right subtree must be > root.data
        return validate(root.left , min , root.data) && validate(root.right , root.data , max);
    }

    public boolean isValid(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, int MIN, int MAX) {
        if(node == null)
            return true;
        if((node.data > MIN) && (node.data < MAX) && isValidBST(node.left, MIN, Math.min(node.data,MAX)) && isValidBST(node.right, Math.max(node.data,MIN), MAX))
            return true;
        else
            return false;
    }

    //    4.9 You are given a binary tree in which each node contains a value. Design an algo- rithm to print
    //    all paths which sum to a given value. The path does not need to start or end at the root or a leaf.


    public static void findSum(TreeNode node , int target)
    {
        int depth = findDepth(node);
        int[] path = new int[depth];
        findSum(node , target , path , 0);
    }

    public static void findSum(TreeNode node , int target , int[] path , int level)
    {
        if (node == null)
        {
            return;
        }

		/* Insert current node into path */
        path[level] = node.data;

        int t = 0;
        for (int i = level; i >= 0; i--)
        {
            t += path[i];
            if (t == target)
            {
                findSumPrint(path, i, level);
            }
        }

        findSum(node.left, target, path, level + 1);
        findSum(node.right, target, path, level + 1);

		/* Remove current node from path. Not strictly necessary, since we would
		 * ignore this value, but it's good practice.
		 */
        path[level] = Integer.MIN_VALUE;
    }

    public static int findDepth(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        else
        {
            return 1 +  Math.max(findDepth(node.left) , findDepth(node.right));
        }
    }

    private static void findSumPrint(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    //Find the distance between 2 nodes in a BST and a normal binary tree
    public int findDistanceInTree(TreeNode root , int x , int y)
    {
        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();

        findPath(root, x , path1);
        findPath(root, y , path2);

        if(path1.size() == 0 || path2.size() == 0)
        {
            return -1;
        }
        int index =0;
        for(index = 0 ; index < path1.size(); index++)
        {
            if(path1.get(index) != path2.get(index))
            {
                break;
            }
        }
        int distance = path1.size() + path2.size() - 2*index;
        return distance;
    }


    public boolean findPath(TreeNode root , int value , ArrayList<TreeNode> path)
    {
        if (root == null)
        {
            return false;
        }

        path.add(root);

        if (root.data == value)
        {
            return true;
        }
        if (findPath(root.left, value, path)|| findPath(root.right, value, path))
        {
            return true;
        }

        path.remove(root);
        return false;
    }


    //print binary tree using BFS
    public static void printTreeBFS(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
        {
            queue.add(root);
        }
        while(!queue.isEmpty())
        {
            TreeNode current = queue.remove();
            System.out.println(current.data);
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }

    }

    //print binary tree using DFS
    public static void printTreeDFS(TreeNode root)
    {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();

            if(top.left != null) stack.push(top.left);
            System.out.println(top.data);
            if(top.right != null) stack.push(top.right);

        }


        System.out.println(root.data);
        printTreeDFS(root.right);
    }


    public static void printTreeRecursiveDFS(TreeNode root)
    {
        if(root == null) return;
        printTreeDFS(root.left);
        System.out.println(root.data);
        printTreeDFS(root.right);
    }

}
