package com.contact.contactBook.enums;

public enum UserRole {
    ADMIN("admin"), USER("user");
    private String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


}
