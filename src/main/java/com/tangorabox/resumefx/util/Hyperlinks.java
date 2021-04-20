package com.tangorabox.resumefx.util;

import com.tangorabox.resumefx.ApplicationContext;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class Hyperlinks implements EventHandler<MouseEvent> {

    private final ApplicationContext context;
    private final Map<Labeled, StringProperty> customNameLinks = new HashMap<>();

    @Inject
    public Hyperlinks(ApplicationContext context) {
        this.context = context;
    }

    public void install(Labeled label) {
        label.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
    }

    public void install(Labeled labelWithCustomName, StringProperty urlLinkProperty) {
        install(labelWithCustomName);
        customNameLinks.put(labelWithCustomName, urlLinkProperty);
    }

    public void remove(Labeled label) {
        label.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
    }

    @Override
    public void handle(MouseEvent event) {
        context.openUrl(getUrl(event));
    }

    private String getUrl(MouseEvent event) {
        Labeled control = (Labeled) event.getSource();
        if (customNameLinks.containsKey(control)) {
            return customNameLinks.get(control).get();
        }
        return control.getText();
    }

}
