package Trade.model.dto;

public class ProductDto {
    private int pno;
    private String pname;
    private String ppro;
    private String pdes;
    private int ppri;
    private String ppw;
    private String ppn;
    private String pdate;
    private String pout;

    public ProductDto(){}
    public ProductDto(int pno, String pname, String ppro, String pdes, int ppri, String ppw, String ppn, String pdate, String pout) {
        this.pno = pno;
        this.pname = pname;
        this.ppro = ppro;
        this.pdes = pdes;
        this.ppri = ppri;
        this.ppw = ppw;
        this.ppn = ppn;
        this.pdate = pdate;
        this.pout = pout;
    }

    public int getPno() {
        return pno;
    }
    public void setPno(int pno) {
        this.pno = pno;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPpro() {
        return ppro;
    }
    public void setPpro(String ppro) {
        this.ppro = ppro;
    }
    public String getPdes() {
        return pdes;
    }
    public void setPdes(String pdes) {
        this.pdes = pdes;
    }
    public int getPpri() {
        return ppri;
    }
    public void setPpri(int ppri) {
        this.ppri = ppri;
    }
    public String getPpw() {
        return ppw;
    }
    public void setPpw(String ppw) {
        this.ppw = ppw;
    }
    public String getPpn() {
        return ppn;
    }
    public void setPpn(String ppn) {
        this.ppn = ppn;
    }
    public String getPdate() {
        return pdate;
    }
    public void setPdate(String pdate) {
        this.pdate = pdate;
    }
    public String getPout() {
        return pout;
    }
    public void setPout(String pout) {
        this.pout = pout;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "pno=" + pno +
                ", pname='" + pname + '\'' +
                ", ppro='" + ppro + '\'' +
                ", pdes='" + pdes + '\'' +
                ", ppri=" + ppri +
                ", ppw='" + ppw + '\'' +
                ", ppn='" + ppn + '\'' +
                ", pdate='" + pdate + '\'' +
                ", pout='" + pout + '\'' +
                '}';
    }
}
