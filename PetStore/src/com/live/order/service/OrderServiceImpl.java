package com.live.order.service;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;
import org.springframework.samples.jpetstore.dao.ProductDao;
import org.springframework.samples.jpetstore.domain.Product;

import com.live.order.domain.Order;

/**
* <pre>
* Service implementation for {@link OrderService}
* </pre>
*
* @see OrderService
*
*/
public class OrderServiceImpl implements OrderService {
    
    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);
	private ProductDao productDao;

    public OrderServiceImpl() {
    }
    
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public List getProductListByCategory(String categoryId) {
		return this.productDao.getProductListByCategory(categoryId);
	}

	public List searchProductList(String keywords) {
		return this.productDao.searchProductList(keywords);
	}

	public Product getProduct(String productId) {
		return this.productDao.getProduct(productId);
	}

    @Override
    public String placeOrder(Order order) {
        logger.info("Order has been placed. Order Info is : " + ObjectUtils.toString(order));
        return getRandomOrderRefNo();
    }

    @Override
    public boolean cancelOrder(String orderRef) {
        logger.info("Order has been placed. Order Reference : " + orderRef);
        return true;
    }
    
    @Override
    public String viewDogs(String orderRef) {
    	String tmpstr = this.getProduct("1").getName();
        logger.info("viewDogs: " + tmpstr);
        return tmpstr;
    }
    
    private String getRandomOrderRefNo() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return "Ref-" + year + "-" + month + "-" + day + "-" + Math.random();
        
    }
}