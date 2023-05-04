// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь 
// несколько телефонов. Нужны методы добавления новой записи в книгу и метод поиска записей в телефонной книге

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        Map<String, List<String>> phoneBook = new HashMap<>();

        addNumber("123", "Семён", phoneBook);
        addNumber("321", "Семён", phoneBook);
        addNumber("111", "Андрей", phoneBook);
        addNumber("222", "Жора", phoneBook);

        System.out.println("Введите номер команды(1 - Ввод, 2 - Поиск по имени, 3 - Поиск по номеру): ");
        Scanner scan = new Scanner(System.in);
        int command1 = scan.nextInt();

        if (command1 == 1) {
            System.out.println("Введите номер: ");
            Scanner numN = new Scanner(System.in);
            String number = numN.nextLine();
            System.out.println("Введите имя: ");
            Scanner namN = new Scanner(System.in);
            String name = namN.nextLine();
            addNumber(number, name, phoneBook);
            numN.close();
            namN.close();
        } else if (command1 == 2) {
            System.out.println("Введите имя: ");
            Scanner namN = new Scanner(System.in);
            String name = namN.nextLine();
            searchNumber(name, phoneBook);

            namN.close();
        } else if (command1 == 3) {
            System.out.println("Введите номер: ");
            Scanner numN = new Scanner(System.in);
            String number = numN.nextLine();
            searchPerson(number, phoneBook);
            numN.close();
        } else {
            System.out.println("Команда не найдена!");
        }
        System.out.println(phoneBook);
        scan.close();
    }

    static void addNumber(String number, String person, Map<String, List<String>> book) {
        if (book.containsKey(person)) {
            book.get(person).add(number);
        } else {
            List<String> list = new ArrayList<>();
            list.add(number);
            book.put(person, list);
        }
    }

    static void searchNumber(String person, Map<String, List<String>> book) {
        if (book.containsKey(person)) {
            StringBuilder str = new StringBuilder();
            str.append("Номера ");
            str.append(person);
            str.append(" - ");
            str.append(book.get(person));
            System.out.println(str);
        } else {
            System.out.println("Нет результата");
        }
    }

    static void searchPerson(String number, Map<String, List<String>> book) {
        for (Entry<String, List<String>> entry : book.entrySet()) {
            if (entry.getValue().contains(number)) {
                System.out.println("Номер " + number + " - " + entry.getKey());
                return;
            }
        }
        System.out.println("Нет результата");
    }

}