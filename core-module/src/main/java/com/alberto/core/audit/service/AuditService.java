package com.alberto.core.audit.service;

import com.alberto.core.audit.model.dto.AuditAccountDto;

public interface AuditService {
    void persistAuditAccount(AuditAccountDto auditAccountDto);
}
