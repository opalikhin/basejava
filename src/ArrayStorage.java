/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume result = new Resume();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid == uuid) {
                result = storage[i];
                break;
            }
        }
        return result;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid == uuid) {
                storage[i] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int storageSize = this.size();
        int j = 0;
        Resume[] result = new Resume[storageSize];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                result[j] = new Resume();
                result[j] = storage[i];
                j++;
            }
        }
        return result;
    }

    int size() {
        int result = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                result++;
            }
        }
        return result;
    }
}
