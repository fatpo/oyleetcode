package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ouyang on 2020/7/15.
 */
public class 队列的最大值II_medium_剑指Offer59 {
    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(15);
        int param_3 = obj.pop_front();
    }
}

class MaxQueue {
    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() <= value) {
            deque.pollLast();
        }
        deque.addLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        int a = queue.poll();
        if (a == deque.peekFirst()) {
            deque.pollFirst();
        }
        return a;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */