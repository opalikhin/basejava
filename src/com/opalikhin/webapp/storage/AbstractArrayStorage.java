package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.StorageException;
import com.opalikhin.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract int getIndex(String uuid);

    protected abstract void deleteElement(int index);

    protected abstract void saveElement(Resume r, int index);

    @Override
    protected final void saveResume(Resume r, int index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            saveElement(r, index);
            size++;
        }
    }

    @Override
    protected final void deleteResume(int index) {
        deleteElement(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected final void updateResume(Resume r, int index) {
        storage[index] = r;
    }

    @Override
    protected final Resume getResume(int index) {
        return storage[index];
    }

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public final int size() {
        return size;
    }
}
