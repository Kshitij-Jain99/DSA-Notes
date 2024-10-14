import java.util.*;

public class G1 {
  
    static class Job{
    int deadline;
    int profit;
    int id;  //0(A), 1(B), 2(C), 3(D)

    public Job(int i, int d, int p){   //Constructor - to pass value
        id = i;
        deadline = d;
        profit =p;
    }
  } 
  
  public static void main(String arg[]) {
    int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};

     //jobs ko objects mein convert karke unka ArrayList bana liya
    //Job jobs[] = new Job[jobsInfo.length]; //arr of onjects of job type
    ArrayList<Job> jobs = new ArrayList<>();  //used ArrayList instead of above beacuse we want to use collections.


    for(int i=0; i<jobsInfo.length; i++) {
        jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));  //(id, deadline, profit)
      } 

      Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);
      //descending order of profit
    
      ArrayList<Integer> seq = new ArrayList<>();
      int time =0;
      for(int i=0; i<jobs.size(); i++) {
        Job curr = jobs.get(i);
        if(curr.deadline> time) {
            seq.add(curr.id);
        time++;       }
      }
    

    //print seq
    System.out.println("max jobs = "+ seq.size());
    for(int i=0; i<seq.size(); i++) {
        System.out.print(seq.get(i)+ " ");
    }
    System.out.println();
  }
}
