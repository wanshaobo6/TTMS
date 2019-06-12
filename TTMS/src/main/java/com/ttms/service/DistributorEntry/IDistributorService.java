package com.ttms.service.DistributorEntry;

import com.ttms.Entity.DisTourist;
import com.ttms.Entity.ProPricepolicy;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IDistributorService {
    Void login(String distributorname, String password , HttpServletRequest request);

    List<DisTourist> getMySignUpTourist(Integer did, Integer productId);

    List<ProPricepolicy> getPricePolicyByProductId(Integer productId);

    Void signup(Integer pricePolicy , String name, Byte sex, String idcard, String phone, String desc, Integer productId, Integer did);
}
