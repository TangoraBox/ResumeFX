package com.tangorabox.resumefx.views.work;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.Hyperlinks;
import com.tangorabox.resumefx.views.View;
import com.tangorabox.resumefx.views.components.Highlight;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@FXMLView
public class WorkView extends VBox implements Initializable, View<WorkViewModel> {

    @FXML
    private Label position;

    @FXML
    private Hyperlink company;

    @FXML
    private Label summary;

    @FXML
    private FlowPane highlights;

    @Inject
    private Hyperlinks hyperlinks;

    private final ObjectProperty<WorkViewModel> model = new SimpleObjectProperty<>();

    public WorkViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<WorkViewModel> modelProperty() {
        return model;
    }

    @Override
    public void setModel(WorkViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HBox.setHgrow(this, Priority.ALWAYS);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(WorkViewModel viewModel) {
        position.textProperty().bind(viewModel.positionProperty().concat(","));
        company.textProperty().bind(viewModel.companyProperty());
        hyperlinks.install(company, viewModel.websiteProperty());
        summary.textProperty().bind(viewModel.summaryProperty());

        highlights.getChildren().setAll(viewModel.getHighlights().stream().map(Highlight::new)
                .collect(Collectors.toList()));
    }
}
