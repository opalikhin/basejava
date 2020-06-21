package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public final class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isExist(Integer key) {
        return key >= 0;
    }

    @Override
    protected List<Resume> getList() {
        return new ArrayList<>(storage);
    }

    @Override
    protected Integer getKey(String uuid) {
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
    protected void saveResume(Resume r, Integer key) {
        storage.add(r);
    }

    @Override
    protected void deleteResume(Integer key) {
        storage.remove(key.intValue());
    }

    @Override
    protected void updateResume(Resume r, Integer key) {
        storage.set(key, r);
    }

    @Override
    protected Resume getResume(Integer key) {
        return storage.get(key);
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
