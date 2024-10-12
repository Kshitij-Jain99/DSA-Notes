//Circular Queue using array

public class B2 {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear =-1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front ==-1;   
        }

        public static boolean isFull() {
            return (rear+1)%size == front;
        }

        //add
        public static void add(int data) {
            if(isFull()){ 
                System.out.println("queue is full");
                return;
            }

            //extra condition- add 1st element
            if(front==-1) {
                front = 0;
            }


            rear = (rear+1)%size;
            arr[rear] = data;
        }

    //remove
    public static int remove() {
        if(isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int result = arr[front];

        //last el delete
        if(rear == front) {
            rear = front =-1;
        } else {
            front = (front +1)%size;
        }
        return result;
        
    }

    //peek
    public static int peek() {
        if(isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return arr[front];
    }

    }

    public static void main(String args[]) {
       Queue q = new Queue(3);
       q.add(1);
       q.add(2);
       q.add(3);
       System.out.println(q.remove()); //front remove and update
       q.add(4);
       System.out.println(q.remove()); ////front remove and update
       q.add(5);

      // 1 2 3
       while(!q.isEmpty()) {
        System.out.println(q.peek());
            q.remove();
        
       }

    }

    
}

/*
 * Queue creation
Queue is created with size 3.
arr array is initialized to [None, None, None].
rear and front are initialized to -1 indicating the queue is empty.

Adding elements
1 is added to the queue. Since the queue is empty, front is set to 0 and rear is set to 0. The queue becomes [1, None, None].
2 is added to the queue. rear is incremented to 1 (becomes 1 % 3 = 1) and the element is added at index 1. The queue becomes [1, 2, None].
3 is added to the queue. rear is incremented to 2 (becomes 2 % 3 = 2) and the element is added at index 2. The queue becomes [1, 2, 3].

Removing elements
remove is called. The element at front (index 0) which is 1 is removed. front is incremented to 1 (becomes 1 % 3 = 1). The queue becomes [None, 2, 3].
4 is added to the queue. Since rear was pointing to the last element, it is wrapped around to the beginning of the queue (0). The element is added at index 0. The queue becomes [4, 2, 3].
remove is called. The element at front (index 1) which is 2 is removed. front is incremented to 2 (becomes 2 % 3 = 2). The queue becomes [4, None, 3].
5 is added to the queue. rear is incremented to 0 (becomes 0 % 3 = 0) and the element is added at index 0. The queue becomes [5, None, 3].
Printing elements

peek is called and it returns 3 (the element at front).
remove is called. The element at front (index 2) which is 3 is removed. front is incremented to 0 (becomes 0 % 3 = 0) and rear is set to -1 since it was the last element. The queue becomes [5, None, None].
peek is called and it returns 5 (the element at front).
remove is called. The element at front (index 0) which is 5 is removed. front and rear are set to -1 since the queue is empty. The queue becomes [None, None, None].
 */
