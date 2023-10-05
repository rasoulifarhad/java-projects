package com.farhad.example.documents_contracts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.farhad.example.documents_contracts.constraints.SizeLimit;

public class DocumentTest {

    private static Stream<Arguments> validationMethods() {
        BiFunction<Document, Contract, Stream<ContractViolation>> faultyProceduralIsValidAccordingTo = Document::faultyProceduralIsValidAccordingTo;
        BiFunction<Document, Contract, Stream<ContractViolation>> proceduralIsValidAccordingTo = Document::proceduralIsValidAccordingTo;
        BiFunction<Document, Contract, Stream<ContractViolation>> refactoredProceduralIsValidAccordingTo = Document::refactoredProceduralIsValidAccordingTo;
        BiFunction<Document, Contract, Stream<ContractViolation>> isValidAccordingTo = Document::isValidAccordingTo;
        return Stream.of(
                Arguments.of(Named.of("Faulty procedural", faultyProceduralIsValidAccordingTo)),
                Arguments.of(Named.of("Procedural", proceduralIsValidAccordingTo)),
                Arguments.of(Named.of("Procedural without throwing exception", refactoredProceduralIsValidAccordingTo)),
                Arguments.of(Named.of("Functional", isValidAccordingTo)));
    }

    @ParameterizedTest
    @MethodSource("validationMethods")
    void shouldFulfillContract(BiFunction<Document, Contract, Stream<ContractViolation>> validationMethod) {
        // given
        Contract contract = new Contract(
                Stream.of(
                        new SectionConstraint("Introduction", new SizeLimit(20)),
                        new SectionConstraint("Body", new SizeLimit(500)),
                        new SectionConstraint("Conclusion", new SizeLimit(20)))
                        .collect(Collectors.toSet()));
        Document document = new Document(
                Stream.of(
                        new Section("Introduction", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
                        new Section("Body",
                                "Sollicitudin tempor id eu nisl nunc mi. Ut ornare lectus sit amet est placerat. Viverra maecenas accumsan lacus vel facilisis volutpat est velit egestas."),
                        new Section("Conclusion", "Et magnis dis parturient montes nascetur ridiculus mus mauris. "))
                        .collect(Collectors.toSet()));

        // when
        Stream<ContractViolation> validationResult = validationMethod.apply(document, contract);

        // then
        assertThat(validationResult).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("validationMethods")
    void shouldRejectWhenSectionDoesNotFulfillConstraint(
            BiFunction<Document, Contract, Stream<ContractViolation>> validationMethod) {
        // given
        Contract contract = new Contract(
                Stream.of(
                        new SectionConstraint("Introduction", new SizeLimit(20)),
                        new SectionConstraint("Body", new SizeLimit(10)),
                        new SectionConstraint("Conclusion", new SizeLimit(20)))
                        .collect(Collectors.toSet()));
        Document document = new Document(
                Stream.of(
                        new Section("Introduction", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
                        new Section("Body",
                                "Sollicitudin tempor id eu nisl nunc mi. Ut ornare lectus sit amet est placerat. Viverra maecenas accumsan lacus vel facilisis volutpat est velit egestas."),
                        new Section("Conclusion", "Et magnis dis parturient montes nascetur ridiculus mus mauris. "))
                        .collect(Collectors.toSet()));
        // when
        Stream<ContractViolation> validationResult = validationMethod.apply(document, contract);

        // then
        assertThat(validationResult).map(ContractViolation::id)
                .containsExactlyInAnyOrder("SECTION_CONSTRAINT_VIOLATION");
    }

    @ParameterizedTest
    @MethodSource("validationMethods")
    void shouldRejectWhenMultipleSectionsDoNotFulfillConstraint(
            BiFunction<Document, Contract, Stream<ContractViolation>> validationMethod) {
        // given
        Contract contract = new Contract(
                Stream.of(
                        new SectionConstraint("Introduction", new SizeLimit(4)),
                        new SectionConstraint("Body", new SizeLimit(10)),
                        new SectionConstraint("Conclusion", new SizeLimit(20)))
                        .collect(Collectors.toSet()));
        Document document = new Document(
                Stream.of(
                        new Section("Introduction", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
                        new Section("Body",
                                "Sollicitudin tempor id eu nisl nunc mi. Ut ornare lectus sit amet est placerat. Viverra maecenas accumsan lacus vel facilisis volutpat est velit egestas."),
                        new Section("Conclusion", "Et magnis dis parturient montes nascetur ridiculus mus mauris. "))
                        .collect(Collectors.toSet()));
        // when
        Stream<ContractViolation> validationResult = validationMethod.apply(document, contract);

        // then
        assertThat(validationResult).map(ContractViolation::id)
                .containsExactlyInAnyOrder("SECTION_CONSTRAINT_VIOLATION", "SECTION_CONSTRAINT_VIOLATION");
    }

    @ParameterizedTest
    @MethodSource("validationMethods")
    void shouldRejectWhenSectionRequiredByContractIsMissing(
            BiFunction<Document, Contract, Stream<ContractViolation>> validationMethod) {
        // given
        Contract contract = new Contract(
                Stream.of(
                        new SectionConstraint("Introduction", new SizeLimit(20)),
                        new SectionConstraint("Body", new SizeLimit(100)),
                        new SectionConstraint("Conclusion", new SizeLimit(20)))
                        .collect(Collectors.toSet()));
        Document document = new Document(
                Stream.of(
                        new Section("Introduction", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
                        new Section("Body",
                                "Sollicitudin tempor id eu nisl nunc mi. Ut ornare lectus sit amet est placerat. Viverra maecenas accumsan lacus vel facilisis volutpat est velit egestas."))
                        .collect(Collectors.toSet()));
        // when
        Stream<ContractViolation> validationResult = validationMethod.apply(document, contract);

        // then
        assertThat(validationResult).map(ContractViolation::id).containsExactlyInAnyOrder("SECTION_MISSING");
    }

    @ParameterizedTest
    @MethodSource("validationMethods")
    void shouldRejectWhenSectionRequiredByContractIsMissingAndSectionDoesNotFulfillConstraint(
            BiFunction<Document, Contract, Stream<ContractViolation>> validationMethod) {
        // given
        Contract contract = new Contract(
                Stream.of(
                        new SectionConstraint("Introduction", new SizeLimit(20)),
                        new SectionConstraint("Body", new SizeLimit(10)),
                        new SectionConstraint("Conclusion", new SizeLimit(20)))
                        .collect(Collectors.toSet()));
        Document document = new Document(
                Stream.of(
                        new Section("Introduction", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
                        new Section("Body",
                                "Sollicitudin tempor id eu nisl nunc mi. Ut ornare lectus sit amet est placerat. Viverra maecenas accumsan lacus vel facilisis volutpat est velit egestas."))
                        .collect(Collectors.toSet()));
        // when
        Stream<ContractViolation> validationResult = validationMethod.apply(document, contract);

        // then
        assertThat(validationResult).map(ContractViolation::id)
                .containsExactlyInAnyOrder("SECTION_MISSING", "SECTION_CONSTRAINT_VIOLATION");
    }
}
