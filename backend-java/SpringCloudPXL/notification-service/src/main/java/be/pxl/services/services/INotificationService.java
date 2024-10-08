
package be.pxl.services.services;
import be.pxl.services.domain.Notification;
import java.util.List;

public interface INotificationService {
    List<Notification> getAllNotifications();
    Notification getNotificationById(Long id);
    Notification createNotification(Notification notification);
    Notification updateNotification(Long id, Notification notification);
    boolean deleteNotification(Long id);

    // New method to send a notification
    void sendNotification(Long id);
}
