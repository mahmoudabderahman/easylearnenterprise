package com.easylearn.easylearn.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class AppointmentRespDTO {
    private Long id;
    private Date startDate;
    private Date endDate;
    private int roomNumber;
}
