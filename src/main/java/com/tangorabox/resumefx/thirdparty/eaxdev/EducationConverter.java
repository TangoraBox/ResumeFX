package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.google.common.base.Strings;
import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.education.EducationViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Education;

public class EducationConverter implements GenericViewModelConverter<Education, EducationViewModel> {
    @Override
    public EducationViewModel createFromDto(Education dto) {
        EducationViewModel viewModel = new EducationViewModel();
        viewModel.setArea(dto.getArea());
        if (!Strings.isNullOrEmpty(dto.getGpa())) {
            viewModel.setGpa(Float.parseFloat(dto.getGpa().replace(',', '.')));
        }
        viewModel.setInstitution(dto.getInstitution());
        viewModel.setStudyType(dto.getStudyType());
        viewModel.setStartDate(dto.getStartDate());
        viewModel.setEndDate(dto.getEndDate());
        viewModel.setCourses(dto.getCourses());
        return viewModel;
    }
}
