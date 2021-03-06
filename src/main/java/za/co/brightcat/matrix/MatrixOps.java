package za.co.brightcat.matrix;

public class MatrixOps {

    private static final BiDoubleFunction minus = (x, y) -> x - y;

    public Matrix dot(Matrix A, Matrix B) {
        final int m = A.m();
        final int n = B.n();
        final int o = B.m();
        final double[][] data = new double[m][n];
        for (int i = 0; i < m; i++) {
            final double[] row = A.row(i);
            for (int j = 0; j < n; j++) {
                final double[] col = B.col(j);
                double sum = 0.0;
                for (int k = 0; k < o; k++) {
                    sum += row[k] * col[k];
                }
                data[i][j] = sum;
            }
        }

        return new Matrix(data);
    }

    public Matrix map(Matrix M, DoubleFunction f) {
        final int m = M.m();
        final int n = M.n();
        final double[][] data = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = f.apply(M.value(i, j));
            }
        }
        return new Matrix(data);
    }

    public Matrix biMap(Matrix A, Matrix B, BiDoubleFunction f) {
        final int m = A.m();
        final int n = A.n();
        assert m == B.m() && n == B.n();
        final double[][] d = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = f.apply(A.value(i, j), B.value(i, j));
            }
        }

        return new Matrix(d);
    }

    public double reduce(Matrix A, double init, ReduceFunction f) {
        final int m = A.m();
        final int n = A.n();
        final double[][] data = A.getData();
        double res = init;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = f.apply(res, data[i][j]);
            }
        }
        return res;
    }

    public Matrix minus(Matrix A, Matrix B) {
        return biMap(A, B, minus);
    }

    public Matrix transpose(Matrix M) {
        final int m = M.m();
        final int n = M.n();
        final double[][] data = new double[n][m];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                data[j][i] = M.value(i, j);
            }
        }

        return new Matrix(data);
    }
}
