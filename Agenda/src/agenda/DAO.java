package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dewes
 */
public class DAO extends Model {
    
    public Connection conn;
    
    public boolean save (Model p) {
        final String INSERT = "INSERT INTO contato (nome, fone) VALUES (?, ?); ";
        try {
            conn = DBHelper.getConn();
            PreparedStatement stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, Util.ArrayToString(p.getNome()));
            stmt.setString(2, Util.ArrayToStringComma(p.getFone()));
            stmt.executeUpdate();
            conn.close(); 
            System.out.println(" Salvou => "+ p.toString());
            return true;
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean update (Model p) {
        final String UPDATE = "UPDATE contato SET nome=?, fone=? WHERE id=?; ";
        try {
            conn = DBHelper.getConn();
            PreparedStatement stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, Util.ArrayToString(p.getNome()));
            stmt.setString(2, Util.ArrayToStringComma(p.getFone()));
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();
            conn.close(); 
            System.out.println(" Alterou => "+ p.toString());
            return true;
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete (int id) {
        final String DELETE = "DELETE FROM contato WHERE id = ?;";
        Model p = get(id);
        if (p != null) {
            try {
                conn = DBHelper.getConn();
                PreparedStatement stmt = conn.prepareStatement(DELETE);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                conn.close(); 
                System.out.println(" Apagou => "+ p.toString());
                return true;
            } 
            catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public Model get (int id) {
        final String GET = "SELECT * FROM contato WHERE id = ?;";
        ResultSet rs = null;
        Model p = null;
        try {
           conn = DBHelper.getConn();
           PreparedStatement stmt = conn.prepareStatement(GET);
           stmt.setInt(1, id);
           rs = stmt.executeQuery();
           while (rs.next()) {
               int id_p = rs.getInt("id");
               ArrayList nomes = Util.StringToArray( rs.getString("nome") );
               ArrayList fones = Util.StringToArray( rs.getString("fone") );
               p = new Model(id_p, nomes, fones);
               System.out.println(" Pegou => "+ p.toString());
           }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public ResultSet list () {
        final String GET = "SELECT * FROM contato ORDER BY nome ASC;";
        ResultSet rs = null;
        try {
           conn = DBHelper.getConn();
           PreparedStatement stmt = conn.prepareStatement(GET);
           rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println( ex.getMessage() );
        }
        return rs; 
    }
    
    public ResultSet listLike (String nome) {
        final String GET_LIKE = "SELECT * FROM contato WHERE nome LIKE '%' ? '%' ORDER BY nome ASC;";
        System.out.println(" Buscar => "+ nome);
        ResultSet rs = null;
        try {
            conn = DBHelper.getConn();
            PreparedStatement stmt = conn.prepareStatement(GET_LIKE);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println( ex.getMessage() );
        }
        return rs; 
    }
    
    public boolean exists (String nome) {
        final String SELECT = "SELECT * FROM contato WHERE nome = ?; ";
        ResultSet rs=null;
        try {
           conn = DBHelper.getConn();
           PreparedStatement stmt = conn.prepareStatement(SELECT);
           stmt.setString(1, nome);
           rs = stmt.executeQuery();
           if (rs.next()) return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
