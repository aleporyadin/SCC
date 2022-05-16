import Components.*;
import Storages.Storage;
import Utils.Component;
import Utils.ComponentEnum;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Storage st = new Storage();
        String answer = null;
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
                            st.addToListCPU((CPU) addAndValidateComponent(ComponentEnum.CPU));
                            break;
                        case "2":
                            st.addToListGPU((GPU) addAndValidateComponent(ComponentEnum.GPU));
                            break;
                        case "3":
                            st.addToListRAM((RAM) addAndValidateComponent(ComponentEnum.RAM));
                            break;
                        case "4":
                            st.addToListMotherboard((Motherboard) addAndValidateComponent(ComponentEnum.MOTHERBOARD));
                            break;
                        case "5":
                            st.addToListPowerSupply((PowerSupply) addAndValidateComponent(ComponentEnum.POWER_SUPPLY));
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
                                        st.changeComponent(Integer.parseInt(answer), ComponentEnum.CPU);
                                        break;
                                    } catch (Exception e) {
                                        throwMessage("Error! Enter valid id!");
                                    }
                                }
                            } else {
                                System.out.println("\nThere is nothing to change. List items empty\n");
                            }
                            break;
                        }
                        case "2": {
                            if (!st.getListGPU().isEmpty()) {
                                st.showGPU();
                                while (true) {
                                    try {
                                        System.out.println("Input id to change: ");
                                        answer = in.nextLine().toLowerCase().replace(" ", "");
                                        st.changeComponent(Integer.parseInt(answer), ComponentEnum.GPU);
                                        break;
                                    } catch (Exception e) {
                                        throwMessage("Error! Enter valid id!");
                                    }
                                }
                            } else {
                                System.out.println("\nThere is nothing to change. List items empty\n");
                            }
                            break;
                        }
                        case "3": {
                            if (!st.getListRAM().isEmpty()) {
                                st.showRAM();
                                while (true) {
                                    try {
                                        System.out.println("Input id to change: ");
                                        answer = in.nextLine().toLowerCase().replace(" ", "");
                                        st.changeComponent(Integer.parseInt(answer), ComponentEnum.RAM);
                                        break;
                                    } catch (Exception e) {
                                        throwMessage("Error! Enter valid id!");
                                    }
                                }
                            } else {
                                System.out.println("\nThere is nothing to change. List items empty\n");
                            }
                            break;
                        }
                        case "4": {
                            if (!st.getListMotherboard().isEmpty()) {
                                st.showMotherboard();
                                while (true) {
                                    try {
                                        System.out.println("Input id to change: ");
                                        answer = in.nextLine().toLowerCase().replace(" ", "");
                                        st.changeComponent(Integer.parseInt(answer), ComponentEnum.MOTHERBOARD);
                                        break;
                                    } catch (Exception e) {
                                        throwMessage("Error! Enter valid id!");
                                    }
                                }
                            } else {
                                System.out.println("\nThere is nothing to change. List items empty\n");
                            }
                            break;
                        }
                        case "5": {
                            if (!st.getListPowerSupply().isEmpty()) {
                                st.showPowerSupply();
                                while (true) {
                                    try {
                                        System.out.println("Input id to change: ");
                                        answer = in.nextLine().toLowerCase().replace(" ", "");
                                        st.changeComponent(Integer.parseInt(answer), ComponentEnum.POWER_SUPPLY);
                                        break;
                                    } catch (Exception e) {
                                        throwMessage("Error! Enter valid id!");
                                    }
                                }
                            } else {
                                System.out.println("\nThere is nothing to change. List items empty\n");
                            }
                            break;
                        }
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
                    int id = 0;
                    switch (answer) {
                        case "1": {
                            st.showCPU();
                            while (true) {
                                try {
                                    System.out.println("Input id to remove: ");
                                    id = in.nextInt();
                                    st.removeComponent(id, ComponentEnum.CPU);
                                    break;
                                } catch (Exception e) {
                                    throw new Exception("Error! Unknown id");
                                }
                            }
                            break;
                        }
                        case "2": {
                            st.showCPU();
                            while (true) {
                                try {
                                    System.out.println("Input id to remove: ");
                                    id = in.nextInt();
                                    st.removeComponent(id, ComponentEnum.GPU);
                                    break;
                                } catch (Exception e) {
                                    throw new Exception("Error! Unknown id");
                                }
                            }
                            break;
                        }
                        case "3": {
                            st.showCPU();
                            while (true) {
                                try {
                                    System.out.println("Input id to remove: ");
                                    id = in.nextInt();
                                    st.removeComponent(id, ComponentEnum.RAM);
                                    break;
                                } catch (Exception e) {
                                    throw new Exception("Error! Unknown id");
                                }
                            }
                            break;
                        }
                        case "4": {
                            st.showCPU();
                            while (true) {
                                try {
                                    System.out.println("Input id to remove: ");
                                    id = in.nextInt();
                                    st.removeComponent(id, ComponentEnum.MOTHERBOARD);
                                    break;
                                } catch (Exception e) {
                                    throw new Exception("Error! Unknown id");
                                }
                            }
                            break;
                        }
                        case "5": {
                            st.showCPU();
                            while (true) {
                                try {
                                    System.out.println("Input id to remove: ");
                                    id = in.nextInt();
                                    st.removeComponent(id, ComponentEnum.POWER_SUPPLY);
                                    break;
                                } catch (Exception e) {
                                    throw new Exception("Error! Unknown id");
                                }
                            }
                            break;
                        }
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

    static Component addAndValidateComponent(ComponentEnum component) throws Exception {
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
                switch (component) {
                    case CPU -> {
                        return new CPU(name, quantity, price);
                    }
                    case GPU -> {
                        return new GPU(name, quantity, price);
                    }
                    case RAM -> {
                        return new RAM(name, quantity, price);
                    }
                    case MOTHERBOARD -> {
                        return new Motherboard(name, quantity, price);
                    }
                    case POWER_SUPPLY -> {
                        return new PowerSupply(name, quantity, price);
                    }
                }

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
