package com.mailTravel;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mailTravel.dto.Employee;
import com.mailTravel.dto.EmployeeResponse;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiServiceSteps {

	// @Given("^I have api connection$")
	// public void iHaveApiConnection() {
	// //ToDO - Implement Api Steps
	// }
	//
	Random rand = new Random();
	int upperbound = 2500;

	private final static String BASE_URL = "https://dummy.restapiexample.com";

	private final static String LIST_EMPLOYEE = "/api/v1/employees";
	private final static String ADD_EMPLOYEE = "/api/v1/create";
	private final static String UPDATE_EMPLOYEE = "/api/v1/update";
	private final static String DELETE_EMPLOYEE = "/api/v1/delete";

	public List<Employee> newEmployeeList = new LinkedList<Employee>();

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://dummy.restapiexample.com";
	}

	@Test(priority = 0)
	public void listEmployees() throws IOException {

		/*
		 * RequestSpecification request = getRequestSpec(); Response response =
		 * getResponse(request, LIST_EMPLOYEE); String jsonString = response.asString();
		 */
		Response response = given()
				.contentType(ContentType.JSON)
				.when()
				.get("/api/v1/employees")
				.then()
				.extract()
				.response();

		Assert.assertEquals(200, response.statusCode());
		EmployeeResponse empList = getEmployeesList(response.asString());
		System.out.println("Employees Count : " + empList.getData().size());
		empList.getData().forEach(employee -> {
			System.out.println("Employee Name : " + employee.getEmployeeName());
		});
	}

	@Test(priority = 1)
	public void addTwoNewEmployees() throws Exception {
		for (int i = 0; i<2; i++){
			Employee employee = prepareNewEmployee();
            Thread.sleep(60000);
			Response response = given()
					.header("Content-type", "application/json")
					.and()
					.body(employee)
					.when()
					.post("/api/v1/create")
					.then()
					.extract().response();

			Assert.assertEquals(200, response.getStatusCode());
			Assert.assertEquals("success", JsonPath.from(response.asString()).get("status"));
			System.out.println(" data is "  + JsonPath.from(response.asString()).get("data"));
			Employee newEmployeeDetail = getNewEmployee(JsonPath.from(response.asString()).get("data"));
			newEmployeeList.add(newEmployeeDetail);
			System.out.printf("\n Successfully created employees %s ", newEmployeeDetail);
		}
	}

	@Test(priority = 2)
	public void updateSalaryBy10000ForNewlyCreatedEmployee() throws Exception {
		Employee employee = newEmployeeList.get(1);
		System.out.println("****** employee salary "  + employee.getEmployeeSalary() +  employee.getEmployeeName() + "-" + employee.getEmployeeSalary() + "-" + employee.getEmployeeAge());
		employee.setEmployeeSalary(Integer.parseInt(employee.getEmployeeSalary()) + 10000 + "");
		Integer employeeId = employee.getId();
		Thread.sleep(60000);
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(employee)
                .when()
                .put(UPDATE_EMPLOYEE + "/" + employeeId)
                .then()
                .extract().response();
		
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("success", JsonPath.from(response.asString()).get("status"));
		Assert.assertEquals("Successfully! Record has been updated.",
				JsonPath.from(response.asString()).get("message"));
	}

	@Test(priority = 3)
	public void deleteEmployee() throws Exception{
		Employee employee = newEmployeeList.get(0);
		Integer employeeId = employee.getId();
		Thread.sleep(60000);
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(employee)
                .when()
                .delete(DELETE_EMPLOYEE + "/" + employeeId)
                .then()
                .extract().response();
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("success", JsonPath.from(response.asString()).get("status"));
		Assert.assertEquals("Successfully! Record has been deleted", JsonPath.from(response.asString()).get("message"));
	}


	public Response getResponse(RequestSpecification request, String endPoint) {
		return request.get(endPoint);
	}

	public Response postResponse(RequestSpecification request, Object newEmployee, String endPoint) {
		return request.body(newEmployee).post(endPoint);
	}

	public Response putResponse(RequestSpecification request, Object newEmployee, String endPoint) {
		return request.body(newEmployee).put(endPoint);
	}

	public Response deleteResponse(RequestSpecification request, Object newEmployee, String endPoint) {
		return request.body(newEmployee).delete(endPoint);
	}

	public EmployeeResponse getEmployeesList(String response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(response, EmployeeResponse.class);
	}

	public Employee getNewEmployee(HashMap<String, Object> response) throws IOException {
		Employee employee = new Employee();
		employee.setEmployeeName((String) response.get("employee_name"));
		employee.setEmployeeAge((String) response.get("employee_age"));
		employee.setEmployeeSalary((String) response.get("employee_salary"));
		employee.setId((Integer) (response.get("id")));
		return employee;
	}

	public Employee prepareNewEmployee() {
		int int_random = rand.nextInt(upperbound);
		Employee employee = new Employee();
		employee.setEmployeeName("FName" + int_random + " LName");
		employee.setEmployeeSalary(int_random + "");
		employee.setEmployeeAge(int_random + "");
		System.out.println("*****" + employee.getEmployeeName() + "-" + employee.getEmployeeSalary() + "-" + employee.getEmployeeAge());
		return employee;
	}
}
