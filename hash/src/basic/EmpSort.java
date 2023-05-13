package basic;


import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// 对薪水进行排序
// comparable , comparator 优先级更高
public class EmpSort {

    public static void main(String[] args) {
        // 1.comparable
        TreeMap<Emp, String> treeMap = new TreeMap<>();
        treeMap.put(new Emp(1001,"aa", 8000), "111111");
        treeMap.put(new Emp(1002,"bb", 18000), "111111");
        treeMap.put(new Emp(1003,"cc", 2000), "111111");

        // 2000 8000 18000 对薪水进行排序
        Set<Map.Entry<Emp, String>> entries = treeMap.entrySet();
        for (Map.Entry<Emp, String> entry : entries) {
            Emp emp = entry.getKey();
            System.out.println(emp.getSalary() + " " + entry.getValue());
        }


        //2.comparator
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            // 根据key值比较
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        map.put("a", "8000");
        map.put("c", "300000");
        map.put("b", "2000000");

        // a b c

        Set<Map.Entry<String, String>> entries1 = map.entrySet();
        for (Map.Entry<String, String> entry : entries1) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
