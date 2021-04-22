package com.tangorabox.resumefx.views;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.ApplicationContext;
import com.tangorabox.resumefx.util.Section;
import com.tangorabox.resumefx.views.aboutproject.AboutProjectView;
import com.tangorabox.resumefx.views.components.SectionPaneFactory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLView
public class ResumeView extends BorderPane implements Initializable, View<ResumeViewModel> {

    @FXML
    private VBox rightPane;

    @FXML
    private VBox centerPane;

    @FXML
    private ToggleButton projectInfo;

    @FXML
    private VBox aboutPane;

    @Inject
    private SectionPaneFactory sectionPaneFactory;

    @Inject
    private AboutProjectView aboutProjectView;

    @Inject
    private ApplicationContext context;

    private final ObjectProperty<ResumeViewModel> model = new SimpleObjectProperty<>();

    public ResumeView() {
        super();
    }

    public ResumeViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<ResumeViewModel> modelProperty() {
        return model;
    }

    @Override
    public void setModel(ResumeViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aboutPane.managedProperty().bind(aboutPane.visibleProperty());
        aboutPane.visibleProperty().bind(projectInfo.selectedProperty());
        aboutPane.getChildren().add(aboutProjectView);
        if (context.isMobile()) {
            rightPane.setManaged(false);
            rightPane.setVisible(false);
        }
        projectInfo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (Boolean.TRUE.equals(newValue)) {
                aboutProjectView.play();
            } else {
                aboutProjectView.stop();
            }
        });
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(ResumeViewModel viewModel) {
        if (context.isMobile()) {
            mobileLayout(viewModel);
        } else {
            desktopLayout(viewModel);
        }
    }

    private void mobileLayout(ResumeViewModel viewModel) {
        centerPane.getChildren().setAll(
                sectionPaneFactory.create(Section.BASIC_INFO, viewModel.getBasicInfo()),
                sectionPaneFactory.create(Section.EDUCATION, viewModel.getEducations()),
                sectionPaneFactory.create(Section.WORK, viewModel.getWorks()),
                sectionPaneFactory.create(Section.VOLUNTEER, viewModel.getVolunteers()),
                sectionPaneFactory.create(Section.SKILL, viewModel.getSkills()),
                sectionPaneFactory.create(Section.AWARD, viewModel.getAwards()),
                sectionPaneFactory.create(Section.PUBLICATION, viewModel.getPublications()),
                sectionPaneFactory.create(Section.LANGUAGE, viewModel.getLanguages()),
                sectionPaneFactory.create(Section.INTEREST, viewModel.getInterests()),
                sectionPaneFactory.create(Section.REFERENCE, viewModel.getReferences()),
                aboutPane
        );
        aboutPane.managedProperty().unbind();
        aboutPane.setManaged(true);
    }

    private void desktopLayout(ResumeViewModel viewModel) {
        rightPane.getChildren().setAll(
                sectionPaneFactory.create(Section.BASIC_INFO, viewModel.getBasicInfo()),
                sectionPaneFactory.create(Section.SKILL, viewModel.getSkills()),
                sectionPaneFactory.create(Section.EDUCATION, viewModel.getEducations()),
                sectionPaneFactory.create(Section.LANGUAGE, viewModel.getLanguages()),
                sectionPaneFactory.create(Section.INTEREST, viewModel.getInterests()),
                sectionPaneFactory.create(Section.REFERENCE, viewModel.getReferences())
        );

        centerPane.getChildren().setAll(
                sectionPaneFactory.create(Section.WORK, viewModel.getWorks()),
                sectionPaneFactory.create(Section.VOLUNTEER, viewModel.getVolunteers()),
                sectionPaneFactory.create(Section.AWARD, viewModel.getAwards()),
                sectionPaneFactory.create(Section.PUBLICATION, viewModel.getPublications())
        );
    }
}
