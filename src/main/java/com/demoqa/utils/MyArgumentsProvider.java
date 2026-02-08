package com.demoqa.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MyArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                arguments("Lika Star", "lika@gmail.com", "Berlin"),
                arguments("Lika Star1", "lika@gmail.com", "Berlin"),
                arguments("Lika Star2", "lika@gmail.com", "Berlin"));
    }
}
