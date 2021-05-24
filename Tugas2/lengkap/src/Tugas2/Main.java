/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas2;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author GF63-9SC-621ID
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String inputMerk, inputUsername, inputPassword;
        char inputDriver;
        int inputMenu=0;
        int inputDay;
        
        User customer = new User("1","1");
        
        
        System.out.print("Masukkan username\t : ");
        inputUsername = input.next();
        System.out.print("Masukkan password\t : ");
        inputPassword = input.next();
      
        if (customer.Login(inputUsername,inputPassword)){
            try{
                System.out.println("----Parakan Rental Center----\n");
                System.out.println("1. Motor (Rp 200.000/hari)");
                System.out.println("2. Mobil (Rp 600.000/hari)");
                System.out.println("3. Bus (Rp 1.000.000/hari)");
                System.out.print("\nPilih Kendaraan (1-3) : ");
                inputMenu = input.nextInt(); //user input menu yg mau dipilih
            }
            catch (InputMismatchException error) {
                System.out.println("Jangan memasukan input selain angka 1-3! (errornya adalah " + error.getMessage() + ")");
                // ketika user memilih menu tapi inputnya huruf, maka akan error
            }
            finally{
                switch(inputMenu){
                    case 1 :
                        System.out.println("Rental Motor");
                        System.out.print("Merk Motor\t\t : ");
                        inputMerk = input.next();
                        System.out.print("Lama Sewa\t\t : ");
                        inputDay = input.nextInt();
                        Motor bookMotor = new Motor(inputMerk, inputDay);
                        System.out.println("\nSilahkan bayar penyewaan Motor " + inputMerk + " sebesar Rp " + bookMotor.cost());
                        break;

                    case 2 :
                        System.out.println("Rental Mobil");
                        System.out.print("Merk Mobil\t\t : ");
                        inputMerk = input.next();
                        System.out.print("Lama Sewa\t\t : ");
                        inputDay = input.nextInt();
                        Mobil bookMobil = new Mobil(inputMerk, inputDay);
                        System.out.println("\nSilahkan bayar penyewaan Mobil " + inputMerk + " sebesar Rp " + bookMobil.cost());
                        break;

                    case 3 :
                        System.out.println("Rental Bus");
                        System.out.print("Merk Bus\t\t : ");
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
        }
        else
            System.out.println("Login Gagal!");   
    }
}
