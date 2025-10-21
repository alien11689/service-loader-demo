package com.github.alien11689.serviceloaderdemo.main;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.alien11689.serviceloaderdemo.coreservice.TypeAliasProvider;
import com.github.alien11689.serviceloaderdemo.coreservice.annotation.TypeAlias;
import com.github.alien11689.serviceloaderdemo.extensions.custom.CustomTypeAlias;
import com.github.alien11689.serviceloaderdemo.extensions.uppercased.UpperCasedClassSimpleNameTypeAlias;

class TypeAliasExtensionMappingTest {

    private final TypeAliasProvider typeAliasProvider = new TypeAliasProvider();

    @ParameterizedTest
    @MethodSource("objectToTypeName")
    void should_map_object_to_type_name(Object o, String expectedTypeName) {
        Assertions.assertEquals(expectedTypeName, typeAliasProvider.getTypeName(o));
    }

    private static Stream<Arguments> objectToTypeName() {
        return Stream.of(
                arguments(new Object(), "java.lang.Object"),
                arguments(new ClassWithDefaultTypeAlias(), "class_a"),
                arguments(new ClassWithCustomTypeAlias(), "Class B with custom alias"),
                arguments(new UpperCaseClass(), "UPPERCASECLASS")
        );
    }
}

@TypeAlias("class_a")
class ClassWithDefaultTypeAlias {
}

@CustomTypeAlias(nameOfTheType = "Class B with custom alias")
class ClassWithCustomTypeAlias {
}

@UpperCasedClassSimpleNameTypeAlias
class UpperCaseClass {
}
