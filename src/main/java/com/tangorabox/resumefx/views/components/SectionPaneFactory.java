package com.tangorabox.resumefx.views.components;

import com.tangorabox.resumefx.util.Section;
import com.tangorabox.resumefx.views.View;
import com.tangorabox.resumefx.views.ViewFactory;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Singleton
public class SectionPaneFactory {

    @Inject
    private ViewFactory viewFactory;

    public <T> Parent create(Section section, T viewModel) {
        return create(section, Collections.singletonList(viewModel));
    }

    public <T> Parent create(Section section, List<T> viewModels) {
        if (viewModels.isEmpty()) {
            return new HBox();
        }
        SectionPane sectionPane = new SectionPane(section);
        Stream<T> stream = viewModels.stream();
        if (section.hasPeriod()) {
            stream = stream.sorted();
        }
        stream.forEach(viewModel -> {
            View<T> view = viewFactory.create(section);
            view.setModel(viewModel);
            sectionPane.addView(view);
        });
        return sectionPane;
    }
}
