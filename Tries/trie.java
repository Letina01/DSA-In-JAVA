package Tries;

import java.util.List;

public class trie {
    static class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++)
                children[i] = null;

        
        freq=1;
    }
}

    public static Node root = new Node();

    public static void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }else{
                current.children[index].freq++;//this part code for prefix tree
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public static boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;//word not exist
            }
            current = current.children[index];
        }
        return current.isEndOfWord==true;
    }
    //word break problem using tries
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && search(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            return dp[s.length()];
        }
                return false;
        
    }
    //prefix tree for shotest unique prefix
    public static void shortestUniquePrefix(String ans, Node root ) {//O(L)
        if(root == null) return;
        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                shortestUniquePrefix(ans+(char)(i+'a'),root.children[i]);
        }
        }
    }
    //start with problem
    public static boolean startWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        
    return true;
    }
    //count unique substring using first cut sufix
    public static int countUniqueSubstring(Node root) {
        if(root==null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i <26; i++) {
            if (root.children[i] != null) {
                count += countUniqueSubstring(root.children[i]);
            }
        }
        return count + 1;
    }
    //longest word with all prefixes
    public static String ans="";
    public static void longestWordWithAllPrefixes(Node root,StringBuilder temp) {
        if(root==null){
            return ;
        }
        for(int i=0;i<26;i++){// gives larger ti smaller i--
            if(root.children[i]!=null && root.children[i].isEndOfWord==true){
            char ch=(char)(i+'a');
            temp.append(ch);
            if(temp.length()>ans.length()){
                ans=temp.toString();
            }
            longestWordWithAllPrefixes(root.children[i],temp);
            temp.deleteCharAt(temp.length()-1);//backtrack

            }
            }
        }
    public static void main(String[] args) {
        // insert o(L) largest word length
        String word[]={"i","like","sam","sung","samsung","man","go","mango","ice"};
        for(int i=0;i<word.length;i++){
            insert(word[i]);
        }
        //print all unique prefix
        shortestUniquePrefix("",root);
        //check if prefix exist
        System.out.println(startWith("sam"));

        String str="abcde";
        //sufix->insert in  tries
        for(int i=str.length()-1;i>=0;i--){
            String suffix=str.substring(i);
            insert(suffix);
        }

        //count unique substring
        System.out.println(countUniqueSubstring(root));
        //longest word with all prefixes
    }

}
