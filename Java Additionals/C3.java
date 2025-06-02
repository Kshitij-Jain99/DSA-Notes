// File Handling in java: OutpurStreamWriter class, FileWriter class, Buffered Writer class

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
 

public class C3 {
     public static void main(String[] args){
        OutputStream os = System.out;
        // os.write(😀);      //range is exceeded

        System.out.println();

        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){
            osw.write("Hello world");
            osw.write(97);
            osw.write(10);
            osw.write('A');
            osw.write('\n');
            char[] arr = "hello world".toCharArray();
            osw.write(arr);
           // osw.write(😀); cant print
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        //This override the original note file and write the new content
         try(FileWriter fw = new FileWriter("notes.txt")){
            fw.write("Hello world");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

          try(BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))){
            bw.write("Hare Krishna");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
     }
}
