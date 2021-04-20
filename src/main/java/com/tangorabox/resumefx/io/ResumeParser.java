package com.tangorabox.resumefx.io;

import com.tangorabox.resumefx.views.ResumeViewModel;

import java.nio.file.Path;

public interface ResumeParser {

    ResumeViewModel parse(Path jsonResumeFile);
}
