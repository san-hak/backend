package com.mda.imirror.dto.mapper;

public interface EntityMapper<D, E> {
    public D toDto(final E entity);

    public E toEntity(final D dto);
}
