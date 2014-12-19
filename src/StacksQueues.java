import java.util.Stack;

/**
 * Created by Ivan on 10/29/2014.
 *
 *   1.	Implement a stack with push and pop functions
     2.	Implement a queue with queue and dequeue functions
     3.	Find the minimum element in a stack in O(1) time
     4.	Write a function that sorts a stack (bonus: sort the stack in place without extra memory)
     5.	Implement a binary min heap. Turn it into a binary max heap.
     HARD: Implement a queue using 2 stacks

 *
 *   3.1 Describe how you could use a single array to implement three stacks.
     pg 202
     3.2 How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time. pg 206
     3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOf Stacks that mimics this. SetOf Stacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. SetOf Stacks. push() and SetOf Stacks. pop() should behave identically to a single stack (that is, popO should return the same values as it would if there were just a single stack).
     FOLLOW UP

     Implement a function popAt(int index) which performs a pop operation on a specific sub-stack. __ p g 2

     3.5 Implement a MyQueue class which implements a queue using two stacks.
     3.6 Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one additional stack to hold items,
 but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
     3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. People must adopt either the "oldest"
 (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 They cannot select which specificanimal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.You may use the built-in LinkedList data structure.

     *
 *
 *
 */
public class StacksQueues {

    //1.	Implement a stack with push and pop functions
    static int stackSize = 10;
    static int [] buffer = new int [stackSize * 3]; //create array to mimic the 3 stacks.

    // 3 stack pointers to keep track of the index of the top element
    static int [] stackPointer = {-1, -1, -1};

    public void push(int stackNum , int value )
    {
        //Find the index of the top element in the array + 1 , and increment the stack pointer.
        int index = stackNum * stackSize + stackPointer[stackNum] + 1;
        stackPointer[stackNum]++;
        buffer[index] = value;
    }

    public int pop(int stackNum)
    {
        int index =  stackNum * stackSize + stackPointer[stackNum] + 1;
        stackPointer[stackNum]--;
        int value = buffer[index];
        buffer[index] = 0;
        return value;
    }




// Google Career Cup

    /**
     *Write code to get maximum and second maximum element of a stack. The given function should be in O(1) complexity . Later extend for finding kth max in O(1).
     4,3,5,2,1

     Stack = Last In First Out
     Queue = First in First out

     Stack1     Max_Stack
     4            4
     3            5
     5
     2
     1

     */

    public int[] getKMaxOfStack(int[]data , int k)
    {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> max_stack = new Stack<Integer>();

        stack.setSize(data.length);
        //max_stack.setSize(k);//k k> max_Stack.size() : invalid give out error

        if(data.length == 0)
        {
            return null;
        }
        else
        {
            max_stack.push(data[0]);
            stack.push(data[0]);
        }

        for ( int i = 1 ; i < data.length ; i++ )
        {
            if(data[i] > max_stack.peek())
            {
                max_stack.push(data[i]);
                stack.push(data[i]);
            }
            else
            {
                stack.push(data[i]);
            }
        }

        int[] returnResult = new int[k];
        for(int i =0 ; i < k  && max_stack.size() >0 ;i++) {
            returnResult[i] = max_stack.pop();

        }
        return returnResult;
    }




//You're given an input string , write a function to check if the parenthesis are valid.

    public boolean parenValidator(String str)
    {
        char[] dataArray = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(char x : dataArray)
        {
            if(x == '(')
            {
                stack.add(x);
            }
            else
            {
                if(stack.size() == 0)
                {
                    return false;
                }
                else
                {
                    stack.pop();
                }
            }
        }
        if(stack.size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
//

    //3.2 How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time. pg 206

    public static class StackWithMin extends Stack<Integer> {
        Stack<Integer> stackMin;

        public StackWithMin(){
            stackMin = new Stack<Integer>();
        }

        public void push(int value) {

            if(value <= getMin())
            {
                //add element to min stack
                stackMin.push(value);
            }
            super.push(value);
        }

        public Integer pop() {

            int value = super.pop();
            if (value ==  getMin())
            {
                stackMin.pop();
            }
            return value;
        }

        public int getMin(){

            if(stackMin.isEmpty())
            {
                //Stack is empty return largest value known to man.
                return Integer.MAX_VALUE;
            }
            else
            {
              return   stackMin.peek();
            }
        }

        }




   // 3.4 In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower.
   // The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
   //         (1) Only one disk can be moved at a time.
   //         (2) A disk is slid off the top of one tower onto the next tower.
   //         (3) A disk can only be placed on top of a larger disk.
   // Write a program to move the disks from the first tower to the last using stacks. pg 21


//     3.5 Implement a MyQueue class which implements a queue using two stacks.




    //3.6 Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one additional stack to hold items,

    public Stack<Integer> sortStack(Stack<Integer> unsorted){
        Stack<Integer> output =  new Stack<Integer>();

        while(!unsorted.isEmpty())
        {
            int temp = unsorted.pop(); //store element in temp to see where temp needs to go in the sorted stack.

            while(!output.isEmpty() && output.peek() > temp)  //pops all the elements of output stack until temp is greater than the top of the stack. from here we can place temp onto output and keep going.
            {
                unsorted.push(output.pop()); // this actually pops all the elements from output back to unsorted until we find where temp can go.
            }
            output.push(temp); // adds temp to the sorted stack.
        }
        return output;
    }



}
