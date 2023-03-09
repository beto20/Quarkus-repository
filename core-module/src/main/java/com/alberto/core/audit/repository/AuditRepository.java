package com.alberto.core.audit.repository;

import com.alberto.core.audit.model.document.AuditAccountDocument;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuditRepository implements PanacheMongoRepository<AuditAccountDocument> {

}
