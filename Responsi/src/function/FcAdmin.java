package function;

import window.WdAdmin;
import java.sql.*;

public interface FcAdmin {
    public void edit(WdAdmin adm) throws SQLException;
    public void view(WdAdmin adm) throws SQLException;
    public void delete(WdAdmin adm) throws SQLException;
    public void onTable(WdAdmin adm) throws SQLException;
    //fungsi pada bagian admin untuk curd
}
