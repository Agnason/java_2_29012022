package lesson03;

import java.util.*;

public class MobDirectory {
    private Map<String, List<String>> directory = new HashMap<>();
    private List<String> phoneNumberList;

    public void add(String surname, String phoneNumber) {
        if (directory.containsKey(surname)) {
            phoneNumberList = directory.get(surname);
            phoneNumberList.add(phoneNumber);
        } else {
            phoneNumberList = new ArrayList<>();
            phoneNumberList.add(phoneNumber);
            directory.put(surname, phoneNumberList);
        }
    }

    public void get(String surname) throws NullPointerException {
        System.out.println("Поиск по фамилии " + surname + ":");
        phoneNumberList = directory.get(surname);
        phoneNumberList.forEach((v) -> {
            System.out.println(v);
        });

    }

    public static void main(String[] args) {
        MobDirectory mobDirectory = new MobDirectory();
        mobDirectory.add("Насонов", "89213333333");
        mobDirectory.add("Насонов", "89214444444");
        mobDirectory.add("Задорнов", "8922222222");
        mobDirectory.add("Насонов", "89215555555");

        try {
            mobDirectory.get("Насо");
        } catch (NullPointerException e) {
            System.out.println("Такой фамилии в базе нет");
        }
    }

}
