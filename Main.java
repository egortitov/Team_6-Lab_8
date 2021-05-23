package com.company;

import com.company.hashtable.CustomHashTable;
import com.company.hashtable.Data;
import com.company.tree.BST;


public class Main {

    public static void main(String[] args) {
        int[] size = {1_000, 10_000, 20_000, 25_000};
        for (int i: size) {
            System.out.println("\nSize: " + i);
            DataProcessor dp = new DataProcessor(new BST(), new CustomHashTable(), i);

            System.out.println("Tree Inserting: " + dp.insertTree());
            System.out.println("Tree Searching: " + dp.searchTree());

            System.out.println("Map Inserting: " + dp.insertMap());
            System.out.println("Map Searching: " + dp.searchMap());
            System.out.println();


        }

        Data data = new Data(10, "Uxtomskogo", 2354);
        System.out.println(data.hashCode());
        Data data1 = new Data(1, "Uxtomskogo", 2354);
        System.out.println(data1.hashCode());
        Data data2 = new Data(10, "Uxtomskogo", 354);
        System.out.println(data2.hashCode());

    }
}
