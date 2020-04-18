package hw4.ex2;

import java.util.List;

public class TestData {

    private List<String> summary;
    private List<String> elements;
    private String colors;
    private String metals;
    private List<String> vegetables;

    private TestData (){};

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColors() {
        return colors;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public static Builder newBuilder() {
        return new TestData().new Builder();
    }


    public class Builder {
        private Builder() {}

        public Builder setSummary (List<String> summary){
            TestData.this.summary = summary;
            return this;
        }

        public Builder setElements (List<String> elements){
            TestData.this.elements = elements;
            return this;
        }

        public Builder setColors (String colors){
            TestData.this.colors = colors;
            return this;
        }
        public Builder setMetals (String metals){
            TestData.this.metals = metals;
            return this;
        }
        public Builder setVegetables (List<String> vegetables){
            TestData.this.vegetables = vegetables;
            return this;
        }

        public TestData build(){
            return TestData.this;
        }
    }
}