package com.tangorabox.resumefx.views.skill;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SkillViewModel {

    private static final Double MAX_LEVEL = 5d;

    private final StringProperty name = new SimpleStringProperty();
    private final DoubleProperty level = new SimpleDoubleProperty();
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

    public double getLevel() {
        return level.get();
    }

    public DoubleProperty levelProperty() {
        return level;
    }

    public void setLevel(double level) {
        this.level.set(level / MAX_LEVEL);
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
