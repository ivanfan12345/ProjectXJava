import java.util.NoSuchElementException;

/**
 * Created by Ivan on 11/22/2014.
 */
public class IvanStack {

    private int[] array;
    private int[] minArray;
    private int size = 0;
    private int minSize = 0;

    //Constructor
    public IvanStack(int capacity){
        array = new int[capacity];
        minArray = new int[capacity];
    }

    public void push(int item){
        if( size == array.length) {
            throw new IllegalStateException("Cannot add elements because stack is full dumbass");
        }
        array[size++] = item;
        if(minSize == 0)
        {
            minArray[0] = item;
            minSize++;
        }
        else
        {
            //Check to see if item is less than what's on top of MinArray.
            if(item < minArray[minSize - 1] )
            {
                minArray[minSize] = item;
                minSize++;
            }
            else
            {
                minArray[minSize] = minArray[minSize - 1];
                minSize++;
            }
        }
    }

    public int pop(){
        if(size == 0){
            throw new NoSuchElementException("Cannot pop off empty stack dumbass");
        }
        int result = array[size - 1];
        array[--size] = Integer.MIN_VALUE; //actually pop element
        minArray[--minSize] = Integer.MIN_VALUE;
        return result;
    }

    public int peek(){
        if(size == 0){
            throw new NoSuchElementException("Cannot peek into empty stack dumbass.");
        }

        //Return element on top of the stack.
        return array[size - 1];
    }

    public int getMin(){
        return minArray[minSize -1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

}
