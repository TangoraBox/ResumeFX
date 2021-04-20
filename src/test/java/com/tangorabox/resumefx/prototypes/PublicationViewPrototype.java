package com.tangorabox.resumefx.prototypes;

import com.tangorabox.resumefx.util.Section;
import com.tangorabox.resumefx.views.ResumeViewModel;
import com.tangorabox.resumefx.views.components.SectionPaneFactory;
import javafx.scene.Parent;

import javax.inject.Inject;

public class PublicationViewPrototype extends ResumeApplicationPrototype {

    @Inject
    private SectionPaneFactory sectionPaneFactory;

    @Override
    protected Parent createComponent(ResumeViewModel resumeViewModel) {
        return sectionPaneFactory.create(Section.PUBLICATION, resumeViewModel.getPublications());
    }
}
