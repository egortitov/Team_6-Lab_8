package com.company.hashtable;

public class CustomHashTable {

    int size = 16;
    Entry[] entries = new Entry[size];


    public void add(String key,String value){
        Entry<String,String> entry = new Entry<>(key, value);
        Integer hashCode = hashCode(key);
        if(entries[hashCode] == null){
            entries[hashCode] = entry;
            return;
        }
        Entry<String,String> temp = entries[hashCode];
        while(temp != null) {
            if(temp.key.equalsIgnoreCase(key)){
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        temp.next = entry;
    }

    public boolean search(String key){
        Integer hasCode = hashCode(key);
        if(entries[hasCode] == null){
            return false;
        }
        if(entries[hasCode].next != null && ((String)entries[hasCode].key).equalsIgnoreCase(key))
            return true;

        Entry<String,String> temp  = entries[hasCode];
        while(temp!=null){
            if(temp.key.equalsIgnoreCase(key))
                return true;
            temp = temp.next;
        }
        return false;
    }

    private Integer hashCode(String key){
        return key.hashCode()>0?key.hashCode()%size:((-1)*key.hashCode())%size;
    }

}
    class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
