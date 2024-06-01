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
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" : 
                    sb.append(pop()).append("\n");
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


    private static void push(int data){
        deque.addFirst(data);
    }

    private static int pop(){
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
        return deque.peekLast();
    }

    private static int back(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }
}