package easy;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {

    // 会记录插入的顺序
    // 线程不安全
    public static void main(String[] args) {
        LinkedHashMap<String,String> map = new LinkedHashMap<>(16,0.75f,true);

        for (int i = 0; i < 5; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
        }

        // 有序性的体现  访问置顶  可以作缓存 可实现LRU算法
        map.get("2");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }



    }
}
