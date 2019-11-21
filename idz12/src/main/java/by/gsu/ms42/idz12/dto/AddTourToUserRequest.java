package by.gsu.ms42.idz12.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTourToUserRequest {
    private Long clientId;
    private Long tourId;
}
