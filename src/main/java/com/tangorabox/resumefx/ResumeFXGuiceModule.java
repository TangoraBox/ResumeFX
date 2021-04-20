package com.tangorabox.resumefx;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.tangorabox.resumefx.io.ResumeParser;
import com.tangorabox.resumefx.thirdparty.eaxdev.ResumeParserEaxdev;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

import javax.inject.Named;
import javax.inject.Singleton;
import java.nio.file.Path;

public class ResumeFXGuiceModule extends AbstractModule {

    private final Application application;
    private final Stage primaryStage;

    public ResumeFXGuiceModule(Application application, Stage primaryStage) {
        this.application = application;
        this.primaryStage = primaryStage;
    }

    @Override
    protected void configure() {
        bind(ResumeParser.class).to(ResumeParserEaxdev.class);
    }

    @Provides
    @Named("resume-path")
    Path provideResumeJSonPath() {
        return Path.of("data/resume.json");
    }

    @Provides
    @Singleton
    HostServices provideHostService() {
        return application.getHostServices();
    }

    @Provides
    @Singleton
    Application.Parameters provideApplicationParameters() {
        return application.getParameters();
    }

    @Provides
    @Singleton
    Stage providePrimaryStage() {
        return primaryStage;
    }
}
