// String Buffer: Random Generator, other methods 
import java.util.Arrays;
import java.util.Random;

public class A2 {
     public static void main(String[] args){
          int n = 20;
          String name = generate(n);
          System.out.println(name);

          // Remove all spaces from the string
          String sentence = "Hi h sdf sg sg adsadsaw wad";
          System.out.println(sentence.replaceAll("\\s", ""));
         
          // Split a string by spaces
          String arr = "Kain,Bain,Lane,Stan";
          String[] arrSplit = arr.split(",");
          System.out.println(Arrays.toString(arrSplit));

        }


    static String generate(int size){
    
    // Random Float Generator
    Random random = new Random();
    System.out.println(random.nextFloat());
    
    //Random String Generation
    StringBuffer sb = new StringBuffer(size);
    for(int i = 0; i<size; i++){
        int randomChar = 97 + (int)(random.nextFloat() * 26)  ;
        sb.append((char)randomChar);
    }
    return sb.toString();
  }
     
}
