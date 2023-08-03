package model;

public abstract class SinhVien implements Comparable<SinhVien> {

    private String maSV;
    private String hoTen;
    private String diaChi;
    private String email;

    public SinhVien() {

    }

    public SinhVien(String maSV, String hoTen, String diaChi, String email) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract double getDiemTB();

    @Override
    public String toString() {
        return maSV + ":" + hoTen + ":" + diaChi + ":" + email;
    }

    @Override
    public int compareTo(SinhVien st) {
        return (this.getHoTen()).compareTo(((SinhVien) st).getHoTen());
    }

    public int compareDiemTB(SinhVien st) {
        return ((Double) this.getDiemTB()).compareTo((st).getDiemTB());
    }
}
