// Пусть дан список сотрудников:

// Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов,
//  Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова,
//   Иван Мечников, Петр Петин, Иван Ежов.
  
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию 
// популярности. Для сортировки использовать TreeMap.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class task02 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        StringBuilder userStr = new StringBuilder().append("Иван Иванов, Светлана Петрова, Кристина Белова")
                .append(", Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова")
                .append(", Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова")
                .append(", Иван Мечников, Петр Петин, Иван Ежов");

        String str = String.valueOf(userStr);
        List<String> persons = new ArrayList<>(Arrays.asList(str.split(", ")));
        Map<String, Integer> countRep = new HashMap<>();

        for (int i = 0; i < persons.size(); i++) {
            String name = persons.get(i).split(" ")[0];
            if (countRep.containsKey(name)) {
                countRep.put(name, countRep.get(name) + 1);
            } else {
                countRep.put(name, 1);
            }

        }

        System.out.println(countRep);

        Map<Integer, List<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<String, Integer> entry : countRep.entrySet()) {
            if (treeMap.containsKey(entry.getValue())) {
                String name = entry.getKey();
                List<String> currentNames = treeMap.get(entry.getValue());
                currentNames.add(name);
                treeMap.put(entry.getValue(), currentNames);
            } else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                treeMap.put(entry.getValue(), list);
            }
        }
        System.out.println(treeMap);
    }
}