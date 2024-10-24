import java.util.*;
public class Array6{
        public static int linearSearch(int numbers[], int key) {   //number array aur key ko search karna hai, agar koi key hai hi nahi to -1 return kar

            for(int i=0; i<numbers.length; i++){        //araay ki lenth tak loop chalana    
                if(numbers[i] == key){                 //har number key liye check kara 
                    return i;
                }               
            }
              return -1;          //key dne

        }
        
        public static void main(String args[]) {
            int numbers[] = {2,4,6,8,10,12,14,16};
            int key = 20; 

            int index= linearSearch(numbers,key);
            System.out.println("key is at index");
            if(index ==-1){
                System.out.println("NOT FOUND");
            } else{
                System.out.println("key is at index:"+index);
            }
        }
        
}
     