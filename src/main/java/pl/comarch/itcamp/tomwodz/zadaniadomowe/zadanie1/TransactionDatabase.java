package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TransactionDatabase {
    private final List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getAllTransaction(){
        return new ArrayList<>(this.transactions);
    }

    public String getLastTransaction(){
        return this.transactions.get(transactions.size()-1).getLastTransaction();
    }

    public void persistTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }



}
