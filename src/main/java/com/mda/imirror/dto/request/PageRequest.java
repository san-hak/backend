package com.mda.imirror.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PageRequest {
    private int page;
    private int size;

    public PageRequest() {
        this.page = 1;
        this.size = 20;
    }

    public Pageable getPageable(Sort sort) {
        return org.springframework.data.domain.PageRequest.of(page-1, size, sort);
    }
}
