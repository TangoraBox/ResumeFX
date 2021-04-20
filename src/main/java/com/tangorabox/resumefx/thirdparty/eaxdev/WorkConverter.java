package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.work.WorkViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Work;

import javax.inject.Inject;

public class WorkConverter implements GenericViewModelConverter<Work, WorkViewModel> {

    private final TextHelper textHelper;

    @Inject
    public WorkConverter(TextHelper textHelper) {
        this.textHelper = textHelper;
    }

    @Override
    public WorkViewModel createFromDto(Work dto) {
        WorkViewModel viewModel = new WorkViewModel();
        viewModel.setCompany(dto.getCompany());
        viewModel.setPosition(dto.getPosition());
        viewModel.setWebsite(dto.getWebsite());
        viewModel.setSummary(textHelper.generateLineBreaks(dto.getSummary()));
        viewModel.setStartDate(dto.getStartDate());
        viewModel.setEndDate(dto.getEndDate());
        viewModel.setHighlights(dto.getHighlights());
        return viewModel;
    }
}
