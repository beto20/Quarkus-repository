package com.alberto.person.repository;

import com.alberto.person.model.entity.BaseEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<BaseEntity, Long> {

}
