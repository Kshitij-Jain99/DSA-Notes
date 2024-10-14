import java.util.*;

public class B1 {

    public static void main(String args[]) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //{new added}:when end is not sorted, then do sorting
        int activities[][] = new int [start.length][3]; //3 column, rows=start length
        for(int i=0; i<start.length; i++){            
            activities[i][0] = i;  //storing "i" at "i index", because after sorting we need to know the original index of that activity
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        //lambda function:
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));  //now update the rest code
          

        //end time basis sorted
        int maxAct =0;         //var-1
        ArrayList<Integer> ans = new ArrayList<>();   //var-2

        //1st Activity
        maxAct =1;
        ans.add(activities[0][0]);        //before update-(0)
        int lastEnd = activities[0][0];   //before update:end[0]              //var-3[temp.]
        for(int i=1; i<end.length; i++) {
            if(activities[i][1] >= lastEnd) { //before update:start[i]  //disjoint 
                //activity select
                //variables update
                maxAct++;
                ans.add(activities[i][0]);     //before update:(i)
                lastEnd = activities[i][2];    //before update:end[i]
            }
        }

        System.out.println("max activities = " + maxAct);
        for(int i=0; i<ans.size();i++) {
            System.out.print("A" +ans.get(i)+" ");
        }
        System.out.println();
    }
}
