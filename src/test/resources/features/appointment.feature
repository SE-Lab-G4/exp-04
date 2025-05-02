Feature: Appointment Management

  Scenario: Emergency patient should get appointment even if insurance is rejected
    Given a patient of type "emergency" with insurance status "rejected" requesting an appointment with doctor "Dr. Hosseini" in department "Pediatrics" whose available until "2023-11-15"
    When the patient requests an appointment at "2023-11-20 09:30"
    Then the appointment status should be "canceled"

  Scenario Outline: Manage different appointment situations
    Given a patient of type "<patientType>" with insurance status "<insuranceStatus>" requesting an appointment with doctor "<doctorName>" in department "<department>" whose available until "<availableUntil>"
    When the patient requests an appointment at "<appointmentTime>"
    Then the appointment status should be "<expectedResult>"

    Examples:
      | patientType | insuranceStatus | doctorName     | department   | availableUntil | appointmentTime      | expectedResult |
      | regular     | accepted         | Dr. Razavi     | Cardiology   | 2023-12-31     | 2023-10-10 10:00     | accepted        |
      | emergency   | rejected          | Dr. Hosseini   | Pediatrics   | 2023-11-15     | 2023-11-20 09:30     | canceled        |
      | regular     | rejected          | Dr. Mohammadi  | Orthopedics  | 2024-01-10     | 2023-12-25 14:00     | canceled        |
