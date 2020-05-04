package foo.zongzhe.line.queue;

public class ArrayQueueNoCircle {
    private int maxSize; // 表示数组最大容量
    private int front; // 表示队列头
    private int rear; // 表示队列尾
    private int[] arr; // 用于存放数据，模拟队列
    private String ArrayQueueDesc = "ArrayQueueNoCircle";

    /**
     * 创建队列构造器
     */

    public ArrayQueueNoCircle(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部
        rear = -1;
        System.out.println(String.format("%s initialized. start = %d, end = %d", ArrayQueueDesc, front, rear));
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean 队列是否为空
     */
    public boolean isEmpty() {
//        return front == -1; // 这个不行，因为可以中途取出数据之后，array变成了空
        return front == rear;
    }

    /**
     * 添加数据到队列
     *
     * @param element 数据
     */
    public void addElement(int element) {
        if (isFull()) {
            System.out.println(String.format("%s is full, no values are allowed to add", ArrayQueueDesc));
            return;
        } else {
            rear++;
            arr[rear] = element;
            System.out.println(String.format("%s added one element. start = %d, end = %d", ArrayQueueDesc, front, rear));
        }
    }

    /**
     * 从队列中取出元素
     *
     * @return 元素的值
     */
    public int takeElement() {
        if (isEmpty()) {
            throw new RuntimeException(String.format("%s is empty, no values are able to retrieve", ArrayQueueDesc));
        } else {
            front++;
            return arr[front];
        }
    }

    /**
     * 遍历队列
     */
    public void showElements() {
        if (isEmpty()) {
            System.out.println(String.format("%s is empty, no values are able to show", ArrayQueueDesc));
        } else {
            System.out.print("遍历队列：");
//            for (int i = front + 1; i <= rear; i++) { // 不这么写是因为front可能为-1
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 获得队列头部数据，但并不将其取出
     */
    public int getFirstElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获得头部数据");
        } else {
            return arr[front + 1];
        }
    }

}
