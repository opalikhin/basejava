package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExists(Object key) {
        return storage.containsKey(key);
    }

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        storage.put((String) key, r);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(key);
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        storage.put((String) key, r);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get(key);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Collection<Resume> list = storage.values();
        return list.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
