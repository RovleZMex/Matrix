public class Matrix {

    private final int N; //numbers of columns
    private final int M;//numbers of rows
    private final double matrix[][];

    public Matrix(int n, int m) {
        this.N = n;
        this.M = m;
        this.matrix = new double[m][n];
    }

    // create matrix based on 2d array
    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.matrix = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.matrix[i][j] = data[i][j];
    }

    // copy constructor
    private Matrix(Matrix A) {
        this(A.matrix);
    }

    public int getRows() {
        return M;
    }

    public int getColumns() {
        return N;
    }

    public void fillMatrix(int row, double[] data) {
        if (data.length != N) {
            throw new IllegalArgumentException("Wrong data");
        }
        for (int i = 0; i < N; i++) {
            matrix[row - 1][i] = data[i];
        }

    }

    public void print() {
        //renglones: n columnas: m
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public Matrix solveGauss() {
        Matrix result = new Matrix(this);
        double coeficiente;
        for(int i = 0; i < result.getRows() - 1; i++){
            if(result.matrix[i][i] != 0){
                for(int j = i + 1; j < result.getRows();j++){
                    coeficiente = result.matrix[j][i] / result.matrix[i][i];
                    for(int k = 0; k < result.getColumns(); k++){
                        result.matrix[j][k] = result.matrix[j][k] - (coeficiente * result.matrix[i][k]);
                    }
                }
            }else{
                //buscar el primer elemento en la columna i, debajo de a_ii intercambiar los renglones involucrados
            }
        }
        return result;
    }

    public void swap(int i, int j) {
        double[] temp = matrix[i - 1];
        matrix[i - 1] = matrix[j - 1];
        matrix[j - 1] = temp;
    }

    public double getValue(int row, int column) {
        return matrix[row][column];
    }
}

