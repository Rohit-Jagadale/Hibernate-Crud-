package com.hbm.application;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hbm.model.Employee;

public class Test {

	public static void main(String[] args) {
		int empId, ch;
		String empName;
		String empAddress;
		double salary;

		Scanner sc = new Scanner(System.in);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			do {
				System.out.println("**************************************");
				System.out.println("1: Save Employee Details");
				System.out.println("2: Read All Records");
				System.out.println("3: Read Particular Record");
				System.out.println("4: Update Record");
				System.out.println("5: Delete Record");
				System.out.println("6: Start Name with a");
				System.out.println("7: Greater than Salary");
				System.out.println("8: Less than Salary");
				System.out.println("9: Salary in between");
				System.out.println("10: Exit");
				System.out.println("**************************************");

				System.out.println("Enter u r Choice");
				ch = sc.nextInt();
				System.out.println("**************************************");

				switch (ch) {
				case 1:
					Transaction t1 = session.beginTransaction();

					System.out.print("Enter Employee Id : ");
					empId = sc.nextInt();
					System.out.print("Enter Employee Name : ");
					empName = sc.next();
					System.out.print("Enter Address : ");
					empAddress = sc.next();
					System.out.print("Enter Salary : ");
					salary = sc.nextDouble();

					Employee emp = new Employee(empId, empName, empAddress, salary);

					session.save(emp);
					t1.commit();

					System.out.println("**************************************");
					System.out.println("Save Successfully...");
					break;

				case 2:
					Transaction t2 = session.beginTransaction();

					Criteria criteria = session.createCriteria(Employee.class);

					List<Employee> empList = criteria.list();

					for (Employee employee : empList) {
						System.out.println(employee);
					}

					t2.commit();
					break;

				case 3:
					Transaction t3 = session.beginTransaction();

					System.out.print("Enter Employee Id : ");
					empId = sc.nextInt();

					Employee emp2 = (Employee) session.get(Employee.class, empId);
					System.out.println(emp2);

					t3.commit();
					break;

				case 4:
					Transaction t4 = session.beginTransaction();

					System.out.print("Enter Employee Id : ");
					empId = sc.nextInt();
					System.out.print("Enter Employee Name : ");
					empName = sc.next();
					System.out.print("Enter Address : ");
					empAddress = sc.next();
					System.out.print("Enter Salary : ");
					salary = sc.nextDouble();

					Employee emp3 = new Employee(empId, empName, empAddress, salary);
					session.update(emp3);

					System.out.println("**************************************");
					System.out.println("Update Successfully...");

					t4.commit();
					break;

				case 5:
					Transaction t5 = session.beginTransaction();

					System.out.print("Enter Employee Id : ");
					empId = sc.nextInt();
					Employee emp4 = (Employee) session.get(Employee.class, empId);
					session.delete(emp4);

					System.out.println("**************************************");
					System.out.println("Delete Successfully...");
					t5.commit();

					break;

				case 6:
					Transaction t6 = session.beginTransaction();
					Criteria criteria2 = session.createCriteria(Employee.class);

					criteria2.add(Restrictions.ilike("empName", "a%"));

					List<Employee> eList = criteria2.list();

					for (Employee employee : eList) {
						System.out.println(employee);
					}

					t6.commit();
					break;

				case 7:
					Transaction t7 = session.beginTransaction();
					Criteria criteria3 = session.createCriteria(Employee.class);

					criteria3.add(Restrictions.gt("salary", 50000.00)); // greater than

					List<Employee> eList2 = criteria3.list();

					for (Employee employee : eList2) {
						System.out.println(employee);
					}

					t7.commit();
					break;

				case 8:
					Transaction t8 = session.beginTransaction();

					Criteria criteria4 = session.createCriteria(Employee.class);

					criteria4.add(Restrictions.le("salary", 40000.00)); // less than or equal to

					List<Employee> eList3 = criteria4.list();

					for (Employee employee : eList3) {
						System.out.println(employee);
					}

					t8.commit();
					break;

				case 10:
					System.out.println("Thank You");
					System.out.println("**************************************");
					System.exit(0);
					break;

				case 9:
					Transaction t9 = session.beginTransaction();
					
					Criteria criteria5 = session.createCriteria(Employee.class);
					criteria5.add(Restrictions.between("salary", 30000.0, 50000.0));
					
					List<Employee> eList4 = criteria5.list();
					
					for(Employee employee : eList4)
					{
						System.out.println(employee);
					}
					
					t9.commit();
					break;

				default:
					System.out.println("Invalid Choice");
					System.out.println("**************************************");
				}
			} while (ch <= 10);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
