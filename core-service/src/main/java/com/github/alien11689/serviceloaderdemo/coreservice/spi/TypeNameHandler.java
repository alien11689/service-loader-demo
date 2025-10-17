package com.github.alien11689.serviceloaderdemo.coreservice.spi;

import java.lang.annotation.Annotation;

public interface TypeNameHandler<T extends Annotation> {
    Class<T> getSupportedAnnotation();

    String getTypeName(T annotation, Class<?> annotatedClass);
}
