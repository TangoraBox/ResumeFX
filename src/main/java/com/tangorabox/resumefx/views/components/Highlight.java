package com.tangorabox.resumefx.views.components;

import javafx.scene.control.Label;

public class Highlight extends Label {

    public Highlight(String text) {
        super(text);
        getStyleClass().add("highlight");
    }
}
