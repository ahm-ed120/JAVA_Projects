/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;

import java.util.Date;

/**
 *
 * @author MAHNOOR SARDAR
 */
public class BloodBag {
    public String bloodType;
    public double volume; 
    public Date expiryDate;
    
    public BloodBag()
    {
     bloodType="";
     volume=0.0;
     expiryDate= new Date();
    }
    
    public BloodBag(String bloodType, double volume, Date expiryDate)
    {
      this.bloodType=bloodType;
      this.expiryDate=expiryDate;
      this.volume=volume;
    }
    
    public void setVolume(double volume)
    {
        this.volume= volume;
    }
    public double getVolume()
    {
        return volume;
    }
    
    public void setexpiryDate(Date expiryDate)
    {
        this.expiryDate=expiryDate;
    }
    
    public Date getexpiryDate()
    {
        return expiryDate;
    }
    
    public boolean checkExpiry()
    {
        Date currentDate = new Date();
        return currentDate.after(expiryDate);
    }
    
}
