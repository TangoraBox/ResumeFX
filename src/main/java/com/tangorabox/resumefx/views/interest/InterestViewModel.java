package com.tangorabox.resumefx.views.interest;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InterestViewModel {

    private final StringProperty name = new SimpleStringProperty();
    private final ObservableList<String> keywords = FXCollections.observableArrayList();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(String... keywords) {
        if (keywords != null) {
            this.keywords.setAll(keywords);
        }
    }
}
