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
  public Matrixm inverse()
  {
  	Matrixm inv=new Matrixm(N);
  	double det = this.determinant();
  	
  	double[][] m = new double[N][N];
  	for (int i = 0; i < N; ++i)
  	{
  		for (int j = 0; j < N; ++j)
  		{
  			
  			m[i][j] = Math.pow(-1.0, (double)i + j) * subMatrixm(j, i).determinant() /det;
  		}
  	}
  	inv.data=m;
  	return inv;
  } 

public static void main(String args[]) throws IOException
{	
    Scanner input = new Scanner(System.in);
    File file = new File("input.txt");
    Scanner inputFile = new Scanner(file);
    File fout = new File("out.txt");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

 while(inputFile.hasNextInt())
 {
	 
    int n = inputFile.nextInt();
 
    double[][] mat = new double[n][n];
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
           mat[i][j] = inputFile.nextInt();
        }
    }

    Matrixm I = new Matrixm(n);
    I.data=mat;


if(!(n<2))
{
    bw.write("det(M)= "+I.determinant());
    bw.newLine(); 
    Matrixm L= new Matrixm(n);
    L=I.inverse();
    bw.write("Minv= ");
    bw.newLine(); 
    for (int i = 0; i < L.data.length; i++) {
        for (int j = 0; j < L.data[i].length; j++) {
          	bw.write(L.data[i][j] + " ");
          }
         
  	bw.newLine(); 
    }	
}
    
}

 bw.write("Done!");
 bw.close();
 input.close();
}
}