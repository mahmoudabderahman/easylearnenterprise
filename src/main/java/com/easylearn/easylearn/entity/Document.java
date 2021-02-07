/**
 * @Author: Mahmoud Abdelrahman
 * Course Document is where all Document specifications are declared.
 */

package com.easylearn.easylearn.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increament
    private long id;
    private String nameOfFile;
    @Lob
    private byte[] data;

    private Long courseId;

    private String downloadLink;


}
