package ru.mtsb.okovalev.lessonfive.exceptions;

/**
 * Проверяемое исключение (checked exception ~ унаследовано от Exception).
 */
public class InvalidAnimalBirthdateException extends Exception {
    /**
     * Создаёт объект InvalidAnimalBirthdateException с указанным описанием исключения.
     *
     * @param message Описание исключения
     */
    public InvalidAnimalBirthdateException(String message) {
        super(message);
    }
}
