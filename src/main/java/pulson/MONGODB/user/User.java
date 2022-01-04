package pulson.MONGODB.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "users")//@Entity in JPA
public class User {

    @Id
    private String id;
    //String or BigInteger

    private String firstName;

    @Indexed(unique = true)
    private String email;

    private GenderEnum gender;
    private Address address;
    private List<String> favouriteGames;
    private BigDecimal totalMoneySpentOnGames;
    private LocalDateTime createdAt;

    public User(String firstName, String email, GenderEnum gender, Address address, List<String> favouriteGames, BigDecimal totalMoneySpentOnGames, LocalDateTime createdAt) {
        this.firstName = firstName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteGames = favouriteGames;
        this.totalMoneySpentOnGames = totalMoneySpentOnGames;
        this.createdAt = createdAt;
    }

    public User(String id, String firstName, String email, GenderEnum gender, Address address, List<String> favouriteGames, BigDecimal totalMoneySpentOnGames, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteGames = favouriteGames;
        this.totalMoneySpentOnGames = totalMoneySpentOnGames;
        this.createdAt = createdAt;
    }
}
