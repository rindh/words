package github.com.sjurhr;

import java.util.*;

public class Words {
    private Map<Character, List<Integer>> word;
    private int[][] guesses;
    private int guessNumber = 0;
    private int rounds;
    private int wordLength;
    public Words(String solution, int rounds, int wordLength){
        makeWord(solution);
        this.rounds = rounds;
        this.wordLength = wordLength;
        this.guesses = new int[rounds][wordLength];
    }

    private void makeWord(String solution){
        word = new HashMap<>();
        solution = format(solution);

        for(int i = 0; i < solution.toCharArray().length; i++){
            word.computeIfAbsent(solution.charAt(i), k -> new ArrayList<>()).add(i);
        }
    }

    public void checkGuess(String guess){
        guess = format(guess);
        char[] guessChar = guess.toCharArray();

        for(int i = 0; i < guessChar.length; i++){
            boolean contains = false;
            boolean rightPos = false;
            if(word.get(guessChar[i]) != null){
                contains = true;
                if(word.get(guessChar[i]).contains(i)){
                    rightPos = true;
                    contains = false;
                }
            }
            if (rightPos){
                guesses[guessNumber][i] = 0;
            } else if(contains){
                guesses[guessNumber][i] = 1;
            }else {
                guesses[guessNumber][i] = 2;
            }
        }
        guessNumber++;
    }

    private String format(String word){
        return word.trim().toLowerCase();
    }

    public Map<Character, List<Integer>> getWord() {
        return word;
    }

    public int[][] getGuesses() {
        return guesses;
    }

    public int getGuessNumber() {
        return guessNumber;
    }
}
