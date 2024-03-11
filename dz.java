import java.util.*;

class TelefonContact {
    public String Name;
    public String Telefon;
    private ArrayList<String> telefonList = new ArrayList<>();

    public TelefonContact(String name, String telefon){
        this.Name = name;
        this.telefonList.add(telefon);
        this.Telefon = telefon;
    }

}

class PhoneBook {
    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void AddNewContact(TelefonContact member) {

        ArrayList<String> numbers = phoneBook.getOrDefault(member.Name, new ArrayList<>());
        numbers.add(member.Telefon);
        phoneBook.put(member.Name, numbers);
    }

    public static void showAllContacts() {

        phoneBook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a,b) -> {return b.size() - a.size();}))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().toString().replace("[", "").replace("]", "")));
    }
}

public class dz {
    public static void main(String[] args) {

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.AddNewContact(new TelefonContact("Ivanov", "+75656565"));
        myPhoneBook.AddNewContact(new TelefonContact("Ivanov", "+7565656131235"));

        myPhoneBook.AddNewContact(new TelefonContact("Petrov", "+71234561"));
        myPhoneBook.AddNewContact(new TelefonContact("Petrov", "+7123456113231"));
        myPhoneBook.AddNewContact(new TelefonContact("Petrov", "+545454353453"));

        myPhoneBook.AddNewContact(new TelefonContact("Sidorov", "+496676767"));

        PhoneBook.showAllContacts();
    }
}