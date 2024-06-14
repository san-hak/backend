package com.mda.imirror.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Schema(description = "페이징 request")
@Getter
@Setter
public class PageRequest {
    @Schema(description = "현재 페이지", example = "1")
    private int page;
    @Schema(description = "페이지당 결과 개수", example = "20")
    private int size;

    public PageRequest() {}

    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public Pageable getPageable(Sort sort) {
        return org.springframework.data.domain.PageRequest.of(page-1, size, sort);
    }
}
