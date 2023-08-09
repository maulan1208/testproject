package edu.vti.rocket.democl3.response;

import edu.vti.rocket.democl3.domain.QuanAo;

public class QuanAoDTO {
    String uniqueTag;

    public QuanAoDTO(){
    }

    public QuanAoDTO(QuanAo quanAo) {
        this.uniqueTag = quanAo.getLoaiMatHang().toString() + quanAo.getSize();
    }
}
