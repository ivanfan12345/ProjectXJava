import java.util.*;
import java.awt.*;
/**
 * Created by Ivan on 10/29/2014.
 *
     * 9.1 A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs. p g 316
     9.2 Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down. How many possible paths are there for the robot to go from (0,0) to (X,Y)?
     FOLLOW UP
     Imagine certain spots are "off limits," such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
     P9 317
     9.3 A magic index in an array A[0.. .n-1] is defined to be an index such that A[i] = i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
     FOLLOW UP
     What if the values are not distinct?
     _ pg 319
     9.4 Write a method to return all subsets of a set.
     pg 321
     9.5 Write a method to compute all permutations of a string.
     pg.324
     CrackingTheCodinglnterview.com 109
     Chapter 9 | Recursion and Dynamic Programming
     9.6 Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
     EXAMPLE
     Input: 3
     Output: ((())), (()()), (())(), ()(()), ()()()
     P9 325
     9.7 Implement the "paint fill" function that one might see on many image editing programs. That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding area until the color changes from the original color. P
     9.8 Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), write code to calculate the number of ways of repre- senting n cents. pg 3 28
     9.9 Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the same row, column or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board. P
     9.10 You have a stack of n boxes, with widths w., heights hir and depths drThe boxes cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly larger than the box above it in width, height, and depth. Implement a method to build the tallest stack possible, where the height of a stack is the sum of the heights of each box. pg 3 3 3
     9.11 Given a boolean expression consisting of the symbols 0,1, &, |, and A, and a desired boolean result value result, implement a function to count the number of ways of parenthesizing the expression such that it evaluates to result.
     EXAMPLE
     Expression: 1A01011
     Desired result: false (0)
     Output: 2 ways. 1A( (010) 11) and 1A(91 (011)).

 *
 */
public class Recursion {

    //Write a method to generate the nth Fibonacci Number
    //Recursive
    //1 , 1 , 2 , 3 , 5 , 8 , 13 , 21 , 34 , 55 , 89.
    public int getNthFibNumRecursion(int nthNum)
    {
        if(nthNum == 0 ) return 0;
        if(nthNum == 1 ) return 1;

        return ( getNthFibNumRecursion(nthNum - 1 ) + getNthFibNumRecursion( nthNum - 2));
    }

    public int getNthFibNumIterative(int nthNum)
    {
        if(nthNum == 0 ) return 0;
        if(nthNum == 1 ) return 1;

        int prevPrev = 0;
        int prev = 1;
        int result = 0;

        for(int i = 2 ; i < nthNum ; i++)
        {
            result = prev + prevPrev;
            prevPrev = prev;
            prev = result;
        }
        return result;
    }

    //Write a method to print out all the fib numbers to the Nth element.

    public void printFibbonacci(int n)
    {

    }

    //9.1 A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
    // Implement a method to count how many possible ways the child can run up the stairs. p g 316

    public  int countWaysDP(int n , int[] map)
    {
        if(n < 0) return 0;
        else if(n == 0) return 1;
        else if(map[n] > -1) return map[n];
        else
        {
            map[n] = countWaysDP(n - 1 , map) + countWaysDP(n - 2 , map) + countWaysDP(n - 3 , map);
            return map[n];
        }
    }


    //9.2 Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down. How many possible paths are there for the robot to go from (0,0) to (X,Y)?
    public static int[][] maze = new int[10][10];

    public static boolean isFree(int x , int y)
    {
        if(maze[x][y] == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public boolean getPath(int x , int y , ArrayList<Point> path )
    {
        //If out of bounds or not avaialbe , return false
        if(y < 0 || x < 0 ){
            return false;
        }

        boolean isAtOrigin = ((x ==0) &&(y==0));

        //If there's a path from the stat to my current location , add my location.
        if( isAtOrigin || getPath(x,y-1,path) || getPath(x-1,y ,path)){
            Point p = new Point(x,y);
            path.add(p);
            return true;
        }
        return false;

    }




    /**
     9.3 A magic index in an array A[0.. .n-1] is defined to be an index such that A[i] = i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
     FOLLOW UP
     What if the values are not distinct?
     */


    //9.5 Write a method to compute all permutations of a string of unique characters

    public ArrayList<String> getPermutations(String str)
    {
        if(str == null) return null;

        ArrayList<String> permutations = new ArrayList<String>();
        //Base Case
        if(str.length() == 0)
        {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get first character
        String remainder = str.substring(1);  // remove first character
        ArrayList<String> words = getPermutations(remainder);
        for(String x : words)
        {
            for(int j = 0; j <= x.length() ; j++)
            {
                String s = insertCharAt(x , first , j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void getPermutations2(String prefix , String str)
    {
        System.out.println("==========================");
        System.out.println("Prefix: " + prefix + " str: " + str);
        int length = str.length();

        if( length == 0) // Base Case
        {
            System.out.println("*************************");
            System.out.println("Permutation: " + prefix);
        }
        else
        {
            for(int i = 0 ; i < length ; i++)
            {
                getPermutations2(prefix + str.charAt(i) , str.substring(0,i) + str.substring(i+1));
            }
        }
    }


    /**
    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first character
        String remainder = str.substring(1); // remove the first character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

     **/

    public int calculateUpStairsPermutations(int numberOfSteps)
    {
        if(numberOfSteps < 0)
        {
            return 0;
        }
        else if(numberOfSteps == 0)
        {
            return 1;
        }
        else
        {
            return calculateUpStairsPermutations(numberOfSteps - 1) + calculateUpStairsPermutations(numberOfSteps - 2) + calculateUpStairsPermutations(numberOfSteps - 3);
        }
    }

    //9.6 Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
    //EXAMPLE
    //Input: 3
    //Output: ((())), (()()), (())(), ()(()), ()()()


    public ArrayList<String> printValidParentheses(int nPairs)
    {
        char[] str = new char[nPairs*2];
        ArrayList<String> list = new ArrayList<String>();
        addParentheses(list , nPairs , nPairs , str , 0);
        return list;
    }

    public void addParentheses(ArrayList<String> list , int leftRem , int rightRem , char[] str , int count)
    {
        //checks for invalid state
        if(leftRem < 0 || rightRem < leftRem)return;

        if(leftRem == 0 && rightRem ==0) //all out of parenthesis you are done...so copy the string and add it to the list of cases
        {
            String s = String.copyValueOf(str);
            list.add(s);
        }
        else
        {
            if(leftRem > 0) //Try a left parentheses , if there are some avaliable.
            {
                str[count] = '(';
                addParentheses(list , leftRem -1 , rightRem , str , count + 1);
            }
            if(rightRem > leftRem) //Try a right parenthese , if there's a matching left
            {
                str[count] = ')';
                addParentheses(list , leftRem , rightRem -1 , str , count + 1);
            }
        }
    }

    //Write fibbonaci iteratively and recursively (bonus: use dynamic programming)

    public int fibIterative(int n)
    {
        if(n == 1 || n == 2)
        {
            return 1;
        }
        int fib1 = 1;
        int fib2 = 1;
        int fibonacci = 1;

        for(int i = 3 ; i <= n ; i++)
        {
            fibonacci =  fib1 + fib2;
            fib1 =  fib2;
            fib2 = fibonacci;
        }
        return fibonacci;
    }
    //DP
    public long fibDP(int n)
    {
        long[] results = new long[n + 1];
        results[1] = 1;
        results[2] = 1;

        for(int i = 3 ; i <= n ; i++)
        {
            results[i] = results[i-1] + results[i-2];
        }
        return results[n];
    }


}
