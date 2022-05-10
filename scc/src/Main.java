import Components.*;
import Storages.Storage;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Storage st = new Storage();
        String answer;
        System.out.println("Welcome to PC store\nThis storage is for computer components");

        while (true) {

            menu();
            System.out.println("Input answer: ");
            answer = in.nextLine().toLowerCase().replace(" ", "");
            switch (answer) {
                case "1" -> {
                    menuComponents("see");

                    System.out.println("Input answer: ");
                    answer = in.nextLine().toLowerCase();
                    switch (answer) {
                        case "1":
                            st.showCPU();
                            break;
                        case "2":
                            st.showGPU();
                            break;
                        case "3":
                            st.showRAM();
                            break;
                        case "4":
                            st.showMotherboard();
                            break;
                        case "5":
                            st.showPowerSupply();
                            break;
                        case "6":
                            continue;
                        case "7":
                            System.out.println("Bye");
                            break;
                        default: {
                            throwMessage("Unknown answer");
                        }
                        break;
                    }
                }
                case "2" -> {
                    menuComponents("add");

                    System.out.println("Input answer: ");
                    answer = in.nextLine().toLowerCase().replace(" ", "");
                    switch (answer) {
                        case "1":
                            st.addToListCPU(addAndValidateCPU());
                            break;
                        case "2":
                            st.addToListGPU(addAndValidateGPU());
                            break;
                        case "3":
                            st.addToListRAM(addAndValidateRAM());
                            break;
                        case "4":
                            st.addToListMotherboard(addAndValidateMotherboard());
                            break;
                        case "5":
                            st.addToListPowerSupply(addAndValidatePowerSupply());
                            break;
                        case "6":
                            continue;
                        case "7":
                            System.out.println("Bye");
                            return;
                        default:
                            throwMessage("Unknown answer");
                    }
                }
                case "3" -> {
                    menuComponents("change");

                    System.out.println("Input answer: ");
                    answer = in.nextLine().toLowerCase();
                    switch (answer) {
                        case "1": {
                            if (!st.getListCPU().isEmpty()) {
                                st.showCPU();
                                while (true) {
                                    try {
                                        System.out.println("Input id to change: ");
                                        answer = in.nextLine().toLowerCase().replace(" ", "");
                                        st.changeCPU(Integer.parseInt(answer));
                                        break;
                                    } catch (Exception e) {
                                        throwMessage("Enter id");
                                    }
                                }
                            } else {
                                System.out.println("\nThere is nothing to change. List items empty\n");
                            }
                        }
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                            continue;
                        case "7":
                            System.out.println("Bye");
                            return;
                        default:
                            throwMessage("Unknown answer");
                    }
                }
                case "4" -> {
                    menuComponents("remove");
                    System.out.println("Input answer: ");
                    answer = in.nextLine().toLowerCase();

                    switch (answer) {
                        case "1": {
                            st.showCPU();
                            int id;
                            System.out.println("Input id to remove: ");
                            while (true) {
                                try {
                                    id = in.nextInt();
                                    break;
                                } catch (Exception e) {
                                    throw new Exception("Unknown id");
                                }
                            }

                            st.removeComponent(id, "cpu");
                        }
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                            continue;
                        case "7":
                            System.out.println("Bye");
                            return;
                        default:
                            throwMessage("Unknown answer");
                    }
                }
                case "5" -> {
                    System.out.println("Are you sure you want to clear the Storage?\nEnter YES/NO: ");
                    while (true) {
                        try {
                            answer = in.nextLine().toLowerCase().replace(" ", "");
                            if (answer.equals("yes")) {
                                st.clearStorage();
                            } else if (answer.equals("no")) {
                                break;
                            } else {
                                throw new Exception("Error answer");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter YES or NO");
                        }
                    }
                }
                case "6" -> {
                    System.out.println("Bye");
                    return;
                }
                default -> {
                    throwMessage("Unknown answer");
                }
            }
        }
}

    static CPU addAndValidateCPU() throws Exception {
        CPU newCPU = null;
        int quantity = 0;
        int price = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter name/model: ");
        String name = in.nextLine().toLowerCase();
        while (true) {
            try {
                System.out.println("Enter quantity CPU: ");
                quantity = Integer.parseInt(in.nextLine());
                System.out.println("Enter price CPU: ");
                price = Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newCPU = new CPU(name, quantity, price);
                return newCPU;
            } catch (Exception e) {
                throwMessage(e.getMessage() + " Enter only number please");
            }
        }
    }

    static GPU addAndValidateGPU() throws InterruptedException {
        GPU newGPU = null;
        int quantity = 0;
        int price = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter name/model: ");
        String name = in.nextLine().toLowerCase();
        while (true) {
            try {
                System.out.println("Enter quantity CPU: ");
                quantity = Integer.parseInt(in.nextLine());
                System.out.println("Enter price CPU: ");
                price = Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newGPU = new GPU(name, quantity, price);
                return newGPU;
            } catch (Exception e) {
                throwMessage(e.getMessage() + " Enter only number please");
            }
        }
    }

    static RAM addAndValidateRAM() throws InterruptedException {
        RAM newRAM = null;
        int quantity = 0;
        int price = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter name/model: ");
        String name = in.nextLine().toLowerCase();
        while (true) {
            try {
                System.out.println("Enter quantity CPU: ");
                quantity = Integer.parseInt(in.nextLine());
                System.out.println("Enter price CPU: ");
                price = Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newRAM = new RAM(name, quantity, price);
                return newRAM;
            } catch (Exception e) {
                throwMessage(e.getMessage() + " Enter only number please");
            }
        }
    }

    static Motherboard addAndValidateMotherboard() throws InterruptedException {
        Motherboard newMotherboard = null;
        int quantity = 0;
        int price = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter name/model: ");
        String name = in.nextLine().toLowerCase();
        while (true) {
            try {
                System.out.println("Enter quantity CPU: ");
                quantity = Integer.parseInt(in.nextLine());
                System.out.println("Enter price CPU: ");
                price = Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newMotherboard = new Motherboard(name, quantity, price);
                return newMotherboard;
            } catch (Exception e) {
                throwMessage(e.getMessage() + " Enter only number please");
            }
        }
    }

    static PowerSupply addAndValidatePowerSupply() throws InterruptedException {
        PowerSupply newPowerSupply = null;
        int quantity = 0;
        int price = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter name/model: ");
        String name = in.nextLine().toLowerCase();
        while (true) {
            try {
                System.out.println("Enter quantity CPU: ");
                quantity = Integer.parseInt(in.nextLine());
                System.out.println("Enter price CPU: ");
                price = Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newPowerSupply = new PowerSupply(name, quantity, price);
                return newPowerSupply;
            } catch (Exception e) {
                throwMessage(e.getMessage() + " Enter only number please");
            }
        }
    }

    static private void menuComponents(String action) {
        System.out.printf(
                """
                        \nSelect which component list you want to %s:
                        1. CPU.
                        2. GPU.
                        3. RAM.
                        4. Motherboard.
                        5. Power supply.
                        6. Back.
                        7. Exit
                        """, action);
    }

    static private void menu() {
        System.out.println(
                """
                         \nChoose action:
                        1. Show components.
                        2. Add component.
                        3. Change component.
                        4. Remove component.
                        5. Clear Storage.
                        6. Exit.""");
    }

    static void throwMessage(String e) {
        System.out.println("\nError message: " + e + "\n");
    }
}
