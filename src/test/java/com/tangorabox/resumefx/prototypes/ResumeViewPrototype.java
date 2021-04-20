package com.tangorabox.resumefx.prototypes;

import com.tangorabox.resumefx.views.ResumeView;
import com.tangorabox.resumefx.views.ResumeViewModel;
import javafx.scene.Parent;

import javax.inject.Inject;

public class ResumeViewPrototype extends ResumeApplicationPrototype {

    @Inject
    private ResumeView resumeView;

    @Override
    protected Parent createComponent(ResumeViewModel resumeViewModel) {
        resumeView.setModel(resumeViewModel);
        return resumeView;
    }
}
