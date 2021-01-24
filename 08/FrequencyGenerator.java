package week08;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
   a very basic Word Generator.
   @author Reuben.
*/
public class FrequencyGenerator implements WordGenerator {
    
    /** Random source used to generate words. */
    private Random random;
    
    /**
       Constructs a basic random word generator which uses the given
       random source.
       
       @param r a source of randomness used when generating words.
    */
    public FrequencyGenerator(Random r) {
        random = r;
    }
    
    /**
       returns a random world of length n.
       @param n is the required length of the word.
       @return a random word of length n.
    */
    public String nextWord(int n) {
        
        final int alphabetLength = 26;
        double[] w = new double[alphabetLength];
       
        try{
            File file = new File("letter-frequencies.txt");
            Scanner sc = new Scanner(file);
                
            int i = 0;
            while (sc.hasNext()){
                w[i] = Double.parseDouble(sc.nextLine());
                i++;
            }
        } catch (FileNotFoundException ex){
            System.exit(0);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            int j = 0;
            Double rand = random.nextDouble();
            while(rand > w[j]){
                rand -= w[j];
                j++;
            }
            char c = (char)('a' + j);
            result.append(c);
        }
        return result.toString();
        
    }

}
