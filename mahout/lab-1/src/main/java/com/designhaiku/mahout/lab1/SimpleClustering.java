package com.designhaiku.mahout.lab1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.mahout.clustering.WeightedVectorWritable;
import org.apache.mahout.clustering.kmeans.Cluster;
import org.apache.mahout.clustering.kmeans.KMeansDriver;
import org.apache.mahout.common.distance.EuclideanDistanceMeasure;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.math.VectorWritable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Jeffrey M Lutz
 * Date: 2/4/13
 */
public class SimpleClustering {

    private Configuration conf;
    private FileSystem fs;
    private double[][] points;

    public SimpleClustering(double[][] points) throws Exception {
        this.points = points;
        init();
    }

    private void writePointsToFile(List<Vector> points,
                                         String fileName,
                                         FileSystem fs,
                                         Configuration conf) throws IOException {
        Path path = new Path(fileName);
        SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf,
                path, LongWritable.class, VectorWritable.class);
        long recNum = 0;
        VectorWritable vec = new VectorWritable();
        for (Vector point : points) {
            vec.set(point);
            writer.append(new LongWritable(recNum++), vec);
        }
        writer.close();
    }

    private List<Vector> getPoints(double[][] raw) {
        List<Vector> points = new ArrayList<Vector>();
        for (int i = 0; i < raw.length; i++) {
            double[] fr = raw[i];
            Vector vec = new RandomAccessSparseVector(fr.length);
            vec.assign(fr);
            points.add(vec);
        }
        return points;
    }

    private void init() throws Exception {
        int k = 2;
        List<Vector> vectors = getPoints(points);

        File testData = new File("testdata");
        if (!testData.exists()) {
            testData.mkdir();
        }
        testData = new File("testdata/points");
        if (!testData.exists()) {
            testData.mkdir();
        }

        conf = new Configuration();
        fs = FileSystem.get(conf);
        writePointsToFile(vectors, "testdata/points/file1", fs, conf);

        Path path = new Path("testdata/clusters/part-00000");
        SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf,
                path, Text.class, Cluster.class);

        for (int i = 0; i < k; i++) {
            Vector vec = vectors.get(i);
            Cluster cluster = new Cluster(vec, i, new EuclideanDistanceMeasure());
            writer.append(new Text(cluster.getIdentifier()), cluster);
        }
        writer.close();
    }

    public void cluster() throws Exception {
        KMeansDriver.run(conf, new Path("testdata/points"), new Path("testdata/clusters"),
                new Path("output"), new EuclideanDistanceMeasure(), 0.001, 10,
                true, false);

        SequenceFile.Reader reader = new SequenceFile.Reader(fs,
                new Path("output/" + Cluster.CLUSTERED_POINTS_DIR
                        + "/part-m-00000"), conf);

        IntWritable key = new IntWritable();
        WeightedVectorWritable value = new WeightedVectorWritable();
        while (reader.next(key, value)) {
            System.out.println(value.toString() + " belongs to cluster "
                    + key.toString());
        }
        reader.close();
    }
}
