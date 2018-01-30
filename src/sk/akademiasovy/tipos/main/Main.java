package sk.akademiasovy.tipos.main;

import sk.akademiasovy.tipos.Tipos;
import sk.akademiasovy.tipos.database.mysqldatabase;

public class Main {
    public static void main(String[] args) {
        Tipos tipos = new Tipos();
        tipos.printArray();

        mysqldatabase Mysqldatabase = new mysqldatabase();
        Mysqldatabase.testConnection();
        Mysqldatabase.insertValueIntoDrawHistory(tipos.getArr());
    }
}
