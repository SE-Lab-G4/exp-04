package appointment;

import java.time.LocalDateTime;

public class AppointmentManager {

    public String bookAppointment(String patientType, String insuranceStatus, LocalDateTime doctorAvailableUntil, LocalDateTime appointmentTime) {
        // Rule 1: Doctor's availability
        if (appointmentTime.isAfter(doctorAvailableUntil)) {
            return "canceled";
        }

        // Rule 2: Emergency patient
        if (patientType.equalsIgnoreCase("emergency")) {
            return "accepted";
        }

        // Rule 3: Insurance rejection
        if (insuranceStatus.equalsIgnoreCase("rejected")) {
            return "canceled";
        }

        // Rule 4: Regular patient with accepted insurance
        if (patientType.equalsIgnoreCase("regular") && insuranceStatus.equalsIgnoreCase("accepted")) {
            return "accepted";
        }

        return "canceled";
    }
}
