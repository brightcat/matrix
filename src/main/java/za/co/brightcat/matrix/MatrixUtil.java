package za.co.brightcat.matrix;

import java.util.Random;
import java.util.function.DoubleSupplier;

public class MatrixUtil {
    private static final String NEWLINE = "\n";
    
    final private Random random;

    public MatrixUtil() {
        this.random = new Random();
    }
    
    public Matrix create(final double[] data, int m, int n) {
        assert data.length == m*n;
        int k = 0;
        final double[][] d = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = data[k++];
            }
        }
        return new Matrix(d);
    }
    
    public Matrix create(int m, int n, double value) {
        final double[][] d = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = value;
            }
        }
        return new Matrix(d);
    }
    
    public Matrix create(int m, int n, DoubleSupplier s) {
        final double[][] d = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = s.getAsDouble();
            }
        }
        return new Matrix(d);
    }
    
    public String toString(Matrix mat) {
        final StringBuilder sb = new StringBuilder();
        sb.append(mat.m()).append("x").append(mat.n()).append(NEWLINE);
        final double[][] data = mat.getData();
        for (int i = 0; i < mat.m(); i++) {
            for (int j = 0; j < mat.n(); j++) {
                sb.append(String.format("%.2f  ", data[i][j]));
            }
            sb.append(NEWLINE);
        }
        
        return sb.toString();
    }
    
    public void print(Matrix m) {
        System.out.println(toString(m));
    }
    
    public Matrix zeros(int m) {
        return zeros(m,m);
    }
    
    public Matrix zeros(int m, int n) {
        return new Matrix(new double[m][n]);
    }
    
    public Matrix ones(int m) {
        return ones(m,m);
    }
    
    public Matrix ones(int m, int n) {
        return create(m, n, 1.);
    }
    
    public Matrix random(int m) {
        return random(m, m);
    }
    
    public Matrix random(int m, int n) {
        return create(m, n, () -> random.nextDouble());
    }
}
