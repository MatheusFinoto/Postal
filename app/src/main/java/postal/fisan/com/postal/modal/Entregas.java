package postal.fisan.com.postal.modal;

public class Entregas {
    private String localEntrega;
    private String endereco;
    private String cep;
    private String horaInicio;
    private double localLong;
    private double localLat;
    private Integer status;

    public Entregas() {
        this.localEntrega = localEntrega;
        this.endereco = endereco;
        this.cep = cep;
        this.horaInicio = horaInicio;
        this.localLong = localLong;
        this.localLat = localLat;
        this.status = status;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getLocalLong() {
        return localLong;
    }

    public void setLocalLong(double localLong) {
        this.localLong = localLong;
    }

    public double getLocalLat() {
        return localLat;
    }

    public void setLocalLat(double localLat) {
        this.localLat = localLat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
