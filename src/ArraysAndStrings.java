import IvanPackages.IvanUtils;
import IvanPackages.TreeNode;

import java.util.*;
import java.lang.String;

/**
 * Created by Ivan on 10/29/2014.
 *
 * 1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures? p
 1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null- terminated string. pg 17 3
 1.3 Given two strings, write a method to decide if one is a permutation of the other. pg 174
 1.4 Write a method to replace all spaces in a string with'%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string. (Note: if imple- menting in Java, please use a character array so that you can perform this opera- tion in place.)
 EXAMPLE
 Input: "Mr John Smith
 Output: "Mr%20Dohn%20Smith"
 ^ __ pg 1?5
 1.5 Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the orig- inal string, your method should return the original string. pg176
 1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place? pg 179
 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 1.8 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, si and s2, write code to check if s2 is a rotation of si using only one call to isSubstring (e.g.,"waterbottle"is a rota- tion of "erbottlewat"
 *
 *
 */
public class ArraysAndStrings {

    //Write a function to detect if two strings are anagrams of each other.
    public Boolean detectIfAnagram(String str1 , String str2)
    {
        if(str1.length() == str2.length())
        {
            char[] charArr1 =  str1.toCharArray();
            char[] charArr2 =  str2.toCharArray();

            Arrays.sort(charArr1);
            Arrays.sort(charArr2);

            for(int i = 0 ; i < charArr1.length ; i++)
            {
                if(charArr1[i] == charArr2[i])
                {
                    //Grats...DO NOTHING!@!!
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }



    //1.1 Implement a function to deteremine if a string has all unique characters. What if you cannot use additional data structures.
    public boolean isUniqueChars(String str)
    {
        if(str.length() > 128)
        {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length() ; i++)
        {
            int val = str.charAt(i);
            if(char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    //1.2 Implment a function void reverse(char* str) in C or C++ which reverses a null-terminated string.


    //char[] data = new char[] { A , B , C , D , \0 }
    public String reverseCharArray(String str )
    {
        char[] reverseString =  str.toCharArray();
        for(int i = 0 , j = reverseString.length - 1 ; i < reverseString.length / 2 ; i++ , j-- )
        {
           char temp = reverseString[i];
            reverseString[i] = reverseString[j];
            reverseString[j] =  temp;
        }
        return new String(reverseString);
    }

    //1.3 Given two strings , write a method to decide if one is a permutation of the other.

    public boolean isPermutation(String str1 , String str2)
    {
        if(str1.length() !=  str2.length())
        {
            return false;
        }
        else
        {
            return sortString(str1).equals(sortString(str2));
        }
    }

    public String sortString(String s)
    {
        char[] data = s.toCharArray();
        Arrays.sort(data);
        String newString;
        newString = data.toString();
        return newString;
    }

//Write a method to replace all spaces in a string %20.


    //Input: "Hello my name is Ivan Fan"
    public String replaceAllSpaces(String str)
    {
        StringBuilder sb = new StringBuilder();
        char[] charArray =  str.toCharArray();
        for(char x : charArray)
        {
            if( x == ' ')
            {
                sb.append("%20");
            }
            else
            {
                sb.append(x);
            }
        }
        return sb.toString();
    }

    // 1.4 Write a method to replace all spaces in a string with'%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string. (Note: if imple- menting in Java, please use a character array so that you can perform this opera- tion in place.)
    //EXAMPLE
    //Input: "Mr John Smith
    //Output: "Mr%20Dohn%20Smith"
    public String replaceWhiteSpaces(String str)
    {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for(char x : charArray)
        {
            if(x == ' ')
            {
                //Replace with %20
                sb.append("%20");
            }
            else
            {
                sb.append(x);
            }
        }
        return sb.toString();
    }


    //1.5 Implement a method to perform basic string compression using the counts or repeated chars. For example , the string aabcccccaaa would become a2b1c5a3.
    public String compressString(String str)
    {
        String newStr = "";
        char last = str.charAt(0);
        int count = 1;

        //aabcccccaaa
        for(int i = 1 ; i < str.length() ; i++)
        {
            if(str.charAt(i) == last)
            {
                count++;
            }
            else
            {
                newStr += last + "" + count;
            }
            last = str.charAt(i);
            count = 1;
        }
        return newStr + last + count;
    }
    //1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place? pg 179

    public void rotateArray(int[][]data , int n)
    {
        for(int layer = 0 ; layer < n/2 ; ++layer )
        {
            int first = layer;
            int last = n - 1 - layer;
            System.out.println("################ LAYER ####################");
            System.out.println("first (layer): " + layer );
            System.out.println("last (n - 1 - layer): " + last);
            System.out.println("layer: " + layer);
            System.out.println("n: " + n);
            System.out.println("###########################################");


            for(int i = first ; i < last ; ++i)
            {

                int offset = i - first;
                int top = data[first][i]; //save top
                System.out.println("*************************************");
                System.out.println("offset (i - first): " + offset);
                System.out.println("top (data[first][i]): " + top);
                System.out.println("first (layer): " + layer );
                System.out.println("last (n - 1 - layer): " + last);
                System.out.println("i: " + i);
                System.out.println("*************************************");

                IvanUtils.printMatrix(data);
                System.out.println("=====================================");

                // left -> top
                data[first][i] = data[last-offset][first];
                System.out.println("left -> top: data[first][i] = data[last-offset][first]");
                System.out.println("[" + first + "][" + i + "] = [" + (last - offset) +"][" + first + "]");
                IvanUtils.printMatrix(data);
                System.out.println("=====================================");

                // bottom -> left
                data[last-offset][first] = data[last][last - offset];

                System.out.println("bottom -> left: data[last-offset][first] = data[last][last - offset]");
                System.out.println("[" + (last - offset) + "][" + first + "] = [" + last +"][" + (last - offset) + "]");
                IvanUtils.printMatrix(data);
                System.out.println("=====================================");
                // right -> bottom
                data[last][last - offset] = data[i][last];
                System.out.println("right -> bottom: data[last][last - offset] = data[i][last]");
                System.out.println("[" + last + "][" + (last - offset) + "] = [" + i +"][" + last + "]");
                IvanUtils.printMatrix(data);
                System.out.println("=====================================");
                // top -> right
                data[i][last] = top; // right <- saved top
                System.out.println("top -> right : data[i][last] = top");
                System.out.println("[" + i + "][" + last + "] = [" + top +"]");
                IvanUtils.printMatrix(data);
                System.out.println("=====================================");
            }

        }
    }

    //Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

    public int[][] generateSquareSpiralMatrix(int n)
    {
        int[][] matrix = new int[n][n];

        if (n == 0)
        {
            return new int[0][0];
        }



        // intitalize indexes and end indexes
        int beginX=0;
        int beginY = 0;
        int endX = n -1;
        int endY = n - 1;

        int current = 1;

        while(current <= n *n)
        {
            //top left -> top right
            for(int col = beginX ; col <= endX ; col++)
            {
                matrix[beginY][col] = current++;
            }
            beginY++;
            //top right ->bottom right
            for(int row = beginY ; row <=endY ; row++)
            {
                matrix[row][endX] = current++;
            }
            endX--;
            //bottom right -> bottom left
            for (int col=endX; col>=beginX; col--)
            {
                matrix[endY][col]=current++;
            }
            endY--;
            //bottom left -> top left
            for (int row=endY; row>=beginY; row--)
            {
                matrix[row][beginX]=current++;
            }
            beginX++;
        }
        return matrix;
    }

    //1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

    public int[][] setZerosInMatrix(int[][] matrix)
    {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length;j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        // Nullify rows
        for (int i = 0; i < row.length; i++)
        {
            if (row[i])
            {
                nullifyRow(matrix, i);
            }
        }
        // Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j])
            {
                nullifyColumn(matrix, j);
            }
        }
        return matrix;
    }


    private static void nullifyRow(int[][] matrix, int row)
    {
        for (int j = 0; j < matrix[0].length; j++)
        {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int col)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][col] = 0;
        }
    }



    //Find first non-repeating character ina  given string

    public Character findFirstNonRepeatingChar(String str)
    {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        int length = str.length();
        for(int i = 0 ; i < length ; i++)
        {
            Character c = str.charAt(i);
            if(ht.containsKey(c))
            {
                //Already exist so increment counter
                ht.put(c,ht.get(c) + 1);
            }
            else
            {
                //Does not exist so add it to ht
                ht.put(c,1);
            }
        }
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(ht.get(str.charAt(i)) == 1)
            {
                return str.charAt(i);
            }
        }
        return null;
    }

    //Find the most frequent integer in an array

    public int findMostFrequent(int[] data)
    {
        Map<Integer , Integer> hm = new HashMap<Integer,Integer>();

        for(int i : data)
        {
            if(hm.containsKey(i))
            {
                hm.put(i,hm.get(i) +1);
            }
            else
            {
                hm.put(i,1);
            }
        }

        int maxKey = -1;
        int maxValue = -1;

        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            if(entry.getValue() > maxValue)
            {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        return maxKey;
    }

    //Given 2 integer arrays, determine if the 2nd array is a rotated version of the 1st array. Ex. Original Array A={1,2,3,5,6,7,8} Rotated Array B={5,6,7,8,1,2,3}

    public boolean determineIfRotated(int[] A , int[] B)
    {
        int indexA = 0;
        for(int i = 0 ; i < B.length ; i++)
        {
            if(A[indexA] == B[i])
            {
                //int j = i;
                for(int j = i ; j < B.length ; j++ )
                {
                    if(A[indexA] == B[j])
                    {
                        //GOOD
                    }
                    else
                    {
                        return false;
                    }
                    indexA++;
                }
                for(int j = 0 ; j < i ; j++)
                {
                    if(A[indexA] == B[j])
                    {
                        //GOOD
                    }
                    else
                    {
                        return false;
                    }
                    indexA++;
                }
                return true;
            }
        }
        return false;
    }

    //Find the common elements of 2 int arrays

    public int[] findCommonElements(int[] A , int[] B)
    {
        ArrayList<Integer> commonElements = new ArrayList<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        //Add all elements of array A into HS
        for(int x : A)
        {
            hs.add(x);
        }
        //check hs if any elements in array B exist , if so add it to commonElements Array
        for(int x : B)
        {
            if(hs.contains(x))
            {
                commonElements.add(x);
            }
            else
            {
                //no one cares
            }
        }

        int[] output = new int[commonElements.size()];
        for(int i=0;i < output.length ; i++)
        {
            output[i] = commonElements.get(i);
        }
        return output;
    }
    //Find the only element in an array that only occurs once.

    public int findElementOccursOnce(int[] data)
    {
        Hashtable<Integer,Integer> hm = new Hashtable<Integer, Integer>();
        for(int x : data)
        {
            if(hm.containsKey(x))
            {
                //incremeent count
                hm.put(x , hm.get(x) + 1);
            }
            else
            {
                hm.put(x,1);
            }
        }
        Set<Integer> keys = hm.keySet();
        for(int x : keys)
        {
            if(hm.get(x) == 1)
            {
                return x;
            }
            else
            {
                //do nothing
            }
        }
        return -1;
    }


    /**
     * The FizzBuzz Challenge: Display numbers from 1 to x, replacing the word 'fizz' for multiples of 3, 'buzz'
     * for multiples of 5 and 'fizzbuzz' for multiples of both 3 and 5. Th result must be:1 2 fizz 4 buzz fizz
     * 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16
     */

    public static void fizzBuzz(int x)
    {
        for(int i = 1 ; i < x ; i++)
        {
            if(i%3 == 0 && i%5 != 0 )
            {
                System.out.println(i + " : Fizz");
            }
            else if(i%5 == 0&& i%3 != 0)
            {
                System.out.println(i + " : Buzz");
            }
            else if(i%5 == 0&& i%3 == 0)
            {
                System.out.println(i + " : FizzBuzz");
            }
            else
            {
                System.out.println(i);
            }
        }
    }
}
