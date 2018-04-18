package org.pis.core;

public enum Roles {
    ADMIN("Admin"),
    MANAGER("Manager"),
    EMPLOYEE("Employee");

    private String label;

    private Roles(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    public boolean equals(String roleName){
        return label.toLowerCase().equals(roleName.toLowerCase());
    }
}
