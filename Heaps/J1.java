import java.util.*;

public class J1 {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {  //constructor
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {  //modified logic for 2 conditions
            if(this.soldiers == r2.soldiers) { //soldiers same, idx compare
                return this.idx - r2.idx;
            } else {  //when count of soldiers is not same
                return this.soldiers -r2.soldiers;
            }
        }
    }

    public static void main(String args[]) {
        int army[][] = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0} };

        int k=2;  //we need 2 weakest rows

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<army.length; i++) {
            int count =0;
            //soldiers count
            for(int j=0; j<army[0].length; j++) {
                count += army[i][j] == 1 ? 1  : 0;
            }
            pq.add(new Row(count,i));
        }

        for(int i=0; i<k; i++) {
            System.out.println("R" +pq.remove().idx);
        }
    }
}
