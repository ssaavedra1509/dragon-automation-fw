package pe.com.swtestingdragons.dragonautomationfw.models;

public class Exchange {

    private Double amount;
    private String currencyIsoSource;
    private String currencyIsoTarget;

    public Exchange(){

    }

    public Exchange(Double amount, String currencyIsoSource, String currencyIsoTarget) {
        this.amount = amount;
        this.currencyIsoSource = currencyIsoSource;
        this.currencyIsoTarget = currencyIsoTarget;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyIsoSource() {
        return currencyIsoSource;
    }

    public void setCurrencyIsoSource(String currencyIsoSource) {
        this.currencyIsoSource = currencyIsoSource;
    }

    public String getCurrencyIsoTarget() {
        return currencyIsoTarget;
    }

    public void setCurrencyIsoTarget(String currencyIsoTarget) {
        this.currencyIsoTarget = currencyIsoTarget;
    }
}