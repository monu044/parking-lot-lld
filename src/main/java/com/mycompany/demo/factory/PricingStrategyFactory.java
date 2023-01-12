package com.mycompany.demo.factory;

import com.google.inject.Inject;
import com.mycompany.demo.strategy.pricing.PricingStrategy;
import com.mycompany.demo.strategy.pricing.PricingStrategyType;
import lombok.AllArgsConstructor;

import java.util.Map;
@AllArgsConstructor(onConstructor = @__(@Inject))
public class PricingStrategyFactory {
    private Map<PricingStrategyType, PricingStrategy> pricingStrategyTypePricingStrategyMap;

    public PricingStrategy getPricingStrategyByType(PricingStrategyType strategyType) {
        return pricingStrategyTypePricingStrategyMap.get(strategyType);
    }
}
