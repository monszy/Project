package events;

import com.pl.monszy.*;

public class ProductEvent {

	private Product _product;

	public Product get_Product() {
		return _product;
	}

	public void set_Product(Product _product) {
		this._product = _product;
	}

	public ProductEvent(Object source, Product Product) {
		super();
		_product = Product;
	}

}
