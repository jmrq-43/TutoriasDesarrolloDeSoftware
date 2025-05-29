package Controller;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Persona {
    private int Id;
    private String Nombre;
    private int Edad;
}
