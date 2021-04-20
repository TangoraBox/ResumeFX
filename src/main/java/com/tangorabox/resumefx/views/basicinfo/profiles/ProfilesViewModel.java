package com.tangorabox.resumefx.views.basicinfo.profiles;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProfilesViewModel {

    private final StringProperty network = new SimpleStringProperty();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty url = new SimpleStringProperty();


    public String getNetwork() {
        return network.get();
    }

    public StringProperty networkProperty() {
        return network;
    }

    public void setNetwork(String network) {
        this.network.set(network);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getUrl() {
        return url.get();
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }
}
