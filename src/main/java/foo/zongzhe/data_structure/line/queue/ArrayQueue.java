package foo.zongzhe.data_structure.line.queue;

public abstract class ArrayQueue {
    public int start; // 标记头元素，但是位置可变，详见各实现类
    public int end; // 标记末元素，但是位置可变，详见各实现类
    public int arraySize;
    public int[] array;
    public String arrayQueueDesc;

    /**
     * 初始化队列
     */
    public ArrayQueue(int queueSize){

    }

    /**
     * 判断是否满了
     *
     * @return
     */
    public abstract boolean isFull();

    /**
     * 判断是否为空
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * 增加元素
     */
    public abstract void addElement(int elementValue);

    /**
     * 取出一个元素
     */
    public abstract int takeElement();

    /**
     * 显示所有元素
     */
    public abstract void showElements();


}
