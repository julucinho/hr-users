package com.julucin.hrusers.mappers;

import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
class Mapper {

    public static MapperAux map(Object source){
        return new MapperAux(source);
    }

    @AllArgsConstructor
    static class MapperAux{

        Object source;

        <T> T to(Class<T> targetClass){
            return new ModelMapper().map(this.source, targetClass);
        }

    }

}
