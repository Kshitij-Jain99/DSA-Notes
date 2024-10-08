import java.util.PriorityQueue;
import java.util.Comparator;

public class C1 {
    static class Student implements Comparable<Student> {  //overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

            @Override
            public int compareTo(Student s2) {
                return this.rank-s2.rank;   //better: return Integer.compare(this.rank, s2.rank);
           
        }
        
    }
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A", 4));
        pq.add(new Student("A", 5));
        pq.add(new Student("A", 2));
        pq.add(new Student("A", 12));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();    
        }
    }
}
