package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class NumberPi {

    final double RADIUS = 1;

    @Autowired
    PointsDatabase pointDatabase;
    Random random = new Random();

    public double calculatePi(int quantityPoints){
        createDateBasePoints(quantityPoints);
        return (calculateCircle(quantityPoints) / (2 * RADIUS));
    }

    private void createDateBasePoints(int quantityPoints) {
        pointDatabase.persistPoint(new Point(0, 1));
        double[] DatabaseRandomX = drawAndSortRandomX(quantityPoints);
        for (int source = 0; source < quantityPoints; source++) {
            double y = Math.sqrt((Math.sqrt(RADIUS)) - (Math.pow(DatabaseRandomX[source], 2)));
            pointDatabase.persistPoint(new Point(DatabaseRandomX[source], y));
        }
        pointDatabase.persistPoint(new Point(1, 0));
    }

    private double[] drawAndSortRandomX(int quantityPoints) {
        double[] DatabaseRandomX = new double[quantityPoints];
        for (int source = 0; source < quantityPoints; source++) {
            DatabaseRandomX[source] = random.nextDouble(1);
        }
        Arrays.sort(DatabaseRandomX);
        return DatabaseRandomX;
    }

    private double calculateCircle(int quantityPoints){
        double quarterCircle = 0;
        for(int source = 0; source < quantityPoints+1; source++){
            double singeDistanceBetweenXX = pointDatabase.getPoint(source+1).x() - pointDatabase.getPoint(source).x();
            double singeDistanceBetweenYY  = pointDatabase.getPoint(source).y() - pointDatabase.getPoint(source+1).y();
            double singleDistanceBetweenTwoPoints = Math.sqrt((Math.pow(singeDistanceBetweenXX,2)+(Math.pow(singeDistanceBetweenYY ,2))));
            quarterCircle = quarterCircle + singleDistanceBetweenTwoPoints;
        }
        return 4 * quarterCircle;
    }


}
