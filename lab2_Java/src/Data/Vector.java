package Data;

import java.util.Arrays;

//Vector class. Containing all necessary methods to calculate func1, func2 and func3
public class Vector {

    double[] vector;

    public Vector(double[] vector){
        this.vector = Arrays.copyOf(vector, vector.length);
    }

    public Vector(int n, int k){
        vector = new double[n];
        fill(k);
    }

    //Returns vector that is a sum of this and vector2 vectors
    public Vector add(Vector vector2) throws InvalidIndexException{
        if(vector.length != vector2.vector.length)
            throw new InvalidIndexException();

        double[] sum = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            sum[i] = vector[i] + vector2.vector[i];
        }
        return new Vector(sum);
    }

    //Returns a number that is a scalar product of this and vector2 vectors
    public double multiply(Vector vector2) throws InvalidIndexException{
        if(vector.length != vector2.vector.length)
            throw new InvalidIndexException();

        double res = 0;
        for (int i = 0; i < vector.length; i++) {
            res += vector[i] * vector2.vector[i];
        }
        return res;
    }

    //Returns a vector that is a product of this vector and matrix matrix
    public Vector multiply(Matrix matrix) throws InvalidIndexException{
        if(vector.length != matrix.matrix.length)
            throw new InvalidIndexException();

        double[] product = new double[matrix.matrix[0].length];
        for (int i = 0; i < matrix.matrix[0].length; i++) {
            for (int k = 0; k < vector.length; k++) {
                product[i] += vector[k] * matrix.matrix[k][i];
            }
        }
        return new Vector(product);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < vector.length; i++) {
            str.append(vector[i]).append(" ");
        }
        return str.toString();
    }

    //Fills vector with number n
    public void fill(double n){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = n;
        }
    }
}
