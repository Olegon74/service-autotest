package ru.test.serviceautotests.api.requests;

import ru.test.serviceautotests.api.models.AlfaViewStatus;
import ru.test.serviceautotests.api.models.ContractType;
import ru.test.serviceautotests.api.models.PaymentStatus;
import ru.test.serviceautotests.api.models.TabRequest;
import ru.test.serviceautotests.api.models.UnderwritingStatus;
import ru.test.serviceautotests.generation.DataGenerator;

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
