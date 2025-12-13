package design;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    class Logger {
        Map<String, LocalDateTime> limiterMap;

        public Logger() {
            limiterMap = new HashMap<>();
        }

        boolean shouldPrintMessage(LocalDateTime timestamp, String message) {
            LocalDateTime expirationTime = limiterMap.getOrDefault(message, LocalDateTime.MIN);
            boolean shouldPrint = expirationTime.isBefore(timestamp);

            if (shouldPrint) {
                limiterMap.put(message, timestamp.plusSeconds(10));
            }

            return shouldPrint;
        }
    }
}
