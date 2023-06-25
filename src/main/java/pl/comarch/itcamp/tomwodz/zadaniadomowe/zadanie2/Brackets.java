package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie2;

import org.springframework.stereotype.Component;

@Component
public class Brackets {

    public boolean verificationBrackets(String contents){
        return verificationBrackets(contents, 0, contents.length(),0,0);
    }

    private boolean verificationBrackets(String contents,
                                         int source,
                                         int destination,
                                         int quantityOpeningBrackets,
                                         int quantityLockingBrackets)
    {
        if(quantityOpeningBrackets < quantityLockingBrackets){
            return false;
        }
       else if(source == destination){
           if(quantityOpeningBrackets == quantityLockingBrackets){
               return true;
           }
           return false;
       }
        else {
            if(contents.substring(source,source+1).equals("(")){
                return verificationBrackets(contents, source + 1, destination,
                        quantityOpeningBrackets + 1, quantityLockingBrackets);
            }
            else if(contents.substring(source,source+1).equals(")")){
                return verificationBrackets(contents, source + 1, destination,
                                            quantityOpeningBrackets, quantityLockingBrackets + 1);
            }
            else {
                return verificationBrackets(contents, source + 1, destination,
                                            quantityOpeningBrackets, quantityLockingBrackets);
            }
       }
    }

}
