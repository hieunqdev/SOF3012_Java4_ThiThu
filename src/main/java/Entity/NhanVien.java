package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NhanVien")
public class NhanVien {
	@Id
	String MaNV;
	String TenNV;
	String DiaChi;
	boolean GioiTinh;
	
	public NhanVien() {
		super();
	}
	
	public NhanVien(String maNV, String tenNV, String diaChi, boolean gioiTinh) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		DiaChi = diaChi;
		GioiTinh = gioiTinh;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public boolean isGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	
	
}
