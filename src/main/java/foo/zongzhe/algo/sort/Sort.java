package foo.zongzhe.algo.sort;

public abstract class Sort {
    public int[] array;
    public String sortDesc = "Sort";

    public Sort(int[] array) {
        this.array = array;
    }

    public abstract void sort();

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(boolean sorted) {
        if (!sorted){
            System.out.print("Initial array for " + sortDesc + ": ");
        }else{
            System.out.print("Sorted by " + sortDesc + ": ");
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
