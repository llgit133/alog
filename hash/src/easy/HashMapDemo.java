package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    // 无序输出
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","liming");
        map.put("age","12");
        map.put("sex","男");

        // map 的遍历  entry 拿到每一次put的记录
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
