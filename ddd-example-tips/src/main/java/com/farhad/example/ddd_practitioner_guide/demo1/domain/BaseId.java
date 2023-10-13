package com.farhad.example.ddd_practitioner_guide.demo1.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseId implements Serializable {

	@NotNull
	private final UUID id;

	
}
