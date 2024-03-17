package ru.mtsb.okovalev.lessonthree.animals;

import ru.mtsb.okovalev.lessonthree.animals.enums.AnimalType;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Домашнее животное – расширение базовой абстракции AbstractAnimal.
 * Добавляет два свойства, присущих домашнему животному: кличку и стоимость.
 */
public abstract class Pet extends AbstractAnimal {
    protected double cost;

    /**
     * Максимальная стоимость домашнего животного в USD.
     * Может использоваться для генерации псевдослучайной стоимости.
     */
    protected static final int COST_BOUND = 10000;

    /**
     * Создаёт домашнее животное с указанными параметрами.
     *
     * @param type      Тип
     * @param breed     Порода
     * @param character Характер
     * @param name      Кличка
     * @param birthdate Дата рождения
     * @param cost      Стоимость в USD в зоомагазине или питомнике
     */
    public Pet(AnimalType type, String breed, String character, String name, LocalDate birthdate, double cost) {
        super(type, breed, character, name, birthdate);
        this.cost = cost;
    }

    /**
     * Возвращает тип домашнего животного.
     *
     * @return тип домашнего животного
     */
    @Override
    public AnimalType getType() {
        return super.type;
    }

    /**
     * Возвращает породу домашнего животного.
     *
     * @return порода домашнего животного
     */
    @Override
    public String getBreed() {
        return super.breed;
    }

    /**
     * Возвращает характер домашнего животного.
     *
     * @return характер домашнего животного
     */
    @Override
    public String getCharacter() {
        return super.character;
    }

    /**
     * Возвращает кличку домашнего животного.
     *
     * @return кличка домашнего животного
     */
    @Override
    public String getName() {
        return super.name;
    }

    /**
     * Возвращает дату рождения домашнего животного.
     *
     * @return дата рождения домашнего животного
     */
    @Override
    public LocalDate getBirthdate() {
        return super.birthdate;
    }

    /**
     * Возвращает формат даты рождения домашнего животного.
     *
     * @return формат строкового представления даты рождения домашнего животного
     */
    @Override
    public String getBirthdateFormat() {
        return super.birthdateFormat;
    }

    /**
     * Устанавливает формат даты рождения домашнего животного.
     *
     * @param format формат строкового представления даты рождения домашнего животного
     * @throws IllegalArgumentException если параметр format содержит неверный паттерн форматирования даты
     */
    @Override
    public void setBirthdateFormat(String format) throws IllegalArgumentException {
        try {
            DateTimeFormatter.ofPattern(format);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Format string is wrong for date-time formatting");
        }

        this.birthdateFormat = format;
    }

    /**
     * Возвращает отформатированное строковое представление даты рождения домашнего животного.
     *
     * @return дата рождения домашнего животного в формате this.birthdateFormat
     */
    @Override
    public String getBirthdateFormatted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(getBirthdateFormat());
        return super.birthdate.format(dtf);
    }

    /**
     * Возвращает стоимость домашнего животного в USD.
     *
     * @return стоимость домашнего животного в USD
     */
    public double getCost() {
        return cost;
    }

    /**
     * Возвращает представление домашнего животного в формате JSON.
     *
     * @return компактный (в одну строку) JSON, содержащий объект Pet со всеми полями класса Pet
     */
    @Override
    public String toString() {
        return "{"
                + "\"type\":\"" + getType() + "\","
                + "\"breed\":\"" + getBreed() + "\","
                + "\"character\":\"" + getCharacter() + "\","
                + "\"name\":\"" + getName() + "\","
                + "\"birthdate\":\"" + getBirthdateFormatted() + "\","
                + "\"cost\":\"" + new DecimalFormat("$#0.00").format(getCost()) + "\""
                + "}";
    }
}
