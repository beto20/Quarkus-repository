package com.alberto.app.course.util;

import com.alberto.app.course.model.dto.CustomPaginationResponse;
import org.graalvm.nativeimage.c.function.CEntryPoint;

public class PaginationUtil {

    public PaginationUtil() {
    }

    public CustomPaginationResponse buildCustomPagination(Object content, Boolean hasPrevious, Boolean hasNext, Integer totalPages, Long totalElements, Integer numberPage, Integer totalPagesSize, Integer contentSize) {
        var customPaginationResponse = new CustomPaginationResponse();

        customPaginationResponse.setContent(content);
        customPaginationResponse.setTotalElements(totalElements.intValue());
        customPaginationResponse.setTotalPages(totalPages);
        customPaginationResponse.setNumber(numberPage);
        customPaginationResponse.setSize(totalPagesSize);
        validatePageState(hasPrevious, hasNext, customPaginationResponse);
        customPaginationResponse.setNumberOfElements(contentSize);
        customPaginationResponse.setEmpty(contentSize == 0);

        return customPaginationResponse;
    }

    public void validatePageState(Boolean hasPrevious, Boolean hasNext, CustomPaginationResponse customPaginationResponse) {

        if (hasPrevious && hasNext) {
            customPaginationResponse.setFirst(false);
            customPaginationResponse.setLast(false);
        } else if (!hasPrevious && hasNext) {
            customPaginationResponse.setFirst(true);
            customPaginationResponse.setLast(false);
        } else if (hasPrevious) {
            customPaginationResponse.setFirst(false);
            customPaginationResponse.setLast(true);
        } else {
            customPaginationResponse.setFirst(true);
            customPaginationResponse.setLast(true);
        }
    }

}