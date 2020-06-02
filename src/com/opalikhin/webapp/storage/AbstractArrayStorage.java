package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.ExistStorageException;
import com.opalikhin.webapp.exception.NotExistStorageException;
import com.opalikhin.webapp.exception.StorageException;
import com.opalikhin.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract int getIndex(String uuid);

    protected abstract void saveResume(Resume r, int insIndex);

    protected abstract void deleteResume(int delIndex);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void update(Resume resume) {
        int resumeIdx = getIndex(resume.getUuid());
        if (resumeIdx >= 0) {
            storage[resumeIdx] = resume;
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int resumeIdx = getIndex(uuid);
        if (resumeIdx < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[resumeIdx];
    }

    public int size() {
        return size;
    }

    public void delete(String uuid) {
        int delIndex = getIndex(uuid);
        if (delIndex < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(delIndex);
            storage[size - 1] = null;
            size--;
        }
    }

    public void save(Resume r) {
        int insIndex = getIndex(r.getUuid());
        if ((insIndex >= 0) && (storage[insIndex].equals(r))) {
            throw new ExistStorageException(r.getUuid());
        } else if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            saveResume(r, insIndex);
            size++;
        }
    }

}
