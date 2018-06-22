package com.example.kas.model;

public class Package {
    private String code;
    private Organization organization;

    public Package(){}

    public Package(String code, Organization organization) {
        this.code = code;
        this.organization = organization;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString(){
        return this.code + " " + this.organization.getDescription() + " " + this.organization.getImage_display_url();
    }
}