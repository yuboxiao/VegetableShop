package com.whut.vs.controller;

public class AwardCertificateController extends BaseController{

	private static AwardCertificateController instance;
	private AwardCertificateController() {
		super();
	}
	
	public static AwardCertificateController getInstance() {
		if (instance == null) {
			instance = new AwardCertificateController();
		}
		return instance;
	}
	
	
	
}
