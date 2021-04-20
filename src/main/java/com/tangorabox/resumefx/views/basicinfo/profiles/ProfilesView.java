package com.tangorabox.resumefx.views.basicinfo.profiles;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.Hyperlinks;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLView
public class ProfilesView extends HBox implements Initializable {

    @FXML
    private FontAwesomeIconView network;

    @FXML
    private Hyperlink url;

    @Inject
    private Hyperlinks hyperlinks;

    private final ObjectProperty<ProfilesViewModel> model = new SimpleObjectProperty<>();

    public ProfilesViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<ProfilesViewModel> modelProperty() {
        return model;
    }

    public void setModel(ProfilesViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hyperlinks.install(this.url);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(ProfilesViewModel viewModel) {
        network.glyphNameProperty().bind(viewModel.networkProperty());
        url.textProperty().bind(viewModel.urlProperty());
    }
}
