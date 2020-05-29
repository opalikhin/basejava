package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume r) {
        int insIndex = Arrays.binarySearch(storage, 0, size, r);
        if ((insIndex >= 0) && (storage[insIndex].equals(r))) {
            System.out.println("ERROR: Resume " + r.getUuid() + " already exists.");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            System.arraycopy(storage, -insIndex - 1, storage, -insIndex, size + insIndex + 1);
            storage[-insIndex - 1] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int insIndex = getIndex(uuid);
        if (insIndex < 0) {
            System.out.println("ERROR: Resume " + uuid + " doesn't exists.");
        } else {
            if (size - insIndex >= 0) {
                System.arraycopy(storage, insIndex + 1, storage, insIndex, size - insIndex);
            }
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
