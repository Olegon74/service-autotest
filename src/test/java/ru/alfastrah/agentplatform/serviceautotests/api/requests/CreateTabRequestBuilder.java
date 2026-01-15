package ru.alfastrah.agentplatform.serviceautotests.api.requests;

import ru.alfastrah.agentplatform.serviceautotests.api.models.AlfaViewStatus;
import ru.alfastrah.agentplatform.serviceautotests.api.models.ContractType;
import ru.alfastrah.agentplatform.serviceautotests.api.models.PaymentStatus;
import ru.alfastrah.agentplatform.serviceautotests.api.models.TabRequest;
import ru.alfastrah.agentplatform.serviceautotests.api.models.UnderwritingStatus;
import ru.alfastrah.agentplatform.serviceautotests.generation.DataGenerator;

public final class CreateTabRequestBuilder {
    private CreateTabRequestBuilder() {
    }

    public static TabRequest buildDefaultTabRequest() {
        return TabRequest.builder()
                .title(DataGenerator.generateTitle())
                .subtitle(DataGenerator.generateSubtitle())
                .number(DataGenerator.generateNumber())
                .path(DataGenerator.generatePath())
                .alfaViewStatus(DataGenerator.getRandomEnum(AlfaViewStatus.class))
                .underwritingStatus(DataGenerator.getRandomEnum(UnderwritingStatus.class))
                .paymentStatus(DataGenerator.getRandomEnum(PaymentStatus.class))
                .contractType(DataGenerator.getRandomEnum(ContractType.class))
                .build();
    }
}
