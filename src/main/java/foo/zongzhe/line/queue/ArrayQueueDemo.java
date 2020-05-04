package foo.zongzhe.line.queue;

import java.util.Scanner;

/**
 * 使用多种方法数组来模拟队列，包括环形和非环形。
 */

public class ArrayQueueDemo {

    static final int QUEUE_SIZE = 5;
    static ArrayQueueNoCircle arrayQueueNoCircle;

    public static void main(String[] args) {

        // 创建队列
        initialArrayQueues();

        // 判断是否为空
        checkIsEmpty();

        // 添加一个元素
        addOneElement(3);


        // 接收用户输入，模拟队列生成环境
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        showWelcomeMsg();

        while (true) {
            String input = scanner.nextLine();
            parseInput(arrayQueueNoCircle, input, scanner);
        }

    }



    private static void initialArrayQueues() {
        arrayQueueNoCircle = new ArrayQueueNoCircle(QUEUE_SIZE);
    }

    private static void checkIsEmpty() {
        System.out.println("arrayQueueNoCircle isEmpty? " + arrayQueueNoCircle.isEmpty());
    }

    private static void addOneElement(int elementValue) {
        arrayQueueNoCircle.addElement(elementValue);
    }

    private static void parseInput(ArrayQueueNoCircle arrayQueueNoCircle, String input, Scanner scanner) {
        switch (input) {
            case "s":
                arrayQueueNoCircle.showElements();
                break;
            case "e":
                scanner.close();
                System.exit(0);
                break;
            case "a":
                System.out.println("请输入一个整数");
                int newElementInt = scanner.nextInt();
                arrayQueueNoCircle.addElement(newElementInt);
                break;
            case "h":
                try {
                    int res = arrayQueueNoCircle.getFirstElement();
                    System.out.println("头部的数据是：" + res);
                } catch (Exception e) { // 这里的try-catch是必要的，因为业务端要负责处理异常
                    System.out.println(e.getMessage());
                }
                break;
            case "g":
                try {
                    int res = arrayQueueNoCircle.takeElement();
                    System.out.println("取出的数据是：" + res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("未定义的操作，请重新输入");
                showWelcomeMsg();
                break;
        }
    }

    private static void showWelcomeMsg() {
        System.out.println("s(show): 显示队列");
        System.out.println("e(exit): 退出程序");
        System.out.println("a(add): 添加数据到队列");
        System.out.println("h(head): 获得队列头数据");
        System.out.println("g(get): 从队列取出数据");
    }
}
