package com.tangorabox.resumefx.views;

import com.tangorabox.resumefx.views.award.AwardViewModel;
import com.tangorabox.resumefx.views.basicinfo.BasicInfoViewModel;
import com.tangorabox.resumefx.views.education.EducationViewModel;
import com.tangorabox.resumefx.views.interest.InterestViewModel;
import com.tangorabox.resumefx.views.language.LanguageViewModel;
import com.tangorabox.resumefx.views.publication.PublicationViewModel;
import com.tangorabox.resumefx.views.reference.ReferenceViewModel;
import com.tangorabox.resumefx.views.skill.SkillViewModel;
import com.tangorabox.resumefx.views.work.VolunteerViewModel;
import com.tangorabox.resumefx.views.work.WorkViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ResumeViewModel {

    private final ObjectProperty<BasicInfoViewModel> basicInfo = new SimpleObjectProperty<>();
    private ObservableList<WorkViewModel> works = FXCollections.observableArrayList();
    private ObservableList<VolunteerViewModel> volunteers = FXCollections.observableArrayList();
    private ObservableList<EducationViewModel> educations = FXCollections.observableArrayList();
    private ObservableList<AwardViewModel> awards = FXCollections.observableArrayList();
    private ObservableList<PublicationViewModel> publications = FXCollections.observableArrayList();
    private ObservableList<SkillViewModel> skills = FXCollections.observableArrayList();
    private ObservableList<LanguageViewModel> languages = FXCollections.observableArrayList();
    private ObservableList<InterestViewModel> interests = FXCollections.observableArrayList();
    private ObservableList<ReferenceViewModel> references = FXCollections.observableArrayList();

    public BasicInfoViewModel getBasicInfo() {
        return basicInfo.get();
    }

    public ObjectProperty<BasicInfoViewModel> basicInfoProperty() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfoViewModel basicInfo) {
        this.basicInfo.set(basicInfo);
    }

    public ObservableList<WorkViewModel> getWorks() {
        return works;
    }

    public void setWorks(ObservableList<WorkViewModel> works) {
        this.works = works;
    }

    public ObservableList<VolunteerViewModel> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(ObservableList<VolunteerViewModel> volunteers) {
        this.volunteers = volunteers;
    }

    public ObservableList<EducationViewModel> getEducations() {
        return educations;
    }

    public void setEducations(ObservableList<EducationViewModel> educations) {
        this.educations = educations;
    }

    public ObservableList<AwardViewModel> getAwards() {
        return awards;
    }

    public void setAwards(ObservableList<AwardViewModel> awards) {
        this.awards = awards;
    }

    public ObservableList<PublicationViewModel> getPublications() {
        return publications;
    }

    public void setPublications(ObservableList<PublicationViewModel> publications) {
        this.publications = publications;
    }

    public ObservableList<SkillViewModel> getSkills() {
        return skills;
    }

    public void setSkills(ObservableList<SkillViewModel> skills) {
        this.skills = skills;
    }

    public ObservableList<LanguageViewModel> getLanguages() {
        return languages;
    }

    public void setLanguages(ObservableList<LanguageViewModel> languages) {
        this.languages = languages;
    }

    public ObservableList<InterestViewModel> getInterests() {
        return interests;
    }

    public void setInterests(ObservableList<InterestViewModel> interests) {
        this.interests = interests;
    }

    public ObservableList<ReferenceViewModel> getReferences() {
        return references;
    }

    public void setReferences(ObservableList<ReferenceViewModel> references) {
        this.references = references;
    }
}
