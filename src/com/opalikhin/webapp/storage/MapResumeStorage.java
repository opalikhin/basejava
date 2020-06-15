package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapResumeStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    protected List<Resume> getList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected Object getKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void saveResume(Resume r, Object key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(((Resume) key).getUuid());
    }

    @Override
    protected void updateResume(Resume r, Object key) {
        storage.put(((Resume) key).getUuid(), r);
    }

    @Override
    protected Resume getResume(Object key) {
        return (Resume) key;
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
