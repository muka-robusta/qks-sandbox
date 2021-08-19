package com.onetwostory.model.cryptocurrency;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.json.bind.annotation.JsonbProperty;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Currency {

    private String id;
    private String symbol;
    private String name;

    @JsonbProperty("price_usd")
    private String priceUsd;
}
