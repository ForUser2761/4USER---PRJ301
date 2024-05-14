public class Train {
    private String code;
    private String name;
    private String carr;

    public Train() {
    }

    public Train(String code, String name, String carr) {
        this.code = code;
        this.name = name;
        this.carr = carr;
    }
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarr() {
        return carr;
    }

    public void setCarr(String carr) {
        this.carr = carr;
    }

    
    
    
}
