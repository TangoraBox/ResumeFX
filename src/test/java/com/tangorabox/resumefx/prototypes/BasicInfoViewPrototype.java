package com.tangorabox.resumefx.prototypes;

import com.tangorabox.resumefx.views.ResumeViewModel;
import com.tangorabox.resumefx.views.basicinfo.BasicInfoView;
import javafx.scene.Parent;

import javax.inject.Inject;

public class BasicInfoViewPrototype extends ResumeApplicationPrototype {

    @Inject
    private BasicInfoView basicInfoView;

    @Override
    protected Parent createComponent(ResumeViewModel resumeViewModel) {
        basicInfoView.setModel(resumeViewModel.getBasicInfo());
        return basicInfoView;
    }
}
