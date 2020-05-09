package foo.zongzhe.line.stack;

import java.util.ArrayList;

public class StackDemo {
    private static ArrayList<Stack> stacks;

    public static void main(String[] args) {
        StackDemo demo = new StackDemo();
        demo.initialize(3);
        demo.pushValues();
        demo.popValues();
        demo.showValues();
    }

    public void initialize(int maxValue) {
        stacks = new ArrayList<>();
        stacks.add(new ArrayStack(maxValue));
        stacks.add(new LinkedListStack(maxValue));
    }

    public void pushValues() {
        for (Stack stack : stacks) {
            stack.push(3);
            stack.push(5);
            stack.push(7);
            stack.push(9);
        }
    }

    public void popValues() {
        for (Stack stack : stacks) {
            int value = stack.pop();
            System.out.println("pop value from " + stack.stackDesc + " is: " + value);
        }
    }

    public void showValues() {
        for (Stack stack : stacks) {
            stack.showStack();
        }
    }
}
