package com.tangorabox.resumefx.io;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter pattern (creation) interface between DTOs and Application ViewModels
 *
 * @param <D> the D class type
 * @param <V> the  ViewModel classType
 */
public interface GenericViewModelConverter<D, V> {

    V createFromDto(D dto);
    
    default List<V> createFromDtos(final Collection<D> dtos) {
        if (dtos == null) {
            return Collections.emptyList();
        }
        return dtos.stream()
                .map(this::createFromDto)
                .collect(Collectors.toList());
    }
}