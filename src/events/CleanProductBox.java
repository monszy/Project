package events;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import com.pl.monszy.*;

public class CleanProductBox implements IProductProcesses {

	private static Logger logger = Logger.getLogger(CleanProductBox.class);
    Calendar calendar = GregorianCalendar.getInstance();

	@Override
	public void processProduct(ProductEvent event) {
		event.get_Product().setCleanBox(true);
		logger.info(event.get_Product().getName() + " - cleaned Product box at " + calendar.getTime());

	}

}
