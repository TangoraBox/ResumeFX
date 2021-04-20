package com.tangorabox.resumefx;

import com.jpro.webapi.WebAPI;
import javafx.application.HostServices;
import javafx.stage.Stage;

import javax.inject.Inject;

public class ApplicationContext {

    private final Stage primaryStage;
    private final HostServices hostServices;

    @Inject
    protected ApplicationContext(Stage primaryStage, HostServices hostServices) {
        this.primaryStage = primaryStage;
        this.hostServices = hostServices;
    }


    public boolean isDesktop() {
        return !WebAPI.isBrowser();
    }

    public boolean isMobile() {
        try {
            return WebAPI.getWebAPI(primaryStage).isMobile();
        } catch (RuntimeException ex) {
            return false;
        }
    }

    public void openUrl(String url) {
        if (url.contains("@")) {
            url = "mailto:" + url;
        }
        if (isDesktop()) {
            hostServices.showDocument(url);
        } else {
            WebAPI.getWebAPI(primaryStage).openURLAsTab(url);
        }
    }
}
