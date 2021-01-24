package week03;

/**
 *  A recursive representation of a tower of blocks.
 *
 * @author Reuben
 */
public class Tower{

    /** The top block. */
    private char top;
 
    /** The rest of the tower. */
    private Tower rest;
    
    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }

    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }

    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /** takes x and adds 1 plus the rest of the tower.
        @return height rest of tower plus the one x is currently on
    */
    public int height(){

        int x = 0;

        if (this.isEmpty()){
            return x;
        } else {
            return x+=1 + (this.rest.height());
        }
        
    }

    /** takes c and adds the rest of tower + 1.
        @return count int of height of tower from a char
        @param c char
    */
    public int count(char c){

        if(this.isEmpty()){
            return  0;
        } else if(this.top == c){
            return this.rest.count(c)+1;
        } else {
            return this.rest.count(c); 
        }
        
    }

}
