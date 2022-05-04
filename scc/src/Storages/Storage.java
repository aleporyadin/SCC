package Storages;

import Components.*;

import java.util.ArrayList;

public class Storage {

    private final ArrayList<CPU> listCPU = new ArrayList<>();
    private final ArrayList<GPU> listGPU = new ArrayList<>();
    private final ArrayList<Motherboard> listMotherboard = new ArrayList<>();
    private final ArrayList<PowerSupply> listPowerSupply = new ArrayList<>();
    private final ArrayList<RAM> listRAM = new ArrayList<>();

    public void showStore() {
        System.out.println("\n\t\tCPU\t\t|\t\tGPU\t\t|\t\tRAM\t\t|\t\tMotherboard\t\t|\t\tPowerSupply");
        for(CPU cpu : listCPU){
            for(GPU gpu : listGPU){
                for(Motherboard motherboard : listMotherboard){
                    for(PowerSupply ps : listPowerSupply){
                        for(RAM ram : listRAM) {
                            System.out.println(
                                    "\t\t" + cpu.getName() + "\t\t|\t\t" +gpu.getName() +
                                    "\t\t|\t\t" + motherboard.getName()+"\t\t|\t\t"+ps.getName() +
                                    "\t\t|\t\t" + ram.getName());
                        }
                    }
                }
            }
        }
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
