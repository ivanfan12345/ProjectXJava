import IvanPackages.TreeNode;

import java.util.*;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Ivan on 10/29/2014.
 *
 * 11.1 You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order. pg 360
 11.2 Write a method to sort an array of strings so that all the anagrams are next to each other. _._ pg 361
 11.3 Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
 EXAMPLE
 Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 Output: 8 (the index of 5 in the array)
 11.4 Imagine you have a 20 GB file with one string per line. Explain how you would sort the file. pg 364
 11.5 Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
 EXAMPLE
 Input: find "ball" in {"at", "", "", "", "ball", "", "", "car", tti) tat ftf4^.j>j t(» <t»\ , aau , , )
 Output: 4
 '. pg 364
 11.6 Given an M x N matrix in which each row and each column is sorted in ascending order, write a method to find an element. pg 36S
 11.7 A circus is designing a tower routine consisting of people standing atop one another's shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.
 EXAMPLE:
 Input (ht,wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 Output:The longest tower is length 6 and includes from top to bottom:
 (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 p j 1 ? :
 11.8 Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x (the number of values less than or equal tox). Implement the data structures and algorithms to support these operations.That is, implement the method track(int x), which is called when each number is generated, and the method getRankOfNumber(int x), which returns the number of values less than or equal to x (not including x itself).
 EXAMPLE
 Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3 getRankOfNumber(l) = 0 getRankOfNumber(3) = 1 getRankOfNumber(4) = 3



 *
 *
 */
public class SortingSearching {


    // find two pairs that sum up to target.
    public int[] findSumToValue(ArrayList<Integer> data , int target)
    {
        int difference;
        int[] pair = new int[2];
        HashMap<Integer , Integer> hm = new HashMap<Integer, Integer>();

        for(int x : data)
        {
            if(hm.containsKey(x))
            {
                pair[0] = hm.get(x);
                pair[1] = x;
                return pair;
            }
            else
            {
                hm.put(target - x , x);
            }
        }
        System.out.println("NO PAIRS FOUND RETURNING NULL:");
        return null;
    }

    /***
     *
     * Given a 2-dimensional array of characters and a dictionary in which a word can be searched in O(1) time.
     * Need to print all the words from array which are present in dictionary.
     * Word can be formed in any direction but has to end at any edge of array.(Need not worry much about the dictionary)

     Input:

     a f h u n
     e t a i r
     a e g g o
     t r m l p
     Output:

     after
     hate
     hair
     air
     eat
     tea
     *
     *
     *
     *
     */

    public ArrayList<String> theIvanBoggle()
    {
        char[][] matrix = {{'a','f','h','u','n'},
                           {'e','t','a','i','r'},
                           {'a','e','g','g','o'},
                           {'t','r','m','l','p'}};

        int[][] visted = {{0,0,0,0,0},
                          {0,0,0,0,0},
                          {0,0,0,0,0},
                          {0,0,0,0,0}};

        int i , j;
        StringBuilder sb = new StringBuilder();
        for(i = 0 ; i < matrix.length; i++)
        {
            for(j = 0 ; j < matrix[0].length ; j++)
            {
                if(i > 0 && j > 0)
                {

                }
            }
        }


    }


    //11.1 You are given two sorted arrays, A and B where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.

   //


    public int[] mergeTwoSortedArrays(int[] arr1 , int[] arr2)
    {
        List<Integer> newArray = new ArrayList<Integer>();
        int index1 = 0;
        int index2 = 0;

        while((index1 < arr1.length )&&(index2 < arr2.length))
        {
            //IF they're the same.
            if(arr1[index1] == arr2[index2])
            {
                newArray.add(arr1[index1++]);
                newArray.add(arr2[index2++]);
            }
            else if(arr1[index1] < arr2[index2] ) //Arr1[index] is smaller so add it to the list next and increment.
            {
                newArray.add(arr1[index1++]);
            }
            else //arr2{index2] is smaller so add this to list and increment.
            {
                newArray.add(arr2[index2++]);
            }
        }
        while(index1 < arr1.length )
        {
            newArray.add(arr1[index1++]);
        }
        while(index2 < arr2.length )
        {
            newArray.add(arr2[index2++]);
        }

        int[] mergedArray = new int[newArray.size()];


        for(int i = 0 ; i < arr1.length ; i++)
        {
            arr1[i] = newArray.get(i);
        }

        return arr1;
    }

    //11.2  11.2 Write a method to sort an array of strings so that all the anagrams are next to each other. _._ pg 361
    public  String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public  void sort(String[] strings)
    {
        Hashtable<String, LinkedList<String>> ht = new Hashtable<String, LinkedList<String>>();
        //Group words by anagrams
        for(String s : strings)
        {
            String key = sortChars(s);
            //check if key exist in ht
            if(ht.containsKey(key))
            {
                LinkedList<String> anagrams = ht.get(key);
                anagrams.push(s);
            }
            else
            {
                ht.put(key , new LinkedList<String>());
            }
        }

        //Convert HAsh table to array
        int index = 0;
        for(String key : ht.keySet())
        {
            LinkedList<String> list = ht.get(key);
            for(String t : list)
            {
                strings[index] = t;
                index++;
            }
        }
    }

    //11.3 Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume
    //that the array was orginally sorted in increading order.

    //int[] data = {4, 5, 6, 7, 0, 1, 2}
    //11.3 Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume
    //that the array was orginally sorted in increading order.

    //int[] data = {4, 5, 6, 7, 0, 1, 2}
    public int findElementInRotatedArray(int [] data , int left, int right , int find)
    {
        int mid = (left + right)/2;
        if( find == data[mid] )
        {
            return mid;
        }
        if( right < left )
        {
            return - 1;
        }


        if(data[left] < data[mid]) //left is normally orderd
        {
            if(find >= data[left])
            {
                return findElementInRotatedArray(data , left , mid - 1 , find);
            }
            else
            {
                return findElementInRotatedArray(data , mid + 1 , right , find);
            }
        }
        else if( data[mid] < data[left]) //Right is normally orderd
        {
            if(find >= data[mid] && find <= data[right])
            {
                return findElementInRotatedArray(data ,mid + 1 , right , find);
            }
            else
            {
                return findElementInRotatedArray(data , left , mid - 1 , find);
            }
        }
        return -1;
    }


    //11.4 11.4 Imagine you have a 20 GB file with one string per line. Explain how you would sort the file. pg 364

/**
 * SOLUTION:
         Divide the file into chunks which are x megabytes each, where x is the amount of
         memory we have available. Each chunk is sorted separately and then saved back to the
         file system. Say we now have N chunks. Once all the chunks are sorted, we then merge
         the chunks one by one according to the following algorithm:

         1. Divide your memory into (N+1) parts. First N data parts are used for reading data
         from N chunks, the last one is a buffer.
         2. Load data to fill the first N data parts from N chunks respectively, perform an
         N-way merge sort to the buffer.
         3. While each data part is not empty, perform the sort. If any data part is empty, load
         new content from the according chunk.
         4. While the buffer is not full, perform the sort. If the buffer is full, write buffer
         to the disk, clear buffer.
         5. Repeat step 3-4 until all N chunks are empty.

         At the end, we have a fully sorted file.
         This algorithm is known as *external sort*.
 *
 *
 *
 *
 */



/***
 * Minyoung
         L: [(0, 1), (2, 3), (9, 10), (-5, 7)] N //List of Points
         P: (1, 1) //A single point
         K: 2

         return the K closest points to P from L
         => (0, 1), (2, 3)
 *
 *
 */

    public class Point
    {

        double x;
        double y;
        double distance;

        public Point(double d, double e)
        {
            this.x = d;
            this.y = e;
            distance = Math.sqrt(d * d + e * e);
        }

        public double getDistance()
        {
            return distance;
        }

        public String toString()
        {
            return "(" +  x + "  ," + ")";
        }
    }


    public void getKClosestPoints(ArrayList<Point> L , Point P , int k)
    {
        //Use PriorirtyQueue
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k , new ReversePointComparator());

       // for(Point )



    }


    public class ReversePointComparator implements Comparator<Point> {

        public int compare(Point p1 , Point p2) {
            return (int) (p2.getDistance() - p1.getDistance()); //change to p1 - p2 for max value.
        }
    }


    static int MAX_Priorirty_Que_Size = 100;

//Binary Sarch

    public int getIndexInArrayUsingBinarySearch(int[] array , int target)
    {
        int index = BinarySearch(array , target , 0 , array.length -1);
        return index;
    }

    public int BinarySearch(int[] array, int target , int low , int high)
    {
        if(high < low) return -1; //No bueno;
        int mid = (low + high)/2;

        if( target == array[mid])
        {
            return mid;
        }
        else if( target < array[mid])
        {
            //target exist in bottom half. BS of low -> mid -1;
            return BinarySearch(array , target , low , mid - 1);
        }
        else
        {
            //target exust ub upper half. BS of mid + 1 -> high
            return BinarySearch(array, target , mid + 1 , high);
        }
    }


    public int binarySearchIttr(int[] data , int target , int start , int end )
    {
        if(end < start) return -1;

        int mid = (start+end)/2;

        while(start <= end)
        {
            if(data[mid] == target)
            {
                return mid;
            }
            else if( target < data[mid])
            {
                //BS the first -> mid+1
                end = mid-1;
            }
            else
            {
                //BS mid+1 -> last
                start = mid +1;
            }
        }
        return -1;
    }

    //Mark Zocdoc
    public int[] findLargestSubArraySum(int[] data)
    {
        int max_overall = 0;
        int cur_max = 0;
        int startIndex = -1;
        int endIndex = -1;

        for(int i = 0; i<data.length ; i++ )
        {
           cur_max += data[i];
           if(cur_max < 0)
           {
               cur_max = 0;
               startIndex = i + 1;
           }
            else if(max_overall < cur_max)
           {
               max_overall = cur_max;
               endIndex = i;
               //startIndex = i -1;
           }
        }

        int[] newOutput = Arrays.copyOfRange(data,startIndex,endIndex);


        return newOutput;

    }






}
