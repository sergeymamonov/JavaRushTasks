package com.javarush.task.task31.task3110;

public enum Operation {
    CREATE("0 - упаковать файлы в архив"),
    ADD("1 - добавить файл в архив"),
    REMOVE("2 - удалить файл из архива"),
    EXTRACT("3 - распаковать архив"),
    CONTENT("4 - просмотреть содержимое архива"),
    EXIT("5 - выход");

    private String description;

    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
