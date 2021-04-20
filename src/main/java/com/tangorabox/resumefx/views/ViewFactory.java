package com.tangorabox.resumefx.views;

import com.tangorabox.resumefx.util.Section;
import com.tangorabox.resumefx.views.award.AwardView;
import com.tangorabox.resumefx.views.basicinfo.BasicInfoView;
import com.tangorabox.resumefx.views.education.EducationView;
import com.tangorabox.resumefx.views.interest.InterestView;
import com.tangorabox.resumefx.views.language.LanguageView;
import com.tangorabox.resumefx.views.period.PeriodView;
import com.tangorabox.resumefx.views.publication.PublicationView;
import com.tangorabox.resumefx.views.reference.ReferenceView;
import com.tangorabox.resumefx.views.skill.SkillView;
import com.tangorabox.resumefx.views.work.WorkView;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ViewFactory {

    @Inject
    private Provider<BasicInfoView> basicInfoViewProvider;

    @Inject
    private Provider<WorkView> workViewProvider;

    @Inject
    private Provider<EducationView> educationViewProvider;

    @Inject
    private Provider<AwardView> awardViewProvider;

    @Inject
    private Provider<PublicationView> publicationViewProvider;

    @Inject
    private Provider<SkillView> skillViewProvider;

    @Inject
    private Provider<LanguageView> languageViewProvider;

    @Inject
    private Provider<InterestView> interestViewProvider;

    @Inject
    private Provider<PeriodView> periodViewProvider;

    @Inject
    private Provider<ReferenceView> referenceViewProvider;

    public <T> View<T> create(Section section) {
        View<T> view = createView(section);
        if (!section.hasPeriod()) {
            return view;
        }

        PeriodView periodView = periodViewProvider.get();
        CompositeView<T> compositeView = new CompositeView<>();
        compositeView.addView((View<T>) periodView);
        compositeView.addView(view);
        return compositeView;
    }

    private <T> View<T> createView(Section section) {
        switch (section) {
            case BASIC_INFO:
                return (View<T>) basicInfoViewProvider.get();
            case WORK:
            case VOLUNTEER:
                return (View<T>) workViewProvider.get();
            case EDUCATION:
                return (View<T>) educationViewProvider.get();
            case AWARD:
                return (View<T>) awardViewProvider.get();
            case PUBLICATION:
                return (View<T>) publicationViewProvider.get();
            case SKILL:
                return (View<T>) skillViewProvider.get();
            case LANGUAGE:
                return (View<T>) languageViewProvider.get();
            case INTEREST:
                return (View<T>) interestViewProvider.get();
            case REFERENCE:
                return (View<T>) referenceViewProvider.get();
            default:
                throw new UnsupportedOperationException();
        }
    }


}
