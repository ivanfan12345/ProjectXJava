import java.util.Arrays;
import java.util.*;

/**
 * Created by Ivan on 10/29/2014.
 *
 * 17.1 Write a function to swap a number in place (that is, without temporary vari- ables). pg 430
 17.2 Design an algorithm to figure out if someone has won a game of tic-tac-toe. pg 431
 17.3 Write an algorithm which computes the number of trailing zeros in n factorial. __ pg434
 17.4 Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 *
 */
public class Moderate {

    //Deteremine if an integer is a plaindrom
    public boolean isPalindrome(int x)
    {
        //Negative numbers cannot be a palindrome
        if(x < 0) return false;

        //Find out if X is 0,10,100,1000,10000,10000 etc.
        int div = 1;
        while(x/div >= 10) {
            div = div * 10;
        }

        while(x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }

        return true;

    }

    // Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
    // If there is such a triplet present in array, then print the triplet and return true. Else return false.

    public ArrayList<ArrayList<Integer>> find3SumNaive(int[] data , int target)
    {

        Arrays.sort(data);
        int size = data.length;

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();

        for(int i = 0 ; i < size   ; i++)
        {
            for(int j = i +1 ; j < size  ; j ++)
            {
                for(int k = j + 1 ; k < size ; k++)
                {
                    if(data[i] + data[j] + data[k] == target)
                    {
                        System.out.println("Found 3 Sum: " + data[i] + " " + data[j]+ " " + data[k] );
                        current.add(data[i]);
                        current.add(data[j]);
                        current.add(data[k]);
                        results.add(current);
                        current.clear();
                    }
                }
            }
        }

        return results;
    }

    public ArrayList<ArrayList<Integer>> find3Sum(int[] data , int target)
    {

        Arrays.sort(data);
        int size = data.length;
        int left , right;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();

        for(int i = 0 ; i < size - 2   ; i++)
        {
            left =  i + 1;
            right = size -1;

            while(left < right)
            {
                if(data[i] + data[left] + data[right] == target)
                {
                    System.out.println("Found 3 Sum: " + data[i] + " " + data[left]+ " " + data[right] );
                    current.add(data[i]);
                    current.add(data[left++]);
                    current.add(data[right--]);
                    results.add(current);
                    current.clear();

                }
                else if(data[i] + data[left] + data[right] < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }

        }
        return results;
    }
}
