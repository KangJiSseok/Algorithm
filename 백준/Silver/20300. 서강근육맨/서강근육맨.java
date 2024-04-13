import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

class Main {

    static int exerciseCount;
    static long max = 0;
    static long[] exercise;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        exerciseCount = Integer.parseInt(br.readLine());
        exercise = new long[exerciseCount];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i< exerciseCount; i++){
            exercise[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(exercise);

        if(exerciseCount % 2 == 1){
            odd();
        }else{
            even();
        }
    }
    
    static void odd(){
        long currentValue;

        for(int i=0 ; i< exerciseCount/2; i++){
            currentValue = exercise[i] + exercise[(exercise.length -2) - i];
            max = Math.max(max, currentValue);
        }

        max = Math.max(max,exercise[exercise.length-1]);

        System.out.println(max);
    }

    static void even(){
        long currentValue;

        for(int i=0 ; i< exerciseCount/2; i++){
            currentValue = exercise[i] + exercise[(exercise.length -1) - i];
            max = Math.max(max, currentValue);
        }

        System.out.println(max);
    }
}