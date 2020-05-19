package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class InsSort {
    int[] nums = {53, 3, 542, 91, 748, 14, 214, 2};

    public static void main(String[] args) {
        InsSort sort = new InsSort();
        sort.InsSort();
        ArrayUtil.printArray(sort.nums);
    }

    /**
     * 基本思想：
     * 把n个待排序的元素看称为一个有序表和一个无序表。
     * 开始时有序表只包含一个元素，无序表中包含n-1个元素
     * 排序过程中每次从无序表中取出第一个元素，把它的排序码一次与有序表元素的排序码进行比较，并插入到适当的位置，使之称为新的有序表。
     */
    public void InsSort() {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int insertValue = nums[j];
            while(j>0 && nums[j-1]>insertValue){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = insertValue;
        }
    }
}
