package com.tangorabox.resumefx.views.award;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.View;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLView
public class AwardView extends VBox implements Initializable, View<AwardViewModel> {

    @FXML
    private Label title;

    @FXML
    private Label awarder;

    @FXML
    private Label summary;

    @Inject
    private TextHelper textHelper;

    private final ObjectProperty<AwardViewModel> model = new SimpleObjectProperty<>();

    public AwardViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<AwardViewModel> modelProperty() {
        return model;
    }

    @Override
    public void setModel(AwardViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textHelper.autoHide(title, awarder, summary);
        textHelper.checkHyperlink(summary);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(AwardViewModel viewModel) {
        title.textProperty().bind(viewModel.titleProperty());
        awarder.textProperty().bind(viewModel.awarderProperty());
        summary.textProperty().bind(viewModel.summaryProperty());
    }
}
