package com.tangorabox.resumefx.util;

import javafx.animation.Transition;
import javafx.scene.control.TextInputControl;
import javafx.util.Duration;

public class TextTypedAnimation extends Transition {
    private final String text;
    private final TextInputControl field;

    public TextTypedAnimation(Duration duration, String text, TextInputControl field) {
        this.text = text;
        this.field = field;
        this.setCycleDuration(duration);
    }

    protected void interpolate(double frac) {
        int length = this.text.length();
        int n = Math.round((float) length * (float) frac);
        this.field.setText(this.text.substring(0, n) + " ■");
    }
}