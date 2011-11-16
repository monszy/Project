package events;

import java.util.*;

import com.pl.monszy.*;

public class MasterOfProduct {

	private Product Product;

	private List processes = new ArrayList();

	public Product getGame() {
		return Product;
	}

	public void setProduct(Product Product) {
		this.Product = Product;
	}

	public synchronized void addProcess(IProductProcesses process) {
		processes.add(process);
	}

	public synchronized void removeProcess(IProductProcesses process) {
		processes.remove(process);
	}

	public synchronized void executeProcesses(List<Product> list) {
		for (Product Product : list) {
			setProduct(Product);
			ProductEvent event = new ProductEvent(this, Product);
			Iterator proc = processes.iterator();
			while (proc.hasNext()) {
				((IProductProcesses) proc.next()).processProduct(event);
			}
		}
	}

}
