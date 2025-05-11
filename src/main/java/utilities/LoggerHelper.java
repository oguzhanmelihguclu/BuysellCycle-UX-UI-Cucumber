package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
	// Log4j Logger instance
	private static Logger logger = LogManager.getLogger();

	// Info seviyesinde log
	public static void info(String message) {
		logger.info(message);
	}

	// Warning seviyesinde log
	public static void warn(String message) {
		logger.warn(message);
	}

	// Error seviyesinde log
	public static void error(String message) {
		logger.error(message);
	}

	// Debug seviyesinde log
	public static void debug(String message) {
		logger.debug(message);
	}
}
