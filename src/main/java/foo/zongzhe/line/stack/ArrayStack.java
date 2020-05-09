package foo.zongzhe.line.stack;

/**
 * 利用数组实现栈的操作
 */
public class ArrayStack extends Stack {
    private int[] stack;

    public ArrayStack(int maxSize) {
        super(maxSize);
        stack = new int[maxSize];
        this.maxSize = maxSize;
        top = -1;
        stackDesc = "ArrayStack";
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 压栈
     *
     * @param value
     */
    @Override
    public void push(int value) {
        if (isFull()) {
            System.out.println(stackDesc + " is full, unable to push value");
        } else {
            top++;
            stack[top] = value;
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException(stackDesc + " is empty, unable to pop value");
        } else {
            int value = stack[top];
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
            for (int i = top; i >= 0; i--) { // 这里的顺序不要反了！
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }

    }
}
