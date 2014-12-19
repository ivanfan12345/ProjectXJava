import java.util.Stack;

/**
 * Created by Ivan on 11/22/2014.
 */
public class IvanQueueOnStacks<T> {

    Stack<T> stackNewest , stackOldest;

    public IvanQueueOnStacks()
    {
        stackNewest =  new Stack<T>();
        stackOldest =  new Stack<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void enque(T value){
        stackNewest.push(value);
    }

    public T deque(){
        shiftStacks();
        return stackOldest.pop();
    }

    public T peek()
    {
        shiftStacks();
        return stackOldest.peek();
    }


	/* Move elements from stackNewest into stackOldest. This is usually done so that we can
	 * do operations on stackOldest.
	 */
    private void shiftStacks()
    {
        if (stackOldest.isEmpty())
        {
            while (!stackNewest.isEmpty())
            {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

}
