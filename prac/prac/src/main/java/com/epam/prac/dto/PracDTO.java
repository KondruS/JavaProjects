package com.epam.prac.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PracDTO {
    private String name;
    private String key;
    private String value;
}



