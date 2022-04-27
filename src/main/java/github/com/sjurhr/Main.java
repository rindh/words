package github.com.sjurhr;

public class Main {

    public static void main(String[] args){
        Words w = new Words("hallo", 6, 5);

        int[][] res = w.getGuesses();
        w.checkGuess("Hallo");
        w.checkGuess("Halol");
        w.checkGuess("abcdf");

        String print = "";
        for(int i = 0; i< res.length; i++){
            for(int j = 0; j<res[i].length; j++){
                print += " " + res[i][j] + " ";
            }
            print += "\n";
        }
        System.out.println(print);
    }
}
