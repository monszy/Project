package events;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

public class ChangeProductPrice implements IProductProcesses {

	private static Logger logger = Logger.getLogger(ChangeProductPrice.class);
    Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	public void processProduct(ProductEvent event) {
		event.get_Product().setProductPrice(10);
		logger.info(event.get_Product().getName() + " - changed price for standard 10 at " + calendar.getTime());
	}
}
