package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.util.TextHelper;
import com.tangorabox.resumefx.views.publication.PublicationViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Publication;

import javax.inject.Inject;
import java.time.LocalDate;

public class PublicationConverter implements GenericViewModelConverter<Publication, PublicationViewModel>{

    private final TextHelper textHelper;

    @Inject
    public PublicationConverter(TextHelper textHelper) {
        this.textHelper = textHelper;
    }

    @Override
    public PublicationViewModel createFromDto(Publication dto) {
        PublicationViewModel viewModel = new PublicationViewModel();
        viewModel.setName(dto.getName());
        viewModel.setPublisher(dto.getPublisher());
        viewModel.setEndDate(LocalDate.parse(dto.getReleaseDate()));
        viewModel.setSummary(textHelper.generateLineBreaks(dto.getSummary()));
        viewModel.setWebsite(dto.getWebsite());
        return viewModel;
    }
}
