package com.test.automation.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginData {

	public String userName;

	public String password;

	public XSSFWorkbook workbook;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public XSSFSheet sheet;

	public ArrayList<LoginData> getAPIData(String FilePath) {
		ArrayList<LoginData> arrayList = new ArrayList<LoginData>();

		File file = new File(FilePath);

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

		return arrayList;
	}

	public static LoginData buildAPIData(Row row) {
		LoginData ad = new LoginData();

		ad.setUserName(row.getCell(0).toString().trim());
		ad.setPassword(row.getCell(1).toString().trim());
		return ad;
	}

}
