// File Handling in java: File class
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class C4 {
    public static void main(String[] args){
        // create a new file
        try {
            File fo = new File("new-file.txt");
            fo.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // write in the file
        try {
            FileWriter fw = new FileWriter("new-file.txt");
            fw.write("सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज, अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुच: || 66||");
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader("note.txt"))) {
            while(br.ready()){
                 System.out.println(br.readLine());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
