package com.tangorabox.resumefx.views.work;

import com.tangorabox.resumefx.views.period.PeriodViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkViewModel extends PeriodViewModel {

    private final StringProperty company = new SimpleStringProperty();
    private final StringProperty position = new SimpleStringProperty();
    private final StringProperty website = new SimpleStringProperty();
    private final StringProperty summary = new SimpleStringProperty();
    private final ObservableList<String> highlights = FXCollections.observableArrayList();

    public String getCompany() {
        return company.get();
    }

    public StringProperty companyProperty() {
        return company;
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getWebsite() {
        return website.get();
    }

    public StringProperty websiteProperty() {
        return website;
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public String getSummary() {
        return summary.get();
    }

    public StringProperty summaryProperty() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    public ObservableList<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(String... highlights) {
        if (highlights != null) {
            this.highlights.setAll(highlights);
        }
    }
}
