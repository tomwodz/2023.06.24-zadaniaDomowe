package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie1;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class HashTransaction {

    final int QUANTITY_LAST_ZERO = 5;
    public String drawFirstHash(int nonce){
        return  DigestUtils.md5Hex(Integer.toString(nonce));
    }

    public String drawHash(String getLastTransaction, int nonce){
        String NewHash= DigestUtils.md5Hex(getLastTransaction + Integer.toString(nonce));
        verificationLastTransaction(NewHash);
        return  NewHash;
    }

    public boolean checkToPossibilityHashLastZero(String getLastTransaction, int nonce){
        return verificationLastTransaction(DigestUtils.md5Hex(getLastTransaction + Integer.toString(nonce)));
    }
    private boolean verificationLastTransaction(String contents){
        String NewContents = contents.substring(contents.length()-QUANTITY_LAST_ZERO,contents.length());
        return verificationLastTransactionLastZero(NewContents, NewContents.length(), 0);
    }

    private boolean verificationLastTransactionLastZero(String newContents, int destination, int source){
        if(source == destination){
            return true;
        }
        else {
            if(!newContents.substring(source,source+1).equals("0")){
                return false;
            }
            return verificationLastTransactionLastZero(newContents, destination, source+1);
        }
    }

}
