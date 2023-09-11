package question2;

import nodes.Node;

// 2.1 & 2.2
public class Stack {
    private Node top;
    private int minElement;

    public Stack() {
        this.top = null;
    }

    public void pushHelper(Stack stack, int x) {
        // If stack is empty we perform push and set value to min element, then return
        if (top == null) {
            stack.push(x);
            minElement = x;
            System.out.println("Pushed " + x);
            return;
        }

        // If there's already elements in the stack we need to determine whether the element is bigger or smaller than min element
        if (x < minElement) {
            stack.push(2 * x - minElement);
            minElement = x;
        } else {
            stack.push(x);
        }

        System.out.println("Pushed " + x);
    }

    public void push(int x) {
        Node newNode = new Node(x);

        // We need to change the top pointer
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
    }

    public void popHelper(Stack stack) {
        int poppedValue = stack.pop();
        System.out.print("Popped ");

        // Check whether the min element needs to change
        if (poppedValue < minElement) {
            System.out.println(minElement);
            minElement = 2 * minElement - poppedValue;
        } else {
            System.out.println(poppedValue);
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }

        // We need to change the top pointer and return the popped value
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    public void getMin() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Min element is " + minElement);
        }
    }

    public void printStack() {
        Node current = top;
        System.out.print("Stack content from top to bottom: ");

        while (current != null) {
            if (current.data < minElement) {
                // If condition is true, it means min element stores the value of the top element
                System.out.print(minElement + " ");
            } else {
                System.out.print(current.data + " ");
            }
            current = current.next;
        }
        System.out.println();
    }
}