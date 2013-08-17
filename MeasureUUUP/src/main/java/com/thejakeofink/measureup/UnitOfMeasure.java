package com.thejakeofink.measureup;

import java.math.BigDecimal;

/**
 * Created by Jake on 8/16/13.
 */
public class UnitOfMeasure
{
    private int type;
    private BigDecimal inputValue;

    public UnitOfMeasure(int i, BigDecimal l)
    {
        type = i;
        inputValue = l;
    }

    public int getType()
    {
        return type;
    }

    public BigDecimal getInputValue()
    {
        return inputValue;
    }
}
