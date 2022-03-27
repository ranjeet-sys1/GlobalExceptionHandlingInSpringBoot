package com.app.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Locale;
import java.util.UUID;
@Entity
@Table(name="student",schema = "ExceptionHandling")
@Data
public class Student {
    //@Id
    /*@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @ColumnDefault("random_uuid()")
    //@Type(type = "uuid-char")
    @Column(name = "student_id", updatable = false, nullable = false,columnDefinition="BINARY(128)")
    private UUID studentId;*/
    @Id
    @GeneratedValue
    private Long studentId;
    @Size(min=2, message="character must be size of at least 2")
    private String name;
    private BigInteger USN;
}
