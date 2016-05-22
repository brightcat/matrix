package za.co.brightcat.matrix;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class MatrixOpsTest {
    private MatrixOps mo;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    private MatrixUtil mu;
    
    @Before
    public void setUp() {
        mo = new MatrixOps();
        mu = new MatrixUtil();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dot method, of class MatrixOps.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Matrix A = mu.create(new double[] {1,2,3,4,5,6}, 2, 3);
        Matrix B = mu.create(new double[] {7,8,9,10,11,12}, 3, 2);;
        Matrix result = mo.dot(A, B);
        System.out.println(mu.toString(result));
        assertArrayEquals(result.getData(), new double[][] {
            { 58., 64.}, {139.,154.}
        });
        
        Matrix C = mu.create(new double[] {1,2,3,4,5,6},3,2);
        Matrix D = mu.zeros(2,1);
        
        result = mo.dot(C,D);
        
        mu.print(result);
        
        assertArrayEquals(result.getData(), new double[][] {
            {0},
            {0},
            {0}
        });
    }
    
    
    @Test
    public void testMap() {
        System.out.println("map");
        
        Matrix m = mu.create(new double[] {1,2,3,4,5,6}, 2,3);
        Matrix map = mo.map(m, (double x) -> x*2.);
        
        System.out.println(mu.toString(map));
        assertArrayEquals(map.getData(), new double[][] {
            {2, 4, 6},
            {8, 10, 12}
        });
    }
    
    @Test
    public void testBiMap() {
        System.out.println("biMap");
        
        Matrix A = mu.create(new double[] {1,2,3,4},2,2);
        Matrix B = mu.create(new double[] {4,3,2,1},2,2);
        
        Matrix r = mo.biMap(A, B, (x,y) -> x-y);
        mu.print(r);
        
        assertArrayEquals(r.getData(), new double[][] {
            {-3,-1},
            {1,3}
        });
    }
    
    @Test
    public void testReduce() {
        System.out.println("reduce");
        
        Matrix X = mu.create(new double[] {1,2,3,4},2,2);
        
        double r = mo.reduce(X, 0., (res, x) -> res+x);
        assertEquals(10., r, 0.);
        r = mo.reduce(X, 5., (res, x) -> res+x);
        assertEquals(15, r,0.0);
    }
    
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        Matrix m = mu.create(new double[] {1,2,3,4,5,6}, 2, 3);
        Matrix t = mo.transpose(m);
        
        mu.print(t);
        assertArrayEquals(t.getData(), new double[][] {
            {1,4},
            {2,5},
            {3,6}
        });
    }
}
