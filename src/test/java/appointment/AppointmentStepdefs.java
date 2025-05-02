package appointment;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentStepdefs {
    private AppointmentManager appointmentManager;
    private String patientType;
    private String insuranceStatus;
    private String doctorName;
    private String department;
    private LocalDateTime availableUntil;
    private LocalDateTime appointmentTime;
    private String actualResult;

    @Before
    public void setup() {
        appointmentManager = new AppointmentManager();
    }

    @Given("a patient of type {string} with insurance status {string} requesting an appointment with doctor {string} in department {string} whose available until {string}")
    public void aPatientRequestingAppointment(String patientType, String insuranceStatus, String doctorName, String department, String availableUntil) {
        this.patientType = patientType;
        this.insuranceStatus = insuranceStatus;
        this.doctorName = doctorName;
        this.department = department;
        this.availableUntil = LocalDateTime.parse(availableUntil + "T23:59:59");
    }

    @When("the patient requests an appointment at {string}")
    public void thePatientRequestsAnAppointmentAt(String appointmentTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.appointmentTime = LocalDateTime.parse(appointmentTimeStr, formatter);
        actualResult = appointmentManager.bookAppointment(patientType, insuranceStatus, availableUntil, appointmentTime);
    }

    @Then("the appointment status should be {string}")
    public void theAppointmentStatusShouldBe(String expectedStatus) {
        Assert.assertEquals(expectedStatus, actualResult);
    }
}
