package sk.akademiasovy.tipos.main;

import sk.akademiasovy.tipos.Bet;
import sk.akademiasovy.tipos.Tipos;
import sk.akademiasovy.tipos.database.mysqldatabase;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tipos tipos = new Tipos();
        tipos.printArray();
        tipos.generate();

        mysqldatabase Mysqldatabase = new mysqldatabase();
        Mysqldatabase.testConnection();
        Mysqldatabase.insertValueIntoDrawHistory(tipos.getArr());
        List<Bet> list=Mysqldatabase.getBets();
        tipos.printNewBets(list);

    }
}
