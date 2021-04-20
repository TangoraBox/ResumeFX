package com.tangorabox.resumefx.views.period;

import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.View;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javax.inject.Inject;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@FXMLView
public class PeriodView extends StackPane implements Initializable, View<PeriodViewModel> {

    @FXML
    private Label startDate;

    @FXML
    private Label duration;

    @FXML
    private Label endDate;

    @Inject
    private TextHelper textHelper;

    private final ObjectProperty<PeriodViewModel> model = new SimpleObjectProperty<>();

    public PeriodViewModel getModel() {
        return model.get();
    }

    public ObjectProperty<PeriodViewModel> modelProperty() {
        return model;
    }

    public void setModel(PeriodViewModel model) {
        this.model.set(model);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textHelper.autoHide(startDate, duration, endDate);
        model.addListener((observable, oldValue, newValue) -> bindComponents(newValue));
    }

    private void bindComponents(PeriodViewModel viewModel) {
        startDate.textProperty().bind(Bindings.createStringBinding(
                () -> viewModel.getStartDate() == null ? "" : textHelper.formatDate(viewModel.getStartDate()), viewModel.startDateProperty()));
        endDate.textProperty().bind(Bindings.createStringBinding(
                () -> {
                    if (viewModel.getEndDate().equals(LocalDate.now())) {
                        return "Present";
                    }
                    return textHelper.formatDate(viewModel.getEndDate());
                }, viewModel.endDateProperty()));

        duration.textProperty().bind(viewModel.durationLabelProperty());
    }
}
