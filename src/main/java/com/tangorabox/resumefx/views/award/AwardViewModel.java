package com.tangorabox.resumefx.views.award;

import com.tangorabox.resumefx.views.period.PeriodViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AwardViewModel extends PeriodViewModel {

    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty awarder = new SimpleStringProperty();
    private final StringProperty summary = new SimpleStringProperty();

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAwarder() {
        return awarder.get();
    }

    public StringProperty awarderProperty() {
        return awarder;
    }

    public void setAwarder(String awarder) {
        this.awarder.set(awarder);
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
