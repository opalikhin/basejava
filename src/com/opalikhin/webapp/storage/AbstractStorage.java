package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.ExistStorageException;
import com.opalikhin.webapp.exception.NotExistStorageException;
import com.opalikhin.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndex(String uuid);

    protected abstract void saveResume(Resume r, int index);

    protected abstract void deleteResume(int index);

    protected abstract void updateElement(Resume r, int index);

    protected abstract Resume getElement(int index);

    public abstract void clear();

    public abstract Resume[] getAll();

    public abstract int size();

    public final void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            updateElement(r, index);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getElement(index);
    }

    public final void delete(String uuid) {
        int delIndex = getIndex(uuid);
        if (delIndex < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(delIndex);
        }
    }

    public final void save(Resume r) {
        int insIndex = getIndex(r.getUuid());
        if (insIndex >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r, insIndex);
        }
    }
}
