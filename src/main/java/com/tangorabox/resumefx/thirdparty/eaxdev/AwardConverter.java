package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.award.AwardViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Award;

import java.time.LocalDate;

public class AwardConverter implements GenericViewModelConverter<Award, AwardViewModel> {
    @Override
    public AwardViewModel createFromDto(Award dto) {
        AwardViewModel viewModel = new AwardViewModel();
        viewModel.setAwarder(dto.getAwarder());
        viewModel.setTitle(dto.getTitle());
        viewModel.setEndDate(LocalDate.parse(dto.getDate()));
        viewModel.setSummary(dto.getSummary());
        return viewModel;
    }
}
