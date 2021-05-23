package com.company;

import com.company.hashtable.CustomHashTable;
import com.company.tree.AVL;
import com.company.tree.BST;

import java.util.Locale;


public class DataProcessor {
    private final BST tree;
    private final CustomHashTable map;
    private final int size;

    public DataProcessor(BST tree, CustomHashTable map, int size) {
        this.tree = tree;
        this.map = map;
        this.size = size;
    }

    public String insertTree(){
        long start = System.nanoTime();
        for (int i = 0; i <size; i++) {
            tree.insert(i);
        }
        return String.format(Locale.CANADA_FRENCH, "%,d", (System.nanoTime()-start));
    }


    public String searchTree(){
        long start = System.nanoTime();
        for (int i = 0; i <500 ; i++) {
           tree.search(i);
        }
       return String.format(Locale.CANADA_FRENCH, "%,d", (System.nanoTime()-start));
    }

    public String insertMap(){
        long start = System.nanoTime();
        for (int i = 0; i <size ; i++) {
            map.add("i", "i");
        }
        return String.format(Locale.CANADA_FRENCH, "%,d", (System.nanoTime()-start));
    }

    public String searchMap(){
        long start = System.nanoTime();
        for (int i = 0; i <500 ; i++) {
            map.search("i"+1);
        }
        return String.format(Locale.CANADA_FRENCH, "%,d", (System.nanoTime()-start));
    }


//    public String insertRandomTimer(){
//        Random random = new Random();
//        long start = System.nanoTime();
//        for (int i = 0; i <=1000 ; i++) {
//            tree.insert(random.nextInt());
//        }
//        return String.format(Locale.CANADA_FRENCH, "%,d", (System.nanoTime()-start));
//    }
//
//    public String deleteTimer(){
//        long start = System.nanoTime();
//        for (int i = 0; i <1000 ; i++) {
//           tree.delete(i);
//        }
//        return String.format(Locale.CANADA_FRENCH, "%,d", (System.nanoTime()-start));
//    }

    //    public String balancingTimer(){
//        long start = System.nanoTime();
//        tree.balancing();
//        return String.format(Locale.CANADA_FRENCH, "%,d", (System.nanoTime()-start));
//    }
}
