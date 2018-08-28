package com.sd.util.common;

import java.util.Random;

public class SDCommon {
	//TODO add a good logic to generate the profile id
	public static String generateProfileId(long l,int countryCode) {
		Random rand = new Random();
		int  n = rand.nextInt(500) + 1;
		//StringBuffer buffer = new StringBuffer( countryCode+mobileNo+n);
		String str=Long.toString(countryCode+l)+"_"+Integer.toString(n);
		return str;
	}
	
	public static void main(String args[]) {
		System.out.println(SDCommon.generateProfileId(988989898, 99));
	}

}
