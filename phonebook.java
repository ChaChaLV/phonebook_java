package phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class phonebook {

    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void addContact(String name, String phoneNum) {
       if (phoneBook.containsKey(name)) {
           phoneBook.get(name).add(phoneNum);
       } else {
           ArrayList<String> values = new ArrayList<>();
           values.add(phoneNum);
           phoneBook.put(name, values);
       }
   }

   public static ArrayList<String>find(String name) {
    if (phoneBook.containsKey(name)) {
        return phoneBook.get(name);
    }
    return new ArrayList<String>(); 
}


 
    public static void main(String[] args) {
        Boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while (flag) {
            System.out.println("Что вы хатите сделать? ");
            String action = scanner.next();

            if(action.equals("add")){    
            System.out.println("Введите имя контакта ");
            String contName = scanner.next();
            System.out.println("Введите номер телефона ");
            String contNumber = scanner.next();
            addContact(contName, contNumber);
            
        }
        else if(action.equals("find")){
            System.out.println("Введите имя контакта для поиска ");
            String findName = scanner.next();
            System.out.println(find(findName));
        }
        else if(action.equals("delete")){
            System.out.println("Введите имя контакта для удаления ");
            String deleteName = scanner.next();
            System.out.println("Удаление контакта: " + phoneBook.remove(deleteName));
        }else if(action.equals("show")){
            System.out.println(phoneBook);
        }else if(action.equals("exit")){
            flag = false;
        }
        else{
            break;
        }
    }
}
}

