package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.basicinfo.profiles.ProfilesViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Profiles;

public class ProfilesConverter implements GenericViewModelConverter<Profiles, ProfilesViewModel> {
    @Override
    public ProfilesViewModel createFromDto(Profiles dto) {
        ProfilesViewModel viewModel = new ProfilesViewModel();
        viewModel.setNetwork(dto.getNetwork().toUpperCase());
        viewModel.setUrl(dto.getUrl());
        viewModel.setUsername(dto.getUsername());
        return viewModel;
    }
}
