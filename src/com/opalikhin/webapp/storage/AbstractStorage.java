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

    private void checkExist(Object key, String uuid) {
        if (!isExists(key)) {
            throw new NotExistStorageException(uuid);
        }
    }

    private void checkNotExist(Object key, String uuid) {
        if (isExists(key)) {
            throw new ExistStorageException(uuid);
        }
    }

    public final void update(Resume r) {
        Object key = getKey(r.getUuid());
        checkExist(key, r.getUuid());
        updateResume(r, key);
    }

    public final Resume get(String uuid) {
        Object key = getKey(uuid);
        checkExist(key, uuid);
        return getResume(key);
    }

    public final void delete(String uuid) {
        Object key = getKey(uuid);
        checkExist(key, uuid);
        deleteResume(key);
    }

    public final void save(Resume r) {
        Object key = getKey(r.getUuid());
        checkNotExist(key, r.getUuid());
        saveResume(r, key);
    }

}
