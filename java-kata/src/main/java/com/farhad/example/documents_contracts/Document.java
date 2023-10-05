package com.farhad.example.documents_contracts;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.farhad.example.documents_contracts.constraints.Constraint;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Document {

    private Set<Section> sections = new HashSet<>();

    public Set<Section> sections() {
        return sections;
    }

    public Stream<ContractViolation> faultyProceduralIsValidAccordingTo(Contract contract) {
        Set<ContractViolation> violations = new HashSet<>();
        try {
            for (SectionConstraint sectionConstraint : contract.getSectionConstraints()) {
                Tuple2<Section, Constraint> section = findSectionInDocumentBy(sectionConstraint);
                if (filterInvalidSection(section)) {
                    violations.add(sectionConstraintViolation(section));
                }
            }
        } catch (Exception throwable) {
            return Stream.of(missingSectionViolation(contract));
        }
        return violations.stream();
    }

    // procedural version
    public Stream<ContractViolation> proceduralIsValidAccordingTo(Contract contract) {
        Set<ContractViolation> violations = new HashSet<>();

        for (SectionConstraint sectionConstraint : contract.getSectionConstraints()) {
            try {
                Tuple2<Section, Constraint> section = findSectionInDocumentBy(sectionConstraint);
                if (filterInvalidSection(section)) {
                    violations.add(sectionConstraintViolation(section));
                }
            } catch (Exception throwable) {
                violations.add(missingSectionViolation(contract));
            }
        }
        return violations.stream();
    }

    // procedural without throwing exception
    public Stream<ContractViolation> refactoredProceduralIsValidAccordingTo(Contract contract) {
        Set<ContractViolation> violations = new HashSet<>();

        for (SectionConstraint sectionConstraint : contract.getSectionConstraints()) {

            Optional<Tuple2<Section, Constraint>> sectionOpt = findSectionInDocBy(sectionConstraint);

            if (!sectionOpt.isPresent()) {
                violations.add(missingSectionViolation(contract));
            } else {
                Tuple2<Section, Constraint> section = sectionOpt.get();

                if (filterInvalidSection(section)) {
                    violations.add(sectionConstraintViolation(section));
                }
            }
        }
        return violations.stream();
    }

    public Stream<ContractViolation> isValidAccordingTo(Contract contract) {
        return contract.getSectionConstraints()
                .stream()
                .flatMap(
                        constraint -> findSectionInDocument(constraint)
                                .map(this::validateSection)
                                .getOrElseGet(Stream::of));
    }

    private ContractViolation missingSectionViolation(Contract contract) {
        return new ContractViolation("SECTION_MISSING",
                String.format("Provided document %s does not contain section required by contract %s", this, contract));
    }

    private ContractViolation missingSectionViolation(SectionConstraint constraint) {
        return new ContractViolation("SECTION_MISSING",
                String.format("Provided document %s does not contain section required by contract constraint %s", this,
                        constraint));
    }

    private ContractViolation sectionConstraintViolation(Tuple2<Section, Constraint> invalidSectionValidation) {
        return new ContractViolation("SECTION_CONSTRAINT_VIOLATION",
                String.format("Specification %s not valid according to section constraint %s",
                        invalidSectionValidation._1,
                        invalidSectionValidation._2));
    }

    private boolean filterInvalidSection(Tuple2<Section, Constraint> sectionValidation) {
        return !sectionValidation._1.isSpecValid(sectionValidation._2);
    }

    private Stream<ContractViolation> validateSection(Tuple2<Section, Constraint> sectionValidation) {
        return sectionValidation._1.validateSpec(sectionValidation._2);
    }

    private Tuple2<Section, Constraint> findSectionInDocumentBy(SectionConstraint sectionConstraint) {
        return sections().stream()
                .filter(sectionConstraint::matches)
                .map(section -> Tuple.of(section, sectionConstraint.getConstraint()))
                .findAny()
                .orElseThrow(() -> new RuntimeException());
    }

    private Optional<Tuple2<Section, Constraint>> findSectionInDocBy(SectionConstraint sectionConstraint) {
        return sections().stream()
                .filter(sectionConstraint::matches)
                .map(section -> Tuple.of(section, sectionConstraint.getConstraint()))
                .findAny();
    }

    private Either<ContractViolation, Tuple2<Section, Constraint>> findSectionInDocument(
            SectionConstraint sectionConstraint) {
        return sections().stream()
                .filter(sectionConstraint::matches)
                .map(section -> Tuple.of(section, sectionConstraint.getConstraint()))
                .findAny()
                .map(Either::<ContractViolation, Tuple2<Section, Constraint>>right)
                .orElseGet(() -> Either.left(missingSectionViolation(sectionConstraint)));
    }

}
