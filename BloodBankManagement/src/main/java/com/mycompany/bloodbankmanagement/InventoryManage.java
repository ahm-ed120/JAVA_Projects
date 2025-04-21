/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bloodbankmanagement;

/**
 *
 * @author MAHNOOR SARDAR
 * 
 */
public interface InventoryManage {
    public void addItem(BloodBag bloodBag);
    public void removeItem(BloodBag bloodBag);
    public void displayInventory();
    public String checkItemCondition();
}
