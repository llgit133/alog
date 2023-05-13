package easy;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

    // 直接是红黑树
    // 有排序  compare
    public static void main(String[] args) {
        Map<Integer, String> emps = new TreeMap<>();
        emps.put(10001, "1aaa");
        emps.put(10002, "2bbb");
        emps.put(10005, "5ccc");
        emps.put(10004, "4ccc");
        emps.put(10003, "3ccc");


        // 系统能排序
        // 用keySet遍历
        Set<Integer> keys = emps.keySet();
        for (Integer key : keys) {
            System.out.println(" "+key+" "+emps.get(key));
        }


        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("cc","8000");
        treeMap.put("aa","8000");
        treeMap.put("dd","8000");
        treeMap.put("bb","8000");

        // entrySet遍历  字典顺序
        Set<Map.Entry<String, String>> entries = treeMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(" "+entry.getKey()+" "+entry.getValue());
        }

    }
}
