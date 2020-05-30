package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveResume(Resume r, int insIndex) {
        storage[size] = r;
    }

    @Override
    protected void deleteResume(int delIndex) {
        storage[delIndex] = storage[size - 1];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
