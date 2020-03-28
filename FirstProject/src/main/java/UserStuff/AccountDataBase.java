package UserStuff;

    import UserStuff.DB.DBConnectionManager;

    import UserStuff.Account.Transaction;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.concurrent.atomic.AtomicLong;

    public class AccountDataBase {

        private DBConnectionManager dbConnectionManager;


        public AccountDataBase() {
            this.dbConnectionManager = new DBConnectionManager();
        }

        public Account getAccountByNumber(String number) {
            Account account = null;
            try {
                Connection conn = this.dbConnectionManager.connect();
                PreparedStatement st = conn.prepareStatement("select * from account where number = ?");
                st.setString(1, number);
                System.out.println(st);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    account = new Account(rs.getString(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            CURRENCY.valueOf(rs.getString(4)));

                }
                st.close();
                //ДОСТАЕМ МАССИВ ТРАНЗАКЦИЙ
                if (account != null){
                    PreparedStatement nst = conn.prepareStatement("select * from transaction where sender_id = ? or receiver_id = ?");
                    nst.setString(1, account.getNumber());
                    nst.setString(2, account.getNumber());
                    ResultSet nrs = nst.executeQuery();
                    while (nrs.next()) {
                        account.addTransaction(rs.getString(1),
                                CURRENCY.valueOf(rs.getString(2)),
                                rs.getDouble(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                TAG.valueOf(rs.getString(7)));
                    }
                }

                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return account;
        }


        public void putAccount (Account account){

        }

    }

