package com.opalikhin.webapp.storage;

import com.opalikhin.webapp.exception.ExistStorageException;
import com.opalikhin.webapp.exception.NotExistStorageException;
import com.opalikhin.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getKey(String uuid);

    protected abstract void saveResume(Resume r, SK key);

    protected abstract void deleteResume(SK key);

    protected abstract void updateResume(Resume r, SK key);

    protected abstract Resume getResume(SK key);

    protected abstract boolean isExist(SK key);

    protected abstract List<Resume> getList();

    public final void update(Resume r) {
        LOG.info("Update " + r);
        SK existKey = getExistKey(r.getUuid());
        updateResume(r, existKey);
    }

    public final Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK existKey = getExistKey(uuid);
        return getResume(existKey);
    }

    public final void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK existKey = getExistKey(uuid);
        deleteResume(existKey);
    }

    public final void save(Resume r) {
        LOG.info("Save " + r);
        SK notExistKey = getNotExistKey(r.getUuid());
        saveResume(r, notExistKey);
    }

    public final List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = getList();
        Collections.sort(list);
        return list;
    }

    private SK getExistKey(String uuid) {
        SK key = getKey(uuid);
        if (!isExist(key)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getNotExistKey(String uuid) {
        SK key = getKey(uuid);
        if (isExist(key)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

}
