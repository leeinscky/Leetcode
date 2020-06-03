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