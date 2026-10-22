package org.abes.hrms.repository;

import org.springframework.stereotype.Component;

@Component
public class EmpRepoImp implements EmpRepo {
    @Override
    public double squareroot(double d) {
        double result = Math.sqrt(d);
        return result;
    }

    @Override
    public String empData() {
        return "";
    }

    @Override
    public int add() {
        return 20+30;
    }

    @Override
    public int greater(int a, int b) {
        if(a>b){
            return a;
        }
        else {
            return b;
        }
    }

}
