package com.details;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("Welcome to database connection......");
		Scanner scan = new Scanner(System.in);

		//Connecting Java Program To DataBase By Using Hibernate
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Department.class);

		

		//Creating Session Factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//Initialize Session Object
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.save();



		while (true) {
			System.out.println("Select Database");
			System.out.println("1: Employee details in DataBase\n2: Department details in Database");
			System.out.println("=========================================================================================");
			int select = scan.nextInt();

			if (select == 1) {
				
				System.out.println("1: Add Employee to DataBase\n2: View Employee Details\n3: Update Employee Details\n4: Delete Employee Details");
				System.out.println("Enter your Choice  please....");
				int choice = scan.nextInt();

				switch (choice) {
				case 1:
					/*
					 * Adding Employee Details
					 */
					System.out.println("please Enter Employee ID");
					int id =scan.nextInt();
					System.out.println("please Enter Employee Name");
					String name = scan.next();
					
					System.out.println("please Enter Employee Designation");
					String designation = scan.next();
					System.out.println("please Enter Employee Department Number");
					int deptNo= scan.nextInt();
					System.out.println("please Enter Employee Date of Birth");
					String dob= scan.next();
					System.out.println("please Enter Employee Salary");
					double salary = scan.nextDouble();


					//Creating Employee Object
					Employee	emp = new Employee(id, name, dob, designation, deptNo, salary);
					
					//EMimplementation.db.put(id, emp);
					session.save(emp);
					session.getTransaction().commit();
					//session.close();
					System.out.println("Employee Details saved Sucesfully");
					break;
					
					
				case 2:
					/*
					 * Displaying  Employee Details
					 */
					System.out.println("Enter Employee Id");
					int id1 = scan.nextInt();
					Configuration configuration1 = new Configuration();
					configuration1.configure("hibernate.cfg.xml");
					configuration1.addAnnotatedClass(Employee.class);

					//Creating Session Factory
					SessionFactory sessionFactory1 = configuration1.buildSessionFactory();

					//Initialize Session Object
					Session session1 = sessionFactory1.openSession();
					Employee emp1 = session1.get(Employee.class, id1 );
					System.out.println(emp1);
					System.out.println("===============================================================");
					break;
					
					
				case 3:
					/*
					 * Updating Employee Details
					 * 
					 */
					Configuration configuration3 = new Configuration();
					configuration3.configure("hibernate.cfg.xml");
					configuration3.addAnnotatedClass(Employee.class);

					//Creating Session Factory
					SessionFactory sessionFactory3 = configuration3.buildSessionFactory();

					//Initialize Session Object
					Session session3 = sessionFactory3.openSession();
					System.out.println("Enter Employee ID");
					int empId3 = scan.nextInt();
					Employee emp3 = session3.get(Employee.class, empId3);
					System.out.println("1:Update name\n2:Update Designation\n3:Update Department Number\n4: Update Date of Birth\n5:Update Salary ");
					System.out.println("Enter the Choice");
					int choice3 = scan.nextInt();
					if (choice3==1) {
						System.out.println("Enter Name");
						String name3 = scan.next();
						emp3.setEmpName(name3);
						System.out.println("Employee Name Updated Sucesfull");
					}else if (choice3==2) {
						System.out.println("Enter Designation");
						String designation3 = scan.next();
						emp3.setDesignation(designation3);
						System.out.println("Employee Designation Updated Sucesfull");
					}else if (choice3==3) {
						System.out.println("Enter Department Number");
						int deptNo3 = scan.nextInt();
						emp3.setDeptNo(deptNo3);
						System.out.println("Department Number Updated Sucesfull");
					}else if (choice3==4) {
						System.out.println("Enter Date of Birth");
						String dob3 = scan.next();
						emp3.setDob(dob3);
						System.out.println("Date of Birth Updated Sucesfull");
					}else if (choice3==5) {
						System.out.println("Enter Name");
						double salary3 = scan.nextDouble();
						emp3.setSalary(salary3);
						System.out.println("Salary Updated Sucesfull");
					} else {
						System.out.println("Invalid Choice");
					}
					session3.beginTransaction();
					session3.update(emp3);
					session3.getTransaction().commit();
					break;
					
					
				case 4:
					/*
					 * Deleting Employee Details
					 */
					Configuration configuration4 = new Configuration();
					configuration4.configure("hibernate.cfg.xml");
					configuration4.addAnnotatedClass(Employee.class);

					//Creating Session Factory
					SessionFactory sessionFactory4 = configuration4.buildSessionFactory();

					//Initialize Session Object
					Session session4 = sessionFactory4.openSession();
					
					System.out.println("Enter Employee Id whose Data want to DELETE...");
					int id4 = scan.nextInt();
					Employee emp4 = session4.get(Employee.class, id4);
					session.delete(emp4);
					session.beginTransaction();
					session.getTransaction().commit();
					break;

				default:
					System.out.println("Invalid Input");
					break;
				}
				
				/*
				 * 
				 * Department Table Operations
				 * 
				 */
			} else if(select==2){
				
				Configuration configuration6 = new Configuration();
				configuration6.configure("hibernate.cfg.xml");
				configuration6.addAnnotatedClass(Department.class);

				//Creating Session Factory
				SessionFactory sessionFactoryd = configuration6.buildSessionFactory();

				//Initialize Session Object
				Session sessiond = sessionFactoryd.openSession();
				
				//session.save();
				
				System.out.println("1: Add Departmen to DataBase\n2: View\n3: Update\n4: Delete");
				System.out.println("Enter a Choice");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Department Number");
					int deptNo = scan.nextInt();
					System.out.println("Enter Department Name");
					String deptName = scan.next();
					System.out.println("Enter Department purpose");
					String purpose = scan.next();

					sessiond.beginTransaction();
					//Creating Department Object
					Department dept = new Department(deptNo, deptName, purpose);
					
					sessiond.save(dept);
					sessiond.getTransaction().commit();
					System.out.println("Department Details saved Sucesfully");
					break;
				case 2:
					
					/*
					 * Displaying  Employee Details
					 */
					System.out.println("Enter Department Id");
					int id1 = scan.nextInt();
					Configuration configurationd1 = new Configuration();
					configurationd1.configure("hibernate.cfg.xml");
					configurationd1.addAnnotatedClass(Department.class);

					//Creating Session Factory
					SessionFactory sessionFactoryd1 = configurationd1.buildSessionFactory();

					//Initialize Session Object
					Session sessiond1 = sessionFactoryd1.openSession();
					Department dept1 = sessiond1.get(Department.class, id1 );
					System.out.println(dept1);
					System.out.println("===============================================================");
					break;
					
				case 3:
				//	dp.updateDepartmentDetails();
					System.out.println("Enter Department number whose details should update");
					int deptNo3 = scan.nextInt();
					Configuration configurationd3 = new Configuration();
					configurationd3.configure("hibernate.cfg.xml");
					configurationd3.addAnnotatedClass(Department.class);

					//Creating Session Factory
					SessionFactory sessionFactoryd3 = configuration.buildSessionFactory();

					//Initialize Session Object
					Session sessiond3 = sessionFactoryd3.openSession();
					sessiond3.beginTransaction();
					
						System.out.println("1:Update name\n2:Update purposeS ");
						System.out.println("Enter the Choice");
						int choice1 = scan.nextInt();
						Department dep3 = sessiond3.get(Department.class, deptNo3);
						
						if (choice1==1) {
							
							System.out.println("Enter Name");
							String name1 = scan.next();
							dep3.setDeptName(name1);
							System.out.println("Updated Sucesfull");
						}
						else if (choice1==2) {
							System.out.println("Enter purpose");
							String purpose1 = scan.next();
							dep3.setPurpose(purpose1);
							System.out.println("Updated Sucesfull");
						}
						else {
							System.out.println("InValid Input");
						}
						sessiond3.save(dep3);
						sessiond3.getTransaction().commit();
						break;
					
				case 4:
				//	dp.deleteDepartment();
					Configuration configurationd4 = new Configuration();
					configurationd4.configure("hibernate.cfg.xml");
					configurationd4.addAnnotatedClass(Department.class);

					//Creating Session Factory
					SessionFactory sessionFactoryd4 = configurationd4.buildSessionFactory();

					//Initialize Session Object
					Session sessiond4 = sessionFactoryd4.openSession();
					System.out.println("Enter Department Id whose Data want to DELETE...");
					int id4 = scan.nextInt();
					Department dept4 = session.get(Department.class, id4);
					sessiond4.delete(dept4);
					sessiond4.beginTransaction();
					sessiond4.getTransaction().commit();
					break;
					

				default:
					System.out.println("Invalid Input");
					break;
				}

			}else {
				System.out.println("Invalid Input");
			}
			
			//session.close();
			System.out.println("Thank You");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		}
	}

}