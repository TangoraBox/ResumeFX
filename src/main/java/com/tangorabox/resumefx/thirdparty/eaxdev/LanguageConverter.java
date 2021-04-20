package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.language.LanguageViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Language;

public class LanguageConverter implements GenericViewModelConverter<Language, LanguageViewModel> {
    @Override
    public LanguageViewModel createFromDto(Language dto) {
        LanguageViewModel viewModel = new LanguageViewModel();
        viewModel.setLanguage(dto.getLanguage());
        viewModel.setFluency(dto.getFluency());
        return viewModel;
    }
}
