package Data;

import java.util.Arrays;

//Matrix class. Containing all necessary methods to calculate func1, func2 and func3
public class Matrix {

    double[][] matrix;

    Matrix(double[][] matrix){
        this.matrix = Arrays.copyOf(matrix, matrix.length);
    }

    public Matrix(int n, int m, int k){
        matrix = new double[n][m];
        fill(k);
    }

    //Returns maximum value in the matrix
    public double getMax(){
        double max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    //Returns transposed matrix
    public Matrix transpose(){
        double[][] transposed = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return new Matrix(transposed);
    }

    //Returns matrix that is a product of this and matrix2 matrices
    public Matrix mutiply(Matrix matrix2) throws InvalidIndexException{
        if(matrix[0].length != matrix2.matrix.length)
            throw new InvalidIndexException();

        double[][] product = new double[matrix.length][matrix2.matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix2.matrix[0].length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    product[i][j] += matrix[i][k] * matrix2.matrix[k][j];
                }
            }
        }

        return new Matrix(product);
    }

    //Returns matrix that is a sum of this and matrix2 matrices
    public Matrix add(Matrix matrix2) throws InvalidIndexException{
        if(matrix.length != matrix2.matrix.length || matrix[0].length != matrix2.matrix[0].length)
            throw new InvalidIndexException();
        double[][] sum = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i][j] = matrix[i][j] + matrix2.matrix[i][j];
            }
        }
        return new Matrix(sum);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                str.append(matrix[i][j]).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    //Fills matrix with number n
    public void fill(double n){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = n;
            }
        }
    }
}
