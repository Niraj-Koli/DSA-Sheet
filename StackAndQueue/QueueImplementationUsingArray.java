/*
 * Implement a Queue using an Array. Queries in the Queue are of the following
 * type:
 * (i) 1 x (a query of this type means pushing 'x' into the queue)
 * (ii) 2 (a query of this type means to pop element from queue and print the
 * poped element)
 */

public class QueueImplementationUsingArray {
    private int front, rear, currSize, maxSize;
    private int[] arr;

    public QueueImplementationUsingArray() {
        front = 0;
        rear = 0;
        currSize = 0;
        maxSize = 1000;
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (isFull()) {
            throw new IllegalStateException("Queue Overflow");
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxSize;
        }

        arr[rear] = x;
        currSize++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }

        int popped = arr[front];

        if (currSize == 1) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
        currSize--;

        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }
        return arr[front];
    }

    public int size() {
        return currSize;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == maxSize;
    }

    public static void main(String[] args) {
        QueueImplementationUsingArray queue = new QueueImplementationUsingArray();

        queue.push(10);
        queue.push(7);
        queue.push(21);

        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
