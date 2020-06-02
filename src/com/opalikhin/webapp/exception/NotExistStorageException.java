package com.opalikhin.webapp.exception;

public class NotExistStorageException extends StorageException{
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " doesn't exists", uuid);
    }
}
