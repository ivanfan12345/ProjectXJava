import java.util.Stack;
import java.util.Arrays;
/**
 * Created by Ivan on 12/1/2014.
 *      (^_^)
 */
public class IvanHeapSort {

    private static int size;
    /* Sort Function */
    public static void heapSort(int arr[])
    {
        heapify(arr);
        for (int i = size; i > 0; i--)
        {
            swap(arr,0, i);
            size = size-1;
            maxheap(arr, 0);
        }
    }
    /* Function to build a heap */
    public static void heapify(int arr[])
    {
        size = arr.length-1;
        for (int i = size/2; i >= 0; i--)
            maxheap(arr, i);
    }
    /* Function to swap largest element in heap */
    public static void maxheap(int arr[], int i)
    {
        int left = 2*i +1 ;
        int right = 2*i + 2;
        int max = i;
        if (left <= size && arr[left] > arr[i]) //Flip this for min -> max
            max = left;
        if (right <= size && arr[right] > arr[max]) //flip this for min ->max
            max = right;

        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
