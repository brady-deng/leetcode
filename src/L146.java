/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/23
 **/
public class L146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
    }
}
