import java.util.*;
import java.lang.String;
public class Solve {
    private String eqaution;
    public Solve(String equation){

        this.eqaution = equation;

    }
    public double solve() {

        // list of all valid ints in @this.equation
        ArrayList<String> nums = new ArrayList<String>();

        // index of the logical symbol in @this.equation
        int symbolIndex = 0;

        // logical symbol in @this.equation
        String symbol = "";

        for (int i = 0; i < this.eqaution.length(); i++) {

            try {

                // if @i is a valid int, we add to @nums
                Integer.parseInt(this.eqaution.substring(i, i + 1));
                nums.add(this.eqaution.substring(i, i + 1));

            } catch (NumberFormatException e) {

                // if @i is not a valid int, we assume it is a logical symbol
                symbol = this.eqaution.substring(i, i + 1);
                symbolIndex = i;

            }

        }

        // @fullNumsInts1 is a String of the full ints before the logical symbol
        String fullNumsInts1 = "";

        // adding all numbers before @symbolIndex to create the whole number
            for (int j = 0; j < symbolIndex; j++) {

                fullNumsInts1 += nums.get(j);

            }


        // @fullNumsInts2 is a String of all the full ints after the logical symbol
        String fullNumsInts2 = "";


        // adding all numbers after @symbolIndex to create the whole number
        for (int i = symbolIndex; i < nums.size(); i++) {

            fullNumsInts2 += nums.get(i);

        }

        // checking which symbol was used and returning statement
        if (symbol.equals("*")) {return (double) Integer.parseInt(fullNumsInts1) * Integer.parseInt(fullNumsInts2);}
        if (symbol.equals("+")) {return (double) Integer.parseInt(fullNumsInts1) + Integer.parseInt(fullNumsInts2);}
        if (symbol.equals("-")) {return (double) Integer.parseInt(fullNumsInts1) - Integer.parseInt(fullNumsInts2);}
        if (symbol.equals("/")) {return (double) Integer.parseInt(fullNumsInts1) / Integer.parseInt(fullNumsInts2);}
        if (symbol.equals("%")) {return (double) Integer.parseInt(fullNumsInts1) % Integer.parseInt(fullNumsInts2);}
        else{return -1;}

    }
}
