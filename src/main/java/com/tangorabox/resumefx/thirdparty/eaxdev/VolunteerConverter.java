package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.work.VolunteerViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Volunteer;

public class VolunteerConverter implements GenericViewModelConverter<Volunteer, VolunteerViewModel> {
    @Override
    public VolunteerViewModel createFromDto(Volunteer dto) {
        VolunteerViewModel viewModel = new VolunteerViewModel();
        viewModel.setOrganization(dto.getOrganization());
        viewModel.setPosition(dto.getPosition());
        viewModel.setSummary(dto.getSummary());
        viewModel.setWebsite(dto.getWebsite());
        viewModel.setHighlights(dto.getHighlights());
        viewModel.setStartDate(dto.getStartDate());
        viewModel.setEndDate(dto.getEndDate());
        return viewModel;
    }
}
