package model;

public class SVBiz extends SinhVien {

    private double diemKeToan;
    private double diemMarketting;

    public SVBiz() {

    }

    public SVBiz(String maSV, String hoTen, String diaChi, String email, double diemKeToan, double diemMarketting) {
        super(maSV, hoTen, diaChi, email);
        this.diemKeToan = diemKeToan;
        this.diemMarketting = diemMarketting;
    }

    public double getDiemKeToan() {
        return diemKeToan;
    }

    public void setDiemKeToan(double diemKeToan) {
        this.diemKeToan = diemKeToan;
    }

    public double getDiemMarketting() {
        return diemMarketting;
    }

    public void setDiemMarketting(double diemMarketting) {
        this.diemMarketting = diemMarketting;
    }

    @Override
    public String toString() {
        return getMaSV() + ":" + getHoTen() + ":" + getDiaChi() + ":" + getEmail() + ":" + diemKeToan + ":" + diemMarketting;
    }

    @Override
    public double getDiemTB() {
        return (diemKeToan * 2 + diemMarketting) / 3;
    }
}
