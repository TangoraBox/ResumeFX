package com.tangorabox.resumefx.views.publication;

import com.tangorabox.resumefx.views.period.PeriodViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PublicationViewModel extends PeriodViewModel {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty publisher = new SimpleStringProperty();
    private final StringProperty website = new SimpleStringProperty();
    private final StringProperty summary = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPublisher() {
        return publisher.get();
    }

    public StringProperty publisherProperty() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher.set(publisher);
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
}
