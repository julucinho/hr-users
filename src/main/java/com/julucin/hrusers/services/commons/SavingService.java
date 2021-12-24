package com.julucin.hrusers.services.commons;

public interface SavingService<E> {

    E saveNew(E newEntity);
    void save(E entity);

}
