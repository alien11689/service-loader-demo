package com.github.alien11689.serviceloaderdemo.main;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.javers.core.metamodel.annotation.TypeName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.alien11689.serviceloaderdemo.coreservice.TypeNameProvider;
import com.github.alien11689.serviceloaderdemo.extensions.custom.CustomTypeName;
import com.github.alien11689.serviceloaderdemo.extensions.uppercased.TypeNameAsUpperCasedClassSimpleName;

class TypeNameExtensionMappingTest {

    private final TypeNameProvider typeNameProvider = new TypeNameProvider();

    @ParameterizedTest
    @MethodSource("objectToTypeName")
    void should_map_object_to_type_name(Object o, String expectedTypeName) {
        Assertions.assertEquals(expectedTypeName, typeNameProvider.getTypeName(o));
    }

    private static Stream<Arguments> objectToTypeName() {
        return Stream.of(
                arguments(new Object(), "java.lang.Object"),
                arguments(new ClassA(), "class_a"),
                arguments(new ClassWithCustomName(), "Class B with custom name"),
                arguments(new UpperCaseClass(), "UPPERCASECLASS")
        );
    }
}

@TypeName("class_a")
class ClassA {
}

@CustomTypeName(nameOfTheType = "Class B with custom name")
class ClassWithCustomName {
}

@TypeNameAsUpperCasedClassSimpleName
class UpperCaseClass {
}
