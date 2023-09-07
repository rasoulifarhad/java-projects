package com.farhad.example.discounter.adapters.rate.repository.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import com.farhad.example.discounter.application.BreakingPointWithRate;
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
		return null;
	}
	
}
