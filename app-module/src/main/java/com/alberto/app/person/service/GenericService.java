package com.alberto.app.person.service;

public interface GenericService<K, V> {
    K getPersonById(V id);
}
