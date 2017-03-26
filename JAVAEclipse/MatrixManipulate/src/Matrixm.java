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
  
  
  
}