package Lab2;

import Data.Functions;
import Data.InvalidIndexException;
import Data.Matrix;

//Thread2 class. Thread2 implemented using implement from the Runnable interface
public class Thread2 implements Runnable {

    //Input and output variables
    private Matrix mg, mk, ml;
    private Matrix result;

    Thread2(Matrix mg, Matrix mk, Matrix ml){
        this.mg = mg;
        this.mk = mk;
        this.ml = ml;
    }

    @Override
    public void run() {
        System.out.println("T2 started");
        try {
            result = Functions.func2(mg, mk, ml);
        } catch (InvalidIndexException e) {
            System.out.println("Invalid indexes for initialized matrices and vectors");
        }
        System.out.println("T2 finished");
    }

    public Matrix getResult(){
        return result;
    }
}
