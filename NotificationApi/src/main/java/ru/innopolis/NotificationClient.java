package ru.innopolis;

import org.springframework.mail.SimpleMailMessage;

/**
 * NotificationController
 *
 * @author "Andrei Prokofiev"
 */
public interface NotificationClient {

    Boolean notifyUser(SimpleMailMessage message);

}
