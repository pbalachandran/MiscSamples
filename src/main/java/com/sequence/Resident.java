package com.sequence;

public class Resident {

    private String residentId;
    private String name;
    private Policy policy;

    public Resident(String residentId, String name) {
        this.residentId = residentId;
        this.name = name;
    }


    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public String toString() {
        String policyNumber = (policy != null) ? policy.getPolicyNumber() : "";
        return residentId + " - " + name + " - " + policyNumber;
    }

    public void print() {
    }
}
