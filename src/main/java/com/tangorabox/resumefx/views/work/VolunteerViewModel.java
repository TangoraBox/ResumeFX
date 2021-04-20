package com.tangorabox.resumefx.views.work;

import javafx.beans.property.StringProperty;

public class VolunteerViewModel extends WorkViewModel {

    public String getOrganization() {
        return getCompany();
    }

    public StringProperty organizationProperty() {
        return companyProperty();
    }

    public void setOrganization(String organization) {
        setCompany(organization);
    }
}
