package com.test.automation.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class HomeData {

	@NonNull
	private String destination;
	@NonNull
	private String checkIn;
	@NonNull
	private String checkOut;
	@NonNull
	private String adult;
	@NonNull
	private String child;

	public static XSSFSheet sheet;
	public static XSSFWorkbook workbook;
	private static HomeData ad = new HomeData();

	private HomeData() {
	}

	public HomeData(String destination, String checkIn, String checkOut, String adult, String child) {
		super();
		this.destination = destination;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adult = adult;
		this.child = child;
	}

	public static HomeData[][] getHomeData(String filePath) {
		ArrayList<HomeData> arrayList = new ArrayList<HomeData>();
		HomeData[][] tabArray = null;
		File file = new File(filePath);

		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}
		sheet = workbook.getSheet("SearchHotel");
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			if (row.getRowNum() == 0)
				continue;

			arrayList.add(HomeData.buildAPIData(row));

		}
		tabArray = new HomeData[arrayList.size()][1];
		for (int i = 0; i < arrayList.size(); i++) {

			HomeData data = (HomeData) arrayList.get(i);
			tabArray[i][0] = data;
		}
		return tabArray;
	}

	public static HomeData buildAPIData(Row row) {
		ad.setDestination(row.getCell(0) != null ? row.getCell(0).toString().trim() : "");
		ad.setCheckIn(row.getCell(1) != null ? row.getCell(1).toString().trim() : "");
		ad.setCheckOut(row.getCell(2) != null ? row.getCell(2).toString().trim() : "");
		ad.setAdult(row.getCell(3) != null ? row.getCell(3).toString().trim() : "");
		ad.setChild(row.getCell(4) != null ? row.getCell(4).toString().trim() : "");
		return ad;
	}

}
