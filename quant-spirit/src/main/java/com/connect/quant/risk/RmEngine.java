package com.connect.quant.risk;

import com.connect.quant.gateway.Gateway;
import com.connect.quant.model.ReqOrder;

abstract public class RmEngine {
	
	abstract public boolean checkRisk(ReqOrder reqOrder, Gateway gateway);
}
