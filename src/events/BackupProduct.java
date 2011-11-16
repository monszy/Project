package events;

import java.util.*;
import org.apache.log4j.Logger;


public class BackupProduct implements IProductProcesses {

	private static Logger logger = Logger.getLogger(BackupProduct.class);
    Calendar calendar = GregorianCalendar.getInstance();
	
	@Override
	public void processProduct(ProductEvent event) {
		event.get_Product().setBackup(true);
		logger.info(event.get_Product().getName() + " - backup done at " + calendar.getTime());
	}

}
