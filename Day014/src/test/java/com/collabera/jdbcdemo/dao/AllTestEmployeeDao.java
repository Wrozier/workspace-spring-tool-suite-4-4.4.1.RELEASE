package com.collabera.jdbcdemo.dao;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	EmployeeDaoGetAllTest.class,
	EmployeeDaoGetInsertTest.class,
	EmployeeDaoGetAllTest.class,
	EmployeeDaoDeleteTest.class })

public class AllTestEmployeeDao {

}
