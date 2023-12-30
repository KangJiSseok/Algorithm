import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        ArrayStack arrayStack = new ArrayStack(10001);

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    arrayStack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(arrayStack.pop()).append('\n');
                    if (arrayStack.getTop() == 0) {
                        break;
                    }
                    arrayStack.setStack(arrayStack.getStack(), arrayStack.getTop());
                    break;

                case "size":
                    sb.append(arrayStack.size()).append('\n');
                    break;

                case "empty":
                    sb.append(arrayStack.empty()).append('\n');
                    break;

                case "top":
                    sb.append(arrayStack.top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);

        br.close();

    }
}


class ArrayStack {
    int top;
    int size;
    int[] stack;

    public int[] getStack() {
        return stack;
    }

    public int getTop() {
        return top;
    }

    public void setStack(int[] stack, int top) {
        stack[top] = 0;
        this.top = --top;
    }

    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
        top = 0;
    }

    public void push(int item) {
        stack[++top] = item;
    }

    public int pop() {
        if (top == 0)
        {
            return -1;
        } else
        {
//            System.out.println(stack[top]);
            return stack[top];
        }
    }

    public int top() {
        if (top == 0){
            return -1;
        } else {
            return stack[top];
        }
    }

    public int size() {
        return top;
    }

    public int empty() {
        if (top == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
