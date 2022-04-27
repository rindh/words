package github.com.sjurhr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    @Test
    public void test_make_word(){
        Words words = new Words("Hello", 6,6);
        int[][] guesses = words.getGuesses();
        assertEquals(words.getGuesses().length, 6);
        for (int i = 0; i < guesses.length; i++){
            for(int j = 0; j < guesses[i].length; j++){
                assertEquals(guesses[i][j], 0);
            }
        }
        assertEquals(words.getGuessNumber(), 0);
    }

    @Test
    public void test_checkGuess(){
        Words words = new Words("Hello", 6,5);

        int[][] guesses = words.getGuesses();
        for (int i = 0; i <= 0; i++){
            for(int j = 0; j < guesses[i].length; j++){
                assertEquals(2, guesses[i][j]);
            }
        }
        assertEquals(words.getGuessNumber(), 1);
        words.checkGuess("hiomb");

        for (int i = 0; i <= 0; i++){
            for(int j = 0; j < guesses[i].length; j++){
                if(j == 0 && i == 1){
                    assertEquals(0, guesses[i][j]);
                }
                assertEquals(2, guesses[i][j]);
            }
        }
        assertEquals(words.getGuessNumber(), 2);
        words.checkGuess("hello");
        for (int i = 0; i <= 0; i++){
            for(int j = 0; j < guesses[i].length; j++){
                if(i == 2){
                    assertEquals(0, guesses[i][j]);
                }
                assertEquals(2, guesses[i][j]);
            }
        }
    }
}