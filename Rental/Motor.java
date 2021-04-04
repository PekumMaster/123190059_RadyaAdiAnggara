/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental;

/**
 *
 * @author GF63-9SC-621ID
 */
public class Motor extends Kendaraan {
    
    public Motor(String merk, int day){
        super(merk,day);
    }
    
    @Override
    int cost(){
        return (200000*day);
    }
}
