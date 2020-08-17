package ru.innopolis;

/**
 * NotificationController
 *
 * @author "Andrei Prokofiev"
 */
public interface NotificationClient {

    Boolean notifyUser(Long userId, String message);

}
