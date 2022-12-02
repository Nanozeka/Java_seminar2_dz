// Задача 2.

// Реализуйте алгоритм сортировки пузырьком числового массива, результат
// после каждой итерации запишите в лог-файл.
package Task_0.Task_2;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

public class task_2 {
    
    private static File log;
    private static FileWriter fileWriter;

    public static void main(String[] args) {

        // если в блоке try произойдут ошибки, то отработает блок catch(в котором будет код
        // для устранения этих ошибок.Блоков catch может быть несколько.Отработает нужный
        //  для данной ошибки)
        try {
            // создаем файл логирования txt
            log = new File("log.txt");
            log.createNewFile();

            // создаем файл для чтения событий
            fileWriter = new FileWriter(log);

            // создаем массив для сортировки пузырьком
            int[] mas = { 11, 34, 14, 16, 7 };
            bubbleSort(mas);

        } catch (IOException e) {
            e.printStackTrace();

            // даже если возникла ошибка закрываем файл чтения
        } finally {
            try {
                fileWriter.close();

                // и выводим на печать ошибку
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // создаем метод сортировки пузырьком
    private static int[] bubbleSort(int[] mas) {
        boolean isSorted = false;
        int buffer;
        while (!isSorted) {
            isSorted = true;

            // проходим циклом по массиву
            for (int i = 0; i < mas.length - 1; i++) {

                // Если элемент(i) массива больше чем следующий
                if (mas[i] > mas[i + 1]) {

                    // то значение ложь
                    isSorted = false;

                    // и в буфер массива записывается(i) 
                    buffer = mas[i];

                    // Если элемент массива(i) равен следующиму элементу(i+1)
                    mas[i] = mas[i + 1];

                    // то этот элемент(i+1) записыватся перед ним
                    mas[i + 1] = buffer;
                }
            }
            // System.out.println(Arrays.toString(mas));

            // преобразаум массив в строку и передадим в логгер
            logStep(Arrays.toString(mas));
        }
        return mas;
    }

    // метод для пошаговой записи лога в формате год -> миллисекунды
    public static void logStep(String note) {
        try {
            fileWriter.write(new Timestamp(System.currentTimeMillis()) + " " + note + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
