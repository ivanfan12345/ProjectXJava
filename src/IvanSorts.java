import java.util.*;

/**
 * Created by Ivan on 11/23/2014.
 */
public class IvanSorts {

    //Selection Sort O(N^2)
    // 11, 1 , 7 ,4 ,12,3,5,1
    public void selectionSort(int[] data)
    {
        for(int i = 0; i < data.length - 1 ; i++ )
        {
            int smallestIndex = 0;
            int smallestValue = Integer.MAX_VALUE;
            for(int j = i ; j < data.length ; j++) //Find smallest element and index
            {
                if(data[j] < smallestValue)
                {
                    smallestIndex = j;
                    smallestValue = data[j];
                }
            }
            selectionSortSwap(data , i , smallestIndex );
        }
    }

    private static void selectionSortSwap(int[] data , int first , int second)
    {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    //Insertion Sort O(N^2)
    public void insertionSort(int[] data)
    {
        int length =  data.length;
        for(int j = 1; j < length ; j++)
        {
            int key = data[j];
            int i = j -1;
            while((i > -1) && (data[i] > key))
            {
                data[i+1] = data[i];
                i--;
            }
            data[i+1] = key;
        }
    }

    //Bubble Sort O(N^2)
    public void bubbleSort(int[]data)
    {
        int length = data.length;
        int k;

        for(int m = length; m >= 0 ; m--)
        {
            for(int i = 0 ; i < length -1 ; i++)
            {
                k = i + 1;
                if(data[i] > data[k])
                {
                    //swap
                    bubbleSortSwap(i , k , data);
                }
            }
        }
    }

    private static void bubbleSortSwap(int i , int j , int[] data)
    {
        int temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //Merge Sort O(n log(n))
    public static int[] MergeSort(int[] data )
    {
        if( data.length == 1 ) return data;
        int[] left = Arrays.copyOfRange(data, 0 , data.length/2);
        int[] right = Arrays.copyOfRange(data , data.length/2 , data.length);
        left = MergeSort(left);
        right = MergeSort(right);
        return merge(left, right);
    }
    public static int[] merge(int[] first, int[] second)
    {
        int firstIndex = 0;
        int secondIndex = 0;
        int i = 0;
        int[] mergedArray = new int[first.length + second.length];

        while(firstIndex < first.length && secondIndex < second.length)
        {
            if(first[firstIndex] < second[secondIndex])
            {
                mergedArray[i++] = first[firstIndex++];
            }
            else
            {
                mergedArray[i++] = second[secondIndex++];
            }
        }
        while(firstIndex < first.length)
        {
            mergedArray[i++] = first[firstIndex++];
        }
        while(secondIndex < second.length)
        {
            mergedArray[i++] = second[secondIndex++];
        }
        return mergedArray;
    }


    //Quick Sort O(n log(n))


    public static void quicksort(int[] data , int lower , int upper)
    {
        if(lower < upper)
        {
            int pivotPoint = partition(data,lower,upper);
            quicksort(data,lower , pivotPoint - 1);
            quicksort(data, pivotPoint + 1 , upper);
        }
    }
    private static int partition(int[] data , int lower , int upper)
    {
        //median to avoid O(N^2) performance if array is already sorted.
        System.out.println("============= PARTITION ===============");
        int pivotIndex = (lower+upper)/2;
        int pivotValue = data[pivotIndex];
        System.out.println("============= "+ pivotValue +" ===============");
        printArray(data);
        quicksortSwap(data,pivotIndex,upper);
        int storeIndex = lower;
        for(int i = lower ; i < upper ; i++)
        {
            if(data[i] < pivotValue)
            {
                printArray(data);
                quicksortSwap(data,i,storeIndex);
                storeIndex++;
            }
        }
        printArray(data);
        quicksortSwap(data,storeIndex,upper);
        return storeIndex++;
    }
    private static void quicksortSwap(int[] data , int first , int second)
    {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    private static void printArray(int[] data)
    {
        for(int x : data)
        {
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    public void quickSort2(int[] data , int left , int right)
    {
        printArray(data);
        if(left < right)
        {
            int pivot = Partition(data, left, right);
            quickSort2(data , left , pivot - 1 );
            quickSort2(data , pivot + 1 , right );
        }
    }

    private int Partition(int[] data , int left , int right)
    {
        int pivot = data[right];
        int temp;
        System.out.println("============= PARTITION ===============");
        System.out.println("============= "+ pivot +" ===============");
        printArray(data);

        int i = left;
        for (int j = left; j < right; j++)
        {
            if (data[j] <= pivot)
            {
                //Swap these data[i] and data[j] bitches
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
                i++;
                System.out.println("============= "+ i +" ===============");
                printArray(data);
            }
        }

        data[right] = data[i];
        data[i] = pivot;

        return i;
    }


}
