package com.github.alien11689.serviceloaderdemo.coreservice;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import com.github.alien11689.serviceloaderdemo.coreservice.spi.TypeAliasHandler;

public class TypeAliasProvider {

    private static Map<Class<? extends Annotation>, TypeAliasHandler> annotationToTypeNameHandler = new HashMap<>();

    static {
        var loader = ServiceLoader.load(TypeAliasHandler.class);
        loader.forEach(typeNameHandler -> annotationToTypeNameHandler.put(typeNameHandler.getSupportedAnnotation(), typeNameHandler));
    }

    public String getTypeName(Object o) {
        var aClass = o.getClass();
        for (Annotation annotation : aClass.getAnnotations()) {
            var typeNameHandler = annotationToTypeNameHandler.get(annotation.annotationType());
            if (typeNameHandler != null) {
                return typeNameHandler.getTypeName(annotation, aClass);
            }
        }
        return aClass.getName();
    }
}
