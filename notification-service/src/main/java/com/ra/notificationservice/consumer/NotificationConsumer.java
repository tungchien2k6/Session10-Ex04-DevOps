package com.ra.notificationservice.consumer;

import com.ra.notificationservice.event.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private static final Logger log = LoggerFactory.getLogger(NotificationConsumer.class);

    @KafkaListener(topics = "medicine-stock-events", groupId = "notification-group")
    public void handleNotificationEvent(OrderEvent event) {
        log.info("==================================================");
        log.info("Hóa đơn cho đơn hàng [{}] đã được gửi tới khách hàng", event.getOrderId());
        log.info("Chi tiết: Mã thuốc = {}, Số lượng = {}", event.getMedicineId(), event.getQuantity());
        log.info("==================================================");
    }
}