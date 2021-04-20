package com.tangorabox.resumefx.views.basicinfo;

import com.tangorabox.resumefx.views.basicinfo.location.LocationViewModel;
import com.tangorabox.resumefx.views.basicinfo.profiles.ProfilesViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class BasicInfoViewModel {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty label = new SimpleStringProperty();
    private final ObjectProperty<Image> picture = new SimpleObjectProperty<>();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final StringProperty webSite = new SimpleStringProperty();
    private final StringProperty summary = new SimpleStringProperty();
    private final ObjectProperty<LocationViewModel> location = new SimpleObjectProperty<>();
    private ObservableList<ProfilesViewModel> profiles = FXCollections.observableArrayList();


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLabel() {
        return label.get();
    }

    public StringProperty labelProperty() {
        return label;
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public Image getPicture() {
        return picture.get();
    }

    public ObjectProperty<Image> pictureProperty() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture.set(picture);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getWebSite() {
        return webSite.get();
    }

    public StringProperty webSiteProperty() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite.set(webSite);
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

    public LocationViewModel getLocation() {
        return location.get();
    }

    public ObjectProperty<LocationViewModel> locationProperty() {
        return location;
    }

    public void setLocation(LocationViewModel location) {
        this.location.set(location);
    }

    public ObservableList<ProfilesViewModel> getProfiles() {
        return profiles;
    }

    public void setProfiles(ObservableList<ProfilesViewModel> profiles) {
        this.profiles = profiles;
    }
}
