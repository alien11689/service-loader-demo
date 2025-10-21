package com.github.alien11689.serviceloaderdemo.extensions.uppercased;

import com.github.alien11689.serviceloaderdemo.coreservice.spi.TypeAliasHandler;

public class UpperCasedClassSimpleNameTypeAliasHandler implements TypeAliasHandler<UpperCasedClassSimpleNameTypeAlias> {
    @Override
    public Class<UpperCasedClassSimpleNameTypeAlias> getSupportedAnnotation() {
        return UpperCasedClassSimpleNameTypeAlias.class;
    }

    @Override
    public String getTypeName(UpperCasedClassSimpleNameTypeAlias annotation, Class<?> annotatedClass) {
        return annotatedClass.getSimpleName().toUpperCase();
    }
}
