
package model.Personnel;

import java.util.ArrayList;

import model.Business.Business;


public class EmployeeDirectory {

    Business business;
    ArrayList<EmployeeProfile> employeeList;

    public EmployeeDirectory(Business d) {

        business = d;
        employeeList = new ArrayList<EmployeeProfile>();

    }

    public EmployeeProfile newEmployeeProfile(Person p) {

        EmployeeProfile sp = new EmployeeProfile(p);
        employeeList.add(sp);
        return sp;
    }

    public EmployeeProfile findEmployee(String id) {

        for (EmployeeProfile sp : employeeList) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; // not found after going through the whole list
    }

}
