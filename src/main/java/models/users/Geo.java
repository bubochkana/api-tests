package models.users;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Geo {
    private String lat;
    private String lng;
}
