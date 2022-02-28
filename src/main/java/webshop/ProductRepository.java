package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("insert into products(productname,price,stock) values(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, productName);
            ps.setInt(2, price);
            ps.setInt(3, stock);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public Product findProductById(long id) {
        return jdbcTemplate.query("select * from products where id=?",
                (rs, rowNum) ->
                        new Product(rs.getLong("id"),
                                rs.getString("productname"),
                                rs.getInt("price"),
                                rs.getInt("stock"))
                , id).get(0);
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("update products SET stock=stock-? where id=?"
                , amount, id);
    }
}
