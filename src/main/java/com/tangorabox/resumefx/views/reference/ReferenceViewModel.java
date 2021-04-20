package com.tangorabox.resumefx.views.reference;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReferenceViewModel {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty reference = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getReference() {
        return reference.get();
    }

    public StringProperty referenceProperty() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference.set(reference);
    }
}
