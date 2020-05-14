package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {8,9,1,7,2,3,5,4,6,0};
        bubble(nums);
        ArrayUtil.printArray(nums);

    }
    public static void bubble(int[] array){
        for (int i=0;i<array.length - 1;i++){
            for (int j=0; j<array.length -1-i;j++){
                if (array[j] > array[j+1]) {
                    ArrayUtil.swap(array, j, j + 1);
                }
            }
        }
    }
}
