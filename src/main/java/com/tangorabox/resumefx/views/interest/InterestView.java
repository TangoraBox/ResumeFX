package com.tangorabox.resumefx.views.interest;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.views.View;
import com.tangorabox.resumefx.views.components.Highlight;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@FXMLView
public class InterestView extends VBox implements Initializable, View<InterestViewModel> {

    @FXML
    private Label name;

    @FXML
    private HBox keywords;

    private final ObjectProperty<InterestViewModel> model = new SimpleObjectProperty<>();

    public InterestViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<InterestViewModel> modelProperty() {
        return model;
    }

    public void setModel(InterestViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(InterestViewModel viewModel) {
        name.textProperty().bind(viewModel.nameProperty());

        keywords.getChildren().setAll(viewModel.getKeywords().stream().map(Highlight::new)
                .collect(Collectors.toList()));
    }
}
