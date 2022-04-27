package github.com.sjurhr;

import java.util.*;

public class Words {
    private Map<Character, List<Integer>> letterMap;
    private String solution;
    private int[][] guesses;
    private int guessNumber = 0;
    private int rounds;
    private int wordLength;

    public Words(String solution, int rounds, int wordLength){
        this.solution = solution;
        this.letterMap = makeWord(solution);
        this.rounds = rounds;
        this.wordLength = wordLength;
        this.guesses = new int[rounds][wordLength];
    }

    private HashMap<Character, List<Integer>> makeWord(String input){
        HashMap<Character, List<Integer>> res = new HashMap<>();
        input = format(input);

        for(int i = 0; i < input.toCharArray().length; i++){
            res.computeIfAbsent(input.charAt(i), k -> new ArrayList<>()).add(i);
        }
        return  res;
    }

    public void checkGuess(String guess){
        guess = format(guess);
        char[] guessChar = guess.toCharArray();
        Map<Character, Integer> letterCount = new HashMap<>();

        for(int i = 0; i < guessChar.length; i++){
            boolean contains = false;
            boolean rightPos = false;
            if(letterMap.get(guessChar[i]) != null){
                contains = true;
                if(letterMap.get(guessChar[i]).contains(i)){
                    rightPos = true;
                    contains = false;
                }
            }
            letterCount.put(guessChar[i], +1);
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
    public void checkGuessV2(String guess){
        Map<Character, List<Integer>> guessMap = makeWord(guess);
        Set<Character> commonKeys = new HashSet<>(guessMap.keySet());
        commonKeys.retainAll(letterMap.keySet());

        Map<Integer, List<Integer>> outPut = new HashMap<>();

        for(char c : commonKeys){
            List<Integer> guessChars = guessMap.get(c);
            List<Integer> solutionChars = letterMap.get(c);
            List<Integer> common = new ArrayList<>(solutionChars);

            common.retainAll(guessChars);
            for(int x : common){
                outPut.computeIfAbsent(1, k -> new ArrayList<>()).add(0);
                System.out.println("MARK POS " + x +" as green");
            }

            if(guessChars.size() > common.size()){
                outPut.computeIfAbsent(1, k -> new ArrayList<>()).add(1);
            }

            //[3][4]  [3][5]
        }
        System.out.println(outPut.get(1));
    }
    private String format(String word){
        return word.trim().toLowerCase();
    }

    public Map<Character, List<Integer>> getLetterMap() {
        return letterMap;
    }

    public int[][] getGuesses() {
        return guesses;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public String getSolution() {
        return solution;
    }

    public int getRounds() {
        return rounds;
    }

    public int getWordLength() {
        return wordLength;
    }
}
