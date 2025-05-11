package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTestDataExcel {
	public static void main(String[] args) {
		Workbook workbook = new XSSFWorkbook();

		// Sheet1: Customer Kullanıcı Bilgileri
		Sheet sheet1 = workbook.createSheet("Sheet1");
		Object[][] userData = {
				{"Kullanıcı Adı", "Şifre",},
				{"customer.oguzhan@gmail.com", "Bsc.0425"},
		};
		populateSheet(sheet1, userData);

		// Sheet2: Admin Kullanıcı Bilgileri
		Sheet sheet2 = workbook.createSheet("Sheet2");
		Object[][] adminData = {
				{"Kullanıcı Adı", "Şifre",},
				{"admin.oguzhan@buysellcycle.com", "Bsc.0425"},
		};
		populateSheet(sheet2, adminData);

		// Sheet3: Gecersiz Kullanıcı Bilgileri
		Sheet sheet3 = workbook.createSheet("Sheet3");
		Object[][] gecersizData = {
				{"Kullanıcı Adı", "Şifre",},
				{"gecersiz@gmail.com", "Bsc.0425"},
		};
		populateSheet(sheet3, gecersizData);













		// Sheet4: Kullanıcı Bilgileri
		Sheet sheet4 = workbook.createSheet("Sheet4");
		Object[][] userDatas = {
				{"User Name", "Password"},
				{"customer.zeynep@gmail.com", "Bsc.0425"}
		};
		populateSheet(sheet4, userDatas);

		// Sheet5: Gecerli Kupon Bilgileri
		Sheet sheet5 = workbook.createSheet("Sheet5");
		Object[][] validCouponCode = {
				{"validCouponCode"},
				{"NEWUSER20"}
		};
		populateSheet(sheet5, validCouponCode);

		// Sheet6: Gecersiz Kupon Bilgileri
		Sheet sheet6 = workbook.createSheet("Sheet6");
		Object[][] invalidCouponCode = {
				{"invalidCouponCode"},
				{"NEWUSER30"}
		};
		populateSheet(sheet6, invalidCouponCode);

		// Sheet7: Gecerli Kart Bilgileri
		Sheet sheet7 = workbook.createSheet("Sheet7");
		Object[][] validCardData = {
				{"cardNumber", "expireDate", "CVV"},
				{"3714 496353 98431", "12 2026", "742"}
		};
		populateSheet(sheet7, validCardData);

		// Sheet8: Gecersiz Kart Bilgileri
		Sheet sheet8 = workbook.createSheet("Sheet8");
		Object[][] invalidCardData = {
				{"cardNumber", "expireDate", "CVV"},
				{"1111 111111 11111", "12 2019", "1"}
		};
		populateSheet(sheet8, invalidCardData);

		// Sheet9: Gecersiz Email
		Sheet sheet9 = workbook.createSheet("Sheet9");
		Object[][] invalidEmail = {
				{"invalidEmail"},
				{"customer.zeynep"}
		};
		populateSheet(sheet9, invalidEmail);
























































		// adminSheet1: Admin Kullanıcı Bilgileri
		Sheet adminSheet1 = workbook.createSheet("adminSheet1");
		Object[][] adminLoginData = {
			{"Kullanıcı Adı", "Şifre",},
			{"admin.gulay@buysellcycle.com", "Bsc.0425"},
		};
		populateSheet(adminSheet1, adminLoginData);

		// adminSheet2: Admin Info Update Basarili Giris Bilgileri
		Sheet adminSheet2 = workbook.createSheet("adminSheet2");
		Object[][] adminBasicInfoData = {
			{"First Name", "Last Name", "Email", "Phone", "Date of Birth"},
			{"Gulay", "Ergul", "admin.gulay@buysellcycle.com", "1234567891011", "04-28-2000"},
		};
		populateSheet(adminSheet2, adminBasicInfoData);

		// adminSheet3: Admin Info Update Basarisiz Dogum Tarihi Guncelleme Bilgileri
		Sheet adminSheet3 = workbook.createSheet("adminSheet3");
		Object[][] adminInvalidDateOfBirth = {
			{"Date of Birth"},
			{"01-01-2010"},
		};
		populateSheet(adminSheet3, adminInvalidDateOfBirth);

		// adminSheet4: Admin Info Update Basarisiz Telefon Guncelleme Bilgileri
		Sheet adminSheet4 = workbook.createSheet("adminSheet4");
		Object[][] adminInvalidPhone = {
			{"Phone"},
			{"1234567891a"},
			{"123"}
		};
		populateSheet(adminSheet4, adminInvalidPhone);
		//adminSheet5: Admin Info Update Basarisiz Email Guncelleme Bilgileri
		Sheet adminSheet5 = workbook.createSheet("adminSheet5");
		Object[][] adminInvalidEmail = {
			{"Email"},
			{"gulay"},
		};
		populateSheet(adminSheet5, adminInvalidEmail);

		//adminSheet6: Admin Yeni Adres Bilgileri
		Sheet adminSheet6 = workbook.createSheet("adminSheet6");
		Object[][] addressInfo = {
				{"Name", "Phone", "Email", "Address", "Country", "State", "City", "Postal Code"},
				{"Gulay Ergul", "12345678910", "admin.gulay@buysellcycle.com", "Abc Str No 10", "United States", "New York", "Airmont", "10901"},
		};
		populateSheet(adminSheet6, addressInfo);

		// Sheet1: Customer Kullanıcı Bilgileri
		Sheet sheetHamza = workbook.createSheet("Sheet1");
		Object[][] hamzaData = {
				{"Kullanıcı Adı", "Şifre",},
				{"customer.hamza@gmail.com", "Bsc.0425"},
		};
		populateSheet(sheet1, userData);

		// Sheet2: Admin Kullanıcı Bilgileri
		Sheet sheetHamza2 = workbook.createSheet("Sheet2");
		Object[][] hamzaAdminData = {
				{"Kullanıcı Adı", "Şifre",},
				{"admin.hamza@buysellcycle.com", "Bsc.0425"},
		};


































































		Sheet Sheet11 = workbook.createSheet("Sheet11");
		Object[][] userCansu = {
				{"Kullanıcı Adı", "Sifre",},
				{"customer.cansu@gmail.com", "Bsc.0425"},
				{"AranacakKelime", "developer"},
				{"OrderNumberInValid", "1234567899"},
				{"OrderNumberValid", "20250413000042"}
		};
		populateSheet(Sheet11, userCansu);




		// Excel dosyasını kaydet
		try (FileOutputStream fos = new FileOutputStream("src/test/resources/TestData.xlsx")) {
			workbook.write(fos);
			System.out.println("Excel dosyası başarıyla oluşturuldu: TestData.xlsx");
		} catch (IOException e) {
			System.err.println("Excel dosyası oluşturulurken hata meydana geldi: " + e.getMessage());
		}
	}

	private static void populateSheet(Sheet sheet, Object[][] data) {
		int rowCount = 0;
		for (Object[] rowData : data) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for (Object field : rowData) {
				Cell cell = row.createCell(columnCount++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}
		}
	}
}
