package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

import java.util.ArrayList;

public class RdSort {
    int[] nums = {53, 3, 542, 91, 748, 14, 214, 2};

    public static void main(String[] args) {
        RdSort sort = new RdSort();
        sort.rdSort();
        ArrayUtil.printArray(sort.nums);
    }

    private void rdSort() {
        // initialize buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // loop
        boolean hasHigherDigits = true;
        int radix = 1;
        while (hasHigherDigits) {
            hasHigherDigits = false;
            for (ArrayList<Integer> bucket : buckets) {
                bucket.clear();
            }
            for (int num : nums) {
                int pos = (num % (radix * 10)) / radix;
                if (pos > 0) hasHigherDigits = true;
                buckets.get(pos).add(num);
            }

            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (int num : bucket) {
                    nums[index] = num;
                    index++;
                }
            }
            ArrayUtil.printArray(nums);
            radix *= 10;
        }
    }
}
