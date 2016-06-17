package agenda;

import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Dewes
 */
public class Model {
    private int id;
    private ArrayList nome;
    private ArrayList fone;

    @Override
    public String toString() {
        return "Pessoa ("+ id +") Nome: " + nome + ", Fone: " + fone +" ";
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.fone);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Model other = (Model) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    public Model() {}
    public Model(int id, ArrayList nome, ArrayList fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }
    
    public Model(ArrayList nome, ArrayList fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList getNome() {
        return nome;
    }
    public void setNome(ArrayList nome) {
        this.nome = nome;
    }
    public ArrayList getFone() {
        return fone;
    }
    public void setFone(ArrayList fone) {
        this.fone = fone;
    }

}
