import java.util.*;
import java.io.*;
public class Matrixm {
	private int N;             // number of rows
	// number of columns
     double[][] data;   // M-by-N array
	
  public Matrixm(int n)
  {
	  N=n;
	  
  }
  public Matrixm subMatrixm(int r, int c)
  {
  	Matrixm sub= new Matrixm(N-1);
  	double[][] m = new double[N-1][];
      for(int k=0;k<(N-1);k++)
      {
          m[k] = new double[N-1];
      }
   
      int row = 0; 
  	for (int i = 0; i < N; ++i)
  	{
  		if (i == r) continue;
  		
  		int col = 0;
  		for (int j = 0; j < N; ++j)
  		{
  			if (j == c) continue;
  			
  			m[row][col] = data[i][j];
  			++col;
  		}
  		
  		++row;
  	}

      
  	sub.data=m;
  	
  	return sub;
  	
  }
  public double determinant()
  {
  	double det = 0.0;
  	
  	if (N == 1)
  	{
  		det = data[0][0];
  	}
  	else if (N == 2)
  	{
  		det = data[0][0] * data[1][1] - data[0][1] * data[1][0];
  	}
  	else
  	{
  		for (int i = 0; i < N; ++i)
  		{
  			det += Math.pow(-1.0, (double)i) * data[0][i] * subMatrixm(0, i).determinant();
  		}
  	}
  	
  	return det;
  }

  
  
  
}