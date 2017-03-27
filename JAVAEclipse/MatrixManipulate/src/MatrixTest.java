import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test
	public void testDeterminant() {
		
		double[][] matrix= new double [3][3];
		Matrixm m=new Matrixm(3);
		matrix[0][0]=5;
		matrix[0][1]=4;
		matrix[0][2]=3;
		matrix[1][0]=6;
		matrix[1][1]=9;
		matrix[1][2]=1;
		matrix[2][0]=2;
		matrix[2][1]=5;
		matrix[2][2]=3;
		m.data=matrix;
		
		assertEquals(82.0,m.determinant(),0.001);
	
	
	}
	@Test
	public void testInverse() {
		
		double[][] matrix= new double [3][3];
		Matrixm m=new Matrixm(3);
		matrix[0][0]=5;
		matrix[0][1]=4;
		matrix[0][2]=3;
		matrix[1][0]=6;
		matrix[1][1]=9;
		matrix[1][2]=1;
		matrix[2][0]=2;
		matrix[2][1]=5;
		matrix[2][2]=3;
		m.data=matrix;
		
		double [] testrow0={0.2682926829268293,0.036585365853658534,-0.2804878048780488};
		double [] testrow1={-0.1951219512195122, 0.10975609756097561, 0.15853658536585366};
		double [] testrow2={0.14634146341463414, -0.2073170731707317, 0.25609756097560976};
		Matrixm t=new Matrixm(3);
		t=m.inverse();
		double [] row0=t.data[0];
		double [] row1=t.data[1];
		double [] row2=t.data[2];
		
		assertArrayEquals(row0,testrow0,0.001);
		assertArrayEquals(row1,testrow1,0.001);
		assertArrayEquals(row2,testrow2,0.001);
	
	
	}
	

}
