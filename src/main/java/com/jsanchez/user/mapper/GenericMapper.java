package com.jsanchez.user.mapper;

public interface GenericMapper<E, D>{

    E dtoToEntity(D dto);

    D entityToDto(E entity);

}
