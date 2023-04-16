package com.alberto.app.course.util;

import com.alberto.app.course.model.dto.CustomPaginationResponse;

public class PaginationUtil {

    private PaginationUtil() {}

    public static CustomPaginationResponse buildCustomPagination(Object content, boolean hasPrevious, boolean hasNext, int totalPages, long totalElements, int numberPage, int totalPagesSize, int contentSize) {
        var customPaginationResponse = new CustomPaginationResponse();

        customPaginationResponse.setContent(content);
        customPaginationResponse.setTotalElements((int) totalElements);
        customPaginationResponse.setTotalPages(totalPages);
        customPaginationResponse.setNumber(numberPage);
        customPaginationResponse.setSize(totalPagesSize);
        validatePageState(hasPrevious, hasNext, customPaginationResponse);
        customPaginationResponse.setNumberOfElements(contentSize);
        customPaginationResponse.setEmpty(contentSize == 0);

        return customPaginationResponse;
    }

    private static void validatePageState(boolean hasPrevious, boolean hasNext, CustomPaginationResponse customPaginationResponse) {
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
