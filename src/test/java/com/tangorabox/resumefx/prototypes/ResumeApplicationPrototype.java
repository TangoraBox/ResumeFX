package com.tangorabox.resumefx.prototypes;

import com.tangorabox.resumefx.io.ResumeParser;
import com.tangorabox.resumefx.views.ResumeViewModel;
import javafx.scene.Parent;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.file.Path;

public abstract class ResumeApplicationPrototype extends ApplicationPrototype {

    @Inject
    private ResumeParser resumeParser;

    @Inject
    @Named("resume-path")
    private Path resumePath;

    @Override
    protected Parent createComponent() {
        ResumeViewModel resumeViewModel = resumeParser.parse(resumePath);
        return createComponent(resumeViewModel);
    }


    protected abstract Parent createComponent(ResumeViewModel resumeViewModel);
}
