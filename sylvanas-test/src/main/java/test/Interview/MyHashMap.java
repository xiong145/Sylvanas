package test.Interview;

import java.util.HashMap;

public class MyHashMap {
    public static void main(String[] args) {
        /**
         * 构造一个具有指定初始容量和默认负载因子(0.75)的空HashMap。
         */
        /**
         * 当链表长度大于阈值（默认为 8）时，会首先调用 treeifyBin()方法。
         * 这个方法会根据HashMap 数组来决定是否转换为红黑树。
         * 只有当数组长度大于或者等于64的情况下，才会执行转换红黑树操作，以减少搜索时间。
         * 否则，就是只是执行resize() 方法对数组扩容。
         */
        HashMap<Object, Object> hashMap = new HashMap(100);
        /**
         *  put方法 public V put(K key, V value) {return putVal(hash(key), key, value, false, true);}
         *  触发 putVal 即为实际put操作
         */
//        java.util.HashMap.putVal();
        /**
         * 除非表太小，否则将在给定哈希索引处替换bin中所有链接的节点
         */
//        java.util.HashMap.treeifyBin();
        /**
         * 初始化或加倍表大小。如果为空，则按照字段阈值中保留的初始容量目标进行分配。否则，由于我们使用的是2的幂展开，每个bin中的元素必须保持相同的索引，或者在新表中以2的幂偏移量移动。
         */
        /**
         * 一般情况下，当元素数量超过阈值时便会触发扩容。每次扩容的容量都是之前容量的2倍。HashMap 的容量是有上限的，必须小于 1<<30，即 1073741824。如果容量超出了这个数，则不再增长，且阈值会被设置为 Integer.MAX_VALUE。
         */
//        java.util.HashMap.resize();
    }
}
