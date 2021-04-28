package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.work.VolunteerViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Volunteer;

import javax.inject.Inject;

public class VolunteerConverter implements GenericViewModelConverter<Volunteer, VolunteerViewModel> {

    private final TextHelper textHelper;

    @Inject
    public VolunteerConverter(TextHelper textHelper) {
        this.textHelper = textHelper;
    }

    @Override
    public VolunteerViewModel createFromDto(Volunteer dto) {
        VolunteerViewModel viewModel = new VolunteerViewModel();
        viewModel.setOrganization(dto.getOrganization());
        viewModel.setPosition(dto.getPosition());
        viewModel.setSummary(textHelper.generateLineBreaks(dto.getSummary()));
        viewModel.setWebsite(dto.getWebsite());
        viewModel.setHighlights(dto.getHighlights());
        viewModel.setStartDate(dto.getStartDate());
        viewModel.setEndDate(dto.getEndDate());
        return viewModel;
    }
}
