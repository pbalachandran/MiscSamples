package com.sequence;

public class ResidentPolicyMatch {

    private String residentId;
    private String policyId;

    public ResidentPolicyMatch(String residentId, String policyId) {
        this.residentId = residentId;
        this.policyId = policyId;
    }


    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }
}
