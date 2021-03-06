package week08;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
  a very basic Word Generator.
  @author Reuben.
*/
public class DigramGenerator implements WordGenerator {
    
    /** Random source used to generate words. */
    private Random random;
    
    /** Constructs a basic random word generator.
        which uses the random given source.
        @param r a source of randomness used hwne generating words.
    */
    public DigramGenerator(Random r) {
        random = r;
    }
    
    /**
       returns a random word of length n.
       @param n the required length of the word.
       @return a random word of length n.
    */
    public String nextWord(int n) {
        final int alphabetLength = 26;
        StringBuilder result = new StringBuilder();
        String[] cont = new String[alphabetLength];
        try{
            File file = new File("first-letters.txt");
            Scanner sc = new Scanner(file);
            String index = "";
            while(sc.hasNext()){
                index += sc.nextLine();
            }
            int x = random.nextInt(index.length());
            char c = index.charAt(x);
            result.append(c);
        }catch(FileNotFoundException ex){
            System.exit(0);
        }
        
        try{
            File file = new File("continuations.txt");
            Scanner sc = new Scanner(file);
            int i = 0;
            while(sc.hasNext()){
                cont[i] = sc.nextLine();
                i++;
            }
            
        }catch(FileNotFoundException ex){
            System.exit(0);
        }
        char r = 'a';
        int i = 0;
        while(i < n-1){
            String letter = cont[result.charAt(i) - r];
            int x = random.nextInt(letter.length());
            char c = letter.charAt(x);
            result.append(c);
            i++;
        }
        
        return result.toString();
    }
    
}
