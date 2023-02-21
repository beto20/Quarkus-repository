package com.alberto.core.account.repository;

import com.alberto.core.account.model.entity.AccountEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<AccountEntity, Long> {

}
