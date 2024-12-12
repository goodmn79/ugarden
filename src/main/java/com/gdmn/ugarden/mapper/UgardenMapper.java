package com.gdmn.ugarden.mapper;

import java.util.List;

public interface UgardenMapper<D, M> {
    public D mapToDto(M m);

    public M mapFromDTO(D d);

    public List<D> mapToDTO(List<M> list);

    public List<M> mapFromDTO(List<D> list);
}
