package com.green.car.wash.company.paymentservice.controller;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.car.wash.company.paymentservice.repository.StatementRepository;
import com.green.car.wash.company.paymentservice.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	  PaymentService ewalletService;

	@Autowired
	  StatementRepository stateRepository;


	@PostMapping("/addMoney/{amount}")
	public String onlinePayment(@PathVariable double amount)throws RazorpayException
	{
		//final PayPalHttpClient payPalHttpClient;
		double amt=amount;
		System.out.println(amt);
		RazorpayClient client=new RazorpayClient("rzp_test_JZUBdxVFDFQOZv","6OYHBEHJWvSkp4CccH0Nq1GR");
		//payPalHttpClient=new PayPalHttpClient(new PayPalEnvironment.Sandbox("AZMBZ10J32RS_WvLOGsECTpc8FUNTZGM5GvldiTmmoG1ctgWRfroZPQ44-jMj-tSGihrunJkPkfMELwI","EHaEuTAqJLFjEPRVC-Pr9WpSyDvc6tRPXk6Yx_B8SsyyMhfJQkQqY"));
		JSONObject options=new JSONObject();

		options.put("amount", amt);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order=client.Orders.create(options);
		System.out.println(order);
		return order.toString();

	}
}
