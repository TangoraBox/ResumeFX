package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.basicinfo.profile.ProfileViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Profiles;

public class ProfilesConverter implements GenericViewModelConverter<Profiles, ProfileViewModel> {
    @Override
    public ProfileViewModel createFromDto(Profiles dto) {
        ProfileViewModel viewModel = new ProfileViewModel();
        viewModel.setNetwork(dto.getNetwork().toUpperCase());
        viewModel.setUrl(dto.getUrl());
        viewModel.setUsername(dto.getUsername());
        return viewModel;
    }
}
