package foo.zongzhe.line.queue;

public abstract class ArrayQueue {
    public int start; // 标记头元素，但是位置可变，详见各实现类
    public int end; // 标记末元素，但是位置可变，详见各实现类
    public int maxSize;
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

}
