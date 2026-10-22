package org.abes.hrms.model;

import org.abes.hrms.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {
    @Autowired
    private EmpRepo repo;
    public int add(){
        return repo.add();
    }
    public double squareRoot(){
        return repo.squareroot(200);
    }
    public int greater(){
        return repo.greater(5,8);
    }
}
