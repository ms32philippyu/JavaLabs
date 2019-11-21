package by.gsu.ms42.idz12.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {

    private Long id;
    private String fname;
    private String lname;
    private String email;
    private List<TourDto> tours;
}
