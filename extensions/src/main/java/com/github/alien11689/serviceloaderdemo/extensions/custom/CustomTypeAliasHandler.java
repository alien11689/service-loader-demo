package com.github.alien11689.serviceloaderdemo.extensions.custom;

import com.github.alien11689.serviceloaderdemo.coreservice.spi.TypeAliasHandler;

public class CustomTypeAliasHandler implements TypeAliasHandler<CustomTypeAlias> {
    @Override
    public Class<CustomTypeAlias> getSupportedAnnotation() {
        return CustomTypeAlias.class;
    }

    @Override
    public String getTypeName(CustomTypeAlias annotation, Class<?> annotatedClass) {
        return annotation.nameOfTheType();
    }
}
