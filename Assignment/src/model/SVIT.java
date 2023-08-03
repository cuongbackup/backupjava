package model;

public class SVIT extends SinhVien {

    private double diemJava;
    private double diemCss;

    public SVIT() {

    }

    public SVIT(String maSV, String hoTen, String diaChi, String email, double diemJava, double diemCss) {
        super(maSV, hoTen, diaChi, email);
        this.diemJava = diemJava;
        this.diemCss = diemCss;
    }

    public double getDiemJava() {
        return diemJava;
    }

    public void setDiemJava(double diemJava) {
        this.diemJava = diemJava;
    }

    public double getDiemCss() {
        return diemCss;
    }

    public void setDiemCss(double diemCss) {
        this.diemCss = diemCss;
    }

    @Override
    public String toString() {
        return getMaSV() + ":" + getHoTen() + ":" + getDiaChi() + ":" + getEmail() + ":" + diemJava + ":" + diemCss;
    }

    @Override
    public double getDiemTB() {
        return (diemJava * 3 + diemCss) / 4;
    }

}
