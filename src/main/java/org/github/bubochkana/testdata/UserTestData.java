package org.github.bubochkana.testdata;

import org.github.bubochkana.models.users.AddressDto;
import org.github.bubochkana.models.users.CompanyDto;
import org.github.bubochkana.models.users.GeoDto;
import org.github.bubochkana.models.users.UserRequestDto;

public class UserTestData {

  public static UserRequestDto getLeanneGrahamUser() {
    return UserRequestDto.builder()
        .name("Leanne Graham")
        .username("Bret")
        .email("Sincere@april.biz")
        .address(
            AddressDto.builder()
                .street("Kulas Light")
                .suite("Apt. 556")
                .city("Gwenborough")
                .zipcode("92998-3874")
                .geo(GeoDto.builder().lat("-37.3159").lng("81.1496").build())
                .build())
        .phone("1-770-736-8031 x56442")
        .website("hildegard.org")
        .company(
            CompanyDto.builder()
                .name("Romaguera-Crona")
                .catchPhrase("Multi-layered client-server neural-net")
                .bs("harness real-time e-markets")
                .build())
        .build();
  }

  public static UserRequestDto getGlennaReichertUser() {
    return UserRequestDto.builder()
        .name("Glenna Reichert")
        .username("Delphine")
        .email("Chaim_McDermott@dana.io")
        .address(
            AddressDto.builder()
                .street("Dayna Park")
                .suite("Suite 449")
                .city("Bartholomebury")
                .zipcode("76495-3109")
                .geo(GeoDto.builder().lat("24.6463").lng("-168.8889").build())
                .build())
        .phone("(775)976-6794 x41206")
        .website("conrad.com")
        .company(
            CompanyDto.builder()
                .name("Yost and Sons")
                .catchPhrase("Switchable contextually-based project")
                .bs("aggregate real-time technologies")
                .build())
        .build();
  }

  public static UserRequestDto getClementinaDuBuqueUser() {
    return UserRequestDto.builder()
        .name("Clementina DuBuque")
        .username("Moriah.Stanton")
        .email("Rey.Padberg@karina.bizo")
        .address(
            AddressDto.builder()
                .street("Kattie Turnpike")
                .suite("Suite 198")
                .city("Lebsackbury")
                .zipcode("31428-2261")
                .geo(GeoDto.builder().lat("-38.2386").lng("57.2232").build())
                .build())
        .phone("024-648-3804")
        .website("ambrose.net")
        .company(
            CompanyDto.builder()
                .name("Hoeger LLC")
                .catchPhrase("Centralized empowering task-force")
                .bs("target end-to-end models")
                .build())
        .build();
  }
}
