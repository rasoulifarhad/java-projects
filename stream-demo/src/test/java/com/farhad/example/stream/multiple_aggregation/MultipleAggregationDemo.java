package com.farhad.example.stream.multiple_aggregation;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MultipleAggregationDemo {
	
	@Data
	@AllArgsConstructor
	static class Row {
		private String sku;
		private double colA;
		private double colB;
		private double colC;
	}

	static class FakeRowsData {

		public static List<Row> rows() {
			List<Row> rows = new ArrayList<>();

			rows.add( new Row("ar5sg5h", 4, 3, 4) );
			rows.add( new Row("sd6ad6d", 2, 5, 3) );
			rows.add( new Row("ar5sg5h", 6, 5, 6) );
			rows.add( new Row("sd6ad6d", 5, 6, 3) );
			rows.add( new Row("sd6ad6d", 3, 7, 3) );

			return rows;
		}
	}

	public static void main(String[] args) {
		
		Collection<List<Row>> collectionOfListRow = FakeRowsData.rows().stream()
														.collect(groupingBy(Row::getSku))
														.values();

		Stream<List<Row>> listRowStream = collectionOfListRow.stream();
		List<Row> result = listRowStream
								.map(rs -> new Row(
									rs.get(0).getSku(),
									rs.stream().mapToDouble(Row::getColA).sum(),
									rs.stream().mapToDouble(Row::getColB).sum(),
									rs.stream().mapToDouble(Row::getColC).sum()
								))
								.collect(toList());
		System.out.println(result);

	}
}
