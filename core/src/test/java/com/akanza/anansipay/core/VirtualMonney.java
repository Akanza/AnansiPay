/*
 * Copyright 2021 Akanza
 * Licensed under the Server Side Public License (SSPL), VERSION 1, OCTOBER 16, 2018;
 */

package com.akanza.anansipay.core;

import java.util.Objects;
import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.money.MonetaryContext;
import javax.money.NumberValue;

/**
 * @author Christian Amani 2021-02-24
 */
public class VirtualMonney implements Money {

  private final org.javamoney.moneta.Money amount;

  public VirtualMonney(org.javamoney.moneta.Money amount) {
    this.amount = amount;
  }

  @Override
  public MonetaryContext getContext() {
    return amount.getContext();
  }

  @Override
  public MonetaryAmountFactory<? extends MonetaryAmount> getFactory() {
    return this.amount.getFactory();
  }

  @Override
  public boolean isGreaterThan(MonetaryAmount monetaryAmount) {
    return this.amount.isGreaterThan(monetaryAmount);
  }

  @Override
  public boolean isGreaterThanOrEqualTo(MonetaryAmount monetaryAmount) {
    return this.amount.isGreaterThanOrEqualTo(monetaryAmount);
  }

  @Override
  public boolean isLessThan(MonetaryAmount monetaryAmount) {
    return this.amount.isLessThan(monetaryAmount);
  }

  @Override
  public boolean isLessThanOrEqualTo(MonetaryAmount monetaryAmount) {
    return this.amount.isLessThanOrEqualTo(monetaryAmount);
  }

  @Override
  public boolean isEqualTo(MonetaryAmount monetaryAmount) {
    return this.amount.isEqualTo(monetaryAmount);
  }

  @Override
  public int signum() {
    return this.amount.signum();
  }

  @Override
  public MonetaryAmount add(MonetaryAmount monetaryAmount) {
    return this.amount.add(monetaryAmount);
  }

  @Override
  public MonetaryAmount subtract(MonetaryAmount monetaryAmount) {
    return this.amount.subtract(monetaryAmount);
  }

  @Override
  public MonetaryAmount multiply(long l) {
    return this.amount.multiply(l);
  }

  @Override
  public MonetaryAmount multiply(double v) {
    return this.amount.multiply(v);
  }

  @Override
  public MonetaryAmount multiply(Number multiply) {
    return this.amount.multiply(multiply);
  }

  @Override
  public MonetaryAmount divide(long l) {
    return this.amount.divide(l);
  }

  @Override
  public MonetaryAmount divide(double v) {
    return this.amount.divide(v);
  }

  @Override
  public MonetaryAmount divide(Number number) {
    return this.amount.divide(number);
  }

  @Override
  public MonetaryAmount remainder(long l) {
    return this.amount.remainder(l);
  }

  @Override
  public MonetaryAmount remainder(double v) {
    return this.amount.remainder(v);
  }

  @Override
  public MonetaryAmount remainder(Number number) {
    return this.amount.remainder(number);
  }

  @Override
  public MonetaryAmount[] divideAndRemainder(long l) {
    return this.amount.divideAndRemainder(l);
  }

  @Override
  public MonetaryAmount[] divideAndRemainder(double v) {
    return this.amount.divideAndRemainder(v);
  }

  @Override
  public MonetaryAmount[] divideAndRemainder(Number number) {
    return this.amount.divideAndRemainder(number);
  }

  @Override
  public MonetaryAmount divideToIntegralValue(long l) {
    return this.amount.divideToIntegralValue(l);
  }

  @Override
  public MonetaryAmount divideToIntegralValue(double v) {
    return this.amount.divideToIntegralValue(v);
  }

  @Override
  public MonetaryAmount divideToIntegralValue(Number number) {
    return this.amount.divideToIntegralValue(number);
  }

  @Override
  public MonetaryAmount scaleByPowerOfTen(int i) {
    return this.amount.scaleByPowerOfTen(i);
  }

  @Override
  public MonetaryAmount abs() {
    return this.amount.abs();
  }

  @Override
  public MonetaryAmount negate() {
    return this.amount.negate();
  }

  @Override
  public MonetaryAmount plus() {
    return this.amount.plus();
  }

  @Override
  public MonetaryAmount stripTrailingZeros() {
    return this.amount.stripTrailingZeros();
  }

  @Override
  public int compareTo(MonetaryAmount o) {
    Objects.requireNonNull(o);
    return this.amount.compareTo(o);
  }

  @Override
  public CurrencyUnit getCurrency() {
    return this.amount.getCurrency();
  }

  @Override
  public NumberValue getNumber() {
    return this.amount.getNumber();
  }
}
