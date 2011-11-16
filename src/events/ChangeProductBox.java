package events;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import com.pl.monszy.*;

public class ChangeProductBox implements IProductProcesses {

	private static Logger logger = Logger.getLogger(ChangeProductBox.class);
    Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	public void processProduct(ProductEvent event) {
		event.get_Product().setProductBoxColor("standard black");
		logger.info(event.get_Product().getName() + " - changed box for standard black at " + calendar.getTime());
	}
}
