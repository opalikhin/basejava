package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ListStorage extends AbstractStorage {

    private List<Resume> storage = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        Resume[] searchArray = storage.toArray(new Resume[0]);
        return Arrays.binarySearch(searchArray, 0, size(), searchKey);
    }

    @Override
    protected void saveResume(Resume r, int index) {
        storage.add(-index - 1, r);
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    @Override
    protected void updateElement(Resume r, int index) {
        storage.set(index, r);
    }

    @Override
    protected Resume getElement(int index) {
        return storage.get(index);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
