package com.example.home.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PRODUCT-SERVICE")
public interface HomeInterface {
	@GetMapping("/product")
	public String products();

}
