package week06;
import java.util.Scanner;
import java.util.ArrayList;

/** performs calculations and changes to scan inputs.
    @author Reuben    
*/
public class LongWords{
    /** int to set maxwords.
     */
    static final int MAX_WORDS = 100;

    /** main method.
        @param args default 
    */
    public static void main(String[] args ){
        String s = "";
        int count = 0;
        int letter = 0;
        double average = 0;
        
        ArrayList<String> storedWords = new ArrayList<String>();
        
        Scanner scan = new Scanner(System.in);
        
        while(scan.hasNext() && count < MAX_WORDS){
            count++;
            s = scan.next();
            letter += s.length();
            storedWords.add(s);
        }
        
        average = (double) letter/count;
        String [] reversedWords = new String[count];
        
        int x = storedWords.size() - 1;
        int j = 0; 
        
        for(String string: storedWords){
            reversedWords[j] = storedWords.get(x);
            x--;
            j++;
            
        }
        for(int i = 0; i < reversedWords.length; i++ ){
            if(reversedWords[i].length() > average && count <=  MAX_WORDS){
                System.out.println(reversedWords[i]);
            }
        }
        
        if(count > 0){
            System.out.printf("Average: %.2f\n",average);
        }
    }
}
