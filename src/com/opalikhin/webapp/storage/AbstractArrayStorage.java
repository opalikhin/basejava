package com.opalikhin.webapp.storage;

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
            System.out.println("ERROR: Resume " + resume.getUuid() + " doesn't exists.");
        }
    }

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

    public void delete(String uuid) {
        int delIndex = getIndex(uuid);
        if (delIndex < 0) {
            System.out.println("ERROR: Resume " + uuid + " doesn't exists.");
        } else {
            deleteResume(delIndex);
            storage[size - 1] = null;
            size--;
        }
    }

    public void save(Resume r) {
        int insIndex = getIndex(r.getUuid());
        if ((insIndex >= 0) && (storage[insIndex].equals(r))) {
            System.out.println("ERROR: Resume " + r.getUuid() + " already exists.");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            saveResume(r, insIndex);
            size++;
        }
    }

}
