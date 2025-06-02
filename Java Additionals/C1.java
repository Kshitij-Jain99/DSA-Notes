// File Handling in java: Byte Stream(data) -> Character Stream

import java.io.IOException;
import java.io.InputStreamReader;

public class C1 {
    public static void main(String[] args){
        try(InputStreamReader isr = new InputStreamReader(System.in)){
            System.out.print("Enter a character:");
            int letters = isr.read();
            while(isr.ready()) {
                System.out.println((char) letters);
                letters = isr.read();
            }
            //isr.close(); > no need to wite this as try-catch block will automatically close it
            System.out.println();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
