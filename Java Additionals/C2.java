// File Handling in java: FileReader Subclass, Buffer Reader Class

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C2 {
     
    public static void main(String[] args){
        try(FileReader fr = new FileReader("note.txt");){
            System.out.print("Enter a character:");
            int letters = fr.read(); // read() method returns an int value, which is the ASCII value of the character read
            while(fr.ready()) {
                System.out.println((char) letters);
                letters = fr.read();
            }
            //isr.close(); > no need to wite this as try-catch block will automatically close it
            System.out.println();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
//To obtain a character-based stream that is attached to the console, wrap System.in in a BufferedReader object.
        // byte to char stream then reading char stream
      try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("You typed:" + br.readLine());
        } catch (IOException e){
            System.out.println(e.getMessage());
        } //After this statement executes, br is a character-based stream that is linked to the console through System.in.


        try(BufferedReader br = new BufferedReader(new FileReader("note.txt"))) {
            while(br.ready()){
                 System.out.println(br.readLine());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        
    }
}
