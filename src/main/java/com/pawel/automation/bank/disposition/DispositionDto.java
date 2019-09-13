package com.pawel.automation.bank.disposition;

import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "disposition")
@Data
@Builder
public class DispositionDto {

    private String accountNumber;
    private long funds;
    private String operationName;

}