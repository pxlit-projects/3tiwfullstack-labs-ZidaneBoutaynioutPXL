package be.pxl.services.services;

import be.pxl.services.domain.Notification;
import be.pxl.services.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService implements INotificationService {


    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, Notification notificationDetails) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            notification.setFrom(notificationDetails.getFrom());
            notification.setTo(notificationDetails.getTo());
            notification.setMessage(notificationDetails.getMessage());
            notification.setSubject(notificationDetails.getSubject());
            return notificationRepository.save(notification);
        }
        return null;
    }

    @Override
    public boolean deleteNotification(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void sendNotification(Long id) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            // Example of sending an email, push notification, etc.
            // Here you would interface with a third-party service, e.g., an email service
            System.out.println("Sending notification to: " + notification.getTo());
            System.out.println("Subject: " + notification.getSubject());
            System.out.println("Message: " + notification.getMessage());

            // Add logic here to actually send the notification (email, push notification, etc.)
        }
    }
}
