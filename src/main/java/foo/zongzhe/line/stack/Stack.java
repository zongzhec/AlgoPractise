package foo.zongzhe.line.stack;

public abstract class Stack {
    public int maxSize;
    public int top;
    public String stackDesc = "Stack";

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackDesc = "Stack";
    }

    public abstract boolean isEmpty();

    public abstract boolean isFull();

    public abstract void push(int value);

    public abstract int pop();

    public abstract void showStack();
}
