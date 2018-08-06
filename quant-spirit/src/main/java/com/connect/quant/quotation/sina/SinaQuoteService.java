package com.connect.quant.quotation.sina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SinaQuoteService {
	@Autowired
	@Qualifier("quoteConfig")
	private SinaQuoteConfig quoteConfig;
}
