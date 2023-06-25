package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie3;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Average {

    Random random = new Random();

    final int QUANTITY_DRAWN_NUMBERS = 10000000;
    int[] numbersDatabase = new int[QUANTITY_DRAWN_NUMBERS];

    public double calculateAverage(){
        createDatabaseNumbers();
        double sum = 0;
        for(int source = 0; source < QUANTITY_DRAWN_NUMBERS; source++){
            sum = sum + numbersDatabase[source];
        }
        return sum / QUANTITY_DRAWN_NUMBERS;
    }

    public double calculateAverageMonteCarlo(int randomNumbersMonteCarlo){
        double sum = 0;
        for(int source = 0; source < randomNumbersMonteCarlo; source++){
            int numberIdNumbersDataBase = numbersDatabase[random.nextInt(numbersDatabase.length)];
            sum = sum + numberIdNumbersDataBase;
        }
        return sum / randomNumbersMonteCarlo;
    }

    public void createDatabaseNumbers(){
        for(int source = 0; source < QUANTITY_DRAWN_NUMBERS; source++){
           numbersDatabase[source] = random.nextInt(10000000);
        }
    }

}
