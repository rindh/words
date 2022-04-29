package github.com.sjurhr;

public enum Status {
    R, W, N;


    public String toString(){
        switch (this){
            case R:
                return "Right position and letter";
            case W:
                return "right letter, wrong position";
            case N:
                return "Wrong letter";
        }
        return "Undefined";
    }
}
