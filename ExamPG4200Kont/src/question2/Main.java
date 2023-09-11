package question2;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.pushHelper(stack, 5);
        stack.pushHelper(stack, 7);
        stack.pushHelper(stack, 2);
        stack.getMin();
        stack.popHelper(stack);
        stack.pushHelper(stack, 25);
        stack.getMin();
        stack.printStack();

        stack.pushHelper(stack, 1);
        stack.printStack();
        stack.pushHelper(stack, 10);
        stack.getMin();
        stack.printStack();

        stack.popHelper(stack);
        stack.popHelper(stack);
        stack.getMin();
        stack.printStack();
    }
}
