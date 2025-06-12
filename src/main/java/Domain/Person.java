package Domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Person {
    private int Id;
    private String Nombre;
    private int Edad;
}
