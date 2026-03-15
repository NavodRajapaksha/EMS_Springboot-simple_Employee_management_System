package edu.bootcamp.ems.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorCode {

    private String Status;
    private String Message;
}
