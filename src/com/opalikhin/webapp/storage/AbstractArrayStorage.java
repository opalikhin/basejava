package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.StorageException;
import com.opalikhin.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void deleteElement(int index);

    protected abstract void saveElement(Resume r, int index);

    @Override
    protected final boolean isExist(Object key) {
        return (int) key >= 0;
    }

    @Override
    protected final List<Resume> getList() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected final void saveResume(Resume r, Object key) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            saveElement(r, (int) key);
            size++;
        }
    }

    @Override
    protected final void deleteResume(Object key) {
        deleteElement((int) key);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected final void updateResume(Resume r, Object key) {
        storage[(int) key] = r;
    }

    @Override
    protected final Resume getResume(Object key) {
        return storage[(int) key];
    }

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final int size() {
        return size;
    }
}
