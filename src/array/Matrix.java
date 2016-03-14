package array;

public class Matrix {
	private int dim_m;
	private int dim_n;
	public double[][] elements;
	public static Matrix id;
	
	public Matrix() {
		super();
		this.dim_m = 3;
		this.dim_n = 3;
		this.elements = new double[this.dim_m][this.dim_m];
	}

	public Matrix(int dim_m, int dim_n) {
		super();
		this.dim_m = dim_m;
		this.dim_n = dim_n;
		this.elements = new double[dim_m][dim_n];
	}
	public int getDim_m() {
		return dim_m;
	}

	public void setDim_m(int dim_m) {
		this.dim_m = dim_m;
	}

	public int getDim_n() {
		return dim_n;
	}

	public void setDim_n(int dim_n) {
		this.dim_n = dim_n;
	}
	//
	public static void fillIdentityMatrix(int dim_m, int dim_n){
		id = new Matrix(dim_m, dim_n);
		for(int i=0; i< dim_m; i++){
			for(int j=0; j <dim_n; j++){
				id.elements[i][j] = 1.0;
			}
		}
	}
	// 
	public Matrix addMatrix(Matrix a){
		Matrix res;
		if ((a.dim_m != this.dim_m)||(a.dim_n != this.dim_n)){
			System.out.println("Сложение матриц разной размерности некорректно");
			return null;
		} else {
			res = new Matrix(a.dim_m, a.dim_n);
			
			for(int i=0; i< a.dim_m; i++){
				for(int j=0; j< a.dim_n;j++){
					res.elements[i][j] = this.elements[i][j] + a.elements[i][j];
				} 
			}
		};
		return res;
	}
	//
	public Matrix subtractMatrix(Matrix a){
		Matrix res;
		if ((a.dim_m != this.dim_m)||(a.dim_n != this.dim_n)){
			System.out.println("Сложение матриц разной размерности некорректно");
			return null;
		} else {
			res = new Matrix(a.dim_m, a.dim_n);
			
			for(int i=0; i< a.dim_m; i++){
				for(int j=0; j< a.dim_n;j++){
					res.elements[i][j] = this.elements[i][j] - a.elements[i][j];
				} 
			}
		};
		return res;
	}
	//
	public Matrix multiplyMatrixOnConst(double x){	
		Matrix res;
		res = new Matrix(this.dim_m, this.dim_n);
		for(int i=0; i< this.dim_m; i++){
			for(int j=0; j< this.dim_n;j++){
				res.elements[i][j] = this.elements[i][j] * x;
				} 
			}
		return res;
	}
	//
	public void printMatrix(){
		for(int i=0; i< this.dim_m; i++){
			for(int j=0; j< this.dim_n;j++){
				System.out.print(this.elements[i][j] + "\t");
				} 
			System.out.println();
			}
	}
	//
	public Matrix multiplytMatrices(Matrix m){
		Matrix res;
		if ((m.dim_m != this.dim_n)||(m.dim_n != this.dim_m)){
			System.out.println("Умножение матриц заданной размерности некорректно");
			return null;
		} else {
			res = new Matrix(this.dim_m, m.dim_n);
			
			for(int i=0; i< this.dim_m; i++){
				for(int j=0; j< m.dim_n;j++){
					for(int idx=0; idx< m.dim_m; idx++){
						res.elements[i][j] += this.elements[i][idx] * m.elements[idx][j];
					}
				} 
			}
		};
		return res;
	}
	
	
	
	
}
