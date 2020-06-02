package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveResume(Resume r, int insIndex) {
        int index = -insIndex - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = r;
    }

    @Override
    protected void deleteResume(int delIndex) {
        System.arraycopy(storage, delIndex + 1, storage, delIndex, size - (delIndex + 1));
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
