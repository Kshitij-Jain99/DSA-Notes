// Activity Selection

import java.util.*;

public class B {

    public static void main(String args[]) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        // When end time is not sorted, then do sorting
        int activities[][] = new int [start.length][3]; 
        for(int i=0; i<start.length; i++){            
            activities[i][0] = i;        //storing "i" at "i index", because after sorting we need to know the original index of that activity.
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); 
          

        //end time basis sorted
        int maxAct = 0;         //var-1
        ArrayList<Integer> ans = new ArrayList<>();   //var-2

        maxAct = 1;                       // 1st Activity
        ans.add(activities[0][2]);        //before update-(0)
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
    }
}
