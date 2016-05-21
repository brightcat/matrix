package za.co.brightcat.matrix;

import java.util.Arrays;

public class Matrix {
    private double[][] data;
    private final int width;
    private final int height;

    public Matrix(double[][] data) {
        this.data = data;
        this.height = data.length;
        this.width = data[0].length;
    }
    
    public double[] row(int row) {
        return Arrays.copyOf(data[row], width);
    }
    
    public double[] col(int col) {
        final double[] d = new double[height];
        for (int i = 0; i < height; i++) {
            d[i] = data[i][col];
        }
        
        return d;
    }
    
    public double[][] getData() {
        return data;
    }
    public double value(int m, int n) {
        return data[m][n];
    }
    
    public int m() {
        return height;
    }
    
    public int n() {
        return width;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrix other = (Matrix) obj;
        if (!Arrays.deepEquals(this.data, other.data)) {
            return false;
        }
        return true;
    }
    
    
}
