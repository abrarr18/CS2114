// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * This is LinkedStack class
 * which implements StackInterface
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 * @param <T>
 *        Works as a type parameter 
 *
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode;
    private int size;

    /**
     * Default constructor
     */
    public LinkedStack() {
        topNode = null;
    }


    /**
     * size method
     * 
     * @return size as an integer
     */
    public int size() {
        return size;
    }


    /**
     * This method clears the whole linked stack
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;

    }


    /**
     * This method checks if the stack is empty
     * 
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * This method
     * 
     * @return the top element of stack without popping
     */
    @Override
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();

        }

        return topNode.getData();
    }


    /**
     * This method removes the top element and
     * 
     * @return it
     */
    @Override
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T dt = topNode.getData();
        topNode = topNode.next;
        size--;

        return dt;
    }


    /**
     * This method takes
     * 
     * @param anEntry
     *            pushes it on the linked stack
     * 
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry);
        newNode.setNextNode(topNode);
        // topNode = newNode.setNext;
        topNode = newNode;
        size++;

    }


    /**
     * This method
     * 
     * @return a string representation of values
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node<T> p = topNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }

    /**
     * This is private Node class
     * 
     * @author Abrar Islam (abrarr18)
     * @version 2020.10.20
     * @param <T>
     *            works as type parameter
     */
    private class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * Constructor of Node class
         * 
         * @param dataPortion
         *            takes as parameter
         */
        public Node(T dataPortion) {
            this(dataPortion, null);
        }


        /**
         * Overloaded constructor of Node class which takes
         * 
         * @param dataPortion
         *            indicates the data
         * @param linkPortion
         *            indicates the link
         */
        public Node(T dataPortion, Node<T> linkPortion) {
            data = dataPortion;
            next = linkPortion;
        }


        /**
         * This method sets the next node
         * 
         * @param nextNode
         *            Takes as parameter
         */
        public void setNextNode(Node<T> nextNode) {
            next = nextNode;

        }


        /**
         * This method
         * 
         * @return next
         *         which is next node
         */
        public Node<T> getNextNode() {
            return next;
        }


        /**
         * This method
         * 
         * @return data
         */
        public T getData() {
            return data;
        }
    }

}
