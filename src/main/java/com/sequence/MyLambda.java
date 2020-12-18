package com.sequence;

import java.util.*;
import java.util.stream.Collectors;

public class MyLambda {

    public static void main(String[] args) {
        MyLambda lambda = new MyLambda();
        lambda.sequence();
    }

    List<Resident> residentList = new ArrayList<>();
    private Map<String, Resident> residentMap = new HashMap<>();
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, String> rpMap = new HashMap<>();

    public void sequence() {
        Resident resident1 = new Resident("resident1", "Resident 1");
        Resident resident2 = new Resident("resident2", "Resident 2");
        Resident resident3 = new Resident("resident3", "Resident 3");
        Resident resident4 = new Resident("resident4", "Resident 4");
        Resident resident5 = new Resident("resident5", "Resident 5");
        Resident resident6 = new Resident("resident6", "Resident 6");

        residentList.add(resident1);
        residentList.add(resident2);
        residentList.add(resident3);
        residentList.add(resident4);
        residentList.add(resident5);
        residentList.add(resident6);

        residentMap.put(resident1.getResidentId(), resident1);
        residentMap.put(resident2.getResidentId(), resident2);
        residentMap.put(resident3.getResidentId(), resident3);
        residentMap.put(resident4.getResidentId(), resident4);
        residentMap.put(resident5.getResidentId(), resident5);
        residentMap.put(resident6.getResidentId(), resident6);


        Policy policy1 = new Policy("policy1");
        Policy policy2 = new Policy("policy2");
        Policy policy3 = new Policy("policy3");
        Policy policy4 = new Policy("policy4");
        Policy policy5 = new Policy("policy5");
        Policy policy6 = new Policy("policy6");

        policyMap.put(policy1.getPolicyNumber(), policy1);
        policyMap.put(policy2.getPolicyNumber(), policy2);
        policyMap.put(policy3.getPolicyNumber(), policy3);
        policyMap.put(policy4.getPolicyNumber(), policy4);
        policyMap.put(policy5.getPolicyNumber(), policy5);
        policyMap.put(policy6.getPolicyNumber(), policy6);

        rpMap.put("resident1", "policy1");
        rpMap.put("resident2", "policy6");
        rpMap.put("resident5", "policy2");

//        for(Resident r: residentList) {
//            String policyId = rpMap.get(r.getResidentId());
//            if (policyId != null) {
//                Policy p = policyMap.get(policyId);
//                r.setPolicy(p);
//            }
//        }

        residentList.stream().map(resident -> {
            String policyId = rpMap.get(resident.getResidentId());
            if (policyId != null) {
                Policy p = policyMap.get(policyId);
                resident.setPolicy(p);
            }
            return resident;
        }).collect(Collectors.toList());
        printResidents();
    }

    public void printResidents() {
        for(Resident r: residentList) {
            System.out.println(r.toString());
        }
    }
}
