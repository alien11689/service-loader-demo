package com.github.alien11689.serviceloaderdemo.extensions.uppercased;

import com.github.alien11689.serviceloaderdemo.coreservice.spi.TypeNameHandler;

public class TypeNameAsUpperCasedClassSimpleNameHandler implements TypeNameHandler<TypeNameAsUpperCasedClassSimpleName> {
    @Override
    public Class<TypeNameAsUpperCasedClassSimpleName> getSupportedAnnotation() {
        return TypeNameAsUpperCasedClassSimpleName.class;
    }

    @Override
    public String getTypeName(TypeNameAsUpperCasedClassSimpleName annotation, Class<?> annotatedClass) {
        return annotatedClass.getSimpleName().toUpperCase();
    }
}
