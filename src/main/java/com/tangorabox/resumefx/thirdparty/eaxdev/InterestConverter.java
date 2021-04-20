package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.interest.InterestViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Interest;

public class InterestConverter implements GenericViewModelConverter<Interest, InterestViewModel> {
    @Override
    public InterestViewModel createFromDto(Interest dto) {
        InterestViewModel viewModel = new InterestViewModel();
        viewModel.setName(dto.getName());
        viewModel.setKeywords(dto.getKeywords());
        return viewModel;
    }
}
