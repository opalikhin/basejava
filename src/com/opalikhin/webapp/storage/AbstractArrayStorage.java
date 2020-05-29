package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume get(String uuid) {
        int resumeIdx = getIndex(uuid);
        if (resumeIdx >= 0) {
            return storage[resumeIdx];
        } else {
            System.out.println("ERROR: Resume " + uuid + " doesn't exists.");
            return null;
        }
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
}
