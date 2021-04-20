package com.tangorabox.resumefx.thirdparty.eaxdev;

import com.tangorabox.resumefx.io.ResumeParser;
import com.tangorabox.resumefx.views.ResumeViewModel;
import io.gitgub.eaxdev.jsonresume.validator.JsonResume;
import io.gitgub.eaxdev.jsonresume.validator.model.Resume;

import javax.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResumeParserEaxdev implements ResumeParser {

    private final ResumeConverter resumeConverter;

    @Inject
    protected ResumeParserEaxdev(ResumeConverter resumeConverter) {
        this.resumeConverter = resumeConverter;
    }

    @Override
    public ResumeViewModel parse(Path jsonResumeFile) {
        try {
            Resume deserializedResumeFromJSon = new JsonResume(Files.readString(jsonResumeFile)).deserialize();
            return resumeConverter.createFromDto(deserializedResumeFromJSon);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
