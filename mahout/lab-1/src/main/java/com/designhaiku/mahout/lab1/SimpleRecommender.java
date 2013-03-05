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
 * Date: 3/4/13
 */
public class SimpleRecommender {
    private DataModel model;
    private UserSimilarity similarity;
    private UserNeighborhood neighborhood;
    private Recommender recommender;

    public SimpleRecommender() throws TasteException, IOException {

        model = new FileDataModel(new File("sales.csv"));
        similarity = new PearsonCorrelationSimilarity(model);
        neighborhood = new NearestNUserNeighborhood(2, similarity, model);
        recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
    }

    public List<RecommendedItem> recommend(int userId, int count) throws TasteException {
        return recommender.recommend(userId, count);
    }
}
