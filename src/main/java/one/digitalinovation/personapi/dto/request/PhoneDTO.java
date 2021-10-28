package one.digitalinovation.personapi.dto.request;

import lombok.*;
import one.digitalinovation.personapi.enums.PhoneType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneDTO {

    private Long id;

    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;


}