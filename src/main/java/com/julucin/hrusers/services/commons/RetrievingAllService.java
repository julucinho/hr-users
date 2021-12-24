package com.julucin.hrusers.services.commons;

import org.springframework.data.domain.Page;

public interface RetrievingAllService <E> {

    Page<E> retrieveAllPaginated(Integer pageNumber, Integer pageSize);

}
