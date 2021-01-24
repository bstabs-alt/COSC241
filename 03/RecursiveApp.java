package week03;

/** Class return number of digits and sum of digits.
    all using recursion with longs of n
    @author Reuben */
public class RecursiveApp{

    /** takes n and adds the number of digits together.
        going through each exponent place
        @return return
        @param n */
    public static long digits(long n){

        if (n < 10){
            return 1;
        } else {
            return 1 + digits(n/10);
        } 
    }

    /** takes n and adds the sum of all the digits.
        adds remainder and the exponent moved to the left
        @return return
        @param n */
    public static long sumOfDigits(long n){

        if (n == 0){
            return 0;
        } else {
            return n%10 + sumOfDigits(n/10);
        }
        
    }
    
}
