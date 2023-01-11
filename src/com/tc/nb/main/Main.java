package com.tc.nb.main;

import com.tc.nb.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller contr = new Controller();
		System.out.println(contr.executeTask("SEARCH_BY_DATE "));

	}

}
