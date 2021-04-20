package com.tangorabox.resumefx.views.publication;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.Hyperlinks;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.View;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLView
public class PublicationView extends VBox implements Initializable, View<PublicationViewModel> {

    @FXML
    private Label publisher;

    @FXML
    private Label name;

    @FXML
    private Hyperlink website;

    @FXML
    private Label summary;

    @Inject
    private TextHelper textHelper;

    @Inject
    private Hyperlinks hyperlinks;

    private final ObjectProperty<PublicationViewModel> model = new SimpleObjectProperty<>();

    public PublicationViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<PublicationViewModel> modelProperty() {
        return model;
    }

    public void setModel(PublicationViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hyperlinks.install(website);
        textHelper.autoHide(publisher, name, website, summary);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(PublicationViewModel viewModel) {
        publisher.textProperty().bind(viewModel.publisherProperty());
        name.textProperty().bind(viewModel.nameProperty());
        website.textProperty().bind(viewModel.websiteProperty());
        summary.textProperty().bind(viewModel.summaryProperty());
    }
}
