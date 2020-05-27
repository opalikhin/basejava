package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        int resumeIdx = getResumeIdx(r.getUuid());
        if (resumeIdx == -1) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("ERROR: Resume already exists.");
        }
    }

    public Resume get(String uuid) {
        int resumeIdx = getResumeIdx(uuid);
        if (resumeIdx >= 0) {
            return storage[resumeIdx];
        } else {
            System.out.println("ERROR: Resume isn't exists.");
            return null;
        }
    }

    public void delete(String uuid) {
        int resumeIdx = getResumeIdx(uuid);
        if (resumeIdx >= 0) {
            storage[resumeIdx] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: Resume isn't exists.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        int resumeIdx = getResumeIdx(resume.getUuid());
        if (resumeIdx >= 0) {
            storage[resumeIdx] = resume;
        } else {
            System.out.println("ERROR: Resume isn't exists.");
        }
    }

    private int getResumeIdx(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
