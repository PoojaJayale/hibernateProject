package com.jbk.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jbk.demo.dao.EmployeeDao;
import com.jbk.demo.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> loadEmployee() {
		System.out.println("getEmployee() in EmployeeServiceImpl...");
		return employeeDao.loadEmployee();
	}

	@Override
	public List<Employee> loadEmployeeById(int Id) {
		System.out.println("getEmpId() in EmployeeServiceImpl...  ");
		return employeeDao.loadEmployeeById(Id);
	}
	
	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeeDao.findByName(name);
	}
	
	@Override
	public String deleteEmpById(int empId) {
		System.out.println("deleteEmpId in EmployeeServiceImpl...");
		return employeeDao.deleteEmpById(empId);
	}

	@Override
	public String addAllFieldOfEmp(Employee e) {
		System.out.println("addAllFieldOfEmp in EmployeeServiceImpl....");
		return employeeDao.addAllFieldOfEmp(e);
	}
	
	/* @Override
	 public Employee update(Employee e,int id) {
	        // TODO Auto-generated method stub
	        return employeeDao.update(e,id);
	    }*/

	/*@Override
	public String updateByEmpId( int id,String name) {		
		System.out.println("updateEmployee in EmployeeServiceImpl.....");
		return employeeDao.updateByEmpId(id,name);
	}*/
	
	@Override
	public List<Employee> findStatus(String status) {
		// TODO Auto-generated method stub
		return employeeDao.findStatus(status);
	}

	@Override
	public List<Employee> paging(int from, int to) {
	return employeeDao.paging(from,to);
	}

	@Override
	public List<Employee> rowCount() {
		// TODO Auto-generated method stub
		return employeeDao.rowCount();
	}

	@Override
	public List<Employee> desc() {
		// TODO Auto-generated method stub
		return employeeDao.desc();
	}

	@Override
	public List<Employee> lessThan(int id) {
		return employeeDao.lessThan(id);
	}

	@Override
	public List<Employee> likeName(String name) {
		return employeeDao.likeName(name);
	}

	@Override
	public List<Employee> betweenQry(int first, int second) {
		return employeeDao.betweenQry(first,second);
	}

	@Override
	public List<Employee> andOr(int id, String name) {
		return employeeDao.andOr(id,name);
	}

	@Override
	public String generateReport(String format) {
		return employeeDao.generateReport(format);
	}

	@Override
	public String generateReport1(String format) {
		// TODO Auto-generated method stub
		return employeeDao.generateReport1(format);
	}

	@Override
	public List<Employee> getActiveEmpList() {
		// TODO Auto-generated method stub
		return employeeDao.getActiveEmpList();
	}

	@Override
	public String generateReport2(String format) {
		
		return employeeDao.generateReport2(format);
	}


	@Override
	public String read_excel() throws EncryptedDocumentException, InvalidFormatException, IOException  {
		
		Workbook workbook = WorkbookFactory.create(new File("E:\\employee.xls"));
		
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }
        
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();
        
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
        workbook.close();
       
    
        return null;
	}

	/*@Override
	public String write_excel() {
		
		return null;
	}*/
}
	



