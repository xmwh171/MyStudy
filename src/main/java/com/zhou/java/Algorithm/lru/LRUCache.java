package com.zhou.java.Algorithm.lru;

import java.util.*;


/**
 * 实现思路：
 * 头结点后存放最新使用的节点，每次使用节点都会把此节点移到到头节点后，新增数据也是放在头节点后，容量不足移除尾节点元素
 */
public class LRUCache {

    private Hashtable<Integer, DLinkedNode>
            cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }

    int getCount(){
        return count;
    }

    int getCapacity(){
        return capacity;
    }

    /**
     * 将当前节点移至头结点后返回数据
     * @param key
     * @return
     */
    public int get(Integer key) {

        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }
    /**
     * Always add the new node right after head;
     * 始终在头之后添加新节点；
     */
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    /**
     * Remove an existing node from the linked list.
     * 从链接列表中删除现有节点。
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     * 将某些节点移动到头部之间。
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail. 弹出当前尾节点。
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        int capacity = 10;
        LRUCache cache = new LRUCache(capacity);
        for(int i=0;i<capacity; i++){
            cache.set(i,i);
        }
        System.out.println(cache.getCapacity());
        System.out.println(cache.getCount());
        System.out.println(cache.get(1));
        cache.get(4);

        System.out.println(cache);
    }
}

///**
// * @Description
// * @Author xiaohu
// * @Date 2021/3/4 13:48
// */
//public class LRUCache<K, V> extends LinkedHashMap<K, V> {
//
//    private final int CACHE_SIZE;
//
//    /**
//     * 传递进来最多能缓存多少数据
//     *
//     * @param cacheSize 缓存大小
//     */
//    public LRUCache(int cacheSize) {
//        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
//        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
//        CACHE_SIZE = cacheSize;
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
//        return size() > CACHE_SIZE;
//    }
//
//}
