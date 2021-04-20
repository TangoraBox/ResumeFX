package com.tangorabox.resumefx.views;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class CompositeView<T> extends HBox implements View<T> {

    private final List<View<T>> views = new ArrayList<>();
    
    public void addView(View<T> view) {
        views.add(view);
        getChildren().add((Node) view);
    }

    @Override
    public void setModel(T viewModel) {
        views.forEach(view -> view.setModel(viewModel));
    }
}
