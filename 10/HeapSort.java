package week10;

/**
 *  A selection sorter  implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class HeapSort extends Sorter {
    
    /**
     *  Create a new Selection sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }
    
    /**
     * calls the Sort class to sort the integers.
     (which are stored in the parent Sorter class).
    */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        build(nums);
        Integer[]heap = new Integer[nums.length];
        for(i = nums.length-1;i >= 0; i--){
            heap[i] = nums[0];
            nums[0] = 0;
            build(nums);
            update();
        }
        nums = heap;
    }
    
    /**
     * build a heap.
     @param heap of nums
    */
    public void build(Integer[] heap){
        for (j = (heap.length-2)/2; j >= 0; j--){
            max(heap, j);
        }
    }
    
    /**
     * heap becomes max to swap down the heap.
     @param heap checked max
     @param i = current pos
    */
    public void max(Integer[] heap, int i){
        if(hasChild(heap, i)){
            int max = heap[i];
            int bigChild;
            int temp = 0;
            if(hasChildren(heap, i)){
                if(heap[2*i+1] > heap[2*i+2]){
                    bigChild = 2*i+1;
                }else{
                    bigChild = 2*i+2;
                }
            } else {
                bigChild = 2*i+1;
            }
            if(max < heap[bigChild]){
                comparisons++;
                temp = heap[bigChild];
                heap[bigChild] = heap[i];
                heap[i] = temp;
            }
            if(max != i){
                max(heap, bigChild);
            }
            update();
        }
    }
    
    /**
       check if has child.
       @param heap checked max
       @param i = currennt pos
       @return boolean if has child
    */
    public boolean hasChild(Integer[] heap, int i){
        try{
            int temp = heap[2*i+1];
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    /**
       check if has children.
       @param heap checked max
       @param i = currennt pos
       @return boolean if has children
    */
    public boolean hasChildren(Integer[] heap, int i){
        try{
            int temp = heap[2*i+2];
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
}
