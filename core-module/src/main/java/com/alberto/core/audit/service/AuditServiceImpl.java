package com.alberto.core.audit.service;

import com.alberto.core.audit.model.dto.AuditAccountDto;
import com.alberto.core.audit.model.mapper.AuditMapper;
import com.alberto.core.audit.repository.AuditRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AuditServiceImpl implements AuditService {

    @Inject
    AuditRepository auditRepository;

    @Override
    public void persistAuditAccount(AuditAccountDto auditAccountDto) {
        var auditAccount = AuditMapper.MAPPER.toResponseDocument(auditAccountDto);
        auditRepository.persist(auditAccount);
    }
}
