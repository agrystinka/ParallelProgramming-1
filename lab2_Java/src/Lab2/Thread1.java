package Lab2;

import Data.InvalidIndexException;
import Data.Matrix;
import Data.Vector;
import Data.Functions;

//Thread1 class. Thread1 implemented using extend from the Thread class
public class Thread1 extends Thread{

    //Input and output variables
    private Matrix ma, mb;
    private Vector a, b;
    private double result;

    Thread1(Matrix ma, Matrix mb, Vector a, Vector b, String name, int priority){
        this.ma = ma;
        this.mb = mb;
        this.a = a;
        this.b = b;
        setName(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        System.out.println("T1 started");
        super.run();
        try {
            sleep(1000);
            result = Functions.func1(ma, mb, a, b);
        } catch (InvalidIndexException e) {
            System.out.println("Invalid indexes for initialized matrices and vectors");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T1 finished");
    }

    public double getResult(){
        return result;
    }
}
