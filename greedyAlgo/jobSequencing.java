package greedyAlgo;

import java.util.ArrayList;
import java.util.Collections;


public class jobSequencing {
    static class job{
        int deadline;
        int profit;
        int id;
        public job(int i,int d,int p){
            deadline=d;
            profit=p;
            id=i;   
        }
    }
    public static void main(String[] args) {
        int jobsinfo[][] = {{1, 2}, {2, 4}, {3, 6}, {4, 8}, {5, 10}, {6, 12}, {7, 14}, {8, 16}, {9, 18}, {10, 20}};
        ArrayList<job> jobs=new ArrayList<>();
        for(int i=0;i<jobsinfo.length;i++){
            jobs.add(new job(i,jobsinfo[i][0],jobsinfo[i][1]));
           
        }
       Collections.sort(jobs, (a,b)->b.profit-a.profit);//descending order of profit
      ArrayList<Integer> seq=new ArrayList<>();
      int time=0;
      for(int i=0;i<jobs.size();i++){
        job curr =jobs.get(i);
        if(curr.deadline>time){
            seq.add(curr.id);
            time++;
        }
       
      }
      //print seq
      System.out.println("the max jobs possible are = "+seq.size());
      for(int i=0;i<seq.size();i++){
        System.out.print(seq.get(i)+" ");
      }
      System.out.println();
     
    }
    
}
