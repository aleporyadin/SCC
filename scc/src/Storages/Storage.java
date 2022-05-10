package Storages;

import Components.*;
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

    public void changeCPU(int id) throws Exception {
        Scanner in = new Scanner(System.in);
        CPU newCPU = null;
        int newID = id-1;
        while (true) {
            try {
                System.out.println("Enter new name: ");
                String name = in.nextLine();
                System.out.println("Enter new quantity: ");
                int quantity = in.nextInt();
                System.out.println("Enter new price: ");
                float price = in.nextFloat();
                newCPU = new CPU(newID, name, quantity, price);

                listCPU.remove(id);
                listCPU.add(newCPU);
                break;
            } catch (IndexOutOfBoundsException e) {
                throw new Exception("Unknown id");
            }
        }
    }

    public void removeComponent(int id, String componentToChange) {
        switch (componentToChange) {
            case "cpu" -> listCPU.remove(id);
            case "gpu" -> listGPU.remove(id);
            case "ram" -> listRAM.remove(id);
            case "motherboard" -> listMotherboard.remove(id);
            case "powersupply" -> listPowerSupply.remove(id);
        }
    }

    public void removeCPU(int id) throws Exception {
        try {
            listCPU.remove(id);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Unknown id");
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
