package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberPiMonteCarlo {

    final double RADIUS = 1;
    Random random = new Random();
    public double calculatePiMonteCarlo(int quantityPoints){
        double counterPointInCircle = 0;
        double counterPointAll = 0;
        for(int source = 0; source < quantityPoints; source++){
            double x = random.nextDouble(1);
            double y = random.nextDouble(1);
            double individualRadius = Math.sqrt((Math.pow(x,2))+(Math.pow(y,2)));
            ++counterPointAll;
            if(individualRadius <= RADIUS){
                ++counterPointInCircle;
            }
        }
        return 4 * (counterPointInCircle/counterPointAll);
    }

}
