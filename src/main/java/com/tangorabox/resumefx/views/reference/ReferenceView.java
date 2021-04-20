package com.tangorabox.resumefx.views.reference;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.views.View;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLView
public class ReferenceView extends VBox implements Initializable, View<ReferenceViewModel> {

    @FXML
    private Label name;

    @FXML
    private Label reference;

    private final ObjectProperty<ReferenceViewModel> model = new SimpleObjectProperty<>();

    public ReferenceViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<ReferenceViewModel> modelProperty() {
        return model;
    }

    @Override
    public void setModel(ReferenceViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HBox.setHgrow(this, Priority.ALWAYS);
        model.addListener((observableValue, oldModel, newModel) -> bindComponents(newModel));
    }

    private void bindComponents(ReferenceViewModel viewModel) {
        reference.textProperty().bind(viewModel.referenceProperty());
        name.textProperty().bind(Bindings.createStringBinding(() -> "- " + viewModel.getName(), viewModel.nameProperty()));
    }
}
