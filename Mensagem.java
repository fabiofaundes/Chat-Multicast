import java.io.Serializable;
import java.util.Objects;

public class Mensagem implements Serializable {

    private String mensagem;
    private String remetente;

    public Mensagem(String mensagem, String remetente) {
        this.mensagem = mensagem;
        this.remetente = remetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem1 = (Mensagem) o;
        return Objects.equals(mensagem, mensagem1.mensagem) &&
                Objects.equals(remetente, mensagem1.remetente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensagem, remetente);
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "mensagem='" + mensagem + '\'' +
                ", remetente='" + remetente + '\'' +
                '}';
    }
}
