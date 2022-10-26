import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Matrix test = new Matrix(3, 3);

        getData(test);
        test.print();
        System.out.println("==============================");
        Matrix solved = test.solveGauss();
        solved.print();
    }

    //gets data from .txt and fills the passed matrix
    public static void getData(Matrix matrix) {
        try {
            Scanner scanner = new Scanner(new File("dataText.txt"));

            int rows = matrix.getRows();
            int columns = matrix.getColumns();
            double[] data = new double[columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (scanner.hasNext()) {
                        data[j] = scanner.nextDouble();
                    }
                }
                matrix.fillMatrix(i + 1, data);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("File not found");
        }
    }
}