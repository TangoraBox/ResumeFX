package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.google.common.base.Strings;
import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.basicinfo.BasicInfoViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.BasicInfo;
import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class BasicInfoConverter implements GenericViewModelConverter<BasicInfo, BasicInfoViewModel> {


    private static final Logger log = LoggerFactory.getLogger(BasicInfoConverter.class);

    private final LocationConverter locationConverter;
    private final ProfilesConverter profilesConverter;
    private final TextHelper textHelper;

    @Inject
    public BasicInfoConverter(LocationConverter locationConverter, ProfilesConverter profilesConverter, TextHelper textHelper) {
        this.locationConverter = locationConverter;
        this.profilesConverter = profilesConverter;
        this.textHelper = textHelper;
    }


    @Override
    public BasicInfoViewModel createFromDto(BasicInfo dto) {
        BasicInfoViewModel basicInfoViewModel = new BasicInfoViewModel();
        basicInfoViewModel.setName(dto.getName());
        basicInfoViewModel.setEmail(dto.getEmail());
        basicInfoViewModel.setLabel(dto.getLabel());
        basicInfoViewModel.setPhone(dto.getPhone());
        if (!Strings.isNullOrEmpty(dto.getPicture())) {
            loadPicture(dto.getPicture(), basicInfoViewModel);
        }

        basicInfoViewModel.setSummary(textHelper.generateLineBreaks(dto.getSummary()));
        basicInfoViewModel.setWebSite(dto.getWebsite());
        basicInfoViewModel.setLocation(locationConverter.createFromDto(dto.getLocation()));
        basicInfoViewModel.setProfiles(FXCollections.observableArrayList(profilesConverter.createFromDtos(dto.getProfiles())));
        return basicInfoViewModel;
    }

    private void loadPicture(String pictureURL, BasicInfoViewModel basicInfoViewModel) {
        try {
            basicInfoViewModel.setPicture(new Image(pictureURL));
        } catch (Exception ex) {
            log.warn("Picture url not valid '{}'", pictureURL, ex);
        }
    }
}
