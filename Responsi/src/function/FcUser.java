package function;

import window.WdUser;
import java.sql.*;

public interface FcUser {
    public void save(WdUser daf) throws SQLException;
    public void edit(WdUser daf) throws SQLException;
    public void delete(WdUser daf) throws SQLException;
    public void view(WdUser daf) throws SQLException;
    public void onTable(WdUser daf) throws SQLException;
    public void updateAccount(WdUser daf) throws SQLException;
    public void viewAccount(WdUser daf) throws SQLException;
    //fungsi pada bagian user untuk curd
}
