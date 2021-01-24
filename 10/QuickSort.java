package week10;

/**
 *  A selection sorter  implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class QuickSort extends Sorter {
    
    /**
     *  Create a new Selection sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }
    
    /**
     * calls the Sort class to sort  the integers.
     (which are stored in the parent Sorter class).
    */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        quick(0, nums.length-1);
    }
    
    /**
     * Sort the integers recursively.
     (which are stored in the parent Sorter class).
     @param left of nums.
     @param right of nums.
    */
    public void quick(int left, int right){
        if(left < right){
            int x = part(left, right);
            quick(left, x-1);
            quick(x+1, right);
        }   
    }
    
    /**
     * partitions the sorted piles of integers with left, right;
     (which are stored in the parent Sorter class).
     @param left of nums.
     @param right of nums.
     @return int of partition.
    */
    public int part(int left, int right){
        i = left;
        j = i-1;
        int k = nums[right];
        int temp = 0;
        for (i = left; i < right; i++){
            comparisons++;
            if(nums[i] < k){
                j++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                update();
            }
        }
        j++;
        temp = nums[j];
        nums[j] = nums[right];
        nums[right] = temp;
        comparisons++;
        update();
        return j;
    }
}
