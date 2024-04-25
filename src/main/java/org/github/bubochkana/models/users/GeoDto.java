package org.github.bubochkana.models.users;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoDto {
    private String lat;
    private String lng;
}
