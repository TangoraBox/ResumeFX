package com.tangorabox.resumefx;

import com.google.inject.Module;
import com.tangorabox.reactivedesk.ReactiveApplication;
import com.tangorabox.resumefx.io.ResumeParser;
import com.tangorabox.resumefx.views.ResumeView;
import com.tangorabox.resumefx.views.ResumeViewModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class ResumeFX extends ReactiveApplication {

    @Inject
    private ResumeParser resumeParser;

    @Inject
    private ResumeView resumeView;

    @Inject
    @Named("resume-path")
    private Path resumePath;

    @Inject
    private ApplicationContext context;


    @Override
    protected Collection<Module> getApplicationModules(Stage primaryStage) {
        return Collections.singletonList(new ResumeFXGuiceModule(this, primaryStage));
    }

    @Override
    protected void startReactiveApp(Stage primaryStage) {
        ResumeViewModel resumeViewModel = resumeParser.parse(resumePath);
        resumeView.setModel(resumeViewModel);
        Parent mainComponent = initMainComponent();
        mainComponent.getStylesheets()
                .add(Objects.requireNonNull(
                        this.getClass().getClassLoader().getResource("css/resumefx.css")).toExternalForm());
        primaryStage.setScene(new Scene(mainComponent));
        primaryStage.show();
    }

    private Parent initMainComponent() {
        if (context.isDesktop()) {
            ScrollPane scrollPane = new ScrollPane(resumeView);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setPannable(true);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            return scrollPane;
        }
        return resumeView;
    }
}
