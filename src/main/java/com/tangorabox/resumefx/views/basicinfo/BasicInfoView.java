package com.tangorabox.resumefx.views.basicinfo;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.Hyperlinks;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.View;
import com.tangorabox.resumefx.views.basicinfo.location.LocationView;
import com.tangorabox.resumefx.views.basicinfo.profile.ProfileView;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import javax.inject.Inject;
import javax.inject.Provider;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@FXMLView
public class BasicInfoView extends VBox implements Initializable, View<BasicInfoViewModel> {

    @FXML
    private Hyperlink email;

    @FXML
    private Label name;

    @FXML
    private Label label;

    @FXML
    private Label phone;

    @FXML
    private Hyperlink website;

    @FXML
    private VBox location;

    @FXML
    private VBox profiles;

    @FXML
    private ImageView picture;

    @Inject
    private LocationView locationView;

    @Inject
    private Provider<ProfileView> profileViewProvider;

    @Inject
    private Hyperlinks hyperlinks;

    @Inject
    private TextHelper textHelper;

    private final ObjectProperty<BasicInfoViewModel> model = new SimpleObjectProperty<>();

    public BasicInfoViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<BasicInfoViewModel> modelProperty() {
        return model;
    }

    public void setModel(BasicInfoViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textHelper.autoHide(email, name, label, phone, website);
        hyperlinks.install(email);
        hyperlinks.install(website);
        initRoundPicture();
        location.getChildren().add(locationView);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void initRoundPicture() {
        picture.setClip(new Circle(picture.getFitWidth() / 2, picture.getFitHeight() / 2, picture.getFitWidth() / 2));
    }

    private void bindComponents(BasicInfoViewModel viewModel) {
        name.textProperty().bind(viewModel.nameProperty());
        label.textProperty().bind(viewModel.labelProperty());
        email.textProperty().bind(viewModel.emailProperty());
        phone.textProperty().bind(viewModel.phoneProperty());
        website.textProperty().bind(viewModel.webSiteProperty());
        picture.imageProperty().bind(viewModel.pictureProperty());
        picture.managedProperty().bind(picture.visibleProperty());
        picture.visibleProperty().bind(viewModel.pictureProperty().isNotNull());
        locationView.setModel(viewModel.getLocation());

        profiles.getChildren().setAll(
                viewModel.getProfiles().stream().map(profilesViewModel -> {
                    ProfileView profilesView = profileViewProvider.get();
                    profilesView.setModel(profilesViewModel);
                    return profilesView;
                }).collect(Collectors.toList()));
    }
}
