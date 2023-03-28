package com.company.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@ToString
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDTO {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String role;
    private String username;
    private String password;
    private Boolean visible;
    private LocalDateTime createdDate;

    private String jwt;

    public CompanyDTO(String jwt) {
        this.jwt = jwt;
    }

}
