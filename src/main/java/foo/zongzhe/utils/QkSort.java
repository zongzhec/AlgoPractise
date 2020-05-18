package foo.zongzhe.utils;

public class QkSort {
    int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6};

    public static void main(String[] args) {

    }

    public void qSort(int start, int end){
        int leftIndex = start +1;
        int rightIndex = end;
        while(rightIndex>leftIndex){
            while(nums[rightIndex]>nums[start]) rightIndex--;
            while(nums[leftIndex]<nums[start]) leftIndex++;

        }
    }
}
