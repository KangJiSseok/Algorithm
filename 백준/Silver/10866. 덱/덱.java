import java.util.*;
import java.io.*;

class Main{

    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String firstText = st.nextToken();

            switch(firstText){
                case "push_front" :
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" : 
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back" : 
                    sb.append(pop_back()).append("\n");
                    break;
                case "size" :
                    sb.append(size()).append("\n");
                    break;
                case "empty" :
                    sb.append(empty()).append("\n");
                    break;
                case "front" :
                    sb.append(front()).append("\n");
                    break;
                case "back" :
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }


    private static void push_front(int data){
        deque.addFirst(data);
    }

    private static void push_back(int data){
        deque.addLast(data);
    }

    private static int pop_front(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.pollFirst();
    }

    private static int pop_back(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.pollLast();
    }

    private static int size(){
        return deque.size();
    }

    private static int empty(){
        if(deque.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

    private static int front(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    private static int back(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekLast();
    }
}