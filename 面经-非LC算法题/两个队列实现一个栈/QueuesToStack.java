
import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * 思路：
 * 1. 所有元素a b c进入q1，因为我们的目的是栈，也就是最先出c,而队列是从队头开始出，所有先把 a b 弹出q1 并 压入q2,
 * 此时目标c跑到了q1队头，弹出q1，完成c最先弹出的操作。
 * 
 * 此时q1已经为空，下一个要弹出的是b。
 * 
 * 2. 把 a 从 q2 弹出队列并压入 q1,此时目标 b 在 q2 队列头部,从 q2 弹出，完成 b 弹出的操作。
 * 
 * 总结：把 非空队列 的前n-1元素个压入 空对列，剩的第n个元素弹出队列（后进先出）...即总有一个队列为空。
 */

 public class QueuesToStack<T> {

    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    //压入：入栈非空的队列
    public boolean push(T t) {
        if (!queue1.isEmpty()) {
            return queue1.offer(t);
        } else {
            return queue2.offer(t);
        }
    }

    //弹出 并删除元素
    public T pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        
        if (!queue1.isEmpty() && queue2.isEmpty()) { //q1非空 q2空 （q1的前n-1个元素压入q2）
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll(); //弹出q1剩下的最后一个元素
        }
        
        if (queue1.isEmpty() && !queue2.isEmpty()) { //q1空 q2非空（q2的前n-1个元素压入q1）
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll(); //弹出q2剩下的最后一个元素
        }

        return null;
    }

    public static void main(String[] args) {
        QueuesToStack<Integer> stack = new QueuesToStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
 
}

/* 输出结果
4
3
6
5
2
1
Exception in thread "main" java.lang.RuntimeException: queue is empty
	at QueuesToStack.pop(QueuesToStack.java:35)
	at QueuesToStack.main(QueuesToStack.java:73)
*/



/* 方法2:
import java.util.LinkedList;

public class QueuesToStack {
    LinkedList<Integer> queue1 = new LinkedList<Integer>();
    LinkedList<Integer> queue2 = new LinkedList<Integer>();

    public void push(int value)// 入栈
    {
        queue1.addLast(value);

    }

    public int pop()// 出栈 必须是非空的栈才能出栈啊
    {
        if (sSize() != 0)// 栈不为空
        {
            // 移动一个队的n-1个到另一个中
            if (!queue1.isEmpty())// q1 空
            {
                putN_1ToAnthor();
                return queue1.removeFirst();
            } else // q2 空
            {
                putN_1ToAnthor();
                return queue2.removeFirst();
            }
        } else {
            System.out.println("栈已经为空啦，不能出栈");
            return -1;
        }

    }

    public int sSize() {
        return queue1.size() + queue2.size();
    }

    public void putN_1ToAnthor()// 从非空中出队n-1个到另一个队列 因为队列总是一空一非空
    {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.addLast(queue1.removeFirst());
            }
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.addLast(queue2.removeFirst());
            }
        }
    }

    public static void main(String[] args) {
        QueuesToStack stack = new QueuesToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
*/