package com.shash.threadpool.example;

public class ProductRepository {
	
	private int mobilePhoneCount;
	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository() {
		mobilePhoneCount = 1000;
	}
	
	public boolean assignPhone(UserRequest req) {
		
		synchronized (INSTANCE) {

			if (mobilePhoneCount <= 0) {
				req.isAssigned = false;
				return false;
			}

			req.isAssigned = true;
			mobilePhoneCount--;
			return true;	
		}
		
	}
	
	public static ProductRepository getInstance() {
		return INSTANCE;
	}
	

}
