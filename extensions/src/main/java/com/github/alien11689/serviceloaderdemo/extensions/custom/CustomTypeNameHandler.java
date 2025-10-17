package com.github.alien11689.serviceloaderdemo.extensions.custom;

import com.github.alien11689.serviceloaderdemo.coreservice.spi.TypeNameHandler;

public class CustomTypeNameHandler implements TypeNameHandler<CustomTypeName> {
    @Override
    public Class<CustomTypeName> getSupportedAnnotation() {
        return CustomTypeName.class;
    }

    @Override
    public String getTypeName(CustomTypeName annotation, Class<?> annotatedClass) {
        return annotation.nameOfTheType();
    }
}
