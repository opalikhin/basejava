package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.StorageException;
import com.opalikhin.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        int i = storage.size();
        try {
            while (i < AbstractArrayStorage.STORAGE_LIMIT) {
                storage.save(new Resume("fullName"));
                i++;
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("fullName"));
    }
}