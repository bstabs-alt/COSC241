package week12;
import java.util.*;

/**
   Application class for the queue.
   @author Reuben
 */
public class QueueApp{

    /**
       Main method for reading stdin.
       @param args reads arguments
    */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TwoStackQueue<String> q = new TwoStackQueue<String>();
        String s = "";
        while(sc.hasNextLine()){
            Scanner sc2 = new Scanner(sc.nextLine());
            switch(sc2.next()){
                case "a":
                    while(sc2.hasNext()){
                        s = sc2.next();
                        q.add(s);
                    }
                    break;
                case "c":
                    q.clear();
                    break;
                case "d":
                    System.out.println(q.debug());
                    break;
                case "g":
                    if(!q.isEmpty()){
                        System.out.println(q.get());
                    }
                    break;
                case "p":
                    System.out.println(q.toString());
                    break;
                case "r":
                    if(!q.isEmpty()){
                        System.out.println(q.remove());
                    }
                    break;
                case "s":
                    System.out.println(q.size());
                    break;
            }
        }
    }
}
