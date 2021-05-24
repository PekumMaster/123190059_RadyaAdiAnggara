/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas2;

/**
 *
 * @author GF63-9SC-621ID
 */
public abstract class Kendaraan {
    String merk;
    int day;

    public Kendaraan(String merk, int day) {
        this.merk = merk;
        this.day = day;
    }
    
    abstract int cost();
}
