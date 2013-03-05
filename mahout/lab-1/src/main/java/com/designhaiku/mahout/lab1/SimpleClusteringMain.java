package com.designhaiku.mahout.lab1;

/**
 * User: Jeffrey M Lutz
 * Date: 2/12/2013
 */
public class SimpleClusteringMain {

    public static void main(String[] args) throws Exception {
        double[][] points = {
                {10, 10}, {1, 1}, {10, 9},
                {1, 2}, {8, 10}, {3, 1},
                {10, 7}, {2, 2}, {9, 9},
                {3, 2}, {8, 9}, {3, 3}
        };

        SimpleClustering clustering = new SimpleClustering(points);
        clustering.cluster();
    }
}
