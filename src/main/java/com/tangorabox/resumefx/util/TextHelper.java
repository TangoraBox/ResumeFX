package com.tangorabox.resumefx.util;

import com.google.common.base.Strings;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.control.Labeled;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Singleton
public class TextHelper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM yyyy");

    private final Hyperlinks hyperlinks;

    @Inject
    public TextHelper(Hyperlinks hyperlinks) {
        this.hyperlinks = hyperlinks;
    }

    public String generateLineBreaks(String text) {
        return Strings.nullToEmpty(text).replace("  ", "\n");
    }

    public void checkHyperlink(Labeled... labeled) {
        for (Labeled label : labeled) {
            label.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.startsWith("http")) {
                    label.getStyleClass().add("hyperlink");
                    label.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.LINK));
                    hyperlinks.install(label);
                } else {
                    hyperlinks.remove(label);
                    label.getStyleClass().remove("hyperlink");
                    label.setGraphic(null);
                }
            });
        }
    }

    public void autoHide(Labeled... labeled) {
        for (Labeled label : labeled) {
            label.managedProperty().bind(label.visibleProperty());
            label.visibleProperty().bind(label.textProperty().isNotEmpty());
        }
    }

    public String formatDate(LocalDate date) {
        return FORMATTER.format(date);
    }
}
