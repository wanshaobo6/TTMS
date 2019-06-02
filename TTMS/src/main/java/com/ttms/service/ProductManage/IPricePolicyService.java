package com.ttms.service.ProductManage;

import com.ttms.Entity.ProPricepolicy;
import com.ttms.Entity.ResGuide;

import java.util.Date;
import java.util.List;

public interface IPricePolicyService {
    List<ProPricepolicy> getProPricepoliciesByProductId(Integer pid);

    List<ProPricepolicy> queryPricePolicyByCriteria(List<Integer> pricePolicyIds, String pricePolicyName, Date startTime, Date endTime);

    List<ProPricepolicy> getPricePolicyByIds(List<Integer> pricepolicyIds);
}
