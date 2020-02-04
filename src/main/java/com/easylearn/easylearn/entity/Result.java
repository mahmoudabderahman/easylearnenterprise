/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * Result Entity is where all Result specifications are declared.
 */
package com.easylearn.easylearn.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increament
    private long id;

    private Long courseId;

    private Long studentId;

    private Double points;

    private int maxValue;
}
