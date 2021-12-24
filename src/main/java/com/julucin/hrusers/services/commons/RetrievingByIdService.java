package com.julucin.hrusers.services.commons;

import java.util.Optional;

public interface RetrievingByIdService<E, I> {

    Optional<E> retrieveBy(I id);

}
