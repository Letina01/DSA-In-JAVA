package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//using arraylist
public class repersentation {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        //vertex 0
        graph[0].add(new Edge(0,1,5));
        //vertex 1
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        //vertex 2
        graph[2].add(new Edge(2,  1,1));
        graph[2].add(new Edge(2,  3,1));
        graph[2].add(new Edge(2,  4,4));
        //vertex 3
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        //vertex 4
        graph[4].add(new Edge(4,2,1));
        System.out.println(graph[0]);

        //2's neighbours
        for(int i=0;i<graph[2].size();i++){
           Edge e=graph[2].get(i);
           System.out.println(e.dest);
        }
        //bfs
        public static void bfs(ArrayList<Edge>[] graph) {
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            boolean[] visited = new boolean[graph.length];
            visited[0] = true;
        
            while (!q.isEmpty()) {
                int curr = q.remove();
                System.out.println(curr); // Print the current node
        
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    if (!visited[e.dest]) { // Ensure we add only unvisited nodes
                        q.add(e.dest);
                        visited[e.dest] = true; // Mark as visited when added to queue
                    }
                }
            }
        }
        
        //dfs
        public static void dfs(ArrayList<Edge>[] graph,int curr,boolean[] visited){//O(v+e)
            System.out.println(curr);
            visited[curr]=true;
            for(int i=0;i<graph[curr].size();i++){//O(v+e)
                Edge e=graph[curr].get(i);
                if(!visited[e.dest]){
                    dfs(graph,e.dest,visited);
                }
            }
        }
        //hash path using dfs
        public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){//O(v+e)
            if(src==dest){
                return true;
            }
            visited[src]=true;//mark visited first element
            for(int i=0;i<graph[src].size();i++){
                Edge e=graph[src].get(i);
                if(!visited[e.dest]){
                    boolean res=hasPath(graph,e.dest,dest,visited);
                    if(res){
                        return true;
                    }
                }
            }
            return false;
        
    
    }
    //connected components
    public static void connectedComponents(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfsutil(graph,i,visited);
            }
        }
        }
        private static void dfsutil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
            System.out.println(curr);
            visited[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(!visited[e.dest]){
                    dfsutil(graph,e.dest,visited);
                }
            }
    }
    
    //cycle detection in undirected graph using dfs
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                isCycleutil(graph ,visited,i,-1);
                return true;
            }
    }
            return false;
    }
    private static boolean isCycleutil(ArrayList<Edge>[] graph,  boolean[] visited,int curr,int parent) {
        
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){//for each neighbour of current node
            Edge e=graph[curr].get(i);
            if(!visited[e.dest] && isCycleutil(graph,visited,e.dest,curr)){
                return true;
            }
            else if(e.dest!=parent){
                return true;
            }
    }
        return false;
    
}
    //bipartite graph
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int[] color=new int[graph.length];
        for(int i=0;i<color.length;i++){
           color[i]=-1;//no color assigned
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){//bfs
                q.add(i);
                color[i]=0;//assign color yellow
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(j);
                        if(color[e.dest]==-1){
                            int nextcol = color[curr]==0 ? 1 : 0;//assign alternate color
                            color[e.dest]=nextcol;
                            q.add(e.dest);
                        }
                        else if(color[e.dest]==color[curr]){//same color
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    //cycle detection in directed graph using dfs
    public static boolean isCycledir(ArrayList<Edge>[] graph) {
        boolean[] visited=new boolean[graph.length];
        boolean stack[] =new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCycledirutil(graph,visited,stack,i,-1)){
                    return true;
            }
            }
            }
            return false;
        }
        //isCylendriuttil
        public static boolean isCycledirutil(ArrayList<Edge>[] graph,int curr,boolean[] visited,boolean[] stack){
            visited[curr]=true;
            stack[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(stack[e.dest]){
                    return true;
                }
                else if(!visited[e.dest] && isCycledirutil(graph,e.dest,visited,stack) || !visited[e.dest] && stack[e.dest]&& isCycledirutil(graph,e.dest,visited,stack)){
                    return true;
                }
            }
            stack[curr]=false;
            return false;

        }
    
    //tropological sort using dfs
    public static void topoSort(ArrayList<Edge>[] graph){
        Stack<Integer> st=new Stack<>();//O(v+e)
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                topoSortUtil(graph,i,visited,st);
            }
        }
        while(!st.isEmpty()){//element printing
            System.out.println(st.pop());
        }
    }
    public static void topoSortUtil(ArrayList<Edge>[] graph,int curr,boolean[] visited,Stack<Integer> st){
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest]){
                topoSortUtil(graph,e.dest,visited,st);
            }
        }
        st.push(curr);
    }
    //tropological sort using bfs kahn's algorithm
    public static void topoSortBFS(ArrayList<Edge>[] graph){
        Queue<Integer> q=new LinkedList<>();//O(v+e)
        int[] indegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                indegree[e.dest]++;
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){//element printing
            int curr=q.remove();
            System.out.println(curr);
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }  
    //all path from source target
    public static void allPathFromSourceToTarget(int[][] graph,int src,int target,ArrayList<Integer> path){
        
        if(src==target){
            System.out.println(path+"->"+target);
            return;
            }
            for(int i=0;i<graph[src].size();i++){
               Edge e=graph[src].get(i);
               allPathFromSourceToTarget(graph, e.dest, target, path+src);
              
            }
    }
    //dijastra's algorithm
    static class pair Comparable<pair>{
        int n;
        int path;
        pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(pair p2){
            return this.path-p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[],int src){
        int[] dist=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean visited[]=new boolean[graph.length];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        pq.add(new pair(src,0));
        while(!pq.isEmpty()){
            pair curr=pq.remove();
           if(visited[curr.n]){
            visited[curr.n]=true;
            for(int i=0;i<graph[curr.n].size();i++){
                Edge e=graph[curr.n].get(i);
                int u=e.src;
                int v=e.dest;
                int weight=e.wt;
                if(dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;
                    pq.add(new pair(v,dist[v]));
                }
                }
                }
                }
    }
    
    //bellman ford algorith
    public static void bellmanFord(ArrayList<Edge> graph[],int src){
        int[] dist=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            dist[i]=Integer.MAX_VALUE;
            }
        
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int weight=e.wt;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                        dist[v]=dist[u]+weight;
                        }
                        }
                        }
                        }
}
    