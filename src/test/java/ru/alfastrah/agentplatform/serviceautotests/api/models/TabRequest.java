package ru.alfastrah.agentplatform.serviceautotests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TabRequest {
    private String title;
    private String subtitle;
    private String number;
    private String path;
    private AlfaViewStatus alfaViewStatus;
    private UnderwritingStatus underwritingStatus;
    private PaymentStatus paymentStatus;
    private ContractType contractType;
}
