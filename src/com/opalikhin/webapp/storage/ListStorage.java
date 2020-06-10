package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public final class ListStorage extends AbstractStorage {

    private List<Resume> storage = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        int i = 0;
        for (Resume r : storage) {
            if (uuid.equals(r.getUuid())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume r, int index) {
        storage.add(r);
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.set(index, r);
    }

    @Override
    protected Resume getResume(int index) {
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
