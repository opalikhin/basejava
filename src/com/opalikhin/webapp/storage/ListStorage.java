package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public final class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isExists(Object key) {
        return (int) key >= 0;
    }

    @Override
    protected List<Resume> getList() {
        return new ArrayList<>(storage);
    }

    @Override
    protected Object getKey(String uuid) {
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
    protected void saveResume(Resume r, Object key) {
        storage.add(r);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove((int) key);
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        storage.set((int) key, r);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get((int) key);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
