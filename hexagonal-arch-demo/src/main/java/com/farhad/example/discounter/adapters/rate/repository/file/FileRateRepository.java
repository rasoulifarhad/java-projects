package com.farhad.example.discounter.adapters.rate.repository.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import com.farhad.example.discounter.application.Amount;
import com.farhad.example.discounter.application.BreakingPointWithRate;
import com.farhad.example.discounter.application.Rate;
import com.farhad.example.discounter.application.ports.RateRepository;

public class FileRateRepository implements RateRepository {

	private final String rateFileName;

	public FileRateRepository(String rateFileName, String... lines) {
		Objects.requireNonNull(rateFileName, "RateFileName must be provided");
		assert !rateFileName.trim().isEmpty() : "RateFileName must be provided";
		this.rateFileName = rateFileName;
		if (lines != null && lines.length > 0) {
			// create 'rateFileName' file , and write lines to it(overwrite if exists)
			System.out.println("Writing to file '" + rateFileName + "'..... ");
			try {
				Files.write(Paths.get(rateFileName), Arrays.asList(lines));
			} catch (IOException e) {
				throw new RuntimeException("An IO error occured ", e);
			}
		}
	}

	@Override
	public ListIterator<BreakingPointWithRate> getDiscountingBreakPointIterator() {
		List<BreakingPointWithRate> rateTable = rateTableFromFile();
		return rateTable.listIterator(rateTable.size());
	}

	private List<BreakingPointWithRate> rateTableFromFile() {
		List<String> fileLines = new ArrayList<>();
		System.out.println("Reading from file '" + rateFileName + "'");
		try {
			fileLines = Files.readAllLines(Paths.get(rateFileName));
		} catch (IOException e) {
			throw new RuntimeException("An IO error occured reading from file '" + rateFileName + "'" , e);
		}
		if (fileLines == null || fileLines.isEmpty()) {
			throw new RuntimeException("'" + rateFileName + "' file must have at least one line");
		}
		List<BreakingPointWithRate> rateTable = new ArrayList<>();
		Amount previousBreakingPoint = null;
		for (String line : fileLines) {
			BreakingPointWithRate breakingPointWithRate = rateTableRowFromFileLine(line);
			if (previousBreakingPoint != null) {
				if (previousBreakingPoint.isGreaterThanOrEqualTo(breakingPointWithRate.getBreakPoint())) {
					throw new RuntimeException("Lines of '" + rateFileName + "' file must be sorted by 'breakingPoint' in ascending order");
				}
			}
			previousBreakingPoint = breakingPointWithRate.getBreakPoint();
			rateTable.add(breakingPointWithRate);
		}
		return rateTable;
	}

	private BreakingPointWithRate rateTableRowFromFileLine(String line) {
		Objects.requireNonNull(line, "Line can not be null");
		assert !line.trim().isEmpty() : "Line can not be empty";
		String [] lineItems = line.split("\\s+");
		if (lineItems.length != 2) {
			throw new RuntimeException("Line must have 2 item");
		}
		Amount breakingPoint = Amount.parse(lineItems[0]);
		Rate rate = Rate.parse(lineItems[1]);
		return new BreakingPointWithRate(breakingPoint, rate);
	}
	
}
