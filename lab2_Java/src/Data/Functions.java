package Data;

//Class that contains calculated functions
public class Functions {

    //F1: c = MAX(MA*MB)*(A*B)
    public static double func1(Matrix ma, Matrix mb, Vector a, Vector b) throws InvalidIndexException{
        return (ma.mutiply(mb)).getMax() * a.multiply(b);
    }

    //F2: MF = TRANS(MG)+MK*ML
    public static Matrix func2(Matrix mg, Matrix mk, Matrix ml) throws InvalidIndexException{
        return mg.transpose().add(mk.mutiply(ml));
    }

    //F3: S = (O+P)*TRANS(MR*MT)
    public static Vector func3(Vector o, Vector p, Matrix mr, Matrix mt) throws InvalidIndexException{
        return o.add(p).multiply((mr.mutiply(mt)).transpose());
    }

}
