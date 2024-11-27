package util;

public class ArrayUtil {


    public static void printArray(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        for (int row = 0; row < rows; row++) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < columns; column++) {
                sb.append(array[row][column]);
                if (column < columns - 1) {
                    sb.append(", "); // 添加逗号和空格
                }
            }
            System.out.println(sb);
        }
    }
}
