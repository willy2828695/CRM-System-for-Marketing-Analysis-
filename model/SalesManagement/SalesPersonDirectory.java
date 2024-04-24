/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.SalesManagement;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonDirectory {

    Business business;
    ArrayList<SalesPersonProfile> salesPersonList;
    private Random r;

    public SalesPersonDirectory(Business d) {

        business = d;
        salesPersonList = new ArrayList<SalesPersonProfile>();
        r = new Random();

    }

    public SalesPersonProfile newSalesPersonProfile(Person p) {

        SalesPersonProfile sp = new SalesPersonProfile(p);
        salesPersonList.add(sp);
        return sp;
    }

    // public SalesPersonProfile findSalesPerson(String id) {

    //     for (SalesPersonProfile sp : salesPersonList) {

    //         if (sp.isMatch(id)) {
    //             return sp;
    //         }
    //     }
    //     return null; // not found after going through the whole list
    // }

    public SalesPersonProfile pickRandomSalesperson() {
        if (salesPersonList.size() == 0)
            return null;
        int randomIndex = r.nextInt(salesPersonList.size());
        return salesPersonList.get(randomIndex);
    }

    public ArrayList<SalesPersonProfile> getSalesPersonList() {
        return salesPersonList;
    }
}
