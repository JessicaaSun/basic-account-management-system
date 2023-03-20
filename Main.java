import java.util.*;

class Account {
    int id;
    String ownerName;
    double balance;

    public int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class Main {

    static void showInfo(ArrayList<Account> accountList) {
        System.out.println(">> After sorting : ");
        System.out.println();
        System.out.println("ID\t\tOWNER NAME\t\t\tBALANCE");
        System.out.println();
        for (Account obj : accountList) {
            System.out.println(obj.getId() + "\t\t" + obj.getOwnerName() + " \t\t\t" + obj.getBalance());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int option;
        ArrayList<Account> accountList = new ArrayList<Account>();
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("===============================");
            System.out.println("1: Add account:");
            System.out.println("2: Remove Account: ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account information");
            System.out.println("5. Exit ");
            System.out.println("===============================");
            System.out.print(">> Please select an option [1-5] : ");
            option = input.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("1. Add account");
                    System.out.println(">> Enter your account information");
                    Account acc = new Account();
                    System.out.print("Input ID : ");
                    acc.id = input.nextInt();
                    System.out.print("Input owner name : ");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("Input balance : ");
                    acc.balance = input.nextInt();
                    accountList.add(acc);
                }
                case 2 -> {
                    System.out.println("2. Remove account");
                    int removeId;
                    boolean found = false;
                    System.out.print(">> Enter the account's ID you want to remove : ");
                    removeId = input.nextInt();
                    for (Account obj : accountList) {
                        if (obj.getId() == removeId) {
                            found = true;
                            accountList.remove(obj);
                            System.out.println("Removed account with ID " + removeId + " successfully!");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Cannot find account with ID " + removeId + " in the list!");
                    }
                }
                case 3 -> {
                    int editId;
                    boolean found = false;
                    System.out.println("3. Edit account");
                    System.out.print(">> Enter the account's ID you want to edit : ");
                    editId = input.nextInt();
                    for (Account obj : accountList) {
                        if (obj.getId() == editId) {
                            found = true;
                            System.out.print("Input new name owner name : ");
                            input.nextLine();
                            obj.setOwnerName(input.nextLine());
                            System.out.print("Input new balance : ");
                            obj.setBalance(input.nextInt());
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Cannot find account with ID " + editId + " in the list!");
                    }
                }
                case 4 -> {
                    int showOption;
                    do {
                        System.out.println("4. Show account information");
                        System.out.println("===============================");
                        System.out.println("1. Ascending order (by ID )");
                        System.out.println("2. Descending order (by ID) ");
                        System.out.println("3. Descending order by balance ");
                        System.out.println("4. Exit");
                        System.out.println("===============================");
                        System.out.print(">> Please select a show option [1-4] : ");
                        showOption = input.nextInt();
                        switch (showOption) {
                            case 1 -> {
                                System.out.println("1. Ascending order by ID");
                                accountList.sort(Comparator.comparingInt(Account::getId));
                                showInfo(accountList);
                            }
                            case 2 -> {
                                System.out.println("2. Descending order by ID");
                                accountList.sort((o1, o2) -> o2.getId() - o1.getId());
                                showInfo(accountList);
                            }
                            case 3 -> {
                                System.out.println("2. Descending order by balance");
                                accountList.sort((o1, o2) -> Double.compare(o2.getBalance(), o1.getBalance()));
                                showInfo(accountList);
                            }
                            case 4 -> System.out.println("Exit the show information section...!");
                            default -> System.out.println("Invalid option, please select again!");
                        }
                        input.nextLine();
                        System.out.println("Press enter to continue...");
                        input.nextLine();
                    } while (showOption != 4);
                }
                case 5 -> System.out.println("Exit the program...!");
                default -> System.out.println("Invalid option, please select again!");
            }
            input.nextLine();
            System.out.println("Press enter to continue...");
            input.nextLine();
        } while (option != 5);
    }
}