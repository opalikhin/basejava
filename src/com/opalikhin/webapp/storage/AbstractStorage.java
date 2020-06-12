package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.ExistStorageException;
import com.opalikhin.webapp.exception.NotExistStorageException;
import com.opalikhin.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    private Object key;

    protected abstract Object getKey(String uuid);

    protected abstract void saveResume(Resume r, Object key);

    protected abstract void deleteResume(Object key);

    protected abstract void updateResume(Resume r, Object key);

    protected abstract Resume getResume(Object key);

    protected abstract boolean isExists(Object key);

    private void checkExist(String uuid) {
        key = getKey(uuid);
        if (!isExists(key)) {
            throw new NotExistStorageException(uuid);
        }
    }

    private void checkNotExist(String uuid) {
        key = getKey(uuid);
        if (isExists(key)) {
            throw new ExistStorageException(uuid);
        }
    }

    public final void update(Resume r) {
        checkExist(r.getUuid());
        updateResume(r, key);
    }

    public final Resume get(String uuid) {
        checkExist(uuid);
        return getResume(key);
    }

    public final void delete(String uuid) {
        checkExist(uuid);
        deleteResume(key);
    }

    public final void save(Resume r) {
        checkNotExist(r.getUuid());
        saveResume(r, key);
    }

}
