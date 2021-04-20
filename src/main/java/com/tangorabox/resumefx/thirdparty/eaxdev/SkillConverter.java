package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.GenericViewModelConverter;
import com.tangorabox.resumefx.views.skill.SkillViewModel;
import io.gitgub.eaxdev.jsonresume.validator.model.Skill;

public class SkillConverter implements GenericViewModelConverter<Skill, SkillViewModel> {
    @Override
    public SkillViewModel createFromDto(Skill dto) {
        SkillViewModel viewModel = new SkillViewModel();
        viewModel.setName(dto.getName());
        viewModel.setLevel(Double.parseDouble(dto.getLevel()));
        viewModel.setKeywords(dto.getKeywords());
        return viewModel;
    }
}
