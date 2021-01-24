package week04;
import java.util.*;
/**
 * code for an array based implementation of Young's tableau.
 *
 * @author Reuben
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
        System.out.println(TableauApp.rowLengthsDecrease(valid));
        System.out.println(TableauApp.rowValuesIncrease(valid));
        System.out.println(TableauApp.columnValuesIncrease(valid));        
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        return rowLengthsDecrease(t) &&  rowValuesIncrease(t) &&
            columnValuesIncrease(t) &&  isSetOf1toN(t);
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     *  Returns a true if no row is longer than a preceding row.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a boolean from the array based tableau.
     */
    public static boolean rowLengthsDecrease(int[][] t){
        
        for(int i=0; i<t.length; i++) {
            if (i > 0 && t[i].length > t[i-1].length){
                return false;
            }          
        }
        return true;
    }

    /**
     *  Returns a true if integers are increasing in any row.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a boolean from the array based tableau.
     */
    public static boolean rowValuesIncrease(int[][] t) {
     
        for(int i=0; i<t.length; i++){
            for(int j=0; j<t[i].length; j++){              
                if (j > 0 && t[i][j] < t[i][j-1]){
                    return false;               
                }
            }
        }       
        return true;
    }
    

    /**
     *  Returns a true if integers are increasing in any col.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a boolean from the array based tableau.
     */
    public static boolean columnValuesIncrease(int[][] t){
                             
        for(int i=0; i<t.length; i++){
            for(int j=0; j<t[i].length; j++){
                if (i > 0 && t[i][j] < t[i-1][j]){
                    return false;
                }                             
            }           
        }
        return true;
    }

    /**
     *  Returns a true if integers used go to n with no duplicates.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a boolean from the array based tableau.
     */
    public static boolean isSetOf1toN(int [] [] t){
        int n = 0;

        for(int i=0; i<t.length; i++){
            for(int j=0; j<t[i].length; j++){
                n++;
            }
        }

        int [] set = new int [n];
        int x = 0;
        
        for(int i =0; i < t.length; i++){
            for(int j =0; j < t[i].length; j++){            
                set[x] = t[i][j];
                x++;
            }
        }

        Arrays.sort(set);
        
        for(int i=0; i < set.length; i++){
            if(set[i] >  i+1 || set[i] < i+1){
                return false;
            }
        }
        
        return true;  
    }
    
}

