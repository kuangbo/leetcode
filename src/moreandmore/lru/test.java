package moreandmore.lru;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/2
 * Time: 上午9:49
 */
public class test {
    public static void main(String[] args) {
        System.out.println("===========================LRU LinkedHashMap(delegation)实现===========================");
        moreandmore.lru.LRUCache<Integer, String> lru = new moreandmore.lru.LRUCache<>(5);
        lru.put(1, "11");
        lru.put(2, "11");
        lru.put(3, "11");
        lru.put(4, "11");
        lru.put(5, "11");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        int[] arr = new int[]{0,1,2,3,4,5,6};
        System.out.println(arr[0]);
    }
}
