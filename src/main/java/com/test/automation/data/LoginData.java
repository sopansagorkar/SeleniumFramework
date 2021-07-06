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
public class LoginData {

	@NonNull
	private String userName;
	@NonNull
	private String password;

	public static XSSFWorkbook workbook;

	public static XSSFSheet sheet;

	private static LoginData ad = new LoginData();

	private LoginData() {

	}

	public LoginData(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public static LoginData[][] getLoginData(String filePath) {
		ArrayList<LoginData> arrayList = new ArrayList<LoginData>();
		LoginData[][] tabArray = null;
		File file = new File(filePath);

		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}
		sheet = workbook.getSheet("login");
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			if (row.getRowNum() == 0)
				continue;

			arrayList.add(LoginData.buildAPIData(row));

		}
		tabArray = new LoginData[arrayList.size()][1];
		for (int i = 0; i < arrayList.size(); i++) {

			LoginData data = (LoginData) arrayList.get(i);
			tabArray[i][0] = data;
		}
		return tabArray;
	}

	public static LoginData buildAPIData(Row row) {
		ad.setUserName(row.getCell(0).toString().trim());
		ad.setPassword(row.getCell(1).toString().trim());
		return ad;
	}

}
