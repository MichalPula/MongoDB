package pulson.MONGODB.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {
    private String country;
    private String city;
    private String postCode;
}
