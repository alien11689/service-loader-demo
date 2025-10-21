package com.github.alien11689.serviceloaderdemo.coreservice.builtin;

import com.github.alien11689.serviceloaderdemo.coreservice.annotation.TypeAlias;
import com.github.alien11689.serviceloaderdemo.coreservice.spi.TypeAliasHandler;

public class BuiltInTypeAliasHandler implements TypeAliasHandler<TypeAlias> {
    @Override
    public Class<TypeAlias> getSupportedAnnotation() {
        return TypeAlias.class;
    }

    @Override
    public String getTypeName(TypeAlias annotation, Class<?> annotatedClass) {
        return annotation.value();
    }
}
