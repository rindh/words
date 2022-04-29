package github.com.sjurhr;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public List<List<Status>> results;

    public Result() {
        this.results = new ArrayList<>();
    }

    public List<List<Status>> getResults() {
        return results;
    }

    public List<List<Status>> addResult(char[] res){
        List<Status> newLine = new ArrayList<>();
        for(char c : res){
            switch (c){
                case '0':
                    newLine.add(Status.R);
                    break;
                case '1':
                    newLine.add(Status.W);
                    break;
                case '2':
                    newLine.add(Status.N);
                    break;
            }
        }
        results.add(newLine);
        return results;
    }

    public String toString(){
        String res = "";
        for(List<Status> stats : results){
            for (Status s : stats){
                res += " " + s.name() + " ";
            }
            res +="\n";
        }
        return res;
    }
}
