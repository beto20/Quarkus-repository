package com.alberto.core.audit.model;

public enum SubscriberMessageActions {
    COMPLETE,
    ABANDON,
    DEADLETTER;

    private SubscriberMessageActions() {
    }
}
