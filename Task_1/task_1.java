// Задача 1.
//  Дана строка sql-запроса"select * from students where ".Сформируйте часть WHERE 
// этого запроса,используя StringBuilder.Данные для фильтрации приведены ниже в виде json
//  строки.Если значение null,то параметр не должен попадать в запрос.

// Параметры для фильтрации:{"name":"Ivanov","country":"Russia","city":"Moscow","age":"null"}

package Task_0.Task_1;

public class task_1 {
    // из неизменяемой строки final делаем выборку 
    public static final String QUERY = "select * from students where ";
    public static final String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";

    /**
     * @param args
     */
    public static void main(String[] args) {

        // С помощью метода replace убираем {}
        String paramsNew = PARAMS.replace('{', ' ').replace('}', ' ');

        // создаем массив строк
        String[] params = paramsNew.split(",");

        // Иницилизируем запрос
        StringBuilder stringBuilder = new StringBuilder(QUERY);

        // Проходимся по всем параметрам массива строк
        for (int i = 0; i < params.length; i++) {

            // Убираем ("")
            String[] elements = params[i].replace('"', ' ').split(":");

            // Если 0 элемент строки = null, то 1 элемент убирается
            if (!"null".equals(elements[1].trim())) {

                // В 0 м элементе массива убираем пробелы перед элементом,далее добавляем =
                // потом добавляем "'". Затем убираем пробелы перед 1 элементом и добавляем "'" 
                stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
                
                // перед препоследним элементом массива строк добавляем and
                if (i < params.length - 2)
                    stringBuilder.append(" and ");
            }
        }
        // Печатаем результат
        System.out.println(stringBuilder);
    }
}