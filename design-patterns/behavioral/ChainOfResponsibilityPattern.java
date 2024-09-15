
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        DispenseChain dispenseChain1 = new Rupee500DispenseChain();
        DispenseChain dispenseChain2 = new Rupee100DispenseChain();
        DispenseChain dispenseChain3 = new Rupee50DispenseChain();
        dispenseChain1.setNextChain(dispenseChain2);
        dispenseChain2.setNextChain(dispenseChain3);

        int amountToWithdraw = 1250;
        System.out.println("-------Dispensing amount " + amountToWithdraw + "----------");
        dispenseChain1.dispense(new Currency(amountToWithdraw));

        amountToWithdraw = 5250;
        System.out.println("-------Dispensing amount " + amountToWithdraw + "----------");
        dispenseChain1.dispense(new Currency(amountToWithdraw));
    }
}

class Currency {
    private int amount;
    public Currency(int amt){
        this.amount=amt;
    }
    public int getAmount(){
        return this.amount;
    }
}

interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}

class Rupee500DispenseChain implements DispenseChain {

    private DispenseChain nextDispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextDispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 500) {
            int notes = cur.getAmount()/500;
            int remainingAmountToDispense = cur.getAmount() % 500;
            System.out.println(notes + " notes of 500 rupees dispensed.");
            if(remainingAmountToDispense > 0) this.nextDispenseChain.dispense(new Currency(remainingAmountToDispense));
        } else {
            this.nextDispenseChain.dispense(cur);
        }
    }
}

class Rupee100DispenseChain implements DispenseChain {

    private DispenseChain nextDispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextDispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 100) {
            int notes = cur.getAmount()/100;
            int remainingAmountToDispense = cur.getAmount() % 100;
            System.out.println(notes + " notes of 100 rupees dispensed.");
            if(remainingAmountToDispense > 0) this.nextDispenseChain.dispense(new Currency(remainingAmountToDispense));
        } else {
            this.nextDispenseChain.dispense(cur);
        }
    }
}

class Rupee50DispenseChain implements DispenseChain {
    private DispenseChain nextDispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextDispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 50) {
            int notes = cur.getAmount()/50;
            int remainingAmountToDispense = cur.getAmount() % 50;
            System.out.println(notes + " notes of 50 rupees dispensed.");
            if(remainingAmountToDispense > 0) this.nextDispenseChain.dispense(new Currency(remainingAmountToDispense));
        } else {
            this.nextDispenseChain.dispense(cur);
        }
    }
}
