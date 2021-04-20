package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.basicinfo.location.LocationViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Location;

public class LocationConverter implements GenericViewModelConverter<Location, LocationViewModel> {
    @Override
    public LocationViewModel createFromDto(Location dto) {
        LocationViewModel viewModel = new LocationViewModel();
        viewModel.setAddress(dto.getAddress());
        viewModel.setCity(dto.getCity());
        viewModel.setCountryCode(dto.getCountryCode());
        viewModel.setPostalCode(dto.getPostalCode());
        viewModel.setRegion(dto.getRegion());
        return viewModel;
    }
}
