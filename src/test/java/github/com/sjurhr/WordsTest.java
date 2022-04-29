package github.com.sjurhr;

import github.com.sjurhr.Exceptions.AZException;
import github.com.sjurhr.Exceptions.IncorrectSizeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    @Test
    public void test_format() throws AZException {
        Words w = new Words("HelLo");
        assertTrue(w.getSolution().equals("hello"));
    }

    @Test
    public void test_make_word() throws Exception{
        Words words = new Words("Hello");
        List<Status> expected = Arrays.asList(Status.R, Status.N, Status.W, Status.R, Status.W);
        words.checkGuess("hdell");
        assertTrue(words.getResult().results.size() == 1);
        for(int i = 0; i < 5; i++) {
            assertEquals(words.getResult().results.get(0).get(i), expected.get(i));
        }
    }

    @Test
    public void test_IncorrectSizeException() throws Exception{
        Words words = new Words("Hello");
        assertThrows(IncorrectSizeException.class, () -> words.checkGuess("hellos"));
    }

    @Test
    public void test_AZException() throws Exception{
        Words words = new Words("Hello");
        assertThrows(AZException.class, () -> words.checkGuess("h3llo"));
    }
}