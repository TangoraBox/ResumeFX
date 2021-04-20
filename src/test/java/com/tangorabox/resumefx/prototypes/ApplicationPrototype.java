package com.tangorabox.resumefx.prototypes;

import com.google.inject.Module;
import com.tangorabox.componentinspector.fx.FXComponentInspectorHandler;
import com.tangorabox.reactivedesk.ReactiveApplication;
import com.tangorabox.resumefx.ApplicationContext;
import com.tangorabox.resumefx.ResumeFXGuiceModule;
import fr.brouillard.oss.cssfx.CSSFX;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public abstract class ApplicationPrototype extends ReactiveApplication {

    @Inject
    private ApplicationContext context;

    private Stage primaryStage;
    private boolean initCSSMonitor = true;

    public void setInitCSSMonitor(boolean initCSSMonitor) {
        this.initCSSMonitor = initCSSMonitor;
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    @Override
    protected Collection<Module> getApplicationModules(Stage primaryStage) {
        return Collections.singleton(new ResumeFXGuiceModule(this, primaryStage));
    }

    @Override
    public void startReactiveApp(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Parent mainComponent = checkJPro(this.createComponent());
        mainComponent.getStylesheets()
                .add(Objects.requireNonNull(
                        this.getClass().getClassLoader().getResource("css/resumefx.css")).toExternalForm());
        primaryStage.setScene(new Scene(mainComponent));
        primaryStage.show();
        if (this.initCSSMonitor) {
            CSSFX.start(primaryStage);
        }
        FXComponentInspectorHandler.handleAll();
    }

    private Parent checkJPro(Parent component) {
        if (context.isDesktop()) {
            ScrollPane scrollPane = new ScrollPane(component);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setPannable(true);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            return scrollPane;
        }
        return component;
    }

    protected abstract Parent createComponent();
}
