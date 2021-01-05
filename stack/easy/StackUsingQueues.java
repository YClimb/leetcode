package stack.easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 * @author yclimb
 * @date 2021/1/5
 */
public class StackUsingQueues {
    public static void main(String[] args) {
        test();
    }

    /**
     * 用队列实现栈
     *
     * 使用队列实现栈的下列操作：
     *
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * 注意:
     *
     * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
     * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void test() {
        MyStack obj = new MyStack();
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    /**
     * 使用两个队列实现
     * 1.分为 q1 和 q2
     * 2.push 值写入 q2，再将 q1 值依次写入 q2
     * 3.对换 q1 和 q2 的值
     */
    static class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /**
         * 初始化两个队列
         */
        public MyStack() {
            // 保存实际的数据
            queue1 = new ArrayDeque<>();
            // 临时队列，push 时使用，之后会清空
            queue2 = new ArrayDeque<>();
        }

        /**
         * 1.将值写入 q2
         * 2.将 q1 所有值依次写入 q2
         * 3.设置临时变量，将 q1 和 q2 互换
         */
        public void push(int x) {
            if (queue1.isEmpty()) {
                queue1.offer(x);
                return;
            }
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /**
         * 堆栈的顶部删除元素,并返回该元素;
         */
        public int pop() {
            if (queue1.isEmpty()) {
                return 0;
            }
            return queue1.poll();
        }

        /**
         * 获得头部元素，不删除
         */
        public int top() {
            if (queue1.isEmpty()) {
                return 0;
            }
            return queue1.peek();
        }

        /**
         * 返回栈是否为空
         */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    /**
     * 使用一个队列实现栈
     * 1.设置一个队列 q
     * 2.push 写入时，查询当前 q.size=n, 再写入 q，之后循环 0-n，依次写入 q
     * 3.(21->3->321)
     */
    static class MyStack2 {

        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack2() {
            queue = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (queue.isEmpty()) {
                return 0;
            }
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            if (queue.isEmpty()) {
                return 0;
            }
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
