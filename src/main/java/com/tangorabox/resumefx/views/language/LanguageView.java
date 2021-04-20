package com.tangorabox.resumefx.views.language;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.views.View;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLView
public class LanguageView extends HBox implements Initializable, View<LanguageViewModel> {

    @FXML
    private Label language;

    @FXML
    private Label fluency;

    private final ObjectProperty<LanguageViewModel> model = new SimpleObjectProperty<>();

    public LanguageViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<LanguageViewModel> modelProperty() {
        return model;
    }

    @Override
    public void setModel(LanguageViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(LanguageViewModel viewModel) {
        language.textProperty().bind(viewModel.languageProperty());
        fluency.textProperty().bind(viewModel.fluencyProperty());
    }
}
