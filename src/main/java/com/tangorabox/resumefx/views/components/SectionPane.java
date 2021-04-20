package com.tangorabox.resumefx.views.components;

import com.tangorabox.resumefx.util.Section;
import com.tangorabox.resumefx.views.View;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SectionPane extends VBox {


    private final VBox contentPane = new VBox();

    protected SectionPane(Section section) {
        super();
        getStyleClass().add("section-pane");
        Label textLabel = createTextLabel(section);
        VBox titlePane = new VBox(textLabel);
        titlePane.getStyleClass().add("title-pane");

        contentPane.setFillWidth(true);
        contentPane.setMaxWidth(Double.MAX_VALUE);
        titlePane.setFillWidth(true);
        titlePane.setMaxWidth(Double.MAX_VALUE);
        
        getChildren().setAll(titlePane, contentPane);
    }

    private Label createTextLabel(Section section) {
        Label textLabel = new Label(section.toString());
        textLabel.getStyleClass().add("section-title");
        textLabel.setGraphic(new FontAwesomeIconView(section.getIcon(), "20"));
        return textLabel;
    }

    public void addView(View<?> view) {
        contentPane.getChildren().add((Node) view);
    }
}
