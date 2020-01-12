/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Appointment Request Data Transfer Object is where the specifications required for requests declared.
 */
package com.easylearn.easylearn.model;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class AppointmentReqDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int roomNumber;
}
