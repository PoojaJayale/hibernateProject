package com.jbk.demo.dao;

import java.io.File;


import java.io.Serializable;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.jbk.demo.domain.Employee;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final String String = null;
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Employee> loadEmployee() {
		System.out.println("getEmployee() in EmployeeDaoImpl...");
		Session session = sessionFactory.openSession();
		System.out.println(session);
		String hql = "from Employee";
		Query query = session.createQuery(hql);
		List<Employee> list = query.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		return list;
	}

    @Override
	public List<Employee> loadEmployeeById(int Id) {
		System.out.println("getEmpById in EmployeeDaoImpl...");
		Session session=sessionFactory.openSession();
		System.out.println(session);
		String hql="from Employee e where e.eid = :empid";
		Query query=session.createQuery(hql);
		query.setParameter("empid", Id);
		List<Employee> list = query.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		return list;
	}
    
    @Override
	public List<Employee> findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Employee where name=:name");
		q.setParameter("name", name);
		List<Employee> employee = q.list();
		return employee;
	}


	@Override
	public String deleteEmpById(int id) {
		System.out.println("deleteEmpId in EmployeeDaoImpl....");
		Session session=sessionFactory.openSession();
		System.out.println(session);
		String hql="delete from Employee e where e.eid= :empid";
		Query query=session.createQuery(hql);
		query.setParameter("empid", id);
		Transaction transaction = session.beginTransaction();
		 int result = query.executeUpdate();
		 System.out.println(result);
		 transaction.commit();
	    return null;
	}


	@Override
	public String addAllFieldOfEmp(Employee e) {
		System.out.println("addAllFieldOfEmp in EmployeeDaoImpl....");
		Session session=sessionFactory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		int result = (int) session.save(e);
		System.out.println(result);
		transaction.commit();
		return null;
	}

	/*public Employee update(Employee e) {
	        // TODO Auto-generated method stub
	        Session session = sessionFactory.openSession();
	        Query query = session.createQuery("update Employee set name=:name where id=:eid");
	        query.setParameter("name","Pooja");
	        query.setParameter("id", 7);
	        // Begin transaction
	        Transaction t = session.beginTransaction();
	        int result = query.executeUpdate();
	        // Commit the transaction and close the session
	        t.commit();
	        System.out.println("No of rows updated: "+result);
	       
	        session.close();
	        return null;
	    }*/
	
	/*public Employee update(Employee e,int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        Employee user =(Employee)session.load(Employee.class, e);
       
        Transaction t = session.beginTransaction();
        session.update(e);
        t.commit();
        
        return null;
}*/
	
	/*public String updateByEmpId(int id,String name) {
		  Session session = sessionFactory.openSession();
		  Transaction t = session.beginTransaction();
		Query query = session
                .createQuery("update Student set name= :name where id= :eid");
        query.setParameter("name", name);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println("Student data Update Status=" + result);
        t.commit();
		return null;
		
	}*/
	
	@Override
	public List<Employee> findStatus(String status) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Employee e WHERE e.status = :status");
		q.setParameter("status", status);
		List<Employee> list = q.list();
		return list;
	}
	
	@Override
	public List<Employee> getActiveEmpList() {
		Session session=sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Employee where status=:active");
		q.setParameter("status", "active");
		List<Employee> employee = q.list();
		return employee;
	}

	@Override
	public List<Employee> paging(int from, int to) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.setFirstResult(from);
		cr.setMaxResults(to);
		List<Employee> list=cr.list();
		return list;
	}

	@Override
	public List<Employee> rowCount() {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.setProjection(Projections.rowCount());
		List list=cr.list();
		list.get(0);
		return list;
	}

	@Override
	public List<Employee> desc() {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.addOrder(Order.desc("eid"));
		List<Employee> list=cr.list();
		return list ;
	}

	@Override
	public List<Employee> lessThan(int id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.add(Restrictions.lt("eid", id));
		List<Employee> list=cr.list();
		return list;
	}

	@Override
	public List<Employee> likeName(String name) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.add(Restrictions.like("name", name + "%"));
		List<Employee> list=cr.list();
		return list;
	}

	@Override
	public List<Employee> betweenQry(int first, int second) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.add(Restrictions.between("eid", first, second));
		List<Employee> list=cr.list();
		return list;
	}

	@Override
	public List<Employee> andOr(int id, String name) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Employee.class);
		Criterion gt = Restrictions.gt("uid", id);
		Criterion like = Restrictions.like("uname", name);
		LogicalExpression orexp = Restrictions.or(gt, like);
		cr.add(orexp);
		List<Employee> list = cr.list();

		return list;
	}

	@Override
	public String generateReport(String format) {
		List<Employee> employees=loadEmployee();
		String destination="E:\\Report";
		
		try {
			File file=ResourceUtils.getFile("classpath:employee.jrxml");
			JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(employees);
			
			
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null ,dataSource);
			
			if(format.equalsIgnoreCase("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint,destination+"\\employee.pdf");
				return "PDF File Generated at "+" " +destination;
				//return destination;
				
			}
			else if(format.equalsIgnoreCase("Html")) {
				JasperExportManager.exportReportToHtmlFile(jasperPrint, destination+"\\employee.html");
				destination="HTML File Generated at "+" "+destination;
				return destination;
			}
			else {
				destination="wrong format";
				return destination;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			destination = "file not found...";
		}
		return destination;
	}

	@Override
	public String generateReport1(String format) {
		String name="Pooja";
		List<Employee> employees=findByName(name);
		String destination="E:\\Report";
		
		try {
			File file=ResourceUtils.getFile("classpath:employee.jrxml");
			JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(employees);
			
			
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null ,dataSource);
			
			if(format.equalsIgnoreCase("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint,destination+"\\employees.pdf");
				return "PDF File Generated at "+" " +destination;
				//return destination;
				
			}
			else if(format.equalsIgnoreCase("Html")) {
				JasperExportManager.exportReportToHtmlFile(jasperPrint, destination+"\\employees.html");
				destination="HTML File Generated at "+" "+destination;
				return destination;
			}
			else {
				destination="wrong format";
				return destination;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			destination = "file not found...";
		}
		return destination;
	}
	
	@Override
	public String generateReport2(String format) {
		String status="active";
		List<Employee> employees=findStatus(status);
		String destination="E:\\Report";
		
		try {
			File file=ResourceUtils.getFile("classpath:Simple_Blue.jrxml");
			JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(employees);
			
			
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null ,dataSource);
			
			if(format.equalsIgnoreCase("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint,destination+"\\emp.pdf");
				return "PDF File Generated at "+" " +destination;
				//return destination;
				
			}
			else if(format.equalsIgnoreCase("Html")) {
				JasperExportManager.exportReportToHtmlFile(jasperPrint, destination+"\\emp.html");
				destination="HTML File Generated at "+" "+destination;
				return destination;
			}
			else {
				destination="wrong format";
				return destination;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			destination = "file not found...";
		}
		return destination;
	}
	
	
	
	
}


	
	
	
	

