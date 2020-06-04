package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

public final class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void saveElement(Resume r, int index) {
        storage[size] = r;
    }

}
