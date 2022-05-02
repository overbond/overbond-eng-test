package com.overbond.test.kh.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.overbond.test.kh.model.IData;
import com.overbond.test.kh.model.IRow;
import com.overbond.test.kh.model.concrete.DataFactory;
import com.overbond.test.kh.model.concrete.NullData;
import com.overbond.test.kh.model.concrete.Row;
import com.overbond.test.kh.parser.IParser;
import com.overbond.test.kh.parser.IntegerParserFactory;
import com.overbond.test.kh.parser.ParserType;

@Service
public class AmountOutstandingService {

	Logger logger = LoggerFactory.getLogger(AmountOutstandingService.class);
	
	private List<IRow<Integer, ?>> parsedRows = new ArrayList<>();

	@PostConstruct
	public void init() {
		IParser<Integer, String[]> praser = IntegerParserFactory.getParser(ParserType.CSV);
		try (InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("data.csv");
				CSVReader reader = new CSVReader(new InputStreamReader(ioStream));) {
			reader.forEach(x -> {
				IRow<Integer, ?> row = praser.praseData(x);
				parsedRows.add(row);
			});
		} catch (IOException e) {
			logger.error("Error while parsing data", e);
		}
	}

	public String calculate() {
		StringBuilder sb = new StringBuilder();
		Map<IData<?>, List<IRow<String, IData<?>>>> groupedRows = parsedRows.parallelStream().map(x -> mappedRow(x))
				.filter(mappedRow -> !mappedRow.getDataForKey("Maturity").getClass().equals(NullData.class))
				.collect(Collectors.groupingBy(filteredRow -> filteredRow.getDataForKey("Maturity"),
						Collectors.toList()));

		sb.append("Maturity Year, AmountOutstanding\n");
		for (Entry<IData<?>, List<IRow<String, IData<?>>>> groupedRow : groupedRows.entrySet()) {
			IData<?> key = groupedRow.getKey();
			List<IRow<String, IData<?>>> val = groupedRow.getValue();

			Long sum = Long.valueOf(0);
			for (IRow<String, IData<?>> row : val) {
				sum += (Long) row.getDataForKey("AmountOutStanding").getData();
			}

			sb.append(key.getDataAsString() + ", " + sum + "\n");
		}
		return sb.toString();
	}

	private IRow<String, IData<?>> mappedRow(IRow<Integer, ?> row) {
		IRow<String, IData<?>> result = new Row();
		for (IData<?> data : row.getData().values()) {
			String isin = getIsin(data);
			String amountOutstanding = getAmountOutstanding(data);
			String maturity = getMaturity(data);

			if (Objects.nonNull(isin)) {
				result.addData("ISIN", DataFactory.createData(isin));
			} else if (Objects.nonNull(amountOutstanding)) {
				result.addData("AmountOutStanding", DataFactory.createData(amountOutstanding));
			} else if (Objects.nonNull(maturity)) {
				result.addData("Maturity", DataFactory.createData(maturity));
			}
		}
		return result;
	}

	private String getMaturity(IData<?> data) {
		if (Objects.nonNull(data)) {
			String dataAsString = data.getDataAsString();
			if (Objects.nonNull(data.getDataAsString()) && dataAsString.startsWith("DMa")) {
				return dataAsString.substring(3, 7);
			}
		}
		return null;
	}

	private String getAmountOutstanding(IData<?> data) {
		if (Objects.nonNull(data)) {
			String dataAsString = data.getDataAsString();
			if (Objects.nonNull(data.getDataAsString()) && dataAsString.startsWith("AOs")) {
				return dataAsString.substring(3);
			}
		}
		return null;
	}

	private String getIsin(IData<?> data) {
		if (Objects.nonNull(data)) {
			String dataAsString = data.getDataAsString();
			if (Objects.nonNull(data.getDataAsString()) && dataAsString.startsWith("ISn")) {
				return dataAsString.substring(3);
			}
		}
		return null;
	}
}
