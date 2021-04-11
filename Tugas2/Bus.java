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
public class Bus extends Kendaraan {
    char driver;

    public char getDriver() {
        return driver;
    }

    public void setDriver(char driver) {
        this.driver = driver;
    }
    
    public Bus(String merk, int day){
        super(merk,day);
    }
    
    @Override
    int cost(){
        return (1000000*day);
    }
    
    int cost(char driver){ //overload
        if (driver == 'y')
            return (1050000*day);
        else
            return (1000000*day); 
    }
}
