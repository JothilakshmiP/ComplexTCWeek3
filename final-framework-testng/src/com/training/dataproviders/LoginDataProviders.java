package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-inputs-register")
	public Object [][] getDBRegisterData() {

		List<RegisterBean> list = new ELearningDAO().getRegisters(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegisterBean temp : list){
			Object[]  obj = new Object[14]; 
			obj[0] = temp.getLoginName();
			obj[1] = temp.getFullName();
			obj[2] = temp.getEmail();
			obj[3] = temp.getDOB();
			obj[4] = temp.getGender();
			obj[5] = temp.getAddress();
			obj[6] = temp.getPostalCode();
			obj[7] = temp.getCity();
			obj[8] = temp.getPhNumber();
			obj[9] = temp.getMbNumber();
			obj[10] = temp.getFax();
			obj[11] = temp.getUrl();
			obj[12] = temp.getNewPassword();
			obj[13] = temp.getConfPassword();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs-TC1")
	public Object[][] getExcelData1(){
		String fileName ="C:/Project1 Selenium/Excel Inputs/Complex TCs IP.xlsx";
		String sheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-TC2")
	public Object[][] getExcelData2(){
		String fileName ="C:/Project1 Selenium/Excel Inputs/Complex TCs IP.xlsx";
		String sheetName = "Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-TC4")
	public Object[][] getExcelData3(){
		String fileName ="C:/Project1 Selenium/Excel Inputs/Complex TCs IP.xlsx";
		String sheetName = "Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-TC5")
	public Object[][] getExcelData4(){
		String fileName ="C:/Project1 Selenium/Excel Inputs/Complex TCs IP.xlsx";
		String sheetName = "Sheet4";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Project1 Selenium/Excel Inputs/Complex TCs IP.xlsx", "Sheet1"); 
	}
}
