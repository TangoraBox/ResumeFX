package com.tangorabox.resumefx.views.aboutproject;

import com.google.common.io.CharStreams;
import com.tangorabox.reactivedesk.FXMLView;
import com.tangorabox.resumefx.util.TextTypedAnimation;
import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.ResourceBundle;

@FXMLView
public class AboutProjectView extends VBox implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(AboutProjectView.class);

    @FXML
    private TextArea aboutText;

    private Animation textTypedAnimation;

    public AboutProjectView() {
        VBox.setVgrow(this, Priority.ALWAYS);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.textTypedAnimation = new TextTypedAnimation(Duration.seconds(15), loadText(), aboutText);
    }

    private String loadText() {
        try (InputStream inputStream = Objects.requireNonNull(getClass().getResourceAsStream("/AboutProject.txt"))) {
            return CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Error reading AboutProject file", e);
            return "";
        }
    }

    public void play() {
        textTypedAnimation.play();
    }

    public void stop() {
        textTypedAnimation.stop();
    }

}
