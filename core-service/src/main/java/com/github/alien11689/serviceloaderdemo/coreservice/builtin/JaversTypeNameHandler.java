package com.github.alien11689.serviceloaderdemo.coreservice.builtin;

import org.javers.core.metamodel.annotation.TypeName;

import com.github.alien11689.serviceloaderdemo.coreservice.spi.TypeNameHandler;

public class JaversTypeNameHandler implements TypeNameHandler<TypeName> {
    @Override
    public Class<TypeName> getSupportedAnnotation() {
        return TypeName.class;
    }

    @Override
    public String getTypeName(TypeName annotation, Class<?> annotatedClass) {
        return annotation.value();
    }
}
