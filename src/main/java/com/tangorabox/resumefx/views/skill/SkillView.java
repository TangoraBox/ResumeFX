package com.tangorabox.resumefx.views.skill;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.views.View;
import com.tangorabox.resumefx.views.components.Highlight;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@FXMLView
public class SkillView extends VBox implements Initializable, View<SkillViewModel> {


    @FXML
    private ProgressBar progress;

    @FXML
    private Label name;

    @FXML
    private FlowPane keywords;

    private final ObjectProperty<SkillViewModel> model = new SimpleObjectProperty<>();

    public SkillViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<SkillViewModel> modelProperty() {
        return model;
    }

    @Override
    public void setModel(SkillViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(SkillViewModel viewModel) {
        viewModel.levelProperty().addListener((observable, oldValue, newValue) -> animateProgress(newValue.doubleValue()));
        animateProgress(viewModel.getLevel());
        name.textProperty().bind(viewModel.nameProperty());

        keywords.getChildren().setAll(viewModel.getKeywords().stream().map(Highlight::new)
                .collect(Collectors.toList()));
    }

    private void animateProgress(double endValue) {
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(progress.progressProperty(), endValue);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}
