package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
public class Transaction {

    double amount;
    String lastTransaction;
    int nonce;


}
