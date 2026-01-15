package ru.alfastrah.agentplatform.serviceautotests.api.models;

public enum PaymentStatus {
    NEED_PAYMENT,
    CARD_AWAITING_PAYMENT,
    CASH_AWAITING_PAYMENT,
    CARD_PAYED,
    CASH_PAYED,
    CARD_EXPIRED,
    CASH_EXPIRED
}
