package foo.zongzhe.line.queue;

import java.util.ArrayList;

/**
 * 使用多种方法数组来模拟队列，包括环形和非环形。
 */

public class ArrayQueueDemo {

    static ArrayList<ArrayQueue> arrayQueues;

    public static void main(String[] args) {

        // 创建队列
        int queueSize = 5;
        initialArrayQueues(queueSize);

        // 判断是否为空
        checkIsEmpty();

        // 添加一个元素
        int[] values = {3};
        addElements(values);
        showElements();

        // 再次判断是否为空
        checkIsEmpty();

        // 连续添加多个元素直至满元素
        int[] values2 = {5, 2, 4, 5};
        addElements(values2);
        showElements();

        // 判断队列是否满了
        checkIsFull();

        // 取出多个元素
        takeElement(2);

        // 再次添加一个元素，查看队列是否可以循环利用
        int[] values3 = {3};
        addElements(values3);

        // 再次判断队列是否满了
        checkIsFull();

        // 展示全部元素
        showElements();

    }


    private static void initialArrayQueues(int queueSize) {
        arrayQueues = new ArrayList<>();
//        arrayQueues.add(new ArrayQueueNoCircle(queueSize)); // 加一个ArrayQueueNoCircle
        arrayQueues.add(new ArrayQueueCircle1(queueSize)); // 加一个ArrayQueueCircle1
    }

    private static void checkIsEmpty() {
        for (ArrayQueue arrayQueue : arrayQueues) {
            System.out.println(String.format("%s isEmpty? %b", arrayQueue.arrayQueueDesc, arrayQueue.isEmpty()));
        }

    }

    private static void addElements(int[] elementValues) {
        for (ArrayQueue arrayQueue : arrayQueues) {
            for (int elementValue : elementValues) {
                arrayQueue.addElement(elementValue);
            }
        }
    }

    private static void checkIsFull() {
        for (ArrayQueue arrayQueue : arrayQueues) {
            System.out.println(String.format("%s isFull? %b", arrayQueue.arrayQueueDesc, arrayQueue.isFull()));
        }
    }

    private static void takeElement(int elementNumber) {
        for (ArrayQueue arrayQueue : arrayQueues) {
            for (int i = 1; i <= elementNumber; i++) {
                int res = arrayQueue.takeElement();
            }
        }
    }

    private static void showElements() {
        for (ArrayQueue arrayQueue : arrayQueues) {
            arrayQueue.showElements();
        }

    }

}
