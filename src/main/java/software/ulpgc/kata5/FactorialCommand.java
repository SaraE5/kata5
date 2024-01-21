package software.ulpgc.kata5;

import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;

public class FactorialCommand implements Command{

    @Override
    public Output execute(Input input) {
        try {
            return factorial(input.get(":number"));
        } catch (NumberFormatException e){
            return Command.output(400,null);
        }
    }

    private Output factorial(String number) {return  factorial(parseInt(number));}

    private  static Output factorial(int n) {
        if (n>20) return Command.output(406, null);
        long factorial = LongStream.range(2, n+1).reduce(1, (a,i)->a*i);
        return Command.output(200,String.valueOf(factorial));
    }
}
