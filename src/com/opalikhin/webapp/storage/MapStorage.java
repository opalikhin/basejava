package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapStorage extends AbstractStorage<String> {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(String key) {
        return storage.containsKey(key);
    }

    @Override
    protected List<Resume> getList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected void saveResume(Resume r, String key) {
        storage.put(key, r);
    }

    @Override
    protected void deleteResume(String key) {
        storage.remove(key);
    }

    @Override
    protected void updateResume(Resume r, String key) {
        storage.put(key, r);
    }

    @Override
    protected Resume getResume(String key) {
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
