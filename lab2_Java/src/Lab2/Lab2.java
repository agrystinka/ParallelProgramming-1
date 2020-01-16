package Lab2;

import Data.Functions;
import Data.InvalidIndexException;
import Data.Matrix;
import Data.Vector;

/*---------Main class----------
Parallel and Distributed Computing
Labwork 2. Threads in Java

F1: c = MAX(MA*MB)*(A*B)
F2: MF = TRANS(MG)+MK*ML
F3: S = (O+P)*TRANS(MR*MT)
*/
public class Lab2 {
    //Matrix size
    private static int n = 3;

    //Input vectors
    private static Vector a, b, o ,p;

    //Input matrices
    private static Matrix ma, mb, mg, mk, ml, mr, mt;

    //Result of func3
    private static Vector res3;

    //Main method
    public static void main(String[] args) {
        System.out.println("Lab2 started");

        //Initialization of input vectors and matrices
        a = new Vector(n, 1);
        b = new Vector(n, 1);
        o = new Vector(n, 1);
        p = new Vector(n, 1);
        ma = new Matrix(n, n, 1);
        mb = new Matrix(n, n, 1);
        mg = new Matrix(n, n, 1);
        mk = new Matrix(n, n, 1);
        ml = new Matrix(n, n, 1);
        mr = new Matrix(n, n, 1);
        mt = new Matrix(n, n, 1);

        //Initialization of Thread1 instance
        Thread1 t1 = new Thread1(ma, mb, a, b, "T1", 1);

        //Initialization of Thread2 instance
        Thread2 t2r = new Thread2(mg, mk, ml);

        //Initialization of thread that uses Thread2 instance
        Thread t2 = new Thread(t2r);
        t2.setName("T2");
        t2.setPriority(5);

        //Initialization of t3 using lambda expressions
        Thread t3 = new Thread(() -> {
            System.out.println("T3 started");
            try {
                res3 = Functions.func3(o, p, mr, mt);
            } catch (InvalidIndexException e){
                System.out.println("Invalid indexes for initialized matrices and vectors");
            }
            System.out.println("T3 finished");
        });
        t3.setName("T3");
        t3.setPriority(10);

        //Start of all 3 threads
        t1.start();
        t2.start();
        t3.start();

        //Let the main thread wait till all 3 threads end running
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Output of results
        if(n < 10) {
            double res1 = t1.getResult();
            Matrix res2 = t2r.getResult();
            System.out.println("F1 result: \n" + res1 + "\n");
            System.out.println("F2 result: \n" + res2);
            System.out.println("F3 result: \n" + res3 + "\n");
        }

        System.out.println("Lab2 finished");
    }
}
