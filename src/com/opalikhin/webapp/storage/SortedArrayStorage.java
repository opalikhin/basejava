package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.Arrays;

public final class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void saveElement(Resume r, int insIndex) {
        int index = -insIndex - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = r;
    }

    @Override
    protected void deleteElement(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
    }

}
