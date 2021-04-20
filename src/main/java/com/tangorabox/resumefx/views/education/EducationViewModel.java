package com.tangorabox.resumefx.views.education;

import com.tangorabox.resumefx.views.period.PeriodViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EducationViewModel extends PeriodViewModel {

    private final StringProperty institution = new SimpleStringProperty();
    private final StringProperty area = new SimpleStringProperty();
    private final StringProperty studyType = new SimpleStringProperty();
    private final FloatProperty gpa = new SimpleFloatProperty();
    private final StringProperty gpaLabel = new SimpleStringProperty();
    private final ObservableList<String> courses = FXCollections.observableArrayList();

    public EducationViewModel() {
        gpaLabel.bind(Bindings.createStringBinding(() -> {
            if (getGpa() > 0) {
                return String.format("(GPA: %.2f)", getGpa());
            }
            return "";
        }, gpaProperty()));
    }

    public String getInstitution() {
        return institution.get();
    }

    public StringProperty institutionProperty() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution.set(institution);
    }

    public String getArea() {
        return area.get();
    }

    public StringProperty areaProperty() {
        return area;
    }

    public void setArea(String area) {
        this.area.set(area);
    }

    public String getStudyType() {
        return studyType.get();
    }

    public StringProperty studyTypeProperty() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType.set(studyType);
    }

    public float getGpa() {
        return gpa.get();
    }

    public FloatProperty gpaProperty() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa.set(gpa);
    }

    public ObservableList<String> getCourses() {
        return courses;
    }

    public void setCourses(String... courses) {
        if (courses != null) {
            this.courses.setAll(courses);
        }
    }

    public String getGpaLabel() {
        return gpaLabel.get();
    }

    public StringProperty gpaLabelProperty() {
        return gpaLabel;
    }

    public void setGpaLabel(String gpaLabel) {
        this.gpaLabel.set(gpaLabel);
    }
}
