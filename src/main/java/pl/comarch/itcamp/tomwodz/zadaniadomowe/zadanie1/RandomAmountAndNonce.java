package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomAmountAndNonce {

    Random random = new Random();

    public double drawRandomAmonut(){
        return random.nextDouble(100);
    }

    public int drawRandomNonce(){
        return random.nextInt(100000000);
    }
}
