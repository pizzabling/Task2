package ru.itmatveev.task2.repository;

import org.springframework.stereotype.Repository;
import ru.itmatveev.task2.domain.Domain;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Repo {
    private List<Domain> domainList = new ArrayList<>();

    public List<Domain> getDomainList(){
        return domainList;
    }

    public Domain getDomainByName(String name){
        for (Domain domain : domainList){
            if(domain != null && domain.getName() == name){
                return domain;
            }
        }
        return null;
    }

    public void addDomain(String id, String charCode, String name, String value){
        Domain domain = new Domain(id,charCode,name,value);
        domainList.add(domain);
    }

    public void clearList(){
        domainList.clear();
    }
}
