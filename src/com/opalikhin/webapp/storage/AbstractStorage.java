package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.ExistStorageException;
import com.opalikhin.webapp.exception.NotExistStorageException;
import com.opalikhin.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getKey(String uuid);

    protected abstract void saveResume(Resume r, Object key);

    protected abstract void deleteResume(Object key);

    protected abstract void updateResume(Resume r, Object key);

    protected abstract Resume getResume(Object key);

    protected abstract boolean isExists(Object key);

    private Object getExistKey(String uuid) {
        Object key = getKey(uuid);
        if (!isExists(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExistKey(String uuid) {
        Object key = getKey(uuid);
        if (isExists(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    public final void update(Resume r) {
        Object existKey = getExistKey(r.getUuid());
        updateResume(r, existKey);
    }

    public final Resume get(String uuid) {
        Object existKey = getExistKey(uuid);
        return getResume(existKey);
    }

    public final void delete(String uuid) {
        Object existKey = getExistKey(uuid);
        deleteResume(existKey);
    }

    public final void save(Resume r) {
        Object notExistKey = getNotExistKey(r.getUuid());
        saveResume(r, notExistKey);
    }

}
