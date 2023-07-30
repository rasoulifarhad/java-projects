package com.farhad.example.refactoring.refactoringbook.performance;

import lombok.Data;
import lombok.ToString;

@ToString()
@Data
public class Performance {

	private PlayID playID;
	private Integer audience;
}
