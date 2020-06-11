package foo.zongzhe.data_structure.tree;

/**
 * 数组的存储方式和树的存储方式的转换
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder();
    }
}

class ArrBinaryTree {
    private int[] arr; // 存储数据的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载
    public void preOrder() {
        preOrder(0);
    }

    /**
     * 编写一个方法，完成顺序存储二叉树的前序遍历
     *
     * @param index
     */
    public void preOrder(int index) {
        // 检查数组是否为空
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
        }
        // 输出当前元素
        System.out.println(arr[index]);
        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
