package gb2.lesson2.lesson2dz;

public class Main {

    public static void main(String[] args) {
        String[][] myArray = {{"1", "1", "1", "1"},
                              {"1", "1", "1", "1"},
                              {"1", "1", "1", "1"},
                              {"1", "1", "1", "1"}};

        try {
            System.out.println("Сумма элементов массива равна " + calculate(myArray));

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int calculate(String[][] myArray) throws MyArraySizeException, MyArrayDataException {

        int row = myArray.length;
        for (String[] strings : myArray) {
            int col = strings.length;
            if (col != 4 | row != 4) {
                throw new MyArraySizeException("Неправильная размерность массива.");
            }
        }

        int buffer = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                int d = myArray[i][j].length();
                String s = myArray[i][j];
                for (int k = 0; k < d; k++) {
                    if(s.charAt(k) != '0' & s.charAt(k) != '1' & s.charAt(k) != '2' & s.charAt(k) != '3' & s.charAt(k) != '4' &
                            s.charAt(k) != '5' & s.charAt(k) != '6' & s.charAt(k) != '7' & s.charAt(k) != '8' & s.charAt(k) != '9'){
                        throw new MyArrayDataException("Элемент массива содержит не цифровые данные в ячейке [" + i + "," + j + "].");
                    }
                }
                buffer += Integer.parseInt(myArray[i][j]);
            }
        }
        return buffer;
    }
}
