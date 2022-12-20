package com.green.car.wash.company.admin.service;

import java.util.Arrays;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.green.car.wash.company.admin.model.OrderDetails;
import com.green.car.wash.company.admin.model.WasherProfile;



@Service
public class AdminService {
	Logger log = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of Order Service
    String url="http://order/orders";
    //Url to access the methods of washer Service
    String url1="http://washer/washers/admin/";



  //To see all the Orders
    public List<OrderDetails> getAllOrders(){
        OrderDetails[] orders=restTemplate.getForObject(url+"/findall",OrderDetails[].class);
        log.info("getting all the orders");
        return (Arrays.asList(orders));
    }
    /** Order controls through admin using rest template*/
    //To assign a washer to the order by Admin
    public OrderDetails assignWasher(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,OrderDetails.class).getBody();
    }
    //To see all washers
    public List<WasherProfile> getAllWashers(){
        WasherProfile[] washers=restTemplate.getForObject(url1+"/getWashers",WasherProfile[].class);
        return (Arrays.asList(washers));
    }

	public List<WasherProfile> getOneWasher(String fullName) {
		WasherProfile[] wp=restTemplate.getForObject(url1+"/Washer/"+fullName,WasherProfile[].class);
		return (Arrays.asList(wp));
	}

}