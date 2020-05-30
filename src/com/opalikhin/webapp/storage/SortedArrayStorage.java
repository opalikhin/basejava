package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveResume(Resume r, int insIndex) {
        System.arraycopy(storage, -insIndex - 1, storage, -insIndex, size + insIndex + 1);
        storage[-insIndex - 1] = r;
    }

    @Override
    protected void deleteResume(int delIndex) {
        System.arraycopy(storage, delIndex + 1, storage, delIndex, size - delIndex);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
