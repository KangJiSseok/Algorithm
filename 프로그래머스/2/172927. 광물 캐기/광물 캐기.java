import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        HashMap<String,Integer> map = new HashMap<>();
        map.put("diamond",25);
        map.put("iron",5);
        map.put("stone",1);
        
        int pickSize = (picks[0] + picks[1] + picks[2]) * 5;
        
        ArrayList<tire> list = new ArrayList<>();

        int size = minerals.length / 5;
        if (minerals.length % 5 != 0) {
            size += 1;
        }

        for (int i = 0; i < size ; i++) {
            list.add(i, new tire(0,0,0,0));
        }

        for(int i=0; i< minerals.length; i++){
            if(pickSize == 0) break;
            tire Tire = list.get(i / 5);
            if(map.get(minerals[i]) == 25){
                Tire.setD(Tire.getD()+1);
            }else if(map.get(minerals[i]) == 5){
                Tire.setI(Tire.getI()+1);
            }else{
                Tire.setS(Tire.getS()+1);
            }
            Tire.setSum(Tire.getSum()+ map.get(minerals[i]));
            pickSize--;
        }

        Collections.sort(list, new tire());

        int hp =0;
        for(tire i : list){
            System.out.println("i.toString() = " + i.toString());
            int dCount = i.getD();
            int iCount = i.getI();
            int sCount = i.getS();
            if(picks[0] >0 ){
                hp += dCount + iCount + sCount;
                picks[0]--;
            }else if(picks[1] >0){
                hp += dCount*5 + iCount + sCount;
                picks[1]--;
            }else if(picks[2] >0){
                hp += dCount*25 + iCount*5 + sCount;
                picks[2]--;
            }
        }

        return hp;
    }
}

class tire implements Comparator<tire> {

    private int d;
    private int i;
    private int s;
    private int sum;

    public tire() {
    }

    public tire(int d, int i, int s, int sum) {
        this.d = d;
        this.i = i;
        this.s = s;
        this.sum = sum;
    }
    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public int compare(tire o1, tire o2) {
        if (o1.sum > o2.sum) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "tire{" +
                "d=" + d +
                ", i=" + i +
                ", s=" + s +
                ", sum=" + sum +
                '}';
    }
}
