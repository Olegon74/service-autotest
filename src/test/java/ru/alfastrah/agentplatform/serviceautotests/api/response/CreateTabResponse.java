package ru.alfastrah.agentplatform.serviceautotests.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alfastrah.agentplatform.serviceautotests.api.models.AlfaViewStatus;
import ru.alfastrah.agentplatform.serviceautotests.api.models.ContractType;
import ru.alfastrah.agentplatform.serviceautotests.api.models.PaymentStatus;
import ru.alfastrah.agentplatform.serviceautotests.api.models.UnderwritingStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTabResponse {
    private String title;
    private String subtitle;
    private String number;
    private String path;
    private AlfaViewStatus alfaViewStatus;
    private UnderwritingStatus underwritingStatus;
    private PaymentStatus paymentStatus;
    private ContractType contractType;
    private Integer id;
}
