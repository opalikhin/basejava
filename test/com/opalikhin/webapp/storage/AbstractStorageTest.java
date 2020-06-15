package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.ExistStorageException;
import com.opalikhin.webapp.exception.NotExistStorageException;
import com.opalikhin.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String DUMMY = "dummy";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;

    static {
        RESUME_1 = new Resume(UUID_1, "fullName1");
        RESUME_2 = new Resume(UUID_2, "fullName2");
        RESUME_3 = new Resume(UUID_3, "fullName3");
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void getAllSorted() {
        List<Resume> list = storage.getAllSorted();
        assertEquals(Arrays.asList(RESUME_1, RESUME_2, RESUME_3), list);
    }

    @Test
    public void update() {
        Resume r = new Resume(UUID_2, "fullName2");
        storage.update(r);
        assertEquals(r, storage.get(UUID_2));
        assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExists() {
        Resume r = new Resume(DUMMY, "dummy");
        storage.update(r);
    }

    @Test
    public void get() {
        assertEquals(new Resume(UUID_2, "fullName2"), storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(DUMMY);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        try {
            // check resume doesn't exist
            Resume r = storage.get(UUID_1);
        } catch (NotExistStorageException e) {
            // valid expected exception
        }
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExists() {
        storage.delete(DUMMY);
    }

    @Test
    public void save() {
        Resume r = new Resume("fullName");
        storage.save(r);
        assertEquals(4, storage.size());
        assertEquals(r, storage.get(r.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume(UUID_3, "fullName3"));
    }

}