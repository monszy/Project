package events;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

public class DiscountProduct implements IProductProcesses {

	private static Logger logger = Logger.getLogger(DiscountProduct.class);
    Calendar calendar = GregorianCalendar.getInstance();

	@Override
	public void processProduct(ProductEvent event) {
		event.get_Product().setDiscount(true);
		double lastPrice=event.get_Product().getPrice();
		event.get_Product().setPrice(lastPrice*0.9);
		logger.info(event.get_Product().getName() + " - Discount product at " + calendar.getTime());

	}

}
