package models.users;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
