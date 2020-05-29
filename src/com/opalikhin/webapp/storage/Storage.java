package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

public interface Storage {

    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();

    void update(Resume resume);

}
