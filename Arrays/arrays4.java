import java.util.*;

public class arrays4{
            public static void update (int marks[], int nonChangeable) {                //take array as argument
                nonChangeable =10;                                 //we updated its value from  5 to 10 
                for(int i=0; i<marks.length; i++) {                  // loop to add 1 in each mark, very important loop, array k sare index tak ja rhe hai
                marks[i] = marks[i] + 1 ;                          // updating marks 
            }
        }
        public static void main (String args[]) {
            int marks[] = {97,98,99};             //initial values
            int nonChangeable = 5;
            update(marks,nonChangeable );
            System.out.println(nonChangeable);
            //print our marks
            for(int i=0; i<marks.length; i++) {
                System.out.print(marks[i]+ " ");
            }
            System.out.println();
        }
    


}