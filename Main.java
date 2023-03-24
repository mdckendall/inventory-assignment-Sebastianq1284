import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Item> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Press 1 to add an item.");
            System.out.println("Press 2 to delete an item.");
            System.out.println("Press 3 to update an item.");
            System.out.println("Press 4 to show all the items.");
            System.out.println("Press 5 to quit the program.");

            int option = scanner.nextInt();
            scanner.nextLine(); //extra newline

            switch (option) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    viewItems();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void addItem() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter serial number:");
        String serialNumber = scanner.nextLine();

        System.out.println("Enter value:");
        int value = scanner.nextInt();
        scanner.nextLine(); // consume extra newline

        Item item = new Item(name, serialNumber, value);
        itemList.add(item);
    }

    private static void deleteItem() {
        System.out.println("Enter serial number of item to delete:");
        String serialNumber = scanner.nextLine();

        for (Item item : itemList) {
            if (item.getSerialNumber().equals(serialNumber)) {
                itemList.remove(item);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    private static void updateItem() {
        System.out.println("Enter serial number of item to update:");
        String serialNumber = scanner.nextLine();

        for (Item item : itemList) {
            if (item.getSerialNumber().equals(serialNumber)) {
                System.out.println("Enter new name:");
                String name = scanner.nextLine();

                System.out.println("Enter new value:");
                int value = scanner.nextInt();
                scanner.nextLine(); // consume extra newline

                item.setName(name);
                item.setValue(value);
                System.out.println("Item updated.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    private static void viewItems() {
        if (itemList.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }

        for (Item item : itemList) {
            System.out.println(item);
        }
    }
}

class Item {
    private String name;
    private String serialNumber;
    private int value;

    public Item(String name, String serialNumber, int value) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return name + "," + serialNumber + "," + value;
    }
}