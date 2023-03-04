package a1qa.nizam.utilit;

import org.apache.logging.log4j.*;

public class LoggerUtil {
	private static Logger log;

	private static void init() {
		log = LogManager.getLogger("LoggerUtil");
	}

	public static Logger logger() {
		init();
		return log;
	}
}
