package com.arun.companies.amazon;

import java.util.ArrayList;
import java.util.List;

public class CommonManager {

    public static void main(String[] args){

        Employee ceo = new Employee();
        ceo.id = 1;

        Employee ceo_sub_1 = new Employee();
        ceo_sub_1.id = 2;

        Employee ceo_sub_2 = new Employee();
        ceo_sub_2.id = 3;

        Employee ceo_sub_3 = new Employee();
        ceo_sub_3.id = 4;

        ceo_sub_1.subordinates.add(ceo_sub_3);
        ceo.subordinates.add(ceo_sub_1);
        ceo.subordinates.add(ceo_sub_2);

        System.out.println(new CommonManager().findCommonManager(ceo, ceo_sub_3, ceo_sub_1).id);

    }

    public Employee findCommonManager(Employee root, Employee p, Employee q){
        if(root == null || root.id == p.id || root.id == q.id){
            return root;
        }
        List<Employee> results = new ArrayList<>();
        for(Employee sub : root.subordinates){
            Employee result = findCommonManager(sub, p, q);
            if(result != null){
                results.add(result);
            }
        }
        if(results.size() == 1){
            return results.get(0);
        }else if(results.size() == 2){
            return root;
        }else{
            return null;
        }
    }

}

class Employee{
    int id;
    List<Employee> subordinates = new ArrayList<>();
}
