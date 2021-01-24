package week10;
import java.util.Arrays;

/**
 *  A selection sorter  implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class MergeSort extends Sorter {
    
    /**
     *  Create a new Selection sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
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
        sort(0, nums.length-1);
    }
    
    /**
     * Sort the integers recursively.
     (which are stored in the parent Sorter class).
     @param left of nums.
     @param right of nums.
    */
    public void sort(int left, int right){
        if(left < right){
            int middle = (left+right)/2;
            sort(left, middle);
            sort(middle+1, right);
            merge(left, middle, right);
        }   
    }
    
    /**
     * merges the sorted piles of integers with left, middle, right;
     (which are stored in the parent Sorter class).
     @param left of nums.
     @param middle nums.
     @param right of nums.
    */
    public void merge(int left, int middle, int right){
        Integer[] temp = Arrays.copyOfRange(nums, 0, right+1);
        i = left;
        j = middle+1;
        int k = left;
        while (i <= middle && j <= right){
            if(temp[i] < temp[j]){
                comparisons++;
                nums[k] = temp[i];
                i++;
            } else {
                comparisons++;
                nums[k] = temp[j];
                j++;
            }
            k++;
        }
        while(i <= middle){
            comparisons++;
            nums[k] = temp[i];
            i++;
            k++;
        }
        update();
    }
}
