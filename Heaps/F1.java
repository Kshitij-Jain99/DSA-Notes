import java.util.*;

public class F1 {

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>(); 
      // Add/Insert in heap
        public void add(int data) {
            //add at last idx
            arr.add(data);  // Add the new element to the ArrayList

            int x = arr.size()-1;    //x is child index
            int par = (x-1)/2;    //par index

            while (x > 0 && arr.get(x) < arr.get(par)) {
                // Swap child and parent if child is smaller
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                //updating the values
                x = par;
                par = (x-1)/2;
            }
        }

        //Get mim. in Heap
        public int peek() {
            return arr.get(0);
        }



        //Delete heap
         private void heapify(int i) {  //index i jis k life theek karna hai
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;
         
            if(left <arr.size() && arr.get(minIdx) > arr.get(left)){      //when i is leaf node then left and right dne in arraylist
                minIdx = left;
                 }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
                 }

            if(minIdx != i) { //new node remove karne sein heap nhi bigda
                    //heap agar nhi bigda then root hi min. hai, sahi karne ki jarurt nhi hai
                int temp = arr.get(i);    //i-root
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                
                //agar neeche wali node kharab ho gyi ho is process ki wajah sein, call heapify
                heapify(minIdx);

            }
        }

        public int remove() {
            int data = arr.get(0);

            //step-1  : swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step-2 :delete last
            arr.remove(arr.size()-1);

            //step-3:  heapify for root, fix
            heapify(0);   //0-root
             
            return data;
        }
       
       
        //to check if heap is empty or not
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }
    public static void main(String args[]) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
    
}
