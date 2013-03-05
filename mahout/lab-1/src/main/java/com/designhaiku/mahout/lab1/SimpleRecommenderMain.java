package com.designhaiku.mahout.lab1;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * User: Jeffrey M Lutz
 * Date: 2/24/13
 */
public class SimpleRecommenderMain {

    public static void main(String[] args) throws Exception {

        SimpleRecommender recommender = new SimpleRecommender();

        for (RecommendedItem recommendation : recommender.recommend(1, 2)) {
            System.out.println(recommendation);
        }

    }

}
