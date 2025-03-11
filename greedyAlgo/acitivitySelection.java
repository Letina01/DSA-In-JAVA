package greedyAlgo;

import java.util.ArrayList;

public class acitivitySelection {
    public static void main(String[] args) {
        
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        //if end is not sorted then sorting code
        // int[] start = {1, 3, 0, 5, 8, 5};
        // int[] end = {2, 4, 6, 7, 9, 9};

        //start time sorted
        //end time not sorted
        //sort end time
        /*
        int activities[][] = new int[start.length][3];
        for(int i = 0; i < start.length - 1; i++) {
        activities[i][0] = i;
        activities[i][1] = start[i];
        activities[i][2] = end[i];
                    }
        lamda function->shortform
        Arrays.sort(activities, `comparator.comparingDouble(a -> o[2]));
        */

        //end time sorted
        int Maxcount = 1;
       ArrayList<Integer> ans = new ArrayList<>();
       Maxcount = 1;
       ans.add(0);
       int lastend=end[0];
       for(int i = 1; i < end.length; i++) {
        if(lastend<= start[i]) {
            Maxcount++;
            ans.add(i);
            lastend = end[i];
            }
        }
        System.out.println("max acitivites are += " + Maxcount);
        for(int i=0;i<ans.size();i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
       

       
    }
    
}
