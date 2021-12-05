package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Aman:Employee = new Employee("Aman","a",22,15000,"Intern","Knoldus","aman.a@knoldus.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Aman)) thenReturn(true)
    val result = userImpl.createEmployee(Aman)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Aman)) thenReturn(false)
    val result = userImpl.createEmployee(Aman)
    assert(result.isEmpty)
  }
}