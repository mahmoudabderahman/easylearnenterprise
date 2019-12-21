package com.easylearn.easylearn.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor

// when there is a null value in the returned response, it will exclude it.
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AppointmentRespDTO {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int roomNumber;
    private CourseRespDTO course;
}
