package com.tangorabox.resumefx.views.education;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.View;
import com.tangorabox.resumefx.views.components.Highlight;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@FXMLView
public class EducationView extends VBox implements Initializable, View<EducationViewModel> {


    @FXML
    private Label institution;

    @FXML
    private Label area;

    @FXML
    private Label studyType;

    @FXML
    private Label gpa;

    @FXML
    private FlowPane courses;

    @Inject
    private TextHelper textHelper;

    private final ObjectProperty<EducationViewModel> model = new SimpleObjectProperty<>();

    public EducationViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<EducationViewModel> modelProperty() {
        return model;
    }

    @Override
    public void setModel(EducationViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textHelper.autoHide(institution, area, studyType, gpa);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(EducationViewModel viewModel) {
        institution.textProperty().bind(viewModel.institutionProperty());
        area.textProperty().bind(viewModel.areaProperty());
        studyType.textProperty().bind(viewModel.studyTypeProperty());
        gpa.textProperty().bind(viewModel.gpaLabelProperty());

        courses.getChildren().setAll(viewModel.getCourses().stream().map(Highlight::new)
                .collect(Collectors.toList()));
    }
}
