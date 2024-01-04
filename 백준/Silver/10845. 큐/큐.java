
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        ArrayQueue arrayQueue = new ArrayQueue(10002);

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    arrayQueue.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(arrayQueue.pop()).append('\n');
                    break;

                case "size":
                    sb.append(arrayQueue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(arrayQueue.empty()).append('\n');
                    break;

                case "back":
                    sb.append(arrayQueue.back()).append('\n');
                    break;

                case "front":
                    sb.append(arrayQueue.front()).append('\n');
                    break;
            }
        }
        System.out.println(sb);

        br.close();

    }
}

class ArrayQueue{
    int front;
    int back;
    int[] queue;

    public ArrayQueue(int size) {
        this.front=0;
        this.back =-1;
        this.queue = new int[size];
    }

    public void push(int item) {
        queue[++back] = item;
    }

    public int front() {
        if (back == -1) {
            return -1;
        }
        return queue[front];
    }

    public int back() {
        if (back == -1) {
            return -1;
        }
        return queue[back];
    }

    public int empty() {
        if (back == -1) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public int size() {
        return back+1;
    }

    public int pop() {
        if (back == -1) {
            return -1;
        }
        int temp;
        int result = queue[front];
        for (int i = 0; i <= back; i++) {
            temp = queue[i];
            queue[i] = queue[i + 1];
            queue[i + 1] = 0;
        }
        back--;
        return result;
    }
}


