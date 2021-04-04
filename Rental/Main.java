/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental;

import java.util.Scanner;

/**
 *
 * @author GF63-9SC-621ID
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String inputMerk;
        char inputDriver;
        int inputMenu, inputDay;
        
        User customer = new User("radyaadi","123190059");
        
        System.out.print("Masukkan username\t : ");
        String inputUsername = input.next();
        System.out.print("Masukkan password\t : ");
        String inputPassword = input.next();
        
        if (customer.Login(inputUsername,inputPassword)){
            System.out.println("----Parakan Rental Center----\n");
            System.out.println("1. Motor (Rp 200.000/hari)");
            System.out.println("2. Mobil (Rp 600.000/hari)");
            System.out.println("3. Bus (Rp 1.000.000/hari)");
            System.out.print("\nPilih Kendaraan : ");
            inputMenu = input.nextInt(); //user input menu yg mau dipilih

            switch(inputMenu){
                case 1 :
                    System.out.println("Rental Motor");
                    System.out.print("Merk Motor\t\t\t : ");
                    inputMerk = input.next();
                    System.out.print("Lama Sewa\t\t : ");
                    inputDay = input.nextInt();
                    Motor bookMotor = new Motor(inputMerk, inputDay);
                    System.out.println("\nSilahkan bayar penyewaan Motor " + inputMerk + " sebesar Rp " + bookMotor.cost());
                    break;
                    
                case 2 :
                    System.out.println("Rental Mobil");
                    System.out.print("Merk Mobil\t\t\t : ");
                    inputMerk = input.next();
                    System.out.print("Lama Sewa\t\t : ");
                    inputDay = input.nextInt();
                    Mobil bookMobil = new Mobil(inputMerk, inputDay);
                    System.out.println("\nSilahkan bayar penyewaan Mobil " + inputMerk + " sebesar Rp " + bookMobil.cost());
                    break;
                    
                case 3 :
                    System.out.println("Rental Bus");
                    System.out.print("Merk Bus\t\t\t : ");
                    inputMerk = input.next();
                    System.out.print("Lama Sewa\t\t : ");
                    inputDay = input.nextInt();
                    System.out.print("Pakai Supir ?(y/n)\t : ");
                    inputDriver = input.next().charAt(0);
                    
                    Bus bookBus = new Bus(inputMerk, inputDay);
                    bookBus.setDriver(inputDriver);
                    
                    System.out.println("\nSilahkan bayar penyewaan Bus " + inputMerk + " sebesar Rp " + bookBus.cost(bookBus.getDriver()));
                    break;
                    
                default :
                    System.out.println("Menu tidak tersedia");
            }
        }
        else
            System.out.println("Login Gagal!");
    }
}
