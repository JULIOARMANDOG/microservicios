package com.projec.jpa.jpaexample.builder;

public class BanckAcountBuilder implements IBuilder {

    private double accountNumer;
    private String ownner;
    private  BanckAcoountType type;
    private double balance;
    private double interstRate;


    public BanckAcountBuilder(double accountNumer){
      this.accountNumer=accountNumer;
   }

    public  BanckAcountBuilder withOwnner(String ownner){
      this.ownner=ownner;
      return this;
    }

    public  BanckAcountBuilder withType(BanckAcoountType type){
        this.type=type;
        return this;
    }

    public BanckAcountBuilder withBalance(double balance){
        this.balance=balance;
        return this;
    }

    public BanckAcountBuilder withInterestRate(double interest){
        this.interstRate=interest;
        return this;
    }

    @Override
    public BanckAcoount build() {
       BanckAcoount account= new BanckAcoount();
       account.setAccountNumer(this.accountNumer);
       account.setBalance(this.balance);
       account.setType(this.type);
       account.setInterstRate(this.interstRate);
       account.setOwnner(this.ownner);
       return account;
    }


}
