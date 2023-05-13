package basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private int maxSize;
    public LruCache(int maxSize){
        // 使用父类的构造器  初始化
        super(16,0.75f,true);
        this.maxSize = maxSize;
    }


    // 添一个  会把最老的移除掉
    // 比最大容量大，直接删除最老的一个
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
