package pulson.MONGODB.user;

import lombok.*;

@Data
@AllArgsConstructor
public class Address {

    private String country;

    private String city;

    private String postCode;
}
