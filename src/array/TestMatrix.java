package array;

public class TestMatrix {

	public static void main(String[] args) {
		// Creating matrix for testing
		Matrix a, b, c, d, e;
		int test_m = 4;
		int test_n = 4;
		int multConst = 9;
		
		a = new Matrix(test_m, test_n);
		for(int i=0; i< test_m; i++){
			for(int j=0; j< test_n; j++){
				a.elements[i][j] = i + j;
			}
		}
		System.out.println("Матрица а:");
		a.printMatrix();
		System.out.println("Размерность матрицы а равна " + a.getDim_m() + " x " + a.getDim_n());
		
		b = new Matrix(test_m, test_n);
		for(int i=0; i< test_m; i++){
			for(int j=0; j< test_n; j++){
				b.elements[i][j] = i * j;
			}
		}
		System.out.println("Матрица b");
		b.printMatrix();
		System.out.println("Размерность матрицы b равна " + b.getDim_m() + " x " + b.getDim_n());
		
		System.out.println("Единичная матрица");
		Matrix.fillIdentityMatrix(test_m, test_n);
		Matrix.id.printMatrix();
		
		System.out.println("Выполним сложение матриц");
		c = a.addMatrix(b);
		c.printMatrix();
		
		System.out.println("Выполним вычитание матриц");
		c = a.subtractMatrix(b);
		c.printMatrix();
		
		System.out.println("Выполним умножение матрицы на константу");
		c = a.multiplyMatrixOnConst(multConst);
		c.printMatrix();
		
		System.out.println("Умножение матриц");
		
		d = new Matrix(3, 2);
		for(int i=0; i< 3; i++){
			for(int j=0; j< 2; j++){
				d.elements[i][j] = i + j;
			}
		}
		d.printMatrix();
		System.out.println("------------------");
		
		e = new Matrix(2, 3);
		for(int i=0; i< 2; i++){
			for(int j=0; j< 3; j++){
				e.elements[i][j] = i * j;
			}
		}
		e.printMatrix();
		System.out.println("------------------");
		
		c = d.multiplytMatrices(e);
		c.printMatrix();
		
	}

}
