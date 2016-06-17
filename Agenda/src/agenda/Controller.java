/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Dewes
 */
public class Controller {
    
    static DAO dao;
    
    public static boolean Salvar(ArrayList nomes, ArrayList fones) {
        if (!nomes.isEmpty()) {
            if (!fones.isEmpty()) {
                Model p = new Model(nomes, fones);
                dao = new DAO();
                if (!dao.exists(Util.ArrayToString(p.getNome()))) {
                    if (dao.save(p)) {
                        JOptionPane.showMessageDialog(null, " "+ Util.ArrayToString(p.getNome()) +"salvo. ");
                        return true;
                    }
                    else JOptionPane.showMessageDialog(null, " Não foi possível salvar "+ Util.ArrayToString(p.getNome()) +". ");
                }
                else JOptionPane.showMessageDialog(null, " "+ Util.ArrayToString(p.getNome()) +"já foi salvo. ", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null, "É necessário ao menos 1 telefone. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null, "Nome em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;     
    }
    
    public static boolean Alterar(Model p, ArrayList nomes, ArrayList fones) {
        Model aux = new Model(nomes, fones);
        if (p.equals(aux)) 
            return true;
        else {
            p.setNome(aux.getNome());
            p.setFone(aux.getFone());
            if (!nomes.isEmpty()) {
                if (!fones.isEmpty()) {
                    dao = new DAO();
                    if (dao.update(p)) {
                        JOptionPane.showMessageDialog(null, " "+ Util.ArrayToString(p.getNome()) +"alterado. ");
                        return true;
                    }
                    else JOptionPane.showMessageDialog(null, " Não foi possível alterar "+ Util.ArrayToString(p.getNome()) +". ");
                }
                else JOptionPane.showMessageDialog(null, "É necessário ao menos 1 telefone. ", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null, "Nome em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public static boolean Apagar(int id) {
        dao = new DAO();
        return dao.delete( id );
    }
    
    public static Model Pegar (int id) {
        dao = new DAO();
        Model p = dao.get(id);
        return p;
    }
    
    public static ResultSet Buscar(String nome) {
        ResultSet rs;
        dao = new DAO();
        rs = dao.listLike(nome);
        return rs;
    }
    
    public static ResultSet Todos () {
        ResultSet rs;
        dao = new DAO();
        rs = dao.list();
        return rs;
    }
    
    public void initDb () throws IOException, SQLException {
        DBHelper dh = new DBHelper();
        dh.createDb();
    }
    
}
