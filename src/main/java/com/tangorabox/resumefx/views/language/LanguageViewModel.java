package com.tangorabox.resumefx.views.language;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LanguageViewModel {

    private final StringProperty language = new SimpleStringProperty();
    private final StringProperty fluency = new SimpleStringProperty();

    public String getLanguage() {
        return language.get();
    }

    public StringProperty languageProperty() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public String getFluency() {
        return fluency.get();
    }

    public StringProperty fluencyProperty() {
        return fluency;
    }

    public void setFluency(String fluency) {
        this.fluency.set(fluency);
    }
}
