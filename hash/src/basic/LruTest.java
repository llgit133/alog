package basic;

import java.util.Map;
import java.util.Set;

public class LruTest {

    public static void main(String[] args) {
        LruCache<String, String> cache = new LruCache<>(3);
        for (int i = 0; i < 10; i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
        }
        // 7 8 9

        cache.get("7");
        //8 9 7

        cache.get("7");
        cache.get("8");
        cache.put("10","10");
        // 9 7 10

        Set<Map.Entry<String, String>> entries = cache.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
