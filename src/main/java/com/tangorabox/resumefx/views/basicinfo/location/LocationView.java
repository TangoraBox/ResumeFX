package com.tangorabox.resumefx.views.basicinfo.location;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.TextHelper;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLView
public class LocationView extends HBox implements Initializable {

    @FXML
    private Label address;

    @FXML
    private Label postalCode;

    @FXML
    private Label city;

    @FXML
    private Label region;

    @Inject
    private TextHelper textHelper;

    private final ObjectProperty<LocationViewModel> model = new SimpleObjectProperty<>();

    public LocationViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<LocationViewModel> modelProperty() {
        return model;
    }

    public void setModel(LocationViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textHelper.autoHide(address, postalCode, city, region);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(LocationViewModel viewModel) {
        address.textProperty().bind(viewModel.addressProperty());
        postalCode.textProperty().bind(viewModel.postalCodeProperty());
        city.textProperty().bind(viewModel.cityProperty());
        region.textProperty().bind(viewModel.regionProperty());
    }
}
