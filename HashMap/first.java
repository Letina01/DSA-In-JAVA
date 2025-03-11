package HashMap;
import java.util.HashMap;
import java.util.Set;

public class first {
    public static void main(String[] args) {

        HashMap<String,Integer> map=new HashMap<>();
        //insertion
        map.put("India",10000);
        map.put("America",20000);
        map.put("China",30000);
        map.put("Russia",40000);
        map.put("Pakistan",50000);
        System.out.println(map);

        //get
        System.out.println(map.get("India"));
        //containskey
        System.out.println(map.containsKey("America"));//true
        System.out.println(map.containsKey("Japan"));//false
        //containsvalue
        System.out.println(map.containsValue(40000));//true
        System.out.println(map.containsValue(500000));//false
        //remove
        System.out.println(map.remove("America"));
        System.out.println(map);
        //size
        System.out.println(map.size());
        //isEmpty
        System.out.println(map.isEmpty());//false
        //clear
        //map.clear();
        //System.out.println(map.isEmpty());//true

    //iteration
    //map.entrySet();
      Set<String> keys=map.keySet();
      System.out.println(keys);
      for (String key : keys) {
        System.out.println(key+" "+map.get(key));
        
      }
    
    }
    

}

