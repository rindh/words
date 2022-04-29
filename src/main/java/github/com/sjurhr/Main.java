package github.com.sjurhr;

public class Main {

    public static void main(String[] args){

        try {
        Words w = new Words("hello");

        Result s = w.checkGuess("hdell");
        System.out.println(s.toString());

     //    s = w.checkGuess("hello");
         System.out.println(s.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
