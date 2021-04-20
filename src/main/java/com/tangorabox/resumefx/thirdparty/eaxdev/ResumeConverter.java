package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.ResumeViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Resume;

import javax.inject.Inject;

public class ResumeConverter implements GenericViewModelConverter<Resume, ResumeViewModel> {

    @Inject
    private AwardConverter awardConverter;
    @Inject
    private BasicInfoConverter basicInfoConverter;
    @Inject
    private EducationConverter educationConverter;
    @Inject
    private InterestConverter interestConverter;
    @Inject
    private LanguageConverter languageConverter;
    @Inject
    private PublicationConverter publicationConverter;
    @Inject
    private ReferenceConverter referenceConverter;
    @Inject
    private SkillConverter skillConverter;
    @Inject
    private VolunteerConverter volunteerConverter;
    @Inject
    private WorkConverter workConverter;

    protected ResumeConverter() {
        super();
    }

    @Override
    public ResumeViewModel createFromDto(Resume dto) {
        ResumeViewModel resumeViewModel = new ResumeViewModel();
        resumeViewModel.getAwards().setAll(awardConverter.createFromDtos(dto.getAwards()));
        resumeViewModel.setBasicInfo(basicInfoConverter.createFromDto(dto.getBasicInfo()));
        resumeViewModel.getEducations().setAll(educationConverter.createFromDtos(dto.getEducations()));
        resumeViewModel.getInterests().setAll(interestConverter.createFromDtos(dto.getInterests()));
        resumeViewModel.getLanguages().setAll(languageConverter.createFromDtos(dto.getLanguages()));
        resumeViewModel.getPublications().setAll(publicationConverter.createFromDtos(dto.getPublications()));
        resumeViewModel.getReferences().setAll(referenceConverter.createFromDtos(dto.getReferences()));
        resumeViewModel.getSkills().setAll(skillConverter.createFromDtos(dto.getSkills()));
        resumeViewModel.getVolunteers().setAll(volunteerConverter.createFromDtos(dto.getVolunteers()));
        resumeViewModel.getWorks().setAll(workConverter.createFromDtos(dto.getWorks()));

        return resumeViewModel;
    }
}
