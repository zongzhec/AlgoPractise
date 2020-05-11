package foo.zongzhe.data_structure.line.queue;

/**
 * 用数组实现循环队列思路1：
 * start为头元素所在位置，end为末元素所在位置+1
 * 数组的size = 队列的size+1
 * @see  <a href="https://blog.csdn.net/zongziczz/article/details/105921622">数组模拟环形队列的思路和思考</a>
 */
public class ArrayQueueCircle1 extends ArrayQueue {

    /**
     * 创建队列构造器
     */
    public ArrayQueueCircle1(int queueSize) {
        super(queueSize);
        this.arraySize = queueSize + 1;
        array = new int[arraySize];
        start = 0; // 指向队列头部
        end = 0;
        arrayQueueDesc = "ArrayQueueCircle1";
        System.out.println(String.format("%s initialized. start = %d, end = %d", arrayQueueDesc, start, end));
    }

    /**
     * 判断队列是否满
     */
    @Override
    public boolean isFull() {
        return start == (end + 1) % arraySize;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean 队列是否为空
     */
    @Override
    public boolean isEmpty() {
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
            array[end] = element;
            end = (end + 1) % arraySize;
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
            int res = array[start];
            start = (start + 1) % arraySize;
            System.out.println(String.format("%s took one element %d. start = %d, end = %d", arrayQueueDesc, res, start, end));
            return res;
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
            for (int i = start; i != end; i = (i + 1) % arraySize) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

}
