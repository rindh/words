package github.com.sjurhr;

public class Main {

    public static void main(String[] args){
        Words w = new Words("hello", 6, 5);

        w.checkGuessV2("hallo");

       /* int[][] res = w.getGuesses();
        w.checkGuess("lllll");

        String print = "";
        for(int i = 0; i< res.length; i++){
            for(int j = 0; j<res[i].length; j++){
                print += " " + res[i][j] + " ";
            }
            print += "\n";
        }
        System.out.println(print);
        */
    }
}
