package foo.zongzhe.data_structure.line.queue;

public class ArrayQueueNoCircle extends ArrayQueue {

    /**
     * 创建队列构造器
     */
    public ArrayQueueNoCircle(int queueSize) {
        super(queueSize);
        this.arraySize = queueSize;
        array = new int[arraySize];
        start = -1; // 指向队列头部
        end = -1;
        arrayQueueDesc = "ArrayQueueNoCircle";
        System.out.println(String.format("%s initialized. start = %d, end = %d", arrayQueueDesc, start, end));
    }

    /**
     * 判断队列是否满
     */
    @Override
    public boolean isFull() {
        return end == arraySize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean 队列是否为空
     */
    @Override
    public boolean isEmpty() {
//        return front == -1; // 这个不行，因为可以中途取出数据之后，array变成了空
        return start == end;
    }

    /**
     * 添加数据到队列
     *
     * @param element 数据
     */
    @Override
    public void addElement(int element) {
        if (isFull()) {
            System.out.println(String.format("%s is full, no values are allowed to add", arrayQueueDesc));
        } else {
            end++;
            array[end] = element;
            System.out.println(String.format("%s added one element %d. start = %d, end = %d", arrayQueueDesc, element, start, end));
        }
    }

    /**
     * 从队列中取出元素
     *
     * @return 元素的值
     */
    @Override
    public int takeElement() {
        if (isEmpty()) {
            throw new RuntimeException(String.format("%s is empty, no values are able to retrieve", arrayQueueDesc));
        } else {
            start++;
            return array[start];
        }
    }

    /**
     * 遍历队列
     */
    @Override
    public void showElements() {
        if (isEmpty()) {
            System.out.println(String.format("%s is empty, no values are able to show", arrayQueueDesc));
        } else {
            System.out.print("Iterating " + arrayQueueDesc + ": ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 获得队列头部数据，但并不将其取出
     */
    public int getFirstElement() {
        if (isEmpty()) {
            throw new RuntimeException(String.format("%s is empty, no values are able to retrieve", arrayQueueDesc));
        } else {
            return array[start + 1];
        }
    }

}
