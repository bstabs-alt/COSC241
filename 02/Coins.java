package week02;

import java.util.Random;

/** Coins class that that simulates coin flips.
    records Head, Tails and runs.
    @author Reuben */
public class Coins{
    /** true is comparative to Heads. */
    public static final boolean HEADS = true;
    
    /** false is comparative to Tails. */
    public static final boolean TAILS = false;
    
    /**  array of coins. */
    private boolean[] coins; 

    /**  main method that makes instances of the array.
         prints relative results for the respective instances of Coins.
         @param  args */
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        Coins c2 = new Coins("HHHTHTTHTT");
        Coins c3 = new Coins(10);
        
        System.out.println(c.countHeads());
        System.out.println(c2);
        System.out.println(c3.countRuns());
        System.out.println(c3);
          
    }
    
    /**  Constructor that takes boolean array.
         @param coins */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /**  Contructor that takes the String c.
         results in the same as toString with for and if loop
         makes flip relative to the String.
         @param c */
    public Coins(String c){

        coins = new boolean[c.length()];

        for(int i=0;i<coins.length;i++){
            if (c.charAt(i)== 'H'){
                coins[i]  = HEADS;
            } else{
                coins[i] = TAILS;
            }
        } 
    }
    
    /** Constructor that takes int length to make a random coin toss.
        uses a for loop to make each position in array random boolean.
        @param length */
    public Coins(int length){
        Random r = new Random();

        coins = new boolean[length];
        for(int i=0; i<coins.length;i++){
            coins[i] = r.nextBoolean();
        }
    }
    
    /**  method to count runs in an instance of coin flips.
         for and if loop to find when a run ends and count it.
         @return */
    
    public int countRuns(){
        int runs = 0;
     
        for(int i=0; i<coins.length-1; i++){
            if (coins[i]!= coins[i+1]) {           
                runs++;   
            }
        }
            
        return runs + 1;
    }
    
    /**  method to count heads when coin position is true.
         @return */
    public int countHeads(){
        int count =0;
        for(boolean coin : coins){

            if (coin){
                count++;
            }
        }
        return count;
    }
    
    /**  toString method to add sequence of coin flip results.
         @return */
    public String toString(){
        String sequence="";

        for(boolean  coin : coins){
            if (coin){
                sequence += "H";
            } else{
                sequence  += "T";
            }
        }        
        return sequence ;            
    }

}

