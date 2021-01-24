package week12;
import java.util.*;

/**
 * A first-in-first-out collection of items.
 *
 * @author Reuben
 */
public class TwoStackQueue<E> implements Queue<E>{

    /**Datafield of the left stack.*/
    public Stack<E> left = new Stack<E>();
    
    /**Datafield of the left stack.*/
    public Stack<E> right = new Stack<E>();

    /**Datafield of the size of the Queue.*/
    public int size;
    
    /**
     * Return true if and only if this Queue is empty.
     *
     * @return true if this Queue is empty, otherwise false.
     */
    public boolean isEmpty(){
        return left.isEmpty() && right.isEmpty();
    }

    /**
     * Return the length of this Queue.
     *
     * @return the number of items in this Queue.
     */
    public int size(){
        return size;
    }

    /**
     * Return the item at the front of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E get(){
        if(this.isEmpty()){
            throw new EmptyQueueException();
        }
        if(right.empty()){
            while(!left.empty()){
                right.push(left.pop());
            }
        }
        return right.peek();
    }

    /**
     * Make this Queue empty.
     */
    public void clear(){
        get();
        size = 0;
        right.clear();
    }

    /**
     * Add an item to the rear of this Queue.
     *
     * @param item the item to be added to the rear of the Queue.
     */
    public void add(E item){
        size++;
        left.push(item);
    }

    /**
     * Remove and return the front item of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E remove(){
        if(this.isEmpty()){
            throw new EmptyQueueException();
        }
        get();
        size--;
        return right.pop(); 
    }

    /**
     * Return a string representation of this queue ordered from front to back.
     *
     * @return a string representation of this Queue.
     */
    public String toString(){
        StringBuilder output = new StringBuilder("[");
        ListIterator<E> list = right.listIterator(right.size());

        while(list.hasPrevious()){
            output.append(list.previous() + ", ");
        }
        
        for(E e: left){
            output.append(e + ", " );
        }
        if(!this.isEmpty()){
            output.delete(output.length()-2, output.length());
        }
        output.append("]");
        return output.toString();
    }

    /**
       Concatonates the stacks.
       @return toString of stacks
     */
    public String debug(){
        return left.toString() + right.toString();
    }
    
}
