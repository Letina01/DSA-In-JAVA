package greedyAlgo;

import java.util.Arrays;
import java.util.Collections;

public class chocolaProblem {
    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        Integer[] costver = {2,1,3,1,4};//m-1
        Integer[] costhor = {4,1,2};//n-1
        
        // Sorting in reverse order
        Arrays.sort(costver, Collections.reverseOrder());
        Arrays.sort(costhor, Collections.reverseOrder());
        
        int h = 0; // Horizontal index
        int v = 0; // Vertical index
        int hp = 1; // Horizontal partitions, starts at 1
        int vp = 1; // Vertical partitions, starts at 1
        int cost = 0; // Total cost
        
        // Loop until we have processed all cuts
        while (h < costhor.length && v < costver.length) {
            if (costver[v] >= costhor[h]) { // Vertical cut
                cost += costver[v] * hp;
                vp++;
                v++;
            } else { // Horizontal cut
                cost += costhor[h] * vp;
                hp++;
                h++;
            }
        }
        
        // Process remaining horizontal cuts
        while (h < costhor.length) {
            cost += costhor[h] * vp;
            h++;
            hp++;
        }
        
        // Process remaining vertical cuts
        while (v < costver.length) {
            cost += costver[v] * hp;
            v++;
            vp++;
        }
        
        System.out.println("Min cost of cuts = " + cost);
    }
}
