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
            System.out.println(
                    """
                        \t\tChoose action:
                        1. Show components.
                        2. Add component.
                        3. Change component.
                        4. Remove component.
                        5. Clear Storage.
                        6. Exit.""");
            System.out.println("Input answer: ");
            answer = in.nextLine().toLowerCase().replace(" ", "");
            if (answer.contains("1") || answer.contains("show")) {
                System.out.println("""
                        \n\tSelect which component list you want to see:
                        1. CPU.
                        2. GPU.
                        3. RAM.
                        4. Motherboard.
                        5. Power supply.
                        6. Back.
                        7. Exit""");
                System.out.println("Input answer: ");
                answer = in.nextLine().toLowerCase().replace(" ", "");
                if (answer.contains("1") || answer.contains("cpu")) {
                    st.showCPU();
                } else if (answer.contains("2") || answer.contains("gpu")) {
                    st.showGPU();
                } else if (answer.contains("3") || answer.contains("ram")) {
                    st.showRAM();
                } else if (answer.contains("4") || answer.contains("motherboard")) {
                    st.showMotherboard();
                } else if (answer.contains("5") || answer.contains("powersupply")) {
                    st.showPowerSupply();
                } else if (answer.contains("6") || answer.contains("back")) {
                    continue;
                } else if (answer.contains("7") || answer.contains("exit")) {
                    System.out.println("Buy");
                    return;
                } else {
                    throwMessage("Unknown Error");
                }
            } else if (answer.contains("2") || answer.contains("add")) {
                System.out.println("\n\tSelect the component you want to add:\n1. CPU.\n2. GPU\n3. RAM\n4. Motherboard.\n5. Power supply.\n6. Back.\n7. Exit");

                System.out.println("Input answer: ");
                answer = in.nextLine().toLowerCase().replace(" ", "");
                if (answer.contains("1") || answer.contains("cpu")) {
                    try {
                        st.addToListCPU(addAndValidateCPU());
                    } catch (Exception e) {
                        throwMessage(e.getMessage());
                    }
                } else if (answer.contains("2") || answer.contains("gpu")) {
                    st.addToListGPU(addAndValidateGPU());
                } else if (answer.contains("3") || answer.contains("ram")) {
                    st.addToListRAM(addAndValidateRAM());
                } else if (answer.contains("4") || answer.contains("motherboard")) {
                    st.addToListMotherboard(addAndValidateMotherboard());
                } else if (answer.contains("5") || answer.contains("powersupply")) {
                    st.addToListPowerSupply(addAndValidatePowerSupply());
                } else if (answer.contains("6") || answer.contains("back")) {
                    continue;
                } else if (answer.contains("7") || answer.contains("exit")) {
                    System.out.println("Buy");
                    return;
                } else {
                    throwMessage("Unknown Error");
                }
            } else if (answer.contains("3") || answer.contains("change")) {
                System.out.println("\n\tSelect the component you want to change:\n1. CPU.\n2. GPU\n3. RAM\n4. Motherboard.\n5. Power supply.\n6. Back.\n7. Exit");

                System.out.println("Input answer: ");
                answer = in.nextLine().toLowerCase().replace(" ", "");
                if (answer.contains("1") || answer.contains("cpu")) {
                    if (!st.getListCPU().isEmpty()) {
                        st.showCPU();
                        while (true) {
                            try {
                                System.out.println("Input id: ");
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
                } else if (answer.contains("2") || answer.contains("gpu")) {
                    st.addToListGPU(addAndValidateGPU());
                } else if (answer.contains("3") || answer.contains("ram")) {
                    st.addToListRAM(addAndValidateRAM());

                } else if (answer.contains("4") || answer.contains("motherboard")) {
                    st.addToListMotherboard(addAndValidateMotherboard());

                } else if (answer.contains("5") || answer.contains("powersupply")) {
                    st.addToListPowerSupply(addAndValidatePowerSupply());
                } else if (answer.contains("6") || answer.contains("back")) {
                    continue;
                } else if (answer.contains("7") || answer.contains("exit")) {
                    System.out.println("Buy");
                    return;
                } else {
                    throwMessage("Unknown Error");
                }
            } else if (answer.contains("4") || answer.contains("remove")) {
                System.out.println("\n\tSelect the component you want to change:\n1. CPU.\n2. GPU\n3. RAM\n4. Motherboard.\n5. Power supply.\n6. Back.\n7. Exit");

                System.out.println("Input answer: ");
                answer = in.nextLine().toLowerCase().replace(" ", "");
                if (answer.contains("1") || answer.contains("cpu")) {
                    if (!st.getListCPU().isEmpty()) {
                        st.showCPU();
                        while (true) {
                            try {
                                System.out.println("Input ID to remove: ");
                                answer = in.nextLine().toLowerCase().replace(" ", "");
                                st.removeCPU(Integer.parseInt(answer));
                                break;
                            } catch (Exception e) {
                                throwMessage("Enter id");
                            }
                        }
                    } else {
                        System.out.println("\nThere is nothing to change. List items empty\n");
                    }
                } else if (answer.contains("2") || answer.contains("gpu")) {
                    st.addToListGPU(addAndValidateGPU());
                } else if (answer.contains("3") || answer.contains("ram")) {
                    st.addToListRAM(addAndValidateRAM());

                } else if (answer.contains("4") || answer.contains("motherboard")) {
                    st.addToListMotherboard(addAndValidateMotherboard());

                } else if (answer.contains("5") || answer.contains("powersupply")) {
                    st.addToListPowerSupply(addAndValidatePowerSupply());
                } else if (answer.contains("6") || answer.contains("back")) {
                    continue;
                } else if (answer.contains("7") || answer.contains("exit")) {
                    System.out.println("Buy");
                    return;
                } else {
                    throwMessage("Unknown Error");
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
                price =  Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newCPU = new CPU(name, quantity, price);
                return newCPU;
            } catch (Exception e) {
                throwMessage(e.getMessage()+" Enter only number please");
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
                price =  Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newGPU = new GPU(name, quantity, price);
                return newGPU;
            } catch (Exception e) {
                throwMessage(e.getMessage()+" Enter only number please");
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
                price =  Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newRAM = new RAM(name, quantity, price);
                return newRAM;
            } catch (Exception e) {
                throwMessage(e.getMessage()+" Enter only number please");
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
                price =  Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newMotherboard = new Motherboard(name, quantity, price);
                return newMotherboard;
            } catch (Exception e) {
                throwMessage(e.getMessage()+" Enter only number please");
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
                price =  Integer.parseInt(in.nextLine());
                if (price < 0 || quantity < 0) {
                    throw new Exception("Price or Quantity cannot be less than zero");
                }
                newPowerSupply = new PowerSupply(name, quantity, price);
                return newPowerSupply;
            } catch (Exception e) {
                throwMessage(e.getMessage()+" Enter only number please");
            }
        }
    }

    static void throwMessage(String e) {
        System.out.println("\nError message: " + e + "\n");
    }
}
