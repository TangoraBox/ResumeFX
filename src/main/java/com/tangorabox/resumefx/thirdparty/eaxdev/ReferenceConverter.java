package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.reference.ReferenceViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Reference;

public class ReferenceConverter implements GenericViewModelConverter<Reference, ReferenceViewModel> {
    @Override
    public ReferenceViewModel createFromDto(Reference dto) {
        ReferenceViewModel viewModel = new ReferenceViewModel();
        viewModel.setName(dto.getName());
        viewModel.setReference(dto.getReference());
        return viewModel;
    }
}
