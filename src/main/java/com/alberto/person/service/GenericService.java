package com.alberto.person.service;

public interface GenericService<K, V> {
    K getPersonById(V id);
}
