package com.dhosio.voucherscan.models.Enums;

public enum Branch {

    GRAND_BAIE("GB", "Grand Baie", "La Croisette"),
    ROSE_BELLE("RB", "Rose Belle", "Rose Belle Mall"),
    FLIC_EN_FLAC("FEF", "Flic en Flac", "Cascavelle"),
    QUATRE_BORNES("QB", "Quatre Bornes", "MEtro Station");

    private String branchId;
    private String branchName;
    private String address;

    Branch(String branchId, String branchName, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.address = address;
    }

    public String getBranchId(){
        return this.branchId;
    }

}
