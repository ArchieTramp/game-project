package ru.innopolis;

/**
 * NotificationServesImpl
 *
 * @author "Andrei Prokofiev"
 */


public class NotificationClientImpl implements NotificationClient {


    @Override
    public Boolean notifyUser(Long userId, String message) {
        return true;
    }
}
