package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.ExistStorageException;
import com.opalikhin.webapp.exception.NotExistStorageException;
import com.opalikhin.webapp.exception.StorageException;
import com.opalikhin.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] arr = new Resume[]{new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        Assert.assertArrayEquals(arr, storage.getAll());
    }

    @Test
    public void update() {
        Resume r = new Resume(UUID_2);
        storage.update(r);
        Assert.assertEquals(UUID_2, storage.get(UUID_2).getUuid());
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExists() {
        Resume r = new Resume("dummy");
        storage.update(r);
    }

    @Test
    public void get() {
        Assert.assertEquals(UUID_2, storage.get(UUID_2).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExists() {
        storage.delete("dummy");
    }

    @Test
    public void save() {
        storage.save(new Resume());
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume(UUID_3));
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        int i = storage.size();
        try {
            while (i < 10000) {
                storage.save(new Resume());
                i++;
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }

}