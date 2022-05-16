package Storages;

import Components.*;
import Utils.ComponentEnum;
import Utils.SimpleTableFormatter;
import Utils.TableFormatter;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private final ArrayList<CPU> listCPU = new ArrayList<>();
    private final ArrayList<GPU> listGPU = new ArrayList<>();
    private final ArrayList<RAM> listRAM = new ArrayList<>();
    private final ArrayList<Motherboard> listMotherboard = new ArrayList<>();
    private final ArrayList<PowerSupply> listPowerSupply = new ArrayList<>();
    TableFormatter tf = new SimpleTableFormatter(true);

    public void createTable(int id, String name, int quantity, float price) {
        tf.nextRow().nextCell().addLine("   ").nextCell().addLine(String.valueOf(id))
                .nextCell().addLine("   ")
                .nextCell().addLine(name)
                .nextCell().addLine("   ")
                .nextCell().addLine(String.valueOf(quantity))
                .nextCell().addLine("   ")
                .nextCell().addLine(String.valueOf(price))
                .nextCell().addLine("   ");
    }

    public void addHeaderToTable() {
        tf.nextRow().nextCell().addLine("   ").nextCell().addLine("ID")
                .nextCell().addLine("   ")
                .nextCell().addLine("NAME")
                .nextCell().addLine("   ")
                .nextCell().addLine("QUANTITY")
                .nextCell().addLine("   ")
                .nextCell().addLine("PRICE")
                .nextCell().addLine("   ");
    }

    public void showCPU() {
        if (!listCPU.isEmpty()) {
            addHeaderToTable();
            System.out.println("\t\tCPU:\t\t");
            for (CPU cpu : listCPU) {
                createTable(cpu.getId(), cpu.getName(), cpu.getQuantity(), cpu.getPrice());
            }
            String[] table = tf.getFormattedTable();
            for (String s : table) {
                System.out.println("\t\t" + s);
            }
        } else {
            System.out.println("List items empty");
        }
        clearTable();
    }

    public void showGPU() {
        if (!listGPU.isEmpty()) {
            addHeaderToTable();
            System.out.println("\t\tGPU:\t\t");
            for (GPU gpu : listGPU) {
                createTable(gpu.getId(), gpu.getName(), gpu.getQuantity(), gpu.getPrice());
            }
            String[] table = tf.getFormattedTable();
            for (String s : table) {
                System.out.println("\t\t" + s);
            }
        } else {
            System.out.println("List items empty");
        }
        clearTable();
    }

    public void showRAM() {
        if (!listRAM.isEmpty()) {
            addHeaderToTable();
            System.out.println("\t\tRAM:\t\t");
            for (RAM ram : listRAM) {
                createTable(ram.getId(), ram.getName(), ram.getQuantity(), ram.getPrice());
            }
            String[] table = tf.getFormattedTable();
            for (String s : table) {
                System.out.println("\t\t" + s);
            }
        } else {
            System.out.println("List items empty");
        }
        clearTable();
    }

    public void showMotherboard() {
        if (!listMotherboard.isEmpty()) {
            addHeaderToTable();
            System.out.println("\t\tMotherboard:\t\t");
            for (Motherboard mb : listMotherboard) {
                createTable(mb.getId(), mb.getName(), mb.getQuantity(), mb.getPrice());
            }
            String[] table = tf.getFormattedTable();
            for (String s : table) {
                System.out.println("\t\t" + s);
            }
        } else {
            System.out.println("List items empty");
        }
        clearTable();
    }

    public void showPowerSupply() {
        if (!listPowerSupply.isEmpty()) {
            addHeaderToTable();
            System.out.println("\t\tPower Supply:\t\t");
            for (PowerSupply ps : listPowerSupply) {
                createTable(ps.getId(), ps.getName(), ps.getQuantity(), ps.getPrice());
            }
            String[] table = tf.getFormattedTable();
            for (String s : table) {
                System.out.println("\t\t" + s);
            }
        } else {
            System.out.println("List items empty");
        }
        clearTable();
    }

    public void changeComponent(int id, ComponentEnum component) throws Exception {

        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter new name: ");
                String name = in.nextLine();
                System.out.println("Enter new quantity: ");
                int quantity = in.nextInt();
                System.out.println("Enter new price: ");
                float price = in.nextFloat();
                switch (component) {
                    case CPU -> {
                        CPU newCPU = new CPU(id, name, quantity, price);
                        listCPU.remove(id);
                        listCPU.add(newCPU);
                    }
                    case GPU -> {
                        GPU newGPU = new GPU(id, name, quantity, price);
                        listGPU.remove(id);
                        listGPU.add(newGPU);
                    }
                    case RAM -> {
                        RAM newRAM = new RAM(id, name, quantity, price);
                        listRAM.remove(id);
                        listRAM.add(newRAM);
                    }
                    case MOTHERBOARD -> {
                        Motherboard newMotherboard = new Motherboard(id, name, quantity, price);
                        listMotherboard.remove(id);
                        listMotherboard.add(newMotherboard);
                    }
                    case POWER_SUPPLY -> {
                        PowerSupply powerSupply = new PowerSupply(id, name, quantity, price);
                        listPowerSupply.remove(id);
                        listPowerSupply.add(powerSupply);
                    }

                }
                break;
            } catch (Exception e) {
                throw new Exception("Unknown enter valid data");
            }
        }
    }

    public void removeComponent(int id, ComponentEnum component) {
        switch (component) {
            case CPU -> {
                CPU.decrementCounter();
                listCPU.remove(id);
                System.out.println("CPU removed");
            }
            case GPU -> {
                GPU.decrementCounter();

                listGPU.remove(id);
                System.out.println("GPU removed");
            }
            case RAM -> {
                RAM.decrementCounter();

                listRAM.remove(id);
                System.out.println("RAM removed");
            }
            case MOTHERBOARD -> {
                Motherboard.decrementCounter();

                listMotherboard.remove(id);
                System.out.println("Motherboard removed");
            }
            case POWER_SUPPLY -> {
                PowerSupply.decrementCounter();

                listPowerSupply.remove(id);
                System.out.println("Power Supply removed");
            }
        }
    }

    public void clearTable() {
        tf = new SimpleTableFormatter(true);
    }

    public void addToListCPU(CPU newCPU) {
        listCPU.add(newCPU);
    }

    public void addToListGPU(GPU newGPU) {
        listGPU.add(newGPU);
    }

    public void addToListMotherboard(Motherboard newMotherboard) {
        listMotherboard.add(newMotherboard);
    }

    public void addToListPowerSupply(PowerSupply newPowerSupply) {
        listPowerSupply.add(newPowerSupply);
    }

    public void addToListRAM(RAM newRAM) {
        listRAM.add(newRAM);
    }

    public void clearStorage() {
        listCPU.clear();
        listRAM.clear();
        listGPU.clear();
        listMotherboard.clear();
        listPowerSupply.clear();
    }

    public boolean isEmpties() {
        return listCPU.isEmpty() && listGPU.isEmpty() && listRAM.isEmpty() && listMotherboard.isEmpty() && listPowerSupply.isEmpty();
    }

    public ArrayList<CPU> getListCPU() {
        return listCPU;
    }

    public ArrayList<GPU> getListGPU() {
        return listGPU;
    }

    public ArrayList<Motherboard> getListMotherboard() {
        return listMotherboard;
    }

    public ArrayList<PowerSupply> getListPowerSupply() {
        return listPowerSupply;
    }

    public ArrayList<RAM> getListRAM() {
        return listRAM;
    }
}
