package pl.comarch.itcamp.tomwodz.zadaniadomowe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1.HashTransaction;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1.RandomAmountAndNonce;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1.Transaction;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1.TransactionDatabase;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie2.Brackets;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie3.Average;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie4.NumberPi;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie4.NumberPiMonteCarlo;
import pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie4.PointsDatabase;

@SpringBootApplication
public class ZadaniaDomoweApplication {

    @Autowired
    RandomAmountAndNonce random;
    @Autowired
    HashTransaction hashTransaction;
    @Autowired
    TransactionDatabase database;

    public static void main(String[] args) {
        SpringApplication.run(ZadaniaDomoweApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void zadanie1() {
        System.out.println("Start zadania 1: ");

        int firstNonce = random.drawRandomNonce();
        database.persistTransaction(
                                     new Transaction
                                                (random.drawRandomAmonut(),
                                                 hashTransaction.drawFirstHash(firstNonce),
                                                 firstNonce)
                                    );
        for (int i = 0; i < 4; i++) {
            boolean run = true;
            while (run) {
                int nonce = random.drawRandomNonce();
                boolean g = hashTransaction.checkToPossibilityHashLastZero(database.getLastTransaction(), nonce);
                if (g == true) {
                    database.persistTransaction(
                            new Transaction(
                                    random.drawRandomAmonut(),
                                    hashTransaction.drawHash(database.getLastTransaction(), nonce),
                                    nonce)
                    );
                    run = false;
                }
            }
        }
        database.getAllTransaction().stream().forEach(System.out::println);
        System.out.println("Koniec zadania 1. \n");
    }


    @Autowired
    Brackets brackets;
    @EventListener(ApplicationStartedEvent.class)
    public void zadanie2() {
        System.out.println("Start zadania 2: ");
        String contents= "(metoda(metoda(metoda)))";
        String contents2= "(metoda(metoda(metoda))))";
        String contents3= ")metoda(metoda)metoda(()";
        System.out.println(brackets.verificationBrackets(contents));
        System.out.println(brackets.verificationBrackets(contents2));
        System.out.println(brackets.verificationBrackets(contents3));
        System.out.println("Koniec zadania 2. \n");
    }

    @Autowired
    Average average;
    @EventListener(ApplicationStartedEvent.class)
    public void zadanie3() {
        System.out.println("Start zadania 3: ");
        System.out.println("Średnia arytmetyczna: \t" + average.calculateAverage());
        System.out.println("Średnia Monte Carlo: \t" + average.calculateAverageMonteCarlo(100000));
        System.out.println("Koniec zadania 3. \n");
    }

    @Autowired
    PointsDatabase pointsDatabase;
    @Autowired
    NumberPi numberPi;
    @Autowired
    NumberPiMonteCarlo numberPiMonteCarlo;

    @EventListener(ApplicationStartedEvent.class)
    public void zadanie4() {
        System.out.println("Start zadania 4 ");
        // pointsDatabase.getAllPoints().stream().forEach(System.out::println);
        double numberPiCalculated = numberPi.calculatePi(100000);
        double numberPiMonteCarloCalculated = numberPiMonteCarlo.calculatePiMonteCarlo(100000000);
        System.out.println("Liczba PI Math \t\t\t= \t" + Math.PI);
        System.out.println("Liczba PI \t\t\t\t= \t" + numberPiCalculated);
        System.out.println("Liczba PI Monte Carlo \t= \t" + numberPiMonteCarloCalculated);
        System.out.println("Koniec zadania 4. \n");
    }

}
