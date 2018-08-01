package com.connect.stock.spirit.controller;

import com.connect.stock.spirit.model.Share;

import java.util.Map;

public class FundShares {

    private Map<String, Share> buyLongShares;
    private Map<String, Share> shortSellingShares;

    public Map<String, Share> getBuyLongShares() {
        return buyLongShares;
    }

    public void setBuyLongShares(Map<String, Share> buyLongShares) {
        this.buyLongShares = buyLongShares;
    }

    public Map<String, Share> getShortSellingShares() {
        return shortSellingShares;
    }

    public void setShortSellingShares(Map<String, Share> shortSellingShares) {
        this.shortSellingShares = shortSellingShares;
    }
}
