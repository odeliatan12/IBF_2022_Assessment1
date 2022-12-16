package calculator;

public class Calculator {
    
    private Double value;

    public Double getValue() {
        
        return this.value;
    
    }


    public void addition(Double firstValue, Double thirdValue) {
        
        this.value = firstValue + thirdValue;
        System.out.println(this.value);

    }
    

    public void minus(Double firstValue, Double thirdValue) {
        
        this.value = firstValue - thirdValue;
        System.out.println(this.value);

    }


    public void divide(Double firstValue, Double thirdValue) {
        
        this.value = firstValue / thirdValue;
        System.out.println(this.value);

    }

    public void multiply(Double firstValue, Double thirdValue) {
        
        this.value = firstValue * thirdValue;
        System.out.println(this.value);

    }
}
