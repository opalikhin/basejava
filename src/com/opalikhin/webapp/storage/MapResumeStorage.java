package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapResumeStorage extends AbstractStorage<Resume> {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(Resume key) {
        return key != null;
    }

    @Override
    protected List<Resume> getList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected Resume getKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void saveResume(Resume r, Resume key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void deleteResume(Resume key) {
        storage.remove((key).getUuid());
    }

    @Override
    protected void updateResume(Resume r, Resume key) {
        storage.put((key).getUuid(), r);
    }

    @Override
    protected Resume getResume(Resume key) {
        return key;
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
