package github.com.sjurhr;

import java.util.*;

public class Words {
    private String solution;

    public Words(String solution){
        this.solution = solution;
    }

    public void checkGuess(String guess) {
        char[] wordArr = this.solution.toCharArray();
        char[] guessArr = format(guess).toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> counter = new HashMap<>();

        for(int i = 0; i < wordArr.length; i++){
            if(wordArr[i] == guessArr[i]){
                wordArr[i] = '0';
                guessArr[i] = '0';
            } else {
                count.merge(wordArr[i], 1, Integer::sum);
            }
        }

        for(int i = 0; i < guessArr.length; i++){
            if(guessArr[i] != '0'){
                for(int j = 0; j < wordArr.length; j++){
                    int countere = counter.get(guessArr[i]) != null ? counter.get(guessArr[i]): 0 ;
                    int counts = count.get(guessArr[i]) != null ? count.get(guessArr[i]) : 0;
                    if (guessArr[i] == wordArr[j] && counts > countere){
                        counter.merge(guessArr[i],1, Integer::sum);
                        guessArr[i] = '1';
                        break;
                    }
                }
                if(guessArr[i] != '1') {
                    guessArr[i] = '3';
                }
            }
        }

        for(int i = 0; i < guessArr.length; i++) {
            System.out.print(" " + guessArr[i] + " ");
        }
    }

    private String format(String word){
        return word.trim().toLowerCase();
    }

}
