package com.mda.imirror.dto.mapper;

public interface EntityMapper<D, E> {
     D toDto(final E entity);
     E toEntity(final D dto);
}