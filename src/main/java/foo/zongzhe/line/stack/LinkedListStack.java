package foo.zongzhe.line.stack;

import java.util.LinkedList;

public class LinkedListStack extends Stack {
    private LinkedList<Integer> stackLinkedList;

    public LinkedListStack(int maxSize) {
        super(maxSize);
        stackLinkedList = new LinkedList<>();
        stackDesc = "LinkedListStack";
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return stackLinkedList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return stackLinkedList.size() == maxSize;
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            System.out.println(stackDesc + " is full, unable to push value");
        } else {
            stackLinkedList.add(value);
            top++;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException(stackDesc + " is empty, unable to pop value");
        } else {
            int value = stackLinkedList.removeLast();
            top--;
            return value;
        }
    }

    @Override
    public void showStack() {
        if (isEmpty()) {
            System.out.println(stackDesc + " is empty, unable to show");
        } else {
            System.out.println(stackDesc + " to iterate");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackLinkedList.get(i) + " ");
            }
            System.out.println();
        }
    }
}
