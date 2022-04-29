package github.com.sjurhr;

import github.com.sjurhr.Exceptions.AZException;
import github.com.sjurhr.Exceptions.IncorrectSizeException;

import java.util.*;

public class Words {
    private String solution;
    private Result result;

    private final String regexAtoZ = "[A-Za-z]+";

    public Words(String solution) throws AZException {
        if(!solution.matches(regexAtoZ)){
            throw new AZException("can only contain letters a-z");
        }
        this.solution = format(solution);
        this.result = new Result();
    }

    public Result checkGuess(String guess) throws IncorrectSizeException, AZException {

        if(solution.length() != guess.length()){
            throw new IncorrectSizeException("Lenght of guess words does not match solution.");
        }
        if(!guess.matches(regexAtoZ)){
            throw new AZException("can only contain letters a-z");
        }

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
                    guessArr[i] = '2';
                }
            }
        }
        for (int i = 0; i< guessArr.length; i++){
            System.out.print(" " + guessArr[i] + " ");
        }
        System.out.print("\n");

        result.addResult(guessArr);
        return result;
    }

    private String format(String word){
        return word.trim().toLowerCase();
    }

    public String getSolution() {
        return solution;
    }

    public Result getResult() {
        return result;
    }
}
